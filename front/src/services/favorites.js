import { get, postJSON, deleteJSON } from "./request";

export const getFavoritesPets = () => get("/favorites");
export const deleteFavoritesPet = (id) => deleteJSON(`/favorites/${id}`);
export const addFavoritesPet = (data) => postJSON("/favorites", data);
