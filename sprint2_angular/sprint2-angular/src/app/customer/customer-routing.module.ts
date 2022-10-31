import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailComponent} from "./detail/detail.component";
import {HistoryPaymentComponent} from "./history-payment/history-payment.component";


const routes: Routes = [
  {
    path:'customer/detail/:name',
    component:DetailComponent
  },
  {
    path:'customer/history/:id',
    component: HistoryPaymentComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
