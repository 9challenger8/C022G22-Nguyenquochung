import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ITodo} from "../model/todo";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private URL_TODO = "http://localhost:3000/todos";

  constructor(private http:HttpClient) { }

  getTodo(count = 10): Observable<ITodo[]> {
    return this.http.get<ITodo[]>(this.URL_TODO).pipe(
      map(data => data.filter( ( todo, i ) => i < count))
    ) ;
  }

  updateTodo( todo: ITodo) : Observable<ITodo> {
    return this.http.patch<ITodo>(
      `${this.URL_TODO}/${todo.id}`, todo);
  }

  deleteTodo(id : number): Observable<any> {
    return this .http.delete(
      `${this.URL_TODO}/${id}`
    ) ;
  }

  createTodo( todo: Partial<ITodo> ): Observable<ITodo> {
    return this.http.post<ITodo>(this.URL_TODO, todo);
  }

}
