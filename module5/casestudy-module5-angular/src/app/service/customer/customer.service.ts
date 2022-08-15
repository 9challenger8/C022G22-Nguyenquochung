import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Customer} from "../../model/customer/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private URL_CUSTOMER = 'http://localhost:3000/customers';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL_CUSTOMER);
  }

  saveCustomer(customer): Observable<Customer> {
    return this.http.post<Customer>(this.URL_CUSTOMER, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(this.URL_CUSTOMER + '/' + id);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(this.URL_CUSTOMER + '/' + id, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(this.URL_CUSTOMER + '/' + id);
  }

  searchCustomerByNameCustomerAndIdCard(name: string , cardId: string): Observable <Customer[]> {
    return this.http.get<Customer[]>(this.URL_CUSTOMER + '?name_like=' + name + '&cardId_like=' + cardId);
  }

}
