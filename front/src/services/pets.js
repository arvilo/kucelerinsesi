import { deleteJSON, get, postJSON } from "./request";

export const getPetsRandom = () => get(`/pets/getrandom`);
export const getFilterPets = (nickname, age, species, breed, gender, color, shelterID) =>
    get(`/pets?nickname=${nickname}&age=${age}&species=${species}&breed=${breed}&gender=${gender}&color=${color}&shelterId=${shelterID}`);
export const getPetDetails = (id) => get(`/pets/${id}`);
export const addPet = (pet, token) => postJSON(`/pets/${token}`, pet);
export const detelePet = (id, token) => deleteJSON(`/pets/${id}/${token}`);
