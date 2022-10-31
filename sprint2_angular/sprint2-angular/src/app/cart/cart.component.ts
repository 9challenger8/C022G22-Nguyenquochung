import {Component, OnInit} from '@angular/core';
import {BookService} from "../service/book.service";
import Swal from 'sweetalert2';
import {render} from 'creditcardpayments/creditCardPayments';
import {BookOrder} from "../model/book-order";
import {BillDetail} from "../model/bill-detail";
import {Bill} from "../model/bill";
import {BookOrderService} from "../service/book-order.service";
import {BillService} from "../service/bill.service";
import {BillDetailService} from "../service/bill-detail.service";
import {formatDate} from "@angular/common";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {CustomerService} from "../service/customer.service";
import {TokenStorageService} from "../service/token-storage.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  totalQuantity: number = this.bookService.getCartTotalQuantity();
  totalMoney: number = this.bookService.getCartTotalMany();
  cart: any = [];

  // an hien nut delete all
  deleteButton = false;

  bookOrder: BookOrder = {};
  billDetail: BillDetail = {};
  bill: Bill = {};
  curDate = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
  today = new Date()

  //tim kiem user
  username: string = " ";
  customer: any = {};

  constructor(private bookService: BookService,
              private bookOrderService: BookOrderService,
              private billService: BillService,
              private billDetailService: BillDetailService,
              private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.cart = this.bookService.getCart();
    if (this.cart.length > 0) {
      this.deleteButton = true;
    }

    console.log(this.cart);

    this.loadHeader();
    this.getCustomerByUsername();

    // Thanh toán paypal.
    render(
      {
        id: "#payments",
        currency: "USD",
        value: this.totalMoney + "",
        onApprove: (details) => {
          this.saveHistoryPayment();
          alert("Thanh toan thanh cong");
        }
      }
    );
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.username = this.tokenStorageService.getUser().username;
    }
  }

  getCustomerByUsername() {
    this.customerService.getCustomerByUsername(this.username).subscribe(data => {
      this.customer = data;
    });
  }

  saveHistoryPayment() {
    this.bill = {
      dateCreate: this.curDate,
      isDeleted: false,
      id: this.today + ''
    }
    this.billService.createBill(this.bill).subscribe(() => {
    }, error => {
    }, () => {
      for (let i = 0; i < this.cart.length; i++) {
        this.bookOrder = {
          quantity: this.cart[i].quantity,
          book: this.cart[i].book,
          bill: this.bill
        }
        this.bookOrderService.createBookOrder(this.bookOrder).subscribe(() => {
          }, e => {
          }, () => {
            this.cart.shift();
            if (this.cart.length == 0) {
              this.billDetail = {
                customer: this.customer,
                bill: this.bill
              }
              this.billDetailService.createBillDetail(this.billDetail).subscribe(() => {
              }, error => {
              }, () => {
                this.clearCart();
              })
            }
          }
        )
      }
    })
  }

  subTotal(cart: any) {
    return cart.quantity * cart.price;
  }

  updateQuantity(idx: number, ev: any) {
    let newQuantity = ev.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    ev.target.value = newQuantity;
    this.cart[idx].quantity = ev.target.value;
    this.bookService.saveCart(this.cart);
    this.totalMoney = this.bookService.getCartTotalMany();
    this.totalQuantity = this.bookService.getCartTotalQuantity();
  }

  reduce(idx: number, quantity: any) {
    // tslint:disable-next-line:radix
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    this.cart[idx].quantity = newQuantity;
    this.bookService.saveCart(this.cart);
    this.totalMoney = this.bookService.getCartTotalMany();
    this.totalQuantity = this.bookService.getCartTotalQuantity();
  }

  up(idx: number, quantity: any) {
    let newQuantity = parseInt(quantity) + 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.cart[idx].quantity = newQuantity;
    this.bookService.saveCart(this.cart);
    this.totalMoney = this.bookService.getCartTotalMany();
    this.totalQuantity = this.bookService.getCartTotalQuantity();
  }

  delete(i: number) {
    // tslint:disable-next-line:variable-name
    const _this = this;
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Bạn có chắc không?',
      text: 'Hành động này không thể hoàn tác!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý!',
      cancelButtonText: 'Hủy!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        swalWithBootstrapButtons.fire(
          'Xóa!',
          'Đã xóa thành công',
          'success'
        );
        _this.cart.splice(i, 1);
        _this.bookService.saveCart(this.cart);
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Đã hủy',
          'Hú hồn không hủy thì mua hàng đi bạn :)',
          'success'
        );
      }
    });
  }

  deleteAll() {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Bạn có chắc không?',
      text: 'Hành động này không thể hoàn tác!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý!',
      cancelButtonText: 'Hủy!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        swalWithBootstrapButtons.fire(
          'Xóa!',
          'Đã xóa thành công',
          'success'
        );
        this.cart = [];
        this.totalMoney = 0;
        this.bookService.saveCart(this.cart);
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Đã hủy',
          'Hú hồn không hủy thì mua hàng đi bạn :)',
          'success'
        );
      }
    });
    this.deleteButton = false;
  }

  clearCart() {
    this.cart = [];
    this.totalMoney = 0;
    this.bookService.saveCart(this.cart);
    this.deleteButton = false;
  }

}
