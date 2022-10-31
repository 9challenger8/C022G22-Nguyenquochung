import { Component, OnInit } from '@angular/core';
import {SwiperOptions} from 'swiper';
import {BookService} from "../../service/book.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Book} from "../../model/book";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-detail-book',
  templateUrl: './detail-book.component.html',
  styleUrls: ['./detail-book.component.css']
})
export class DetailBookComponent implements OnInit {

  idBook ;
  book: Book;
  cart: any = this.bookService.getCart();

  constructor(private bookService:BookService,
              private activatedRoute:ActivatedRoute,
              private toast: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idBook = +paramMap.get('id');
      this.bookService.getBookById(this.idBook).subscribe(data => {
          this.book = data;
      });
    });
  }

  swiperFeaturedConfig: SwiperOptions = {
    spaceBetween: 10,
    loop: true,
    centeredSlides: true,
    autoplay: {
      delay: 6000
    },
    pagination: {
      el: '.swiper-pagination',
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    breakpoints: {
      0: {
        slidesPerView: 1,
      },
      450: {
        slidesPerView: 2,
      },
      768: {
        slidesPerView: 3,
      },
      1024: {
        slidesPerView: 4,
      },
    },
  };

  ngOnInit(): void {
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
