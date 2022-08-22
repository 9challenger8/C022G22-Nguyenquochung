import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility/facility';
import {FacilityService} from '../../service/facility/facility.service';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  facilityList: Array<Facility> = [];

  // delete modal
  idModal: number;
  nameModal: string;

  p = 1;


  // search
  nameSearch = new FormControl('');

  constructor(private facilityService: FacilityService) {
  }

  ngOnInit(): void {
    this.getSearchListByNamePagination();
  }

  getAllFacilityPagination() {
    this.facilityService.getAll().subscribe(data => {
      this.facilityList = data;
    });
  }

  deleteSeriesProduct() {
    this.facilityService.deleteFacility(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
    });
  }

  getSearchListByNamePagination() {
    this.facilityService.searchFacilityByName(this.nameSearch.value).subscribe(data => {
      console.log(data);
      this.facilityList = data;
    });
  }

  getDataForModal(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }
}
