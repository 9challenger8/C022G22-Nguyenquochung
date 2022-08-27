import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private URL_FACILITY = ' http://localhost:3000/facilities';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_FACILITY);
  }

  saveFacility(facility): Observable<any> {
    return this.http.post<any>(this.URL_FACILITY, facility);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>(this.URL_FACILITY + '/' + id);
  }

  deleteFacility(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_FACILITY + '/' + id);
  }

  updateFacility(id: number, facility): Observable<any> {
    return this.http.put<any>(this.URL_FACILITY + '/' + id, facility);
  }

  searchFacilityByName(name: string): Observable<any> {
    return this.http.get<any>(this.URL_FACILITY + '?name_like=' + name);
  }
}
