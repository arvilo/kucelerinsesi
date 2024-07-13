import React, { createContext, useState } from "react";

export const ThemeContext = createContext();

export const ThemeProvider = ({ children }) => {
    const [theme, setTheme] = useState(localStorage.getItem("theme") || "light");

    const changeTheme = () => {
        setTheme(theme == "light" ? "dark" : "light");
        localStorage.setItem("theme", theme == "light" ? "dark" : "light");
    };

    return <ThemeContext.Provider value={{ theme, changeTheme }}>{children}</ThemeContext.Provider>;
};
