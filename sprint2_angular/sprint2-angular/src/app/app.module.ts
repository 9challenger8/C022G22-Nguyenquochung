import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import {NgxUsefulSwiperModule} from 'ngx-useful-swiper';
import { CartComponent } from './cart/cart.component';
import { ListBookComponent } from './list-book/list-book.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CartComponent,
    ListBookComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgxUsefulSwiperModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
