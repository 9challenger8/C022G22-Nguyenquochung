import {Component, OnInit} from '@angular/core';
import {Facility} from "../../model/facility/facility";
import {RentType} from "../../model/facility/rentType";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  facilityList: Array<Facility> = [];

  idModal: number;
  nameModal: string;
  // nameSearch = new FormControl('');


  constructor() {
    this.facilityList.push({
      id: 1,
      name: 'Room_123',
      area: '12',
      cost: '12000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
    this.facilityList.push({
      id: 2,
      name: 'Room_1',
      area: '12',
      cost: '1000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
    this.facilityList.push({
      id: 3,
      name: 'Room_2',
      area: '12',
      cost: '12000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
    this.facilityList.push({
      id: 4,
      name: 'Room_3',
      area: '12',
      cost: '12000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
    this.facilityList.push({
      id: 5,
      name: 'Room_456',
      area: '12',
      cost: '12000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
    this.facilityList.push({
      id: 5,
      name: 'Room_789',
      area: '12',
      cost: '12000',
      numberOfPeople: '20',
      rentType: {id: 1, name: 'Year'}
    });
  }

  ngOnInit(): void {
  }

  getDataForModal(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }


}
