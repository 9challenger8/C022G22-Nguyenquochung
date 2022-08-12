import { Component, OnInit } from '@angular/core';
import {Contract} from "../../model/contract/contract";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contractList : Array<Contract> = [];

  constructor() {

    this.contractList.push({id:1,customer:{id:1,name:'Joni'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
      endDate:'22-23-2021',deposit:'12000'})
    this.contractList.push({id:2,customer:{id:1,name:'Jonah'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
      endDate:'22-23-2021',deposit:'12000'})
    this.contractList.push({id:3,customer:{id:1,name:'Jone'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
      endDate:'22-23-2021',deposit:'12000'})
    this.contractList.push({id:4,customer:{id:1,name:'Joni'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
      endDate:'22-23-2021',deposit:'12000'})
    this.contractList.push({id:5,customer:{id:1,name:'Rose'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
      endDate:'22-23-2021',deposit:'12000'})
  }

  ngOnInit(): void {
  }

}
