import {Customer} from "./customer";
import {Bill} from "./bill";

export interface BillDetail {
  id?: number;
  customer?: Customer;
  bill?: Bill;
}
