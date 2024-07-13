import { ErrorMessage, useField } from "formik";
import { IoMdCheckmark } from "react-icons/io";
import classNames from "classnames";
const Textarea = ({ label, ...props }) => {
    const [field, meta, helpers] = useField(props);

    return (
        <label className='w-full'>
            <div className='text-sm shrink-0 text-gray-600'>{label}</div>
            <textarea
                className={classNames({
                    "w-full rounded  border outline-none ps-2": true,
                    "focus:border-black": !meta.error || !meta.touched,
                    "border-red-600": meta.error && meta.touched,
                })}
                {...field}
                {...props}
            />
            <ErrorMessage className='text-red-600 block' component={"small"} name={field.name} />
        </label>
    );
};

export default Textarea;
