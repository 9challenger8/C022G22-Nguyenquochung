import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ProductEditComponent} from "./product/product-edit/product-edit.component";
import {ProductListComponent} from "./product/product-list/product-list.component";
import {ProductCreatComponent} from "./product/product-creat/product-creat.component";
import {ProductDeleteComponent} from "./product/product-delete/product-delete.component";


const routes: Routes = [
  {
    path: 'product/list',
    component: ProductListComponent
  }, {
    path: 'product/create',
    component: ProductCreatComponent
  }, {
    path: 'product/edit/:id',
    component: ProductEditComponent
  }, {
    path: 'product/delete/:id',
    component: ProductDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
