import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  private API_URL = 'http://localhost:8080/manager';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.API_URL + '/list');
  }

  getManagerById(id: number): Observable<any> {
    return this.http.get<any>(this.API_URL + '/detail/' + id);
  }

}
