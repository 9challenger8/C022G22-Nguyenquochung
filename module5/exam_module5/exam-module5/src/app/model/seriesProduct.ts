import {Product} from './product';

export interface SeriesProduct {
  id: string;
  product?: Product;
  amount?: string;
  startDate?: string;
  produceDate?: string;
  deadDate?: string;
}
