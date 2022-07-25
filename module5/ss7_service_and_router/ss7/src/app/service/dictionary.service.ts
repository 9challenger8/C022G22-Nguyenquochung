import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionaries = new Map<string, string>();

  constructor() {
    this.dictionaries.set('dog','Chó');
    this.dictionaries.set('cat','Mèo');
    this.dictionaries.set('fish','Cá');
    this.dictionaries.set('elephant','Voi');
    this.dictionaries.set('tiger','Hổ');
    this.dictionaries.set('wolf','Sói');
    this.dictionaries.set('shark','Cá Mập');
  }


  findMeanWord( word: string): string {
    if(this.dictionaries.has(word)){
      return this.dictionaries.get(word)
    }else {
      return 'No data available.'
    }

  }






}
