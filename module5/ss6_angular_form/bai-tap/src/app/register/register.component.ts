import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", [Validators.minLength(6), Validators.required]),
      confirmPassword: new FormControl("", [Validators.required]),
      country: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.min(18), Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)])
    }, this.validateConfirmPassword)
  }

  validateConfirmPassword(item: AbstractControl) {
    console.log("abc")
    console.log(item.value);
    console.log(item.value.password);
    const pass = item.value.password;

    const confirm = item.value.confirmPassword;
    if (pass != confirm) {
      return {'checkPassword': true};
    }
    return null;
  }

  ngOnInit(): void {
  }

  registerFormSuccess() {
    console.log('Ok')
  }
}
