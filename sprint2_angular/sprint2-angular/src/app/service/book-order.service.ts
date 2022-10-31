import {Injectable} from '@angular/core';
import {BookOrder} from "../model/book-order";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BookOrderService {

  URL_BOOK_ORDER = 'http://localhost:8080/api/public/bookOrder';

  constructor(private http: HttpClient) {
  }

  createBookOrder(bookOrder: BookOrder): Observable<BookOrder> {
    return this.http.post<BookOrder>(this.URL_BOOK_ORDER + '/create', bookOrder);
  }
}
