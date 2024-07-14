import { createSlice } from "@reduxjs/toolkit";
// import { useAuth } from "../context/AuthContext";
// const { token } = useAuth();
const initialState = {
    favoritesPets: JSON.parse(localStorage.getItem("favoritesPets")) || [],
};

const favoritesPets = createSlice({
    name: "favoritesPets",
    initialState,
    reducers: {
        setFavorites: (state, action) => {
            state.favoritesPets = action.payload;
            localStorage.setItem("favoritesPets", JSON.stringify(state.favoritesPets));
        },
        addPet: (state, action) => {
            state.favoritesPets = [action.payload, ...state.favoritesPets];
            localStorage.setItem("favoritesPets", JSON.stringify(state.favoritesPets));
        },
        deletePet: (state, action) => {
            state.favoritesPets = state.favoritesPets.filter((pet) => pet.id != action.payload);
            localStorage.setItem("favoritesPets", JSON.stringify(state.favoritesPets));
        },
    },
});

export const { setFavorites, addPet, deletePet } = favoritesPets.actions;
export default favoritesPets.reducer;
