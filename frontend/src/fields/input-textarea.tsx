import React, { useContext } from "react";
import { FieldProps } from "../ui/types";
import { useDispatch } from "react-redux";
import { getFieldValue } from "../ui/reducers/fieldValuesSlice";
import { useAppSelector } from "../ui/store"; 
import FormServiceContext from "../ui/form-service-ctx";
import FormService from "../form-service";


export const InputTextArea = (props: FieldProps<any, string>) => {
    
    const formService = useContext(FormServiceContext) as FormService

    const dispatch = useDispatch();
    const fieldValueState = useAppSelector(getFieldValue(props.field.id!));

    const handleChange = async (event: any) => {
        const value = event.target.value as string;
        await formService.updateFieldValue<string>(dispatch, value, props.field, props.sectionId, props.formId);
    }

    return <React.Fragment>
        <textarea
            id={props.field.id}
            name={props.field.id}
            defaultValue={undefined}
            className={`form-control ${(fieldValueState?.valid || !fieldValueState) ? "" : "is-invalid"}`}
            value={fieldValueState ? fieldValueState.fieldValue : undefined}
            required={props.field.required}
            onChange={handleChange} /></React.Fragment>
}

export const Component = InputTextArea;
export default Component;
