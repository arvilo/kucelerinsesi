import { postJSON } from "./request";

export const signInAdopter = (data) => postJSON("/signin/adopter", data);
export const signInShelter = (data) => postJSON("/signin/shelter", data);
