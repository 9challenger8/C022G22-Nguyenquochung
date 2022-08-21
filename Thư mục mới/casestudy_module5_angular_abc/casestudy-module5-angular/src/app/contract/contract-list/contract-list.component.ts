import {Component, OnInit} from '@angular/core';
import {Contract} from "../../model/contract/contract";
import {ContractDetailService} from "../../service/contract/contract-detail.service";
import {ContractService} from "../../service/contract/contract.service";
import {AttachFacilityService} from "../../service/contract/attach-facility.service";
import {AttachFacility} from "../../model/contract/attachFacility";
import {ContractDetail} from "../../model/contract/contractDetail";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contractDetailList: Array<ContractDetail> = [];
  attachFacilityList: Array<AttachFacility> = [];
  contractList: Array<Contract> = [];


  // form add contract detail
  contractDetailAddForm: FormGroup;

  // search
  nameCustomerSearch = new FormControl('');

  //id contract find facility to display list attach facility
  idContract: number;

  //pagination
  indexPagination: number = 0;
  pages: Array<number>;
  totalPagination: number;

  constructor(private contractDetailService: ContractDetailService,
              private contractService: ContractService,
              private attachFacilityService: AttachFacilityService,
              private activatedRoute: ActivatedRoute,
              private router:Router) {
    // this.contractList.push({id:1,customer:{id:1,name:'Joni'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
    //   endDate:'22-23-2021',deposit:'12000'})
    // this.contractList.push({id:2,customer:{id:1,name:'Jonah'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
    //   endDate:'22-23-2021',deposit:'12000'})
    // this.contractList.push({id:3,customer:{id:1,name:'Jone'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
    //   endDate:'22-23-2021',deposit:'12000'})
    // this.contractList.push({id:4,customer:{id:1,name:'Joni'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
    //   endDate:'22-23-2021',deposit:'12000'})
    // this.contractList.push({id:5,customer:{id:1,name:'Rose'},facility:{id:1,name:'Room_123'},startDate:'12-22-2019',
    //   endDate:'22-23-2021',deposit:'12000'})
    // this.activatedRoute.paramMap.subscribe((paramMap:ParamMap)=>{
    //   this.idContract = +paramMap.get('id');
    // })

  }

  ngOnInit(): void {
    this.getSearchListByNamePagination();
    this.displayFormContractDetailAdd();
    this.getAllAttachFacility();
  }

  // create form contract detail add.
  displayFormContractDetailAdd() {
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('',Validators.required),
      contract: new FormControl('',Validators.required),
      attachFacility: new FormControl('',Validators.required)
    })
  }

  // chuyen du lieu contract khi mo form
  getFormContractDetailAdd(contract:any) {
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('',Validators.required),
      contract: new FormControl(contract,Validators.required),
      attachFacility: new FormControl('',Validators.required)
    })
  }

  saveContractDetail() {
    const contractDetail = this.contractDetailAddForm.value;
    contractDetail.id = +contractDetail.id;
    console.log(this.contractDetailAddForm.value)
    this.contractDetailService.saveContractDetail(contractDetail).subscribe(() => {
      alert('Tạo thành công');
      this.contractDetailAddForm.reset();
    }, e => console.log(e), () => {
      // this.router.navigateByUrl('/facility/list');
    });
  }

  getSearchListByNamePagination() {
    this.contractService.searchContractByNameCustomer(this.nameCustomerSearch.value, this.indexPagination).subscribe(data => {
      console.log(data)
      this.contractList = data.content
      this.pages = new Array(data['totalPages']);
    })
  }

  getContractDetailListByContractId(idContract: number) {
    this.contractDetailService.getAttachFacilityByContractId(idContract).subscribe(data => {
      this.contractDetailList = data;
    })
  }

  getAllAttachFacility() {
    this.attachFacilityService.getAll().subscribe(data => {
      console.log('attach facility list:')
      console.log(data);
      this.attachFacilityList = data;
    })
  }

  setPage(i: number, event: any) {
    event.preventDefault();
    this.indexPagination = i;
    this.getSearchListByNamePagination()
  }
}
