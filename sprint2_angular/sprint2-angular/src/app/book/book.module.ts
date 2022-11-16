import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import {BookListComponent} from "./book-list/book-list.component";
import {DetailBookComponent} from "./detail-book/detail-book.component";
import {NgxUsefulSwiperModule} from "ngx-useful-swiper";
import { BookAddComponent } from './book-add/book-add.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    BookListComponent,
    DetailBookComponent,
    BookAddComponent,
  ],
  imports: [
    CommonModule,
    BookRoutingModule,
    NgxUsefulSwiperModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule
  ]
})
export class BookModule { }
