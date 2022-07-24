import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer/customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];

  constructor() {
    this.customers.push({id:1,name:'Jonh',dateOfBirth:'11-12-2019',gender:'Male',cardId:'123',phoneNumber:'0944',
      customerType:{id:1,name:'Diamond'},address:'12/Putin Street'});
    this.customers.push({id:2,name:'Alex',dateOfBirth:'11-12-2019',gender:'Female',cardId:'123',phoneNumber:'0944',
      customerType:{id:1,name:'Diamond'},address:'12/Putin Street'});
    this.customers.push({id:3,name:'Tom',dateOfBirth:'11-12-2019',gender:'Male',cardId:'123',phoneNumber:'0944',
      customerType:{id:1,name:'Diamond'},address:'12/Putin Street'});
    this.customers.push({id:4,name:'Jerry',dateOfBirth:'11-12-2019',gender:'Male',cardId:'123',phoneNumber:'0944',
      customerType:{id:1,name:'Diamond'},address:'12/Putin Street'});
    this.customers.push({id:5,name:'Black Girl',dateOfBirth:'11-12-2019',gender:'Female',cardId:'123',phoneNumber:'0944',
      customerType:{id:1,name:'Diamond'},address:'12/Putin Street'});
  }

  ngOnInit(): void {
  }

}
