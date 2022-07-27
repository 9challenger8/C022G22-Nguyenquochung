import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../../model/customer/customerType";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../service/customer/customer.service";
import {CustomerTypeService} from "../../service/customer/customer-type.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerTypes: CustomerType[] = [];
  id:number;

  customerEdit: FormGroup;

  constructor(private customerService:CustomerService,
              private customerTypeService:CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    });


  }

  ngOnInit(): void {
    this.getAllCustomerType()
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(data => {
      this.customerEdit = new FormGroup({
        name: new FormControl(data.name, [Validators.pattern(/^([A-Z][a-z]+\s?)+$/), Validators.required]),
        dateOfBirth: new FormControl(data.dateOfBirth, [Validators.required]),
        gender: new FormControl(data.gender, [Validators.required]),
        cardId: new FormControl(data.cardId, [Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]),
        phoneNumber: new FormControl(data.phoneNumber, [Validators.pattern(/(^090\d{7}|091\d{7}|(84)+90\d{7}|(84)+91\d{7})$/)
          , Validators.required]),
        customerType: new FormControl(data.customerType.id, Validators.required),
        address: new FormControl(data.address, Validators.required)
      });
    });
  }

  updateCustomer(id: number) {
    const customer = this.customerEdit.value;
    customer.customerType = {
      id: customer.customerType
    };
    this.customerService.updateCustomer(id, customer).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('/customer/list');
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
    });
  }


}
