import {Component, OnInit} from '@angular/core';
import {Facility} from "../../model/facility/facility";
import {FacilityService} from "../../service/facility/facility.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  facilityList: Array<Facility> = [];

  // delete modal
  idModal: number=1;
  nameModal: string='g';


  // search
  nameSearch = new FormControl('');


  //pagination
  indexPagination: number = 0;
  pages: Array<number>;
  totalPagination: number;


  constructor( private facilityService:FacilityService) {
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

  }

  ngOnInit(): void {
    this.getSearchListByNamePagination();
  }

  getAllFacilityPagination(){
    this.facilityService.getAll().subscribe(data =>{
      this.facilityList=data;
    })
  }

  deleteSeriesProduct() {
    this.facilityService.deleteFacility(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
    });
  }

  getSearchListByNamePagination(){
    this.facilityService.searchFacilityByName(this.nameSearch.value,this.indexPagination).subscribe(data => {
      console.log(this.nameSearch.value)
      console.log("search data:");
      console.log(data)
      console.log(this.pages)
      this.facilityList = data.content
      this.pages = new Array(data['totalPages']);
    })
  }

  getDataForModal(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }

  setPage(i: number, event: any) {
    event.preventDefault();
    this.indexPagination = i;
    this.getSearchListByNamePagination()
  }
}