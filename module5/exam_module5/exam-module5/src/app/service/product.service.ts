import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  private URL_PRODUCT = 'http://localhost:8080/product/list';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_PRODUCT);
  }


}
