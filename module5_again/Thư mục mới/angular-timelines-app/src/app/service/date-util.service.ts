import {Injectable} from '@angular/core';
import {addMonths, addYears, differenceInDays, differenceInMonths, differenceInYears} from 'date-fns';

@Injectable({
  providedIn: 'root'
})
export class DateUtilService {

  constructor() {
  }

  getDiffToNow(diff: string | number | Date): string {
    const result: string[] = [];
    const now = new Date();
    console.log('now   :' + now);
    diff = new Date(diff);
    console.log('diff   ' + diff);

    const years = differenceInYears(now, diff);
    console.log(years);

    if (years > 0) {
      result.push(`${years} years`);

      diff = addYears(diff, years);
      console.log('addYears     ' + diff);
    }

    const months = differenceInMonths(now, diff);
    result.push(`${months} months`);
    if (months > 0) {
      diff = addMonths(diff, months);
      console.log('addMonths       ' + diff);
    }

    const days = differenceInDays(now, diff);

    if (days > 0) {
      result.push(`${days} days`);
    }

    return result.join(',');
  }
}
