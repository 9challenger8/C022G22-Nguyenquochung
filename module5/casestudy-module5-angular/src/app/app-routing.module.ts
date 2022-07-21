import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {FacilityAddComponent} from './facility/facility-add/facility-add.component';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CustomerAddComponent} from "./customer/customer-add/customer-add.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";
import {ContractListComponent} from "./contract/contract-list/contract-list.component";
import {ContractAddComponent} from "./contract/contract-add/contract-add.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'facility/add', component: FacilityAddComponent},
  {path: 'facility/list', component: FacilityListComponent},
  {path: 'facility/edit', component: FacilityEditComponent},
  {path: 'customer/list', component: CustomerListComponent},
  {path: 'customer/add', component:CustomerAddComponent},
  {path: 'customer/edit', component:CustomerEditComponent},
  {path: 'contract/list', component: ContractListComponent},
  {path: 'contract/add', component: ContractAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
