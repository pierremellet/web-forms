import React from "react"
import { FormField, FormValue } from "../client"
import { useAppSelector } from "./store"
import { FieldValueValid, getAllFieldValues } from "./reducers/fieldValuesSlice"
import { evalDisplayRule } from "../form-service"

export const Display = (props: {
    field: FormField,
    children: React.ReactElement
}) => {


    const values = useAppSelector(getAllFieldValues) as FieldValueValid[];

    var shouldBeDisplay = true;

    if (props.field.display) {
        shouldBeDisplay = evalDisplayRule(props.field.display, values);
    }

    if (!shouldBeDisplay) {
        return;
    }

    return <React.Fragment>
        {props.children}
    </React.Fragment>
}