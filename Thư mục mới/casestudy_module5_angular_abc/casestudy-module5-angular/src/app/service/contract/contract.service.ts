import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  private URL_CONTRACT = 'http://localhost:3000/contracts';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT);
  }

  saveContract(contract): Observable<any> {
    return this.http.post<any>(this.URL_CONTRACT + '/', contract);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT + '/' + id);
  }

  deleteContract(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_CONTRACT + '/' + id);
  }

  updateContract(id: number, contract): Observable<any> {
    return this.http.put<any>(this.URL_CONTRACT + '/' + id, contract);
  }

  searchContractByNameCustomer(nameCustomer: string): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT + '/?customer.name_like=' + nameCustomer );
  }
}
