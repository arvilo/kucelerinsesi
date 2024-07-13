import { Outlet, useNavigate } from "react-router-dom";
import { useEffect } from "react";
import { useAuth } from "@/context/AuthContext";

const AuthLayout = () => {
    const navigate = useNavigate();
    const { token } = useAuth();

    useEffect(() => {
        if (token) {
            navigate("/");
        }
    }, [token, navigate]);
    return (
        <>
            <Outlet />
        </>
    );
};

export default AuthLayout;
