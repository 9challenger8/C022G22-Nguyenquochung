import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  // hien thi form dang ki
  loginFormClass = 'login-form-container';

  constructor() {
  }

  ngOnInit(): void {
  }

  displayLoginForm() {
    this.loginFormClass = 'active';
  }

  closeLoginForm() {
    this.loginFormClass = 'login-form-container';
  }


}
