import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer/customer.service';
import {CustomerTypeService} from '../../service/customer/customer-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerType} from '../../model/customer/customerType';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerTypeList: Array<CustomerType>;

  customerEdit: FormGroup;

  id: number;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    });
  }


  ngOnInit(): void {
    this.getAllCustomerType();
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypeList = data;
    });
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
        customerType: new FormControl(data.customerType, Validators.required),
        address: new FormControl(data.address, Validators.required)
      });
    });
  }

  updateCustomer(id: number) {
    const customer = this.customerEdit.value;

    this.customerService.updateCustomer(id, customer).subscribe(() => {
      alert('Successfully');
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/customer/list');
    });
  }

  compareObj(value, option) {
    return value.id === option.id;
  }
}
