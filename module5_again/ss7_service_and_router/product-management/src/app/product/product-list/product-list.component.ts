import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../../../ss7/src/app/service/product.service";
import {Product} from "../../../../../ss7/src/app/model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  idModal: number;
  nameModal: string;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

  getDataForModal(id: number, name: string) {
    console.log(id)
    this.idModal = id;
    this.nameModal = name;
  }

}
