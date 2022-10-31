import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BookService {

  URL_BOOK = 'http://localhost:8080/api/public/book';

  constructor(private httpClient: HttpClient) {
  }

  getBook(name: string): Observable<any> {
    return this.httpClient.get(this.URL_BOOK + '/list' + '?name=' + name );
  }

  getBookById(id: number): Observable<any>{
    return this.httpClient.get(this.URL_BOOK + '/detail' + '/' + id)
  }

  getCart() {
    const cartJson = sessionStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
  }

  saveCart(cart: any) {
    const cartJson = JSON.stringify(cart);
    sessionStorage.setItem('cart', cartJson);
  }

  getCartTotalQuantity() {
    const cart = this.getCart();
    let total = 0;
    cart.forEach((item: any) => {
      total += item.quantity;
    });
    return total;
  }

  getCartTotalMany() {
    const cart = this.getCart();
    let total = 0;
    cart.forEach((item: any) => {
      total += item.price * item.quantity;
    });
    return total;
  }


}
