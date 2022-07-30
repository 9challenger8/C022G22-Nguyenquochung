import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {SeriesProductService} from '../../service/series-product.service';
import {SeriesProduct} from '../../model/seriesProduct';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  seriesProducts: SeriesProduct[] = [];

  p = 1;
  idSeriesModal: string;
  nameProductModal: string;
  startDateProductModal: string;

  constructor(private seriesProduct: SeriesProductService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.seriesProduct.getAll().subscribe(data => {
      this.seriesProducts = data;
    });
  }

  getDataForModal(nameProductModal: string , idSeriesModal: string, startProductModal: string) {
    this.idSeriesModal = idSeriesModal;
    this.nameProductModal = nameProductModal;
    this.startDateProductModal = startProductModal;
  }

  deleteCustomer() {
    this.seriesProduct.deleteSeriesProduct(this.idSeriesModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
    });
  }

}
