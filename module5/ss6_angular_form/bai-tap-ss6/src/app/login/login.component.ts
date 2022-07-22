import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login: FormGroup;

  constructor() {
    this.login = new FormGroup({
      email: new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl("",[Validators.required,Validators.minLength(6)])
    })
  }

  ngOnInit(): void {
  }

  loginSubmit() {
    console.log("Success")
  }
}
