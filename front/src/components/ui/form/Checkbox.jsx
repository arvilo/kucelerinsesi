import { ErrorMessage, useField } from "formik";
import { IoMdCheckmark } from "react-icons/io";
import classNames from "classnames";
const Checkbox = ({ label, ...props }) => {
    const [field, meta, helpers] = useField(props);

    return (
        <div>
            <label className='flex gap-x-2 text-sm cursor-pointer items-center'>
                <button
                    onClick={() => helpers.setValue(!field.value)}
                    type='button'
                    className={classNames({
                        "w-5 h-5 rounded border transition-all flex items-center justify-center": true,
                        "text-transparent border-gray-300": !field.value,
                        "border-red-600": meta.error && meta.touched,
                        "text-white bg-blue-600 border-blue-600": field.value && !meta.error,
                    })}
                >
                    <IoMdCheckmark size={16} />
                </button>
                {label}
            </label>
            <ErrorMessage className='text-red-600 block' component={"small"} name={field.name} />
        </div>
    );
};

export default Checkbox;
