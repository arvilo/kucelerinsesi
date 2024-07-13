import store from "./stores";
import { addPet, deletePet, setFavorites } from "./stores/favoritesPets";

export const handleAddPet = (pet) => {
    store.dispatch(addPet(pet));
};

export const handleDeletePet = (id) => {
    store.dispatch(deletePet(id));
};

export const handleSetFavorites = (favorites) => {
    store.dispatch(setFavorites(favorites));
};
