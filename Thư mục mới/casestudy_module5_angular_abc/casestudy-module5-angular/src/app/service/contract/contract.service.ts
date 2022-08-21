import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  private URL_CONTRACT = 'http://localhost:8080/contract';

  constructor(private http:HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(this.URL_CONTRACT)
  }

  saveContract(contract):Observable<any>{
    return this.http.post<any>(this.URL_CONTRACT+'/create',contract);
  }

  findById(id : number):Observable<any>{
    return this.http.get<any>(this.URL_CONTRACT + "/detail/" + id);
  }

  deleteContract(id: number):Observable<any>{
    return this.http.delete<any>(this.URL_CONTRACT + '/delete/' + id);
  }

  updateContract(id: number, contract):Observable<any>{
    return this.http.put<any>(this.URL_CONTRACT + '/update/' + id,contract);
  }

  searchContractByNameCustomer(nameCustomer: string, indexPagination:number):Observable<any>{
    return this.http.get<any>(this.URL_CONTRACT + '/searchList?name=' + nameCustomer+'&page='+indexPagination);
  }
}
