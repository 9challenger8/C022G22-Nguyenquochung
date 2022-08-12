import {Customer} from '../customer/customer';
import {Facility} from '../facility/facility';

export interface Contract {
  id: number;
  customer: Customer;
  facility: Facility;
  startDate: String;
  endDate: String;
  deposit: String;
}
