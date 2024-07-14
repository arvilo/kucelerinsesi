import { postJSON } from "./request";

export const signUpAdopter = (data) => postJSON("/signup/adopter", data);
export const signUpShelter = (data) => postJSON("/signup/shelter", data);