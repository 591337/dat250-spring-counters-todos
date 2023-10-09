import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Todo } from './todo';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  // API URI
  private _url: string = "http://localhost:8080/todos"
  constructor(private http: HttpClient) { }

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this._url);
  }

  addTodo(todo: Todo): Observable<Todo> {
    return this.http.post<Todo>(this._url, todo)
  }

  deleteTodo(todo: Todo): Observable<Todo> {
    return this.http.delete<Todo>(this._url + "/" + todo.id)
  }

}