import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { DetailComponent } from './detail/detail.component';
import { HistoryPaymentComponent } from './history-payment/history-payment.component';


@NgModule({
  declarations: [DetailComponent, HistoryPaymentComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }
