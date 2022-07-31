import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SeriesProductService} from "../../service/series-product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  seriesProductEdit: FormGroup;


  products: Product[] = [];

  id:string;

  constructor(private seriesProductService:SeriesProductService,
              private productService: ProductService,
              private router:Router,
              private activatedRoute:ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap:ParamMap)=>{
      this.id = paramMap.get('id');
      this.getSeriesProduct(this.id)
    })

  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getSeriesProduct(id:string) {
      this.seriesProductService.findById(id).subscribe(data =>{

        this.seriesProductEdit = new FormGroup({
          id: new FormControl(data.id, [Validators.pattern(/^LH\-[0-9]{4}$/), Validators.required]),
          product: new FormControl(data.product.id, [Validators.required]),
          amount: new FormControl(data.amount, [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]),
          startDate: new FormControl(data.startDate, [Validators.required]),
          produceDate: new FormControl(data.produceDate, [Validators.required]),
          expirationDate: new FormControl(data.expirationDate, Validators.required),
        });
      })
  }

  updateSeriesProduct(id:string){
    const seriesProduct = this.seriesProductEdit.value
    seriesProduct.product={
      id:seriesProduct.product
    }
    console.log(seriesProduct)

    this.seriesProductService.updateSeriesProduct(id,seriesProduct).subscribe(() => {
    } , e=>{
    },()=>{
      alert('Cập nhật thành công');
      this.router.navigateByUrl('/list');
    })

  }

  getAllProduct() {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    });
  }

}
