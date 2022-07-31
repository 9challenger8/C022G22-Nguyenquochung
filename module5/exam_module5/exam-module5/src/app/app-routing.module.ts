import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './product/list/list.component';
import {AddComponent} from './product/add/add.component';
import {HomeComponent} from './home/home.component';
import {EditComponent} from "./product/edit/edit.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'list', component: ListComponent},
  {path: 'add', component: AddComponent},
  {path: 'edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
