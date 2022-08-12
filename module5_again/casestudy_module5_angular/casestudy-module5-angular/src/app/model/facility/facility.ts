import {RentType} from "./rentType";

export interface Facility {
  id:number;
  name:string;
  area?:string;
  cost?:string;
  numberOfPeople?:string;
  rentType?:RentType;
  standardRoom?:string;
  describe?:string;
  areaPool?:string;
  numberOfFloor?:string;
  freeFacility?:string;
}
