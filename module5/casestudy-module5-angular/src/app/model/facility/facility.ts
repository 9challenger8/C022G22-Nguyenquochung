import {RentType} from "./rentType";

export interface Facility {
  id:number;
  name:String;
  area?:String;
  cost?:String;
  numberOfPeople?:String;
  rentType?:RentType;
  standardRoom?:String;
  describe?:String;
  areaPool?:String;
  numberOfFloor?:String;
  freeFacility?:String;
}
