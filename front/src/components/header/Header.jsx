import { ThemeContext } from "@/context/MainContext";
import React, { useContext } from "react";
import styles from "./header.module.scss";
import { FaSearch } from "react-icons/fa";
import { Link } from "react-router-dom";

const Header = () => {
    const { theme, changeTheme } = useContext(ThemeContext);
    return (
        <>
            <div>
                <div className={`flex justify-between ${styles.header}`}>
                    <div className='logo'>Logo</div>
                    <div className={`${styles.links} links`}>
                        <a href=''>Elanlar</a>
                        <a href=''>Sığınacaqlar</a>
                        <a href=''>Favorilər</a>
                    </div>
                    <div className={` ${styles.search} search`}>
                        <input type='text' name='' id='' placeholder='Axtarın' className={`${styles.searchInp} links`} />
                        <FaSearch className={`${styles.icon} search-icon`} />
                    </div>
                    <div className='flex'>
                        <Link to='/register' className={`${styles.btn1} block`}>
                            Qeydiyyatdan keç
                        </Link>
                        <Link to='/login' className={`${styles.btn2} block`}>
                            Daxil ol
                        </Link>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Header;
