import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {FacilityAddComponent} from "./facility/facility-add/facility-add.component";
import {FacilityEditComponent} from "./facility/facility-edit/facility-edit.component";
import {FacilityListComponent} from "./facility/facility-list/facility-list.component";


const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'facility/add',component:FacilityAddComponent},
  {path:'facility/edit',component:FacilityEditComponent},
  {path:'facility/list',component:FacilityListComponent},
  {path:'customer/add',component:FacilityListComponent},
  {path:'customer/edit',component:FacilityListComponent},
  {path:'customer/list',component:FacilityListComponent},
  {path:'contract/add',component:FacilityListComponent},
  {path:'contract/list',component:FacilityListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
