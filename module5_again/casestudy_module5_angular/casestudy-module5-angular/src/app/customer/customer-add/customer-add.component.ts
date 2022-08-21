import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer/customer.service';
import {CustomerTypeService} from '../../service/customer/customer-type.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../model/customer/customerType';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {

  customerTypeList: Array<CustomerType>;
  customerAdd: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.getFormAddCustomer();
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypeList = data;
    });
  }

  getFormAddCustomer() {
    this.customerAdd = new FormGroup({
        name: new FormControl('', [Validators.pattern(/^([A-Z][a-z]*\s*)*$/), Validators.required]),
        dateOfBirth: new FormControl('', [Validators.required]),
        gender: new FormControl('', [Validators.required]),
        cardId: new FormControl('', [Validators.required, Validators.pattern(/(^[0-9]{9}|[0-9]{12})$/)]),
        phoneNumber: new FormControl('', [Validators.pattern(/^(090\d{7}|091\d{7}|(84)+90\d{7}|(84)+91\d{7})$/)
          , Validators.required]),
        email : new FormControl('',Validators.required),
        customerType: new FormControl('', Validators.required),
        address: new FormControl('', Validators.required)
      }
    );
  }

  submit() {
    const customer = this.customerAdd.value;
    this.customerService.saveCustomer(customer).subscribe(() => {
      alert('Successfully');
    }, e => {
      console.log(e);
    }, () => {
      this.router.navigateByUrl('/customer/list');
    });
  }

}
