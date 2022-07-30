import { Injectable } from '@angular/core';
import {SeriesProduct} from '../model/seriesProduct';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SeriesProductService {
  private URL_SERIES_PRODUCT = '   http://localhost:3000/seriesProducts';

  constructor(private http: HttpClient) { }

  getAll(): Observable<SeriesProduct[]> {
    return this.http.get<SeriesProduct[]>(this.URL_SERIES_PRODUCT);
  }

  saveSeriesProduct(seriesProduct): Observable<SeriesProduct> {
    return this.http.post<SeriesProduct>(this.URL_SERIES_PRODUCT, seriesProduct);
  }

  findById(id: number): Observable<SeriesProduct> {
    return this.http.get<SeriesProduct>(this.URL_SERIES_PRODUCT + '/' + id);
  }

  updateSeriesProduct(id: number, seriesProduct: SeriesProduct): Observable<SeriesProduct> {
    return this.http.put<SeriesProduct>(this.URL_SERIES_PRODUCT + '/' + id, seriesProduct);
  }

  deleteSeriesProduct(id: string): Observable<SeriesProduct> {
    return this.http.delete<SeriesProduct>(this.URL_SERIES_PRODUCT + '/' + id);
  }
}
