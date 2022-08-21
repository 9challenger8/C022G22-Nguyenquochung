import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private URL_CUSTOMER_SPRING = 'http://localhost:8080/customer';

  constructor(private http : HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CUSTOMER_SPRING +'/searchList')
  }

  saveCustomer(customer):Observable<any>{
    return this.http.post<any>(this.URL_CUSTOMER_SPRING+'/create',customer);
  }

  findById(id : number):Observable<any>{
    return this.http.get<any>(this.URL_CUSTOMER_SPRING + "/detail/" + id);
  }

  deleteCustomer(id: number):Observable<any>{
    return this.http.delete<any>(this.URL_CUSTOMER_SPRING + '/delete/' + id);
  }

  updateCustomer(id: number, customer):Observable<any>{
    return this.http.put<any>(this.URL_CUSTOMER_SPRING + '/update/' + id,customer);
  }

  searchCustomerByName(name: string, indexPagination:number):Observable<any>{
    return this.http.get<any>(this.URL_CUSTOMER_SPRING + '/searchList?name=' + name+'&page='+indexPagination);
  }

}
