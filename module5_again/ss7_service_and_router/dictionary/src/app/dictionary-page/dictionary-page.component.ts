import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../dictionary";
import {DictionaryService} from "../service/dictionary.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  dictionaries: Dictionary[] = [];

  constructor(private dictionaryService: DictionaryService) {
    this.dictionaries = this.dictionaryService.getAll();
  }

  ngOnInit(): void {

  }
}
