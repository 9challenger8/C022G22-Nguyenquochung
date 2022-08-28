import {Doctor} from './doctor';

export interface Patient {
  idRecord?: string;
  idPatient?: string;
  namePatient: string;
  startDate?: string;
  outDate?: string;
  issue?: string;
  solution?: string;
  doctor?: Doctor;
}
