import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {PatientInformationService} from '../../service/patient-information.service';
import {Doctor} from '../../model/doctor';
import {checkInputDateFuture} from '../../validator/validator';
import {Router} from '@angular/router';
import {DoctorService} from '../../service/doctor.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  doctorList: Doctor[] = [];

  patientAdd: FormGroup;

  constructor(private toastr: ToastrService,
              private patientInformationService: PatientInformationService,
              private router: Router,
              private doctorService: DoctorService) {
  }

  ngOnInit(): void {
    this.getFormPatientAdd();
    this.getAllDoctor();
  }

  getAllDoctor() {
    this.doctorService.getAll().subscribe(data => {
      this.doctorList = data;
    });
  }

  getFormPatientAdd() {
    this.patientAdd = new FormGroup({
      idRecord: new FormControl('', [Validators.required]),
      idPatient: new FormControl('', [Validators.required]),
      namePatient: new FormControl('', [Validators.required]),
      startDate: new FormControl('', [Validators.required]),
      outDate: new FormControl('', [Validators.required]),
      issue: new FormControl('', Validators.required),
      solution: new FormControl('', Validators.required),
      doctor: new FormControl('', [Validators.required])
    }, checkInputDateFuture);
  }

  submit() {
    const patient = this.patientAdd.value;
    this.patientInformationService.savePatient(patient).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/list');
      this.toastr.success('Successfully added new.', 'Notification!');
    });
  }


}
