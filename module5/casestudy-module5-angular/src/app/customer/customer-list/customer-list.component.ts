import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer/customer";
import {CustomerService} from "../../service/customer/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  p: number = 1;

  constructor(private customerService:CustomerService,
              private router:Router) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(() => {
      this.getAll();
      this.router.navigate(['/customer/list']);
    }, e => {
      console.log(e);
    });
  }

}
