import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private API_URL = 'http://localhost:8080/facility';

  constructor(private http: HttpClient) {
  }

  getListBySearchAndPagination(name: string, idCard: string, indexPagination: number, size: number): Observable<any> {
    return this.http.get<any>(this.API_URL + '/searchList?nameManager=' + name + '&nameFacility=' + idCard +
      '&page=' + indexPagination + '&size=' + size);
  }

  saveFacility(facility: Facility): Observable<any> {
    return this.http.post<any>(this.API_URL + '/create', facility);
  }

  deleteFacility(id: number): Observable<any> {
    // @ts-ignore
    return this.http.patch<any>(this.API_URL + '/delete/' + id);
  }
}
