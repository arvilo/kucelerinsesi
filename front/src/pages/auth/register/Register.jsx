import styles from "./register.module.scss";
import { Link, useNavigate } from "react-router-dom";
import { Form, Formik } from "formik";
import Input from "@/components/ui/form/Input";
import { RegisterSchema } from "@/validations/RegisterSchema";
const Register = () => {
    const initialValues = { name: "", surname: "", email: "", password: "" };
    const navigate = useNavigate();

    return (
        <div className={styles.login}>
            <div className={`${styles.wrapper}`}>
                <h2 className={`text-black ${styles.title} mb-5`}>Sign Up</h2>
                <Formik
                    initialValues={initialValues}
                    onSubmit={(values, actions) => {
                        setTimeout(() => {
                            alert(JSON.stringify(values, null, 2));
                            actions.setSubmitting(false);
                            
                            navigate("/login");
                        }, 3000);
                    }}
                    validationSchema={RegisterSchema}
                >
                    {({ isSubmitting }) => (
                        <Form className='grid gap-y-5'>
                            <Input name='name' type='text' label='Name' />
                            <Input name='surname' type='text' label='Surname' />
                            <Input name='email' type='email' label='Email' />
                            <Input name='password' type='password' label='Password' />
                            <div className='relative'>
                                <button
                                    type='submit'
                                    className='w-full h-10 rounded bg-[#ff0000] text-sm text-white px-5 disabled:opacity-40'
                                    disabled={isSubmitting}
                                >
                                    <span className={`${isSubmitting ? "hidden" : "block"}`}>Sign Up</span>
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
                    Already have an account?{" "}
                    <Link
                        className='text-blue-600 font-semibold'
                        data-testid='login-link'
                        data-track-action='click_login_from_sign_in_page'
                        data-track-label='free_registration'
                        to='/login'
                    >
                        Login
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Register;
