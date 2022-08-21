import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../../model/customer/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private URL_CUSTOMER = 'http://localhost:3000/customers';

  private URL_CUSTOMER_SPRING = 'http://localhost:8080/customer';

  constructor(private http : HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CUSTOMER_SPRING +'/list')
  }

  saveCustomer(customer):Observable<any>{
    return this.http.post<any>(this.URL_CUSTOMER,customer);
  }

  findById(id : number):Observable<any>{
    return this.http.get<any>(this.URL_CUSTOMER + "/" + id);
  }

  deleteCustomer(id: number):Observable<any>{
    return this.http.delete<any>(this.URL_CUSTOMER + '/' + id);
  }

  updateCustomer(id: number, customer):Observable<any>{
    return this.http.put<any>(this.URL_CUSTOMER + '/' + id,customer);
  }

  searchCustomerByName(name: string):Observable<any>{
    return this.http.get<any>(this.URL_CUSTOMER + '?name_like=' + name);
  }

}
