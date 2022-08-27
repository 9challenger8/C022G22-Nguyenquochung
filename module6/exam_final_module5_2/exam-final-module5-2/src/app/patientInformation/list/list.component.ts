import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Patient} from "../../model/patient";
import {PatientInformationService} from "../../service/patient-information.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  patientList: Patient[]=[];

  idModal: string;

  nameSearch = new FormControl('');


  p = 1;

  constructor(private toastr:ToastrService,
              private patientInformationService:PatientInformationService) { }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  deletePatient() {
    this.patientInformationService.delete(this.idModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
      this.toastr.success('Successfully deleted.', 'Notification!');
    });
  }

  getAllCustomer() {
    this.patientInformationService.getAll().subscribe(data => {
      console.log(data);
      this.patientList = data;
    });
  }

  getDataForModal(id: string) {
    this.idModal = id;
  }


}
