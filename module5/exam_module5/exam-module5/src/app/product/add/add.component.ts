import {Component, Inject, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {SeriesProductService} from '../../service/series-product.service';
import {AngularFireStorage} from "@angular/fire/storage";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {

  products: Product[] = [];

  seriesProductAdd: FormGroup;

  selectedImage:any=null;

  constructor(private seriesProductService: SeriesProductService,
              private productService: ProductService,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) { }

  ngOnInit(): void {
    this.getForm();
    this.getAllProduct();
  }

  getForm() {
    this.seriesProductAdd = new FormGroup({
      image:new FormControl(''),
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

  showPreview(event: any) {
    this.selectedImage= event.target.files[0];
    console.log(this.selectedImage)
  }

  saveImg(){
    // const nameImg= this.getCurrentDateTime() + this.selectedImage.name
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy', 'en-US');
  }


}
