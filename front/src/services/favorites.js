import { get, postJSON, deleteJSON } from "./request";

export const getFavoritesPets = (token) => get(`/favorites/${token}`);
export const deleteFavoritesPet = (id, token) => deleteJSON(`/favorites/${id}/${token}`);
export const addFavoritesPet = (id, token) => postJSON(`/favorites/${id}/${token}`);
