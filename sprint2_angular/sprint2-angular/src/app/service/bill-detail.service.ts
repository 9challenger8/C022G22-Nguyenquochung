import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BillDetail} from "../model/bill-detail";

@Injectable({
  providedIn: 'root'
})
export class BillDetailService {

  URL_BILL_DETAIL = 'http://localhost:8080/api/public/billDetail';

  constructor(private http: HttpClient) {
  }

  createBillDetail(billDetail: BillDetail): Observable<BillDetail> {
    return this.http.post<BillDetail>(this.URL_BILL_DETAIL + '/create', billDetail);
  }
}
