import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { Form, Formik } from "formik";
import Input from "@/components/ui/form/Input";
import { useAuth } from "@/context/AuthContext";
import { LoginSchema } from "@/validations";
import styles from "./login.module.scss";
const Login = () => {
    const { loginAction } = useAuth();
    const location = useLocation();
    const navigate = useNavigate();
    return (
        <>
            <Formik
                initialValues={{ username: "", password: "" }}
                onSubmit={(values, actions) => {
                    setTimeout(() => {
                        actions.setSubmitting(false);
                        actions.resetForm();
                        loginAction(values);
                        navigate(location?.state?.return_url || "/", { replace: true });
                    }, 3000);
                }}
                validationSchema={LoginSchema}
            >
                {({ values, isSubmitting }) => (
                    <Form className='grid gap-y-3 p-4'>
                        <h1 className='text-2xl font-bold mt-3'> Login Form</h1>
                        <Input name='email' type='email' label='Email' />
                        <Input name='password' type='password' label='Password' /> <br />
                        <div className='relative'>
                            <button
                                type='submit'
                                className='w-full h-10 rounded bg-[#ff0000] text-sm text-white px-5 disabled:opacity-40'
                                disabled={isSubmitting}
                            >
                                <span className={`${isSubmitting ? "hidden" : "block"}`}>Login</span>
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
                Don't have an account yet?{" "}
                <Link
                    className='text-blue-600 font-semibold'
                    data-testid='register-link'
                    data-track-action='click_register_from_sign_in_page'
                    data-track-label='free_registration'
                    to='/register'
                >
                    Register now
                </Link>
            </div>
        </>
    );
};

export default Login;
