import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {

  private URL_RENT_TYPE = '  http://localhost:3000/rentTypes';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_RENT_TYPE);
  }
}
