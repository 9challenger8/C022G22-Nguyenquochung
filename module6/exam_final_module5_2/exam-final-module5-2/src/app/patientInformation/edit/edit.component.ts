import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {PatientInformationService} from "../../service/patient-information.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {checkInputDateFuture} from "../../validator/validator";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  patientEdit: FormGroup;

  id: string;

  p=1;

  constructor(private toastr: ToastrService,
              private patientInformationService: PatientInformationService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      this.getPatient(this.id);
    });
  }

  ngOnInit(): void {
  }

  getPatient(id: string) {
    return this.patientInformationService.findById(id).subscribe(data => {
      this.patientEdit = new FormGroup({
          id: new FormControl(data.id, [Validators.required]),
          idPatient: new FormControl(data.idPatient, [Validators.required]),
          namePatient: new FormControl(data.namePatient, [Validators.required,Validators.pattern(/^([A-Z][a-z]*\s*)*$/)]),
          startDate: new FormControl(data.startDate, [Validators.required]),
          outDate: new FormControl(data.outDate, [Validators.required]),
          issue: new FormControl(data.issue, Validators.required),
          solution: new FormControl(data.solution, Validators.required),
          nameDoctor: new FormControl(data.nameDoctor, [Validators.required,Validators.pattern(/^([A-Z][a-z]*\s*)*$/)])
        },checkInputDateFuture);
    });
  }

  update(id: string) {
    const patient = this.patientEdit.value;
    this.patientInformationService.update(id, patient).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/list');
      this.toastr.success('Successfully edited new.', 'Notification!');
    });
  }


}
