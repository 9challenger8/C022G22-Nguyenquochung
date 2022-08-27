import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, Validators} from "@angular/forms";
import {CustomValidationService} from "../custom-validation.service";


@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  stateOptions: string[] = ["PA", "OH", "MI"];

  userAddressInfo: any = {
    street: "1234 Main Street",
    city: "My City",
    state: this.stateOptions[0],
    zip: "12345"
  };

  userForm = this.fb.group(
    {
      username: [
        "",
        [Validators.required, Validators.minLength(3)]
      ],
      password: ["", Validators.required],
      confirmPassword: ["", Validators.required],
      address: this.fb.group({
        street: [""],
        city: [""],
        state: [""],
        zip: [""]
      }),
      daysAvailable: this.fb.array([this.fb.control("")])
    },
    {
      validator: this.customValidationService.passwordMatchValidator(
        "password",
        "confirmPassword"
      )
    }
  );

  ngOnInit() {}

  constructor(
    private fb: FormBuilder,
    private customValidationService: CustomValidationService
  ) {}

  autoFillAddress() {
    this.userForm.patchValue({
      address: {
        street: this.userAddressInfo.street,
        city: this.userAddressInfo.city,
        state: this.userAddressInfo.state,
        zip: this.userAddressInfo.zip
      }
    });
  }

  addDay() {
    this.daysAvailable.push(this.fb.control(""));
  }

  get daysAvailable() {
    return this.userForm.get("daysAvailable") as FormArray;
  }

  get username() {
    return this.userForm.get("username");
  }

  get confirmPassword() {
    return this.userForm.get("confirmPassword");
  }

  get password() {
    return this.userForm.get("password");
  }

  clear() {
    this.userForm.reset();
  }

  onSubmit() {
    console.log(this.userForm.value);
  }

}
