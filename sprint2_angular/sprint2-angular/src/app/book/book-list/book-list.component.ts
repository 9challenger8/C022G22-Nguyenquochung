import {AfterContentInit, Component, DoCheck, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {BookService} from '../../service/book.service';
import {Book} from "../../model/book";
import {ToastrService} from "ngx-toastr";
import {DataService} from "../../service/data.service";
import {TokenStorageService} from "../../service/token-storage.service";
import {ShareService} from "../../service/share.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  cart: any = this.bookService.getCart();

  bookList: Book[] = [];

  username: string;
  currentUser: string;
  role: string;
  isLoggedIn = false;

  constructor(private bookService: BookService,
              private toast: ToastrService,
              private data: DataService,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  ngOnInit(): void {
    this.data.currentList.subscribe(list => this.bookList = list);
    this.loadHeader();
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }

  addToCart(book: any) {
    const idx = this.cart.findIndex((item: any) => {
      return item.id == book.id;
    });
    alert("Thêm thành công");
    this.toast.success('Thêm thành công', 'Thông báo');
    if (idx >= 0) {
      this.cart[idx].quantity += 1;
    } else {
      const cartItem: any = {
        image: book.image,
        id: book.id,
        author: book.author,
        name: book.name,
        price: book.price,
        quantity: 1,
        book: book
      };

      this.cart.push(cartItem);
    }
      this.bookService.saveCart(this.cart);
  }


}
