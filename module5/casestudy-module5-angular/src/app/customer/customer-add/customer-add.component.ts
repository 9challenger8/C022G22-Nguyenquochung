import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../service/customer/customer.service";
import {CustomerTypeService} from "../../service/customer/customer-type.service";
import {CustomerType} from "../../model/customer/customerType";
import {Router} from "@angular/router";
import {Customer} from "../../model/customer/customer";

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {

  customerTypes: CustomerType[] = [];

  customerAdd: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
  }

  getForm(){
    this.customerAdd = new FormGroup({
      name: new FormControl('', [Validators.pattern(/^([A-Z][a-z]*\s*)*$/), Validators.required]),
      dateOfBirth: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      cardId: new FormControl('', [Validators.required, Validators.pattern(/(^[0-9]{9}|[0-9]{12})$/)]),
      phoneNumber: new FormControl('', [Validators.pattern(/^(090\d{7}|091\d{7}|(84)+90\d{7}|(84)+91\d{7})$/)
        , Validators.required]),
      customerType: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.getAllCustomerType();
    this.getForm()
  }

  submit() {
    const customer = this.customerAdd.value;

    // customer.customerType = {
    //   id: customer.customerType
    // };


    // const customer: Customer ={
    //   name: value.name,
    //   dateOfBirth: value.dateOfBirth,
    //   gender: value.gender,
    //   cardId: value.cardId,
    //   phoneNumber: value.phoneNumber,
    //   customerType: {
    //     id: value.customerType,
    //     name: value.customerType
    //   },
    //   address: value.address
    // }

    this.customerService.saveCustomer(customer).subscribe(() => {
      alert('Tạo thành công');
      this.customerAdd.reset();
    }, e => console.log(e), () => {
      this.router.navigateByUrl('/customer/list');
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
    });
  }

}
