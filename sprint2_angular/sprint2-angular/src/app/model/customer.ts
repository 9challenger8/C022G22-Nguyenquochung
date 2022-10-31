import {AppUser} from "./app-user";

export interface Customer {
  id?: number;
  birthday?: string;
  address?: string;
  gender?: string;
  name?: string;
  image?: string;
  phone?: string;
  isDeleted?: boolean;
  userDto?: AppUser;
  // bill?:
}

