import React, { useContext } from "react"
import { FormField, FormValue } from "../client"
import { useAppSelector } from "./store"
import { FieldValueValid, getAllFieldValues } from "./reducers/fieldValuesSlice"
import FormServiceContext from "./form-service-ctx"
import FormService from "../form-service"

export const Display = (props: {
    field: FormField,
    children: React.ReactElement
}) => {

    const formService = useContext(FormServiceContext) as FormService
    const values = useAppSelector(getAllFieldValues) as FieldValueValid[];

    var shouldBeDisplay = true;

    if (props.field.display) {
        shouldBeDisplay = formService.evalDisplayRule(props.field.display, values);
    }

    if (!shouldBeDisplay) {
        return;
    }

    return <React.Fragment>
        {props.children}
    </React.Fragment>
}