import { ErrorMessage, useField } from "formik";

const Select = ({ label, options, originally = false, ...props }) => {
    const [field, meta, helpers] = useField(props);
    const handleChange = (e) => {
        if (props.multiple) {
            const selectedValues = Array.from(e.target.selectedOptions, (option) => option.value);
            const selectedOptions = options.filter((option) => selectedValues.includes(option.key.toString()));
            helpers.setValue(originally ? selectedOptions : selectedValues);
        } else {
            let selected = options.find((option) => option.key == e.target.value);
            helpers.setValue(originally ? selected : e.target.value);
        }
    };
    return (
        <label className='block w-full'>
            <div className='text-sm text-gray-600'>{label}</div>
            <select
                className={`w-full rounded ${props.multiple ? "h-3DD0" : "h-10"} border outline-none focus:border-black0`}
                onChange={handleChange}
                value={field.value}
                {...props}
            >
                {options.map((item, index) => (
                    <option value={item.key} key={index}>
                        {item.value}
                    </option>
                ))}
            </select>
            <ErrorMessage className="text-red-600 block" component={"small"} name={field.name} />
        </label>
    );
};

export default Select;
