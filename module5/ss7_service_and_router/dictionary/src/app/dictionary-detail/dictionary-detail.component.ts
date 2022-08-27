import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../dictionary";
import {DictionaryService} from "../service/dictionary.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  detail: Dictionary;

  constructor(private dictionaryService: DictionaryService, private dictionaryRoute: ActivatedRoute) {
    this.getDetail();
  }

  ngOnInit(): void {
  }

  getDetail(){
    this.dictionaryRoute.paramMap.subscribe((p: ParamMap) => {
      this.detail = this.dictionaryService.findByWord(p.get('word'));
    });
  }

}
