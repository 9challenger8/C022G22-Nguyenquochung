import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {TokenStorageService} from "../../service/token-storage.service";
import {Customer} from "../../model/customer";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  // username tim kiem
  username: string = " ";
  customer: any = {};

  constructor(private customerService: CustomerService,
              private tokenStorageService: TokenStorageService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getCustomerByUsername();
  }

  getCustomerByUsername(){
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.username = paramMap.get('name');
      console.log("hien thi khach hang: ")
      console.log(this.username);
      this.customerService.getCustomerByUsername(this.username).subscribe(data => {
        this.customer = data;
        console.log(this.customer.id)
        console.log(this.customer.birthday);
      });
    });
  }

}
