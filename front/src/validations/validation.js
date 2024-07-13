import * as Yup from "yup";

Yup.setLocale({
    mixed: {
        required: "Bu alan doldurulmalidir!",
        oneOf: "Kurrallari kabul edin!",
    },
    string: {
        min: "Bu alan minimum ${min} karakter olmalidir!",
        max: "Bu alan maximum ${max} karakter olmalidir!",
    },
});

export default Yup;
