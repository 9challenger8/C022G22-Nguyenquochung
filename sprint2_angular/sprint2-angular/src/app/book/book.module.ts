import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import {BookListComponent} from "./book-list/book-list.component";
import {DetailBookComponent} from "./detail-book/detail-book.component";
import {NgxUsefulSwiperModule} from "ngx-useful-swiper";


@NgModule({
  declarations: [
    BookListComponent,
    DetailBookComponent,
  ],
  imports: [
    CommonModule,
    BookRoutingModule,
    NgxUsefulSwiperModule
  ]
})
export class BookModule { }
