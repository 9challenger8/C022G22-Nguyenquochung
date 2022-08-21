import {Contract} from "./contract";
import {AttachFacility} from "./attachFacility";

export interface ContractDetail {
  id:number;
  quantity:string;
  contract:Contract;
  attachFacility:AttachFacility;
}
