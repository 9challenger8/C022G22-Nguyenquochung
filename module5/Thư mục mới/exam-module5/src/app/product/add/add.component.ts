import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {SeriesProductService} from '../../service/series-product.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  products: Product[] = [];

  seriesProductAdd: FormGroup;

  constructor(private seriesProductService: SeriesProductService,
              private productService: ProductService,
              private router: Router) { }

  ngOnInit(): void {
    this.getForm();
    this.getAllProduct();
  }

  getForm() {
    this.seriesProductAdd = new FormGroup({
      id: new FormControl('', [Validators.pattern(/^LH\-[0-9]{4}$/), Validators.required]),
      product: new FormControl('', [Validators.required]),
      amount: new FormControl('', [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]),
      startDate: new FormControl('', [Validators.required]),
      produceDate: new FormControl('', [Validators.required]),
      expirationDate: new FormControl('', Validators.required),
    });
  }

  submit() {
    const seriesProduct = this.seriesProductAdd.value;
    console.log(seriesProduct)
    this.seriesProductService.saveSeriesProduct(seriesProduct).subscribe(() => {
      alert('Tạo thành công');
      this.seriesProductAdd.reset();
    }, e => console.log(e), () => {
      this.router.navigateByUrl('/list');
    });
  }

  getAllProduct() {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    });
  }

}
