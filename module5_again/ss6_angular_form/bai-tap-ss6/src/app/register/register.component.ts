import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  // formPassword: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl("", [Validators.required, Validators.email]),

      // formPassword: new FormGroup({
        password: new FormControl("", [Validators.minLength(6), Validators.required]),
        confirmPassword: new FormControl("", [Validators.required]),
      // }),

      country: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.min(18), Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)])
    })
  }

  ngOnInit(): void {
  }

  registerFormSuccess() {
    console.log('Ok')
    console.log(this.registerForm)
  }

}
