import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer/customer.service';
import {Customer} from '../../model/customer/customer';
import {Router} from '@angular/router';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];

  idModal: number;
  nameModal: string;
  nameSearch = new FormControl('');


  p = 1;

  constructor(private customerService: CustomerService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.getAllCustomer();

  }

  getAllCustomer() {
    this.customerService.getAll().subscribe(data => {
      this.customerList = data;
    });
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
    });
  }

  getDataForModal(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }

  searchCustomerByName() {
    this.customerService.searchCustomerByName(this.nameSearch.value).subscribe(data => {
      this.customerList = data;
    });
  }

}
