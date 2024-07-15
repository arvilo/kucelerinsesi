import React from "react";
import styles from "./slider.module.scss";

const Slider = () => {
    return (
        <div className=''>
            <div className={`${styles.slider} items-center flex justify-between bg-sliderBg w-full relative`}>
                <div className={`${styles.textHeader} sliderText`}>
                    <div className='p-16'>
                        <p className='tracking-wide font-semibold text-6xl w-400 leading-64'>
                            Eşitdim bizi <br /> sahiblənmək istəyən var!
                        </p>
                        <button className='rounded-12 px-2 py-2 mt-4 bg-slider-button-color text-slate-50 font-semibold text-2xl'>
                            {" "}
                            Bəli mən :&#41;
                        </button>
                    </div>
                </div>
                <div
                    className={`${styles.slider} sliderImg before:from-purple-600 before:to-transparent before:absolute before:inset-0 before:w-full before:z-10`}
                >
                    <img src='/dog-hear.svg' alt='Dog illustration' className={`${styles.image}`} />
                </div>
            </div>
        </div>
    );
};

export default Slider;
