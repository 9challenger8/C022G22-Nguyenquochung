import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../model/customer/customer";
import {Facility} from "../../model/facility/facility";
import {CustomerService} from "../../service/customer/customer.service";
import {ContractService} from "../../service/contract/contract.service";
import {FacilityService} from "../../service/facility/facility.service";
import {Router} from "@angular/router";
import {ContractDetailService} from "../../service/contract/contract-detail.service";
import {AttachFacilityService} from "../../service/contract/attach-facility.service";
import {AttachFacility} from "../../model/contract/attachFacility";
import {ToastrService} from "ngx-toastr";
import {ContractDetail} from "../../model/contract/contractDetail";
import {Contract} from "../../model/contract/contract";
import {calculateDay} from "../../validator/validator";

@Component({
  selector: 'app-contract-add',
  templateUrl: './contract-add.component.html',
  styleUrls: ['./contract-add.component.css']
})
export class ContractAddComponent implements OnInit {

  contractAddForm: FormGroup;

  customerList: Array<Customer> = [];
  facilityList: Array<Facility> = [];
  attachFacilityList: Array<AttachFacility> = [];

  //khoi tao 1 contract de chua du lieu.
  contract: Contract;

  // list chứa dịch vụ đính kèm để thêm vào sau.
  contractDetailList: Array<ContractDetail> = [];

  // Form add attach facility
  contractDetailAddForm: FormGroup;

  //Total money
  totalMoney = 0;


  constructor(private customerService: CustomerService,
              private contractService: ContractService,
              private facilityService: FacilityService,
              private router: Router,
              private contractDetailService: ContractDetailService,
              private attachFacilityService: AttachFacilityService,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.displayContractAddForm();
    this.displayFormContractDetailAdd();
    this.getAllCustomer();
    this.getAllFacility();
    this.getAllAttachFacility();
  }

  getAllCustomer() {
    this.customerService.getAll().subscribe(data => {
      this.customerList = data;
    })
  }

  getAllFacility() {
    this.facilityService.getAll().subscribe(data => {
      console.log(data)
      this.facilityList = data;
    })
  }

  displayContractAddForm() {
    this.contractAddForm = new FormGroup({
      customer: new FormControl('', [Validators.required]),
      facility: new FormControl('', [Validators.required]),
      startDate: new FormControl('', [Validators.required]),
      endDate: new FormControl('', [Validators.required]),
      deposit: new FormControl('', [Validators.required]),
      totalMoney: new FormControl('', [Validators.required])
    })
  }

  // Khởi tạo form thêm dịch vụ đi kèm.
  displayFormContractDetailAdd() {
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('', Validators.required),
      contract: new FormControl('', Validators.required),
      attachFacility: new FormControl('', Validators.required)
    })
  }

  // truyen doi tuong contract vao de them moi bang contract detail.
  getFormContractDetailAdd() {
    this.contract = this.contractAddForm.value;
    console.log(this.contractAddForm)
    console.log("click: " + this.contract);
    console.log("hien thi id:  " + this.contract.id)
    this.totalMoney = this.calculateMoneyFacility(this.contract.startDate, this.contract.endDate
      , this.contract.deposit, this.contract.facility.cost);
    this.contractDetailAddForm = new FormGroup({
      // id: new FormControl('',Validators.required),
      quantity: new FormControl('', Validators.required),
      contract: new FormControl(this.contract, Validators.required),
      attachFacility: new FormControl('', Validators.required)
    })
  }

  //  Đẩy dư liệu vào danh sách contractDetailList để đợi thêm.
  saveContractDetail() {
    const contractDetail = this.contractDetailAddForm.value;
    console.log(contractDetail.attachFacility.cost);
    console.log(contractDetail.quantity);
    console.log("tong tien hien tai " +this.totalMoney )
    console.log(this.contractDetailAddForm.value)
    this.contractDetailList.push(contractDetail);
    this.totalMoney += this.calculateAttachFacility(contractDetail.attachFacility.cost,contractDetail.quantity);
    console.log(this.contractDetailList)
  }

  createContract() {
    // Hành động them contract.
    const contract = this.contractAddForm.value
    console.log(this.contractAddForm.value)
    this.contractService.saveContract(contract).subscribe(data => {
      this.contract = data;
      console.log("hien thi id:  " + this.contract.id)
      this.contractAddForm.reset();
    }, e => console.log(e), () => {
      console.log("XOng rồi.")
      //Hành động thêm dịch vụ đính kèm (thêm contract detail).
      for (let contractDetail of this.contractDetailList) {
        contractDetail.contract.id = this.contract.id;
        console.log("gan id : " + contractDetail.contract.id)
        this.contractDetailService.saveContractDetail(contractDetail).subscribe(() => {
        }, e => console.log(e), () => {
          console.log(" add attach  facility thanh cong lan " + this.contractDetailList.indexOf(contractDetail) + 1)
          this.contractDetailList.shift();
          if (this.contractDetailList.length === 0) {
            this.router.navigateByUrl('/contract/list');
            this.toastrService.success('Successfully added new attach facility.', 'Notification!');
          }
        });
      }
    });


  }

  getAllAttachFacility() {
    this.attachFacilityService.getAll().subscribe(data => {
      console.log('attach facility list:')
      console.log(data);
      this.attachFacilityList = data;
    })
  }

  //Ham tinh tong tien.
  calculateMoneyFacility(startDay: string, endDay: string, deposit: string, costFacility: string): number {
    const dayNumber: number = calculateDay(startDay, endDay);
    return dayNumber * (+costFacility) - (+deposit);
  }

  //Ham tinh dich vu di kem.
  calculateAttachFacility(costFacility: string, quantity: string) {
    return (+costFacility) * (+quantity);
  }
}


