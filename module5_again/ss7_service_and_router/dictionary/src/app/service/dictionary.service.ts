import { Injectable } from '@angular/core';
import {Dictionary} from "../dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionaryLibraries: Dictionary[] = [];

  constructor() {
    this.dictionaryLibraries.push({word: "hello", mean: "xin chào"});
    this.dictionaryLibraries.push({word: "cat", mean: "con mèo"});
    this.dictionaryLibraries.push({word: "dog", mean: "con chó"});
    this.dictionaryLibraries.push({word: "shark", mean: "cá mập"});
    this.dictionaryLibraries.push({word: "walk", mean: "đi bộ"});

  }

  getAll(): Dictionary[]{
    return this.dictionaryLibraries;
  }

  findByWord(word: string): Dictionary{
    for(let i =0 ; i<= this.dictionaryLibraries.length; i++){
      if(this.dictionaryLibraries[i].word === word){
        return this.dictionaryLibraries[i];
      }
    }
    return {};
  }
}
