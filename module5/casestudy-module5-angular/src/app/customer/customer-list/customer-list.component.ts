import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer/customer";
import {CustomerService} from "../../service/customer/customer.service";
import {Router} from "@angular/router";

// input thu vien npm i lodash --save
import * as _ from 'lodash';
// input thu vien npm i moment --save
import * as moment from 'moment';
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {


  searchText: string='';
  customers: Customer[] = [];
  p: number = 1;

  idModal:number;
  nameModal:string;

  nameSearch = new FormControl('');

  idCardSearch = new FormControl('');

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

  deleteCustomer() {
    this.customerService.deleteCustomer(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    },()=>{
     this.ngOnInit();
    });
  }

  sortByName(dir) {
    if(dir=='up'){
      this.customers = _.orderBy(this.customers,['name'],['asc'])
    }else {
      this.customers = _.orderBy(this.customers,['name'],['desc'])
    }
  }

  searchCustomerByNameAndIdCard(){
    console.log(this.nameSearch.value)
    console.log(this.idCardSearch.value)
    this.customerService.searchCustomerByNameCustomerAndIdCard(this.nameSearch.value,this.idCardSearch.value).subscribe(data=>{
      this.customers=data;
      this.router.navigate(['/customer/list']);
    }, e => {
      console.log(e);
    });
  }

  getDataForModal(id:number,name:string){
    this.idModal= +id;
    this.nameModal=name;
  }

}
