import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private URL_CATEGORY = 'http://localhost:3000/categorys';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CATEGORY);
  }
}
