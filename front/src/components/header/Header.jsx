import { ThemeContext } from "@/context/MainContext";
import React, { useContext } from "react";

const Header = () => {
    const { theme, changeTheme } = useContext(ThemeContext);
    return (
        <>
            <div className='flex justify-between'>
                Header
                <button type='button' className='h-10 bg-black rounded  px-3 text-white' onClick={changeTheme}>
                    change theme
                </button>
            </div>
            <div>{theme == "dark" ? <p>dark</p> : <p>light</p>}</div>
        </>
    );
};

export default Header;
