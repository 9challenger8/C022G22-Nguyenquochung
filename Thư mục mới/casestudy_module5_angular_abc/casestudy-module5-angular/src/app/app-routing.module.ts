import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {FacilityAddComponent} from './facility/facility-add/facility-add.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {CustomerAddComponent} from './customer/customer-add/customer-add.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {ContractAddComponent} from './contract/contract-add/contract-add.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'facility/add', component: FacilityAddComponent},
  {path: 'facility/edit/:id', component: FacilityEditComponent},
  {path: 'facility/list', component: FacilityListComponent},
  {path: 'customer/add', component: CustomerAddComponent},
  {path: 'customer/edit/:id', component: CustomerEditComponent},
  {path: 'customer/list', component: CustomerListComponent},
  {
    path: 'contract',
    loadChildren: () => import('./contract/contract.module').then(module => module.ContractModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
