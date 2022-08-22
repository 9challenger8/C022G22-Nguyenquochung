import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FacilityService} from '../../service/facility/facility.service';
import {FacilityTypeService} from '../../service/facility/facility-type.service';
import {RentTypeService} from '../../service/facility/rent-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FacilityType} from '../../model/facility/facilityType';
import {RentType} from '../../model/facility/rentType';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {

  // Array facility type and array rent type
  facilityTypeList: Array<FacilityType> = [];
  rentTypeList: Array<RentType> = [];

  // Select Facility
  displayStandardRoom = 'none';
  displayOtherConvenience = 'none';
  displayPoolArea = 'none';
  displayNumberFloor = 'none';
  displayFacilityFree = 'none';

  // id find facility for edit
  id: number;

  // declare form edit
  facilityEditForm: FormGroup;

  constructor(
    private facilityService: FacilityService,
    private facilityTypeService: FacilityTypeService,
    private rentTypeService: RentTypeService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      console.log('Id edit:');
      console.log(this.id);
      this.getFacility(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllFacilityType();
    this.getAllRentType();
  }

  submit(id: number) {
    const facility = this.facilityEditForm.value;
    console.log(facility);

    this.facilityService.updateFacility(id, facility).subscribe(() => {
    }, e => {
    }, () => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('/facility/list');
    });
  }

  // Get facility
  getFacility(id: number) {
    this.facilityService.findById(id).subscribe(data => {
      this.loadInputFacility(data.facilityType.name);
      console.log(data.facilityType.name);
      this.facilityEditForm = new FormGroup({
        name: new FormControl(data.name, [Validators.required]),
        area: new FormControl(data.area, [Validators.required]),
        cost: new FormControl(data.cost, [Validators.required]),
        numberOfPeople: new FormControl(data.numberOfPeople, [Validators.required]),
        rentType: new FormControl(data.rentType, [Validators.required]),
        facilityType: new FormControl(data.facilityType, [Validators.required]),
        standardRoom: new FormControl(data.standardRoom, [Validators.required]),
        otherConvenience: new FormControl(data.otherConvenience, [Validators.required]),
        poolArea: new FormControl(data.poolArea, [Validators.required]),
        numberOfFloor: new FormControl(data.numberOfFloor, [Validators.required]),
        freeFacility: new FormControl(data.freeFacility, [Validators.required]),
      });
    });
  }

  // Select Facility
  selectFacility(event: any) {
    console.log('Select data change:');
    console.log(event);
    console.log(event.target.value);
    switch (event.target.value) {
      case '1: Object' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'block';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '2: Object' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '3: Object' :
        this.displayStandardRoom = 'none';
        this.displayOtherConvenience = 'none';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'none';
        this.displayFacilityFree = 'block';
        break;
      default:
        this.displayStandardRoom = 'none';
        this.displayOtherConvenience = 'none';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'none';
        this.displayFacilityFree = 'none';
    }
  }

  // Get data Facility type
  getAllFacilityType() {
    this.facilityTypeService.getAll().subscribe(data => {
      this.facilityTypeList = data;
    });
  }

  // Get data Rent type
  getAllRentType() {
    this.rentTypeService.getAll().subscribe(data => {
      this.rentTypeList = data;
    });
  }

  // Compare value choose select
  compareObj(value, option) {
    return value.id === option.id;
  }

  // Display input facility
  loadInputFacility(name: string) {
    switch (name) {
      case 'Villa' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'block';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case 'House' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case 'Room' :
        this.displayStandardRoom = 'none';
        this.displayOtherConvenience = 'none';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'none';
        this.displayFacilityFree = 'block';
        break;
      default:
        this.displayStandardRoom = 'none';
        this.displayOtherConvenience = 'none';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'none';
        this.displayFacilityFree = 'none';
    }
  }
}
