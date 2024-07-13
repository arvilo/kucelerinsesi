import { postJSON } from "./request";

export const signInAdopter = (data) => postJSON("/signin/adopter", data);
export const signInShulter = (data) => postJSON("/signin/shulter", data);
