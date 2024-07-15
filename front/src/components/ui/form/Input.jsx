import classNames from "classnames";
import { ErrorMessage, useField } from "formik";

const Input = ({ label, ...props }) => {
    const [field, meta, helpers] = useField(props);
    return (
        <label className='w-full gap-3 items-center'>
            <div className='text-sm shrink-0 text-gray-600'>{label}</div>
            <input
                className={classNames({
                    "w-full rounded-[8px] h-10 border outline-none ps-2  border-solid ": true,
                    "border-[#fb7e46]": !meta.error || !meta.touched,
                    "border-red-600": meta.error && meta.touched,
                })}
                {...field}
                {...props}
                value={field.value || ""}
            />
            <ErrorMessage className='text-red-600' component={"small"} name={field.name} />
        </label>
    );
};

export default Input;
