import { ErrorMessage, useField } from "formik";
import { IoMdCheckmark } from "react-icons/io";
import classNames from "classnames";
const Radio = ({ label, options, ...props }) => {
    const [field, meta, helpers] = useField(props);

    return (
        <div className='grid gap-y-2 text-sm cursor-pointer items-center'>
            <div className='text-sm text-gray-600'>{label}</div>
            {options.map((option, key) => (
                <label key={key} className='flex gap-x-2 text-sm cursor-pointer items-center'>
                    <button
                        type='button'
                        onClick={() => helpers.setValue(option.key)}
                        className={classNames({
                            "w-5 h-5 rounded-full border transition-all flex items-center justify-center": true,
                            "border-gray-300": field.value !== option.key,
                            "border-blue-600": field.value == option.key,
                        })}
                    >
                        <div className={classNames({ "w-3 h-3 rounded-full": true, "bg-blue-600": field.value == option.key })}></div>
                    </button>
                    {option.value}
                </label>
            ))}
            <ErrorMessage className='text-red-600 block' component={"small"} name={field.name} />
        </div>
    );
};

export default Radio;
