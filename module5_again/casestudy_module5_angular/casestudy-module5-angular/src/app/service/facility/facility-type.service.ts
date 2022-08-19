import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FacilityType} from "../../model/facility/facilityType";

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {

  private URL_FACILITY_TYPE = 'http://localhost:8080/facilityType/list';

  constructor(private http:HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_FACILITY_TYPE)
  }
}
