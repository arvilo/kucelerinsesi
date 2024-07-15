import { useState } from "react";
import styles from "./register.module.scss";
import { Link, useNavigate } from "react-router-dom";
import { Form, Formik } from "formik";
import Input from "@/components/ui/form/Input";
import { AdopterRegisterSchema, ShelterRegisterSchema } from "@/validations";

const Register = () => {
    const initialValues = { name: "", surname: "", email: "", password: "" };
    const navigate = useNavigate();
    const [showShelterForm, setShowShelterForm] = useState(false);

    const handleToggleForm = () => {
        setShowShelterForm(!showShelterForm);
    };

    return (
        <div className={styles.login}>
            <div className={`${styles.wrapper} flex justify-between`}>
                <div className={`max-w-[553px] w-50 w-full grid place-items-center ${!showShelterForm ? "" : "hidden"}`}>
                    <div>
                        <h2 className={`text-black ${styles.title} mb-5`}>Qeydiyyat </h2>
                        <Formik
                            initialValues={initialValues}
                            onSubmit={(values, actions) => {
                                setTimeout(() => {
                                    alert(JSON.stringify(values, null, 2));
                                    actions.setSubmitting(false);
                                    navigate("/login");
                                }, 3000);
                            }}
                            validationSchema={AdopterRegisterSchema}
                        >
                            {({ isSubmitting }) => (
                                <Form className='grid gap-y-5 w-[376px]'>
                                    <div className={`${styles.multiimp}`}>
                                        <Input name='name' type='text' placeholder='Ad' />
                                        <Input name='surname' type='text' placeholder='Soyad' />
                                    </div>
                                    <Input name='email' type='email' placeholder='E-poçt ünvanı' />
                                    <Input name='password' type='password' placeholder='Şifrə' />
                                    <div className='relative'>
                                        <button
                                            type='submit'
                                            className={` ${styles.registerBtn} w-full h-10 rounded-[8px]  text-sm text-white px-5 disabled:opacity-40`}
                                            disabled={isSubmitting}
                                        >
                                            <span className={`${isSubmitting ? "hidden" : "block"}`}>Qeytiyyatdan keç</span>
                                        </button>
                                        <div className={`${styles["spinner-container"]} ${isSubmitting ? "grid " : "hidden"} place-items-center`}>
                                            <div className={styles["dot-spinner"]}>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                                <div className={styles["dot-spinner__dot"]}></div>
                                            </div>
                                        </div>
                                    </div>
                                </Form>
                            )}
                        </Formik>
                        <div className='mt-3 text-center'>
                            Hesabınız var ?{" "}
                            <Link
                                className={`  text-login-color font-semibold`}
                                data-testid='login-link'
                                data-track-action='click_login_from_sign_in_page'
                                data-track-label='free_registration'
                                to='/login'
                            >
                                Daxil ol
                            </Link>
                        </div>
                    </div>
                </div>
                <div className='background-image w-full h-screen bg-red-800'>
                    <button onClick={handleToggleForm}>Deyis</button>
                </div>
                <div className={`${styles.register2} ${showShelterForm ? "" : "hidden"} w-50`}>
                    <h2 className={`text-black ${styles.title} mb-5`}>Qeydiyyat </h2>
                    <Formik
                        initialValues={initialValues}
                        onSubmit={(values, actions) => {
                            setTimeout(() => {
                                alert(JSON.stringify(values, null, 2));
                                actions.setSubmitting(false);
                                navigate("/login");
                            }, 3000);
                        }}
                        validationSchema={ShelterRegisterSchema}
                    >
                        {({ isSubmitting }) => (
                            <Form className='grid gap-y-5 w-[406px] mx-auto my-5 py-5'>
                                <div className={`${styles.multiimp}`}>
                                    <Input name='name' type='text' placeholder='Ad' />
                                    <Input name='surname' type='text' placeholder='Soyad' />
                                </div>
                                <Input name='email' type='email' placeholder='E-poçt ünvanı' />
                                <Input name='password' type='password' placeholder='Şifrə' />
                                <div className='relative'>
                                    <button
                                        type='submit'
                                        className={` ${styles.registerBtn} w-full h-10 rounded-[8px]  text-sm text-white px-5 disabled:opacity-40`}
                                        disabled={isSubmitting}
                                    >
                                        <span className={`${isSubmitting ? "hidden" : "block"}`}>Qeytiyyatdan keç</span>
                                    </button>
                                    <div className={`${styles["spinner-container"]} ${isSubmitting ? "grid " : "hidden"} place-items-center`}>
                                        <div className={styles["dot-spinner"]}>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                            <div className={styles["dot-spinner__dot"]}></div>
                                        </div>
                                    </div>
                                </div>
                            </Form>
                        )}
                    </Formik>
                    <div className='mt-3 text-center'>
                        Hesabınız var ?{" "}
                        <Link
                            className={`  text-login-color font-semibold`}
                            data-testid='login-link'
                            data-track-action='click_login_from_sign_in_page'
                            data-track-label='free_registration'
                            to='/login'
                        >
                            Daxil ol
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Register;
