import { postJSON } from "./request";

export const signUpAdopter = (data) => postJSON("/signup/adopter", data);
export const signUpShulter = (data) => postJSON("/signup/shulter", data);