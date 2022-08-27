import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private URL_PRODUCT = 'http://localhost:3000/products';


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_PRODUCT);
  }

  saveProduct(product): Observable<any> {
    return this.http.post<any>(this.URL_PRODUCT, product);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>(this.URL_PRODUCT + '/' + id);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_PRODUCT + '/' + id);
  }

  updateProduct(id: number, product): Observable<any> {
    return this.http.put<any>(this.URL_PRODUCT + '/' + id, product);
  }

  searchProductByName(name: string): Observable<any> {
    return this.http.get<any>(this.URL_PRODUCT + '?name_like=' + name);
  }
}
