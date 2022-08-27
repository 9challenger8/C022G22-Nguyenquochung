import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PatientInformationService {

  private URL = 'http://localhost:3000/patients';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL);
  }

  save(patient): Observable<any> {
    return this.http.post<any>(this.URL, patient);
  }

  findById(id: string): Observable<any> {
    return this.http.get<any>(this.URL + '/' + id);
  }

  delete(id: string): Observable<any> {
    return this.http.delete<any>(this.URL + '/' + id);
  }

  update(id: string, patient): Observable<any> {
    return this.http.put<any>(this.URL + '/' + id, patient);
  }

  search(name: string): Observable<any> {
    return this.http.get<any>(this.URL + '?name_like=' + name);
  }
}
