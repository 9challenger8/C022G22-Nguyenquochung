import {Component, OnInit} from '@angular/core';
import {Contract} from '../../model/contract/contract';
import {ContractDetailService} from '../../service/contract/contract-detail.service';
import {ContractService} from '../../service/contract/contract.service';
import {AttachFacilityService} from '../../service/contract/attach-facility.service';
import {AttachFacility} from '../../model/contract/attachFacility';
import {ContractDetail} from '../../model/contract/contractDetail';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contractDetailList: Array<ContractDetail> = [];
  attachFacilityList: Array<AttachFacility> = [];
  contractList: Array<Contract> = [];

  p = 1;


  // form add contract detail
  contractDetailAddForm: FormGroup;

  // search
  nameCustomerSearch = new FormControl('');

  // id contract find facility to display list attach facility
  idContract: number;

  // pagination
  indexPagination = 0;
  pages: Array<number>;
  totalPagination: number;

  constructor(private contractDetailService: ContractDetailService,
              private contractService: ContractService,
              private attachFacilityService: AttachFacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idContract = +paramMap.get('id');
    });

  }

  ngOnInit(): void {
    this.getSearchListByNamePagination();
    this.displayFormContractDetailAdd();
  }

  // create form contract detail add.
  displayFormContractDetailAdd() {
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('', Validators.required),
      contract: new FormControl('', Validators.required),
      attachFacility: new FormControl('', Validators.required)
    });
  }

  // chuyen du lieu contract khi mo form
  getFormContractDetailAdd(contract: any) {
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('', Validators.required),
      contract: new FormControl(contract, Validators.required),
      attachFacility: new FormControl('', Validators.required)
    });
  }

  saveContractDetail() {
    const contractDetail = this.contractDetailAddForm.value;
    contractDetail.id = +contractDetail.id;
    console.log(this.contractDetailAddForm.value);
    this.contractDetailService.saveContractDetail(contractDetail).subscribe(() => {
      alert('Tạo thành công');
      this.contractDetailAddForm.reset();
    }, e => console.log(e), () => {
      // this.router.navigateByUrl('/facility/list');
    });
  }

  getSearchListByNamePagination() {
    this.contractService.searchContractByNameCustomer(this.nameCustomerSearch.value).subscribe(data => {
      console.log(data);
      this.contractList = data;
      this.pages = new Array(data.totalPages);
    });
  }

  // getContractDetailListByContractId(idContract: number) {
  //   this.contractDetailService.getAttachFacilityByContractId(idContract).subscribe(data => {
  //     this.contractDetailList = data;
  //   });
  // }

  // getAllAttachFacility() {
  //   this.attachFacilityService.getAll().subscribe(data => {
  //     console.log('attach facility list:');
  //     console.log(data);
  //     this.attachFacilityList = data;
  //   });
  // }

}
