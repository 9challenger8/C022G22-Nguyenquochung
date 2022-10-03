import {Component, HostListener, OnInit} from '@angular/core';

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
  searchFormClass = '';
  fixBarClass = '';

  ngOnInit(): void {
  }

  displayLoginForm() {
    this.loginFormClass = 'active';
  }

  closeLoginForm() {
    this.loginFormClass = '';
  }

  displaySearchForm() {
    if (this.searchFormClass === 'active') {
      this.searchFormClass = '';
    } else {
      this.searchFormClass = 'active';
    }
  }

  @HostListener('window:scroll', ['$event'])
  onScroll() {
    if (window.scrollY > 80) {
      this.fixBarClass = 'active';
    } else {
      this.fixBarClass = '';
    }
  }
}
