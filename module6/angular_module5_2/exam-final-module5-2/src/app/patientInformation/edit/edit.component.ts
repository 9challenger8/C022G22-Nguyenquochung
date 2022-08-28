import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {PatientInformationService} from '../../service/patient-information.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {checkInputDateFuture} from '../../validator/validator';
import {Doctor} from '../../model/doctor';
import {DoctorService} from '../../service/doctor.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  doctorList: Doctor[] = [];

  patientEdit: FormGroup;

  id: string;

  constructor(private toastr: ToastrService,
              private patientInformationService: PatientInformationService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private doctorService: DoctorService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      this.getPatient(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllDoctor();
  }

  getAllDoctor() {
    this.doctorService.getAll().subscribe(data => {
      this.doctorList = data;
    });
  }

  getPatient(id: string) {
    return this.patientInformationService.findById(id).subscribe(data => {
      this.patientEdit = new FormGroup({
        idRecord: new FormControl(data.idRecord, [Validators.required]),
        idPatient: new FormControl(data.idPatient, [Validators.required]),
        namePatient: new FormControl(data.namePatient, [Validators.required]),
        startDate: new FormControl(data.startDate, [Validators.required]),
        outDate: new FormControl(data.outDate, [Validators.required]),
        issue: new FormControl(data.issue, Validators.required),
        solution: new FormControl(data.solution, Validators.required),
        doctor: new FormControl(data.doctor, [Validators.required])
      }, checkInputDateFuture);
    });
  }

  update(id: string) {
    const patient = this.patientEdit.value;
    this.patientInformationService.updatePatient(id, patient).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/list');
      this.toastr.success('Successfully edited.', 'Notification!');
    });
  }

  compareObj(value, option) {
    return value.id === option.id;
  }


}
