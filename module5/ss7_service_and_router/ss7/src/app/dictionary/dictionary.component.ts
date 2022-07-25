import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  word = new FormControl('');
  mean:string='';

  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
  }

  find():string {
    console.log( this.word.value+'')
    return this.mean =this.dictionaryService.findMeanWord(String(this.word.value))
  }
}
