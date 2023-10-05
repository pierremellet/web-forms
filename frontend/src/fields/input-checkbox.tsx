import React from "react";
import { FieldProps } from "../ui/types";
import { addFieldValue, getFieldValue } from "../ui/reducers/fieldValuesSlice";
import { useAppDispatch, useAppSelector } from "../ui/store";
import { I18N } from "../ui/i18n";
import { updateFieldValue } from "../form-service";



export const InputCheckbox = (props: FieldProps<any, string>) => {

    if (!props.sectionId) {
        throw new Error(`Mission section ID for field ${props.field.id}`);
    }

    const dispatch = useAppDispatch();
    const fieldValueState = useAppSelector(getFieldValue(props.field.id));
    var inputValue = "";
    if (fieldValueState) {
        inputValue = fieldValueState.fieldValue;
    }
    const handleChange = async (event: any) => {
        const value = event.target.checked as string;
        await updateFieldValue<string>(dispatch, value, props.field, props.sectionId, props.formId);
    }


    return <React.Fragment>
        <div className="form-check  form-switch" key={props.field.id}>
            <input
                defaultValue={undefined}
                className={`form-check-input ${(fieldValueState?.valid || !fieldValueState) ? "" : "is-invalid"}`}
                type="checkbox"
                onChange={handleChange}
                checked={fieldValueState ? JSON.parse(fieldValueState.fieldValue) : undefined} />
            <label className="form-check-label">
                <I18N label={props.field.description} />
            </label>
        </div>
    </React.Fragment>
}

export const Component = InputCheckbox;
export default Component;
