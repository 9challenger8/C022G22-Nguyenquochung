import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientInformationService {

  private URL = 'http://localhost:8080/patient';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL + '/list');
  }

  savePatient(patient): Observable<any> {
    return this.http.post<any>(this.URL + '/create', patient);
  }

  findById(id: string): Observable<any> {
    return this.http.get<any>(this.URL + '/detail/' + id);
  }

  deletePatient(id: string): Observable<any> {
    return this.http.delete<any>(this.URL + '/delete/' + id);
  }

  updatePatient(id: string, patient): Observable<any> {
    return this.http.put<any>(this.URL + '/update/' + id, patient);
  }

  searchPatientByName(name: string, indexPagination: number): Observable<any> {
    return this.http.get<any>(this.URL + '/searchList?name=' + name + '&page=' + indexPagination);
  }
}
