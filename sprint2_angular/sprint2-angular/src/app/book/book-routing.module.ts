import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookListComponent} from "./book-list/book-list.component";
import {DetailBookComponent} from "./detail-book/detail-book.component";


const routes: Routes = [
  {
    path: 'book',
    component: BookListComponent
    // canActivate: [AuthGuard],
    // data: {
    //   roles: ['ROLE_ADMIN']
    // }
  },
  {
    path: 'book/detail/:id',
    component: DetailBookComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
