import { ErrorMessage, useField } from "formik";
import React from "react";
import { IoMdCheckmark } from "react-icons/io";
const File = ({ label, ...props }) => {
    const [field, meta, helpers] = useField(props);

    const handleChange = (e) => {
        const file = e.target.files[0];
        const reader = new FileReader();
        reader.onload = () => {
            helpers.setValue({ file: reader.result, fileName: file.name });
        };
        reader.readAsDataURL(file);
    };
    return (
        <div className="flex gap-3">
            <label className='flex items-center w-fit relative'>
                <div className='text-sm text-gray-600 me-2'>{label}</div>
                <input type='file' onChange={handleChange} className=' appearance-none absolute -z-10 opacity-0' />
                <span className='px-5 rounded bg-blue-50 text-blue-500 h-10 cursor-pointer leading-[2.2]'>
                    {field.value ? (
                        <div className='flex items-center gap-2 justify-center'>
                            File Chosen <IoMdCheckmark />
                        </div>
                    ) : (
                        "Choose File"
                    )}
                </span>
            </label>
            <button
                type='button'
                className='px-5 rounded bg-red-600 text-white h-10 cursor-pointer leading-[2.2]'
                onClick={() => helpers.setValue("")}
            >
                Remove File
            </button>
            <ErrorMessage className="text-red-600 block" component={"small"} name={field.name} />
        </div>
    );
};

export default File;
