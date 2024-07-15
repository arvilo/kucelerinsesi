import Yup from "./validation";
export const AdopterRegisterSchema = Yup.object({
    name: Yup.string().required().min(2),
    surname: Yup.string().required().min(2),
    email: Yup.string().required().email("Email is not valid"),
    password: Yup.string().required().min(6),
});
