import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FacilityService} from "../../service/facility/facility.service";
import {FacilityTypeService} from "../../service/facility/facility-type.service";
import {RentTypeService} from "../../service/facility/rent-type.service";
import {Router} from "@angular/router";
import {FacilityType} from "../../model/facility/facilityType";
import {RentType} from "../../model/facility/rentType";

@Component({
  selector: 'app-facility-add',
  templateUrl: './facility-add.component.html',
  styleUrls: ['./facility-add.component.css']
})
export class FacilityAddComponent implements OnInit {

  // Array facility type and array rent type
  facilityTypeList: Array<FacilityType> = [];
  rentTypeList: Array<RentType> = [];

  // Select Facility
  displayStandardRoom = 'none';
  displayOtherConvenience = 'none';
  displayPoolArea = 'none';
  displayNumberFloor = 'none';
  displayFacilityFree = 'none';

  //Declare form add
  facilityAddForm: FormGroup

  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllFacilityType();
    this.getAllRentType();
    this.getFormFacilityAdd();
  }

  getAllFacilityType() {
    this.facilityTypeService.getAll().subscribe(data => {
      console.log("Facility data:");
      console.log(data);
      this.facilityTypeList = data;
    })
  }

  getAllRentType() {
    this.rentTypeService.getAll().subscribe(data => {
      this.rentTypeList = data;
    })
  }

  getFormFacilityAdd() {
    this.facilityAddForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      area: new FormControl('', [Validators.required]),
      cost: new FormControl('', [Validators.required]),
      numberOfPeople: new FormControl('', [Validators.required]),
      rentType: new FormControl('', [Validators.required]),
      facilityType: new FormControl('', [Validators.required]),
      standardRoom: new FormControl('', [Validators.required]),
      otherConvenience: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [Validators.required]),
      numberOfFloor: new FormControl('', [Validators.required]),
      freeFacility: new FormControl('', [Validators.required]),
    })
  }

  submit() {
    const facility = this.facilityAddForm.value;
    this.facilityService.saveFacility(facility).subscribe(() => {
      alert('Tạo thành công');
      this.facilityAddForm.reset();
    }, e => console.log(e), () => {
      this.router.navigateByUrl('/facility/list');
    });

  }


  // Select Facility
  selectFacility(event: any) {
    console.log('Select data:')
    console.log(event)
    console.log(event.target.value);
    console.log(event.target.value.id);
    switch (event.target.value) {
      case '1: Object' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'block';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '2: Object':
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '3: Object':
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
