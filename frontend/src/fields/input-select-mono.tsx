import React from "react";
import { I18N } from "../ui/i18n";
import { FieldProps } from "../ui/types";
import { getFieldValue } from "../ui/reducers/fieldValuesSlice";
import { useAppDispatch, useAppSelector } from "../ui/store";
import { updateFieldValue } from "../form-service";



export const InputSelectMono = (props: FieldProps<any, string>) => {

    const dispatch = useAppDispatch();
    const valueState = useAppSelector(getFieldValue(props.field.id));

    const handleChange = async (event: any) => {
        const value = event.target.value as string;
        await updateFieldValue<string>(dispatch, value, props.field, props.sectionId, props.formId);
    }
    const options = [];
    options.push(<option key={null} value={undefined}></option>);

    for (var opts in props.field.config.options) {
        options.push(<option key={opts} value={opts}><I18N label={props.field.config.options[opts]} /></option>);
    }

    return <React.Fragment>
        <select
            id={props.field.id}
            name={props.field.id}
            className="form-select"
            value={valueState?.fieldValue}
            required={props.field.required}
            onChange={handleChange} >
            {options}
        </select>
    </React.Fragment>

}

export const Component = InputSelectMono;
export default Component;
