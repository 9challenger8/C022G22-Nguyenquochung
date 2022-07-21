import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {FacilityAddComponent} from './facility/facility-add/facility-add.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'facility/add', component: FacilityAddComponent},
  {path: 'facility/list', component: ListFacilityComponent},
  {path: 'facility/edit', component: FacilityEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
