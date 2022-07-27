import {CustomerType} from "./customerType";

export interface Customer {
  id?:number;
  name:String;
  dateOfBirth?:String;
  gender?:String;
  cardId?:String;
  phoneNumber?:String;
  customerType?:CustomerType;
  address?:String;
}
