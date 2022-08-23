import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../model/customer/customer';
import {Facility} from '../../model/facility/facility';
import {CustomerService} from '../../service/customer/customer.service';
import {ContractService} from '../../service/contract/contract.service';
import {FacilityService} from '../../service/facility/facility.service';
import {Router} from '@angular/router';
import {checkPositiveNumber} from '../../validator/validator';

@Component({
  selector: 'app-contract-add',
  templateUrl: './contract-add.component.html',
  styleUrls: ['./contract-add.component.css']
})
export class ContractAddComponent implements OnInit {

  contractAddForm: FormGroup;

  customerList: Array<Customer> = [];
  facilityList: Array<Facility> = [];

  constructor(private customerService: CustomerService,
              private contractService: ContractService,
              private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.displayContractAddForm();
    this.getAllCustomer();
    this.getAllFacility();
  }

  getAllCustomer() {
    this.customerService.getAll().subscribe(data => {
      this.customerList = data;
    });
  }

  getAllFacility() {
    this.facilityService.getAll().subscribe(data => {
      this.facilityList = data;
    });
  }

  displayContractAddForm() {
    this.contractAddForm = new FormGroup({
      customer: new FormControl('', [Validators.required]),
      facility: new FormControl('', [Validators.required]),
      startDate: new FormControl('', [Validators.required]),
      endDate: new FormControl('', [Validators.required]),
      deposit: new FormControl('', [Validators.required, checkPositiveNumber]),
      totalMoney: new FormControl('', [Validators.required])
    });
  }

  createContract() {
    const contract = this.contractAddForm.value;
    this.contractService.saveContract(contract).subscribe(() => {
      alert('Tạo thành công');
      this.contractAddForm.reset();
    }, e => console.log(e), () => {
      this.router.navigateByUrl('/contract/list');
    });
  }

}
