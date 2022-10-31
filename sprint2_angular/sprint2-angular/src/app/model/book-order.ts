import {Book} from "./book";
import {Bill} from "./bill";


export interface BookOrder {
  id?: number;
  quantity?: number;
  book?: Book;
  bill?: Bill;
}
