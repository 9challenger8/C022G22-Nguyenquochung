import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {PatientInformationService} from "../../service/patient-information.service";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {


  constructor(private toastr:ToastrService,
              private patientInformationService:PatientInformationService)
  { }

  ngOnInit(): void {
  }


}
