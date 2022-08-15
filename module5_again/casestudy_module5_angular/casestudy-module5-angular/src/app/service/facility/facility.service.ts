import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../../model/customer/customer";
import {Facility} from "../../model/facility/facility";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private URL_FACILITY = '';

  constructor(private http : HttpClient) { }

  getAll(): Observable<Facility[]> {
    return this.http.get<Facility[]>(this.URL_FACILITY)
  }

  saveFacility(facility):Observable<Facility>{
    return this.http.post<Facility>(this.URL_FACILITY,facility);
  }

  findById(id : number):Observable<Facility>{
    return this.http.get<Facility>(this.URL_FACILITY + "/" + id);
  }

  deleteFacility(id: number):Observable<Facility>{
    return this.http.delete<Facility>(this.URL_FACILITY + '/' + id);
  }

  updateFacility(id: number, facility):Observable<Facility>{
    return this.http.put<Facility>(this.URL_FACILITY + '/' + id,facility);
  }

  searchFacilityByName(name: string):Observable<Facility[]>{
    return this.http.get<Facility[]>(this.URL_FACILITY + '?name_like=' + name);
  }
}
