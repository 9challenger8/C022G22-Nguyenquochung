import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RentType} from "../../model/facility/rentType";

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {

  private URL_RENT_TYPE = '';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<RentType[]> {
    return this.http.get<RentType[]>(this.URL_RENT_TYPE)
  }
}
