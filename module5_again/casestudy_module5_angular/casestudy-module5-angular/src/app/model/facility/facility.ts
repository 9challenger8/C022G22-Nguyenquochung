import {RentType} from "./rentType";
import {FacilityType} from "./facilityType";

export interface Facility {
  id:number;
  name?:string;
  area?:string;
  cost?:string;
  numberOfPeople?:string;
  rentType?:RentType;
  facilityType?:FacilityType;
  standardRoom?:string;
  otherConvenience?:string;
  poolArea?:string;
  numberOfFloor?:string;
  freeFacility?:string;
}
