import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ContractAddComponent} from './contract-add/contract-add.component';
import {ContractListComponent} from './contract-list/contract-list.component';

const routes: Routes = [
  {path: 'add', component: ContractAddComponent},
  {path: 'list', component: ContractListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContractRoutingModule { }
