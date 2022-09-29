import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() {
  }

  // hien thi form dang ki
  loginFormClass = '';

  ngOnInit(): void {
  }

  displayLoginForm() {
    this.loginFormClass = 'active';
  }

  closeLoginForm() {
    this.loginFormClass = '';
  }
}
