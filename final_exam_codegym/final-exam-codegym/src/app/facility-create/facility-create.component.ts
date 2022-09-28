import {Component, OnInit} from '@angular/core';
import {Manager} from '../model/manager';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ManagerService} from '../service/manager.service';
import {Router} from '@angular/router';
import {FacilityService} from '../service/facility.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {

  managerList: Array<Manager> = [];

  facilityAdd: FormGroup;

  constructor(private manager: ManagerService,
              private facility: FacilityService,
              private router: Router,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllManager();
    this.getFormAddFacility();
  }

  getAllManager() {
    this.manager.getAll().subscribe(data => {
      this.managerList = data;
    });
  }

  getFormAddFacility() {
    this.facilityAdd = new FormGroup({
      nameFacility: new FormControl(''),
      codeFacility: new FormControl('CS-'),
      openDay: new FormControl(''),
      address: new FormControl(''),
      manager: new FormControl(''),
      deleted: new FormControl(0)
      }
    );
  }

  submit() {
    console.log(this.facilityAdd);
    const facility = this.facilityAdd.value;
    this.facility.saveFacility(facility).subscribe(() => {
      this.toast.success('Thêm mới thành công', 'Thông báo');
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/list');
    });
  }

}
