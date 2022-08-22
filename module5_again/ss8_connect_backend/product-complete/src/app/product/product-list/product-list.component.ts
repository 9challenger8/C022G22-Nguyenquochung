import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

   idModal: number;
   nameModal: string;

  products: Array<Product> = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(data=>{
      this.products = data;
    })
  }

  getDataForModal(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }

}
