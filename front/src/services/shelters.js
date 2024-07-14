import { get } from "./request";

export const getShelterDetails = (id) => get(`/shelters/${id}`);
export const getShelters = () => get(`/shelters`);
