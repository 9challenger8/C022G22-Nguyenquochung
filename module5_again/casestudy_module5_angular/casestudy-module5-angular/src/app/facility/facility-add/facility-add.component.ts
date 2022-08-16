import {Component, DoCheck, OnInit} from '@angular/core';

@Component({
  selector: 'app-facility-add',
  templateUrl: './facility-add.component.html',
  styleUrls: ['./facility-add.component.css']
})
export class FacilityAddComponent implements OnInit{

  displayStandardRoom = 'none';
  displayOtherConvenience = 'none';
  displayPoolArea = 'none';
  displayNumberFloor = 'none';
  displayFacilityFree = 'none';

  constructor() {
  }

  ngOnInit(): void {
  }


  selectFacility(event: any) {
    switch (event.target.value) {
      case '1' :
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'block';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '2':
        this.displayStandardRoom = 'block';
        this.displayOtherConvenience = 'block';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'block';
        this.displayFacilityFree = 'none';
        break;
      case '3':
        this.displayStandardRoom = 'none';
        this.displayOtherConvenience = 'none';
        this.displayPoolArea = 'none';
        this.displayNumberFloor = 'none';
        this.displayFacilityFree = 'block';
        break;
    }
  }


}
