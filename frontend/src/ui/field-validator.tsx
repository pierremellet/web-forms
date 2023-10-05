import React from "react";
import { FormField } from "../client";
import { getFieldValue } from "./reducers/fieldValuesSlice";
import { useAppSelector } from "./store";
import { I18N } from "./i18n";

export const FieldValidator = (props: {
    field: FormField
}) => {

    const fvv = useAppSelector(getFieldValue(props.field.id));
    if (!fvv) {
        return;
    }
    if (!fvv?.valid) {
        return (
            <div className="form-text text-danger"><I18N label={{
                EN: "Invalid",
                FR: "Invalide"
            }} /></div>
        )
    }
    return;

}