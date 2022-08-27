import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractDetailService {

  private URL_CONTRACT_DETAIL = 'http://localhost:8080/contractDetail';

  constructor(private http: HttpClient) {
  }

  getAttachFacilityByContractId(idContract: number): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT_DETAIL + '/listById/' + idContract);
  }

  saveContractDetail(contractDetail): Observable<any> {
    return this.http.post<any>(this.URL_CONTRACT_DETAIL + '/create', contractDetail);
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT_DETAIL + '/list');
  }

}
