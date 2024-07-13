import Footer from "@/components/footer/Footer";
import Header from "@/components/header/Header";
import { ThemeContext } from "@/context/MainContext";
import React, { useContext } from "react";
import { Outlet } from "react-router-dom";


const HomeLayout = () => {
    const { theme } = useContext(ThemeContext);

    return (
        <>
            <Header />
            <main className={`${theme == "dark" ? "dark" : ""}`}>
                <Outlet />
            </main>
            <Footer />
        </>
    );
};

export default HomeLayout;
