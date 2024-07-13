import { createContext, useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState("");
    const [token, setToken] = useState(localStorage.getItem("user-token") || "");
    const navigate = useNavigate();
    // const loginAction = async (data: LoginData) => {

    //     try {
    //         const response = await fetch("/api/auth/login", {
    //             method: "POST",
    //             headers: {
    //                 "Content-Type": "application/json",
    //             },
    //             body: JSON.stringify(data),
    //         });
    //         const res = await response.json();
    //         if (res.data) {
    //             setUser(res.data.user);
    //             setToken(res.token);
    //             localStorage.setItem("site", res.token);
    //             navigate("/");
    //             return;
    //         }
    //         throw new Error(res.message);
    //     } catch (err) {
    //         console.error(err);
    //     }
    // };
    const loginAction = async (data) => {
        if (data) {
            setUser(data.email);
            setToken(data.password);
            localStorage.setItem("user-token", data.password);
            navigate("/");
            return;
        }
    };
    const logOut = () => {
        setUser("");
        setToken("");
        localStorage.removeItem("user-token");
        navigate("/login");
    };
    const data = { user, token, loginAction, logOut };

    return <AuthContext.Provider value={data}>{children}</AuthContext.Provider>;
};

export const useAuth = () => useContext(AuthContext);
