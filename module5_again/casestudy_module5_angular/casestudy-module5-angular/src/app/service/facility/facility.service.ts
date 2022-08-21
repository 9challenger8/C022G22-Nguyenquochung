import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private URL_FACILITY = 'http://localhost:8080/facility';

  constructor(private http : HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_FACILITY+'/list')
  }

  saveFacility(facility):Observable<any>{
    return this.http.post<any>(this.URL_FACILITY+'/create',facility);
  }

  findById(id : number):Observable<any>{
    return this.http.get<any>(this.URL_FACILITY + "/detail/" + id);
  }

  deleteFacility(id: number):Observable<any>{
    return this.http.delete<any>(this.URL_FACILITY + '/delete/' + id);
  }

  updateFacility(id: number, facility):Observable<any>{
    return this.http.put<any>(this.URL_FACILITY + '/update/' + id,facility);
  }

  searchFacilityByName(name: string,indexPagination:number):Observable<any>{
    return this.http.get<any>(this.URL_FACILITY + '/searchList?name=' + name+'&page='+indexPagination);
  }
}
