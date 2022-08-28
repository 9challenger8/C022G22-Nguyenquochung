import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AddComponent} from "./patientInformation/add/add.component";
import {EditComponent} from "./patientInformation/edit/edit.component";
import {ListComponent} from "./patientInformation/list/list.component";


const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'add',component:AddComponent},
  {path:'edit/:id',component:EditComponent},
  {path:'list',component:ListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
