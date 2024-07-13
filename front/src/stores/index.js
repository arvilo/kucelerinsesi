import { configureStore } from "@reduxjs/toolkit";
import favoritesPets from "./favoritesPets";

const store = configureStore({
    reducer: {
        favoritesPets,
    },
});

export default store;
