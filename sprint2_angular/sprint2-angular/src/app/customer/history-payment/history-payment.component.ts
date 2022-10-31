import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {HistoryPayment} from "../../model/history-payment";

@Component({
  selector: 'app-history-payment',
  templateUrl: './history-payment.component.html',
  styleUrls: ['./history-payment.component.css']
})
export class HistoryPaymentComponent implements OnInit {

  id: number;
  historyPaymentList: HistoryPayment[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getHistoryPaymentById();
  }

  getHistoryPaymentById() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.customerService.getHistoryPayment(this.id).subscribe(data => {
        this.historyPaymentList = data;
        console.log(this.historyPaymentList);
      });
    });
  }

}
