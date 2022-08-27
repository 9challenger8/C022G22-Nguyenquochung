import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerListComponent} from './customer-list/customer-list.component';


const routes: Routes = [
  {path: 'add', component: CustomerAddComponent},
  {path: 'edit/:id', component: CustomerEditComponent},
  {path: 'list', component: CustomerListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
