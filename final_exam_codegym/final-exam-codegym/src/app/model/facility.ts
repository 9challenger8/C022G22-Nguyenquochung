import {Manager} from './manager';

export interface Facility {
  id?: number;
  nameFacility: string;
  codeFacility?: string;
  openDay?: string;
  address?: string;
  manager?: Manager;
  deleted: boolean;
}
