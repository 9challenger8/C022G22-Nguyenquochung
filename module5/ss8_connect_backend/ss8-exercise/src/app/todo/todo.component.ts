import {Component, OnInit} from '@angular/core';
import {Todo} from "../model/todo";
import {FormControl, FormGroup} from "@angular/forms";
import {TodoService} from "../service/todo.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})

export class TodoComponent implements OnInit {

  todos: Todo[] = [];
  content = new FormControl('');


  constructor(private todoService: TodoService, private router: Router) {
    this.getAll()

  }

  ngOnInit(): void {

  }

  getAll() {
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }

  toggleTodo(i: number) {
    console.log(i)
    const value = this.content.value;
    const todo: Todo = {
      content: value,
      complete: true
    };
    this.todoService.findById(i).subscribe(data => {
      data.complete = true;
      this.todos[data.id].complete = !this.todos[data.id].complete;
    })
    this.todos[i].complete = !this.todos[i].complete;
  }


  change() {
    const value = this.content.value;

    if (value) {
      const todo: Todo = {
        content: value,
        complete: false
      };

      this.todoService.saveTodo(todo).subscribe(todos => {
        },
        error => {
        },
        () => {
          this.content.reset();
          // window.location.reload();
          this.getAll();
          this.router.navigateByUrl('/list');
        });
    }
  }

  deleteTodo(id: number) {
    this.todoService.deleteTodo(id).subscribe(() => {
      this.getAll();
      this.router.navigate(['/list']);
    }, e => {
      console.log(e);
    });
  }


}
