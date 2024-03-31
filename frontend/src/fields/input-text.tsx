import React, { useContext } from "react";
import { FieldProps } from "../ui/types";
import { getFieldValue } from "../ui/reducers/fieldValuesSlice";
import { useAppDispatch, useAppSelector } from "../ui/store";
import FormService from "../form-service";
import { InputTextConfig } from "../client/models/InputTextConfig";
import FormServiceContext from "../ui/form-service-ctx";

export const InputText = (props: FieldProps<InputTextConfig, string>) => {

    const formService = useContext(FormServiceContext) as FormService

    if (!props.sectionId) {
        throw new Error(`Mission section ID for field ${props.field.id}`);
    }

    const dispatch = useAppDispatch();
    const fieldValueState = useAppSelector(getFieldValue(props.field.id!));
    var inputValue = "";
    if (fieldValueState) {
        inputValue = fieldValueState.fieldValue;
    }
    const handleChange = async (event: any) => {
        const value = event.target.value as string;
        await formService.updateFieldValue<string>(dispatch, value, props.field, props.sectionId, props.formId);
    }


    return <React.Fragment>
        <input
            type="text"
            defaultValue={undefined}
            id={props.field.id}
            name={props.field.id}
            className={`form-control ${(fieldValueState?.valid || !fieldValueState) ? "" : "is-invalid"}`}
            value={fieldValueState ? fieldValueState.fieldValue : ""}
            required={props.field.required}
            onChange={handleChange} />

    </React.Fragment>
}

export const Component = InputText;
export default Component;
