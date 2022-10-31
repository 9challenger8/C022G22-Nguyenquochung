import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Book} from "../model/book";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  bookList: Book[] = [];

  private subject = new BehaviorSubject(this.bookList);

  currentList = this.subject.asObservable();

  constructor() { }

  changeMessage(list: any) {
    this.subject.next(list);
  }

}
