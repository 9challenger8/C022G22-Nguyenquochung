import {Component, HostListener, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {TokenStorageService} from "../service/token-storage.service";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {ShareService} from "../service/share.service";
import {DataService} from "../service/data.service";
import {BookService} from "../service/book.service";
import {Book} from "../model/book";
import {formatDate} from "@angular/common";
import {CustomerService} from "../service/customer.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  //tim kiem
  bookSearch = '';
  bookSearchForm = new FormControl('');
  searchList: Book[] = [];

  // hien thi form dang ki
  loginFormClass = '';
  searchFormClass = '';
  fixBarClass = '';
  cartClass = '';

  //Dang nhap
  formGroup: FormGroup;
  roles: string[] = [];
  username: string;
  customer: any = {};
  returnUrl: string;

  currentUser: string;
  role: string;
  isLoggedIn = false;


  idCustomer:number = 0;

  curDate = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');

  constructor(private formBuild: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private shareService: ShareService,
              private data: DataService,
              private bookService: BookService,
              private customerService: CustomerService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }


  ngOnInit(): void {
    this.data.currentList.subscribe(list => this.searchList = list);

    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '';
    this.formGroup = this.formBuild.group({
        username: [''],
        password: [''],
        remember_me: ['']
      }
    );
    if (this.tokenStorageService.getToken()) {
      this.authService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
      this.getCustomerByUsername();
    }
    this.getBook();
    this.loadHeader();
  }

  displayLoginForm() {
    this.loginFormClass = 'active';
  }

  displayCart() {
    if (this.cartClass === 'active') {
      this.cartClass = '';
    } else {
      this.cartClass = 'active';
    }
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

  //Lay thong tin user
  getCustomerByUsername() {
    this.customerService.getCustomerByUsername(this.username).subscribe(data => {
      this.customer = data;
    });
  }

  // Tim kiem
  getBook(): void {
    this.bookService.getBook(this.bookSearch).subscribe(data => {
      this.searchList = data.content;
      console.log(this.searchList);
      this.data.changeMessage(this.searchList);
    }, e => {
      console.log(e);
    }, () => {
    })
  }

  searchBook() {
    console.log("tim kiem: " + this.bookSearchForm.value);
    this.bookSearch = this.bookSearchForm.value.trim();
    this.bookService.getBook(this.bookSearch).subscribe(data => {
      this.searchList = data.content;
      console.log(this.searchList);
      this.data.changeMessage(this.searchList);
    }, e => {
      console.log(e);
    }, () => {
    })
  }


  // Dang nhap
  onSubmit() {
    this.authService.login(this.formGroup.value).subscribe(data => {
      if (this.formGroup.value.remember_me === true) {
        this.tokenStorageService.saveTokenLocal(data.token);
        this.tokenStorageService.saveUserLocal(data);
      } else {
        this.tokenStorageService.saveTokenSession(data.token);
        this.tokenStorageService.saveUserSession(data);
      }

      //Dong form login
      this.loginFormClass = '';
      this.authService.isLoggedIn = true;

      this.username = this.tokenStorageService.getUser().username;
      this.roles = this.tokenStorageService.getUser().roles;
      this.formGroup.reset();
      this.router.navigateByUrl(this.returnUrl);
      this.toastr.success('Đăng nhập thành công', 'Đăng nhập: ', {
        timeOut: 3000,
        extendedTimeOut: 1500
      });
      this.shareService.sendClickEvent();
    }, err => {
      this.authService.isLoggedIn = false;
      this.toastr.error('Sai tên đăng nhập hoặc mật khẩu hoặc tài khoản chưa được kích hoạt', 'Đăng nhập thất bại: ', {
        timeOut: 3000,
        extendedTimeOut: 1500
      });
    });
  }

  //Dang xuat
  logOut() {
    this.tokenStorageService.signOut();
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }


}
