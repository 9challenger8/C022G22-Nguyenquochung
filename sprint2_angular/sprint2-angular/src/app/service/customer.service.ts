import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  URL_BOOK = 'http://localhost:8080/api/public/customer';

  constructor(private http: HttpClient) {
  }

  getCustomerByUsername(name: string): Observable<any> {
    return this.http.get(this.URL_BOOK + '/detail/' + name)
  }

  getHistoryPayment(id: number): Observable<any> {
    return this.http.get(this.URL_BOOK + '/history/' + id)
  }

}
