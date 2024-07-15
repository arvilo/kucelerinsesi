import Slider from "@/components/slider/Slider";
import { getShelters } from "@/services/shelters";
import React, { useEffect } from "react";

const Home = () => {
    // useEffect(() => {
    //     const fecthData = async () => {
    //         const response = getShelters();
    //         console.log(await response);
    //     };
    //     fecthData();
    // }, []);
    return (
        <section>
            <Slider />
        </section>
    );
};

export default Home;
