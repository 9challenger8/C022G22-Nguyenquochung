import {AbstractControl} from '@angular/forms';

export function checkPositiveNumber(control: AbstractControl) {
  const numberCheck = control.value;
  if (numberCheck < 0) {
    return {positiveNumber: true};
  }
  return null;
}


