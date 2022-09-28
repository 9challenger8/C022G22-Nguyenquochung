import {CustomerType} from './customerType';

export interface Customer {
  id?: number;
  name: string;
  dateOfBirth?: string;
  gender?: string;
  cardId?: string;
  email?: string;
  phoneNumber?: string;
  customerType?: CustomerType;
  address?: string;
}
