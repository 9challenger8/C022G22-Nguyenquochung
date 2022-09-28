import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {FacilityDto} from '../model/facilityDto';
import {FacilityService} from '../service/facility.service';
import {ToastrService} from 'ngx-toastr';
import {Manager} from '../model/manager';
import {ManagerService} from '../service/manager.service';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  facilityList: FacilityDto[] = [];

  // Modal delete
  nameFacilityModal: string;
  addressModal: string;
  idModal: number;

  // search
  nameManagerForm = new FormControl('');
  nameFacilityForm = new FormControl('');
  nameManagerSearch = '';
  nameFacilitySearch = '';

  // pagination
  indexPagination = 0;
  pages: Array<number>;
  previousPageStyle = 'inline-block';
  nextPageStyle = 'inline-block';
  totalElements = 0;
  pageSize = 6;
  displayPagination = 'inline-block';
  numberOfElement = 0;

  // Modal detail
  managerDetail: Manager = {};

  constructor(private facility: FacilityService,
              private manager: ManagerService,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getListBySearchAndPagination();
  }

  getManagerById(id: number) {
    this.manager.getManagerById(id).subscribe(data => {
      this.managerDetail = data;
    });
  }

  getModal(id: number, nameFacility: string, address: string) {
    this.nameFacilityModal = nameFacility;
    this.addressModal = address;
    this.idModal = id;
  }

  deleteFacility() {
    if (this.facilityList.length === 1 && this.indexPagination !== 0) {
      this.indexPagination = this.indexPagination - 1;
    }
    this.facility.deleteFacility(this.idModal).subscribe(() => {
    }, error => {
      console.log(error);
    }, () => {
      this.toast.success('Xóa thành công', 'Thông báo');
      this.ngOnInit();
    });
  }

  searchFacility() {
    this.nameManagerSearch = this.nameManagerForm.value.trim();
    this.nameFacilitySearch = this.nameFacilityForm.value.trim();
    if (this.checkRegex(this.nameManagerSearch, this.nameFacilitySearch)) {
      this.indexPagination = 0;
      this.pages = new Array(0);
      this.facilityList = [];
      this.displayPagination = 'none';
      this.checkPreviousAndNext();
      this.toast.warning('Không được nhập kí tự đặc biệt.', 'Chú ý');
    } else {
      this.indexPagination = 0;
      this.displayPagination = 'inline-block';
      this.getListBySearchAndPagination();
    }
  }

  getListBySearchAndPagination() {
    this.facility.getListBySearchAndPagination(this.nameManagerSearch, this.nameFacilitySearch,
      this.indexPagination, this.pageSize).subscribe(data => {
      if (data === null) {
        this.pages = new Array(0);
        this.facilityList = [];
        this.displayPagination = 'none';
        this.toast.warning('Không có dữ liệu.', 'Chú ý');
      } else {
        this.numberOfElement = data.numberOfElements;
        this.facilityList = data.content;
        this.totalElements = data.totalElements;
        this.pages = new Array(data.totalPages);
      }
      this.checkPreviousAndNext();
    });
  }

  // kiem tra hien thi nut tiep theo va truoc
  checkPreviousAndNext() {
    if (this.indexPagination === 0) {
      this.previousPageStyle = 'none';
    } else if (this.indexPagination !== 0) {
      this.previousPageStyle = 'inline-block';
    }
    if (this.indexPagination < (this.pages.length - 1)) {
      this.nextPageStyle = 'inline-block';
    } else if (this.indexPagination === (this.pages.length - 1) || this.indexPagination > (this.pages.length - 1)) {
      this.nextPageStyle = 'none';
    }
  }

  changePageSize(event: any) {
    switch (event.target.value) {
      case '6' :
        this.pageSize = 6;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
      case '9' :
        this.pageSize = 9;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
      case '12':
        this.pageSize = 12;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
    }
  }

  previousPage(event: any) {
    event.preventDefault();
    this.indexPagination--;
    this.ngOnInit();
  }


  nextPage(event: any) {
    event.preventDefault();
    this.indexPagination++;
    this.ngOnInit();
  }

  // kiểm tra nhập kí tự đặc biệt trên ô tìm kiếm.
  checkRegex(name: string, idCard: string): boolean {
    const format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    return format.test(name) || format.test(idCard);
  }
}
