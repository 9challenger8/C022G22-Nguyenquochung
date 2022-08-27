import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FacilityAddComponent} from './facility-add/facility-add.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';
import {FacilityListComponent} from './facility-list/facility-list.component';


const routes: Routes = [
  {path: 'add', component: FacilityAddComponent},
  {path: 'edit/:id', component: FacilityEditComponent},
  {path: 'list', component: FacilityListComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
