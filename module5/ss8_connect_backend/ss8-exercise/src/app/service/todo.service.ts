import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Todo} from "../model/todo";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private URL_TODOS = "http://localhost:3000";


  constructor(private http:HttpClient) { }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.URL_TODOS + '/todos');
  }

  saveTodo(todo): Observable<Todo> {
    return this.http.post<Todo>(this.URL_TODOS + '/todos', todo);
  }

  findById(id: number): Observable<Todo> {
    return this.http.get<Todo>(this.URL_TODOS+ '/todos/'+ id);
  }

  updateTodo(id: number, todo: Todo): Observable<Todo> {
    return this.http.put<Todo>(this.URL_TODOS+ '/todos/'+id, todo);
  }

  patchTodo(id: number,todo:Todo): Observable<Todo> {
    return this.http.patch<Todo>(this.URL_TODOS + '/todos/'+id,todo);
  }

  deleteTodo(id: number): Observable<Todo> {
    return this.http.delete<Todo>(this.URL_TODOS+ '/todos/' + id);
  }

}
