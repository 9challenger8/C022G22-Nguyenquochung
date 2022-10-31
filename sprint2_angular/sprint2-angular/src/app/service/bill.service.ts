import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bill} from "../model/bill";

@Injectable({
  providedIn: 'root'
})
export class BillService {

  URL_BILL = 'http://localhost:8080/api/public/bill';

  constructor(private http: HttpClient) {
  }

  createBill(bill: Bill): Observable<Bill> {
    return this.http.post<Bill>(this.URL_BILL + '/create', bill);
  }
}
