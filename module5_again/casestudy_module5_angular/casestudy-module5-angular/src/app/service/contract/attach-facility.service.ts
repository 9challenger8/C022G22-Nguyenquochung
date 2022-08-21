import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AttachFacilityService {

  private URL_ATTACH_FACILITY = 'http://localhost:8080/attachFacility/list';

  constructor(private http:HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_ATTACH_FACILITY)
  }


}
