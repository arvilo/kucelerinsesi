import { addFavoritesPet, deleteFavoritesPet, getFavoritesPets } from "./services/favorites";
import store from "./stores";
import { addPet, deletePet, setFavorites } from "./stores/favoritesPets";

export const fetchFavoritesWithAuth = async (token) => {
    try {
        const favorites = await getFavoritesPets(token);
        store.dispatch(setFavorites(favorites));
    } catch (error) {
        console.error("Favorilər alinmadi", error);
    }
};

export const addFavoritePet = async (pet) => {
    try {
        const newFavoritePet = await addFavoritesPet(pet);
        store.dispatch(addPet(newFavoritePet));
    } catch (error) {
        console.error("Favoriyə əlavə olunmadı", error);
    }
};

export const deleteFavoritePet = async (petId) => {
    try {
        await deleteFavoritesPet(petId);
        store.dispatch(deletePet(petId));
    } catch (error) {
        console.error("Favori silinmədi", error);
    }
};
