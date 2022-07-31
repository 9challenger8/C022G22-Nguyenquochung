import {Injectable} from '@angular/core';
import {SeriesProduct} from '../model/seriesProduct';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SeriesProductService {
  private URL_SERIES_PRODUCT = 'http://localhost:3000/seriesProducts';

  private URL_SERIES_PRODUCT_SPRING = 'http://localhost:8080/seriesProduct';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<SeriesProduct[]> {
    return this.http.get<SeriesProduct[]>(this.URL_SERIES_PRODUCT);
  }

  // GET /posts?_page=7&_limit=20
  getAllPagination(indexPagination: number): Observable<any> {
    return this.http.get<[any]>(this.URL_SERIES_PRODUCT_SPRING + '/list?page=' + indexPagination);
  }

  saveSeriesProduct(seriesProduct): Observable<any> {
    return this.http.post<any>(this.URL_SERIES_PRODUCT_SPRING + '/create', seriesProduct);
  }

  findById(id: string): Observable<any> {
    return this.http.get<any>(this.URL_SERIES_PRODUCT_SPRING + '/detail/' + id);
  }

  updateSeriesProduct(id: string, seriesProduct: SeriesProduct): Observable<any> {
    return this.http.put<any>(this.URL_SERIES_PRODUCT_SPRING + '/update/' + id, seriesProduct);
  }

  deleteSeriesProduct(id: string): Observable<any> {
    return this.http.delete<any>(this.URL_SERIES_PRODUCT_SPRING + '/delete/' + id);
  }
}
