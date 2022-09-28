import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Patient} from '../../model/patient';
import {PatientInformationService} from '../../service/patient-information.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  patientList: Patient[] = [];

  idModal: string;
  nameSearch = new FormControl('');

  // pagination
  indexPagination = 0;
  pages: Array<number>;
  totalPagination: number;

  constructor(private toastr: ToastrService,
              private patientInformationService: PatientInformationService) {
  }

  ngOnInit(): void {
    this.getSearchListByNamePagination();
  }

  deletePatient() {
    this.patientInformationService.deletePatient(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
      this.toastr.success('Successfully deleted.', 'Notification!');
    });
  }

  getSearchListByNamePagination() {
    this.patientInformationService.searchPatientByName(this.nameSearch.value, this.indexPagination).subscribe(data => {
      console.log(data);
      this.patientList = data.content;
      this.pages = new Array(data.totalPages);
    });
  }

  getDataForModal(id: string) {
    this.idModal = id;
  }

  setPage(i: number, event: any) {
    event.preventDefault();
    this.indexPagination = i;
    this.getSearchListByNamePagination();
  }
}
