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

  idSeriesModal: string;
  nameProductModal: string;
  startDateProductModal: string;




  indexPagination: number = 0;
  totalPagination: number;
  pages:Array<number>;

  constructor(private seriesProduct: SeriesProductService,
              private router: Router) { }

  ngOnInit(): void {
   this.getAllPagination();
  }

  // getAll() {
  //   this.seriesProduct.getAll().subscribe(data => {
  //     this.seriesProducts = data;
  //   });
  // }

  getDataForModal(nameProductModal: string , idSeriesModal: string, startProductModal: string) {
    this.idSeriesModal = idSeriesModal;
    this.nameProductModal = nameProductModal;
    this.startDateProductModal = startProductModal;
  }

  deleteSeriesProduct() {
    this.seriesProduct.deleteSeriesProduct(this.idSeriesModal).subscribe(() => {
    }, e => {
      console.log(e);
    }, () => {
      this.ngOnInit();
    });
  }

  getAllPagination(){
    this.seriesProduct.getAllPagination(this.indexPagination).subscribe(data =>{
      console.log(data)
      this.seriesProducts = data.content;
      this.pages= new Array(data['totalPages']);
    })
  }

  setPage(i: number,event:any) {
    event.preventDefault();
    this.indexPagination = i;
    this.getAllPagination();
  }
}
