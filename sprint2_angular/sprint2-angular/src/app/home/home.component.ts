import {AfterViewInit, Component, HostListener, OnInit, ViewChild} from '@angular/core';
import Swiper, {Navigation, Pagination, SwiperOptions} from 'swiper';


import SwiperCore, {Autoplay} from 'swiper';

SwiperCore.use([Autoplay]);


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() {
  }

  bookSliderConfig: SwiperOptions = {
    loop: true,
    centeredSlides: true,
    autoplay: {
      delay: 1000,
      disableOnInteraction: false,
    },
    breakpoints: {
      0: {
        slidesPerView: 1,
      },
      768: {
        slidesPerView: 2,
      },
      1024: {
        slidesPerView: 3,
      },
    },
  };

  // bookSlider = new Swiper('.blogs-slider', this.bookSliderConfig);

  // @ViewChild('bookSlider', { static: false }) bookSlider: any;
  swiperFeaturedConfig: SwiperOptions = {
    spaceBetween: 10,
    loop: true,
    centeredSlides: true,
    autoplay: {
      delay: 2000
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

  // @ViewChild('arrivalsSlider', { static: false }) arrivalsSlider: any;
  arrivalsSliderConfig: SwiperOptions = {
    spaceBetween: 10,
    loop: true,
    centeredSlides: true,
    autoplay: {
      delay: 2000,
      disableOnInteraction: false,
    },
    pagination: {clickable: true},
    breakpoints: {
      0: {
        slidesPerView: 1,
      },
      768: {
        slidesPerView: 2,
      },
      1024: {
        slidesPerView: 3,
      },
    },
  };

  ngOnInit(): void {
  }
}
