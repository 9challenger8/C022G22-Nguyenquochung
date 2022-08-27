import {AbstractControl} from "@angular/forms";

export function checkInputDateFuture(date: AbstractControl) {
  console.log(date);
  const startDate = date.value.startDate;
  const endDate = date.value.outDate;

  if (startDate >= endDate) {
    return {checkInputDateFuture: true};
  }
  return null;
}

