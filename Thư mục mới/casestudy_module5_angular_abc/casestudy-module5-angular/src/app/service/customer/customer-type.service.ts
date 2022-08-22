import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../../model/customer/customerType';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  private URL_CUSTOMER_TYPE = 'http://localhost:3000/customerTypes';
  constructor(private http: HttpClient) {
  }


  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CUSTOMER_TYPE);
  }

  saveCustomerType(customerType): Observable<CustomerType> {
    return this.http.post<CustomerType>(this.URL_CUSTOMER_TYPE, customerType);
  }

  findById(id: number): Observable<CustomerType> {
    return this.http.get<CustomerType>(this.URL_CUSTOMER_TYPE + '/' + id);
  }

}
