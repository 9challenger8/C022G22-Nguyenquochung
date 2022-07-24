import { Component, OnInit } from '@angular/core';
import {RentType} from "../../model/facility/rentType";
import {Facility} from "../../model/facility/facility";

@Component({
  selector: 'app-list-facility',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})

export class FacilityListComponent implements OnInit {
  facilities : Facility[]=[];



  constructor() {

   const rentTypes : RentType[] = [{id:1,name:'Year'},{id:2,name:'Month'},{id:3,name:'Day'},{id:4,name:'Hour'}];

   this.facilities.push({id:1,name:'Room_123',area:'12',cost:'12000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});
   this.facilities.push({id:2,name:'Room_1',area:'12',cost:'1000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});
   this.facilities.push({id:3,name:'Room_2',area:'12',cost:'12000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});
   this.facilities.push({id:4,name:'Room_3',area:'12',cost:'12000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});
   this.facilities.push({id:5,name:'Room_456',area:'12',cost:'12000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});
   this.facilities.push({id:5,name:'Room_789',area:'12',cost:'12000',numberOfPeople:'20',rentType:{id:1,name:'Year'}});

  }


  ngOnInit(): void {
  }



}
