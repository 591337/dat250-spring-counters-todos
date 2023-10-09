import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from './todo';
import { TodoService } from './todo.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
    title = "todo";
    todos: Todo[] = [];
    todo: Todo = { id: 0, description: '', summary: ''};
    constructor(private todoService: TodoService) { }
  
    ngOnInit() {
      this.refresh()
    }
    refresh() {
        this.todoService.getTodos().subscribe(data => {
            this.todos = data;
        })
    }
    addNewTodo() {
        console.log('addNewTodo() called');
        this.todoService.addTodo(this.todo).subscribe(
          newTodo => {
            this.todos.push(newTodo);
            this.todo.description = '';
            this.todo.summary = '';

          },
          error => {
            console.error('Error:', error);
            // Handle error here, e.g., display an error message to the user
          }
        );
      }
      delete(todo: Todo) {
        this.todoService.deleteTodo(todo).subscribe(to => {
            this.todos = this.todos.filter(t => t.id !== to.id)
        })
      }
  }
