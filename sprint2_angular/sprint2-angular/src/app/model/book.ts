import {Publisher} from "./publisher";
import {Category} from "./category";
import {Discount} from "./discount";

export interface Book {
  id?: number;
  description?: string;
  name?: string;
  price?: string;
  author?: string;
  quantity?: string;
  releaseDate?: string;
  image?:string;
  isDeleted?: boolean;
  publisher?: Publisher;
  category?: Category;
  discount?: Discount;
}
