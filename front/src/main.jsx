import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import { AuthProvider } from "./context/AuthContext.jsx";
import { ThemeProvider } from "./context/MainContext.jsx";
import { BrowserRouter } from "react-router-dom";
import "./styles/main.scss";
import { Provider } from "react-redux";
import store from "./stores/index.js";
ReactDOM.createRoot(document.getElementById("root")).render(
    <BrowserRouter>
        <ThemeProvider>
            <AuthProvider>
                <Provider store={store}>
                    <App />
                </Provider>
            </AuthProvider>
        </ThemeProvider>
    </BrowserRouter>,
);
