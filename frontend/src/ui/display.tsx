import React from "react"
import { FormField } from "../client"
import { useAppSelector } from "./store"
import { getAllFieldValues } from "./reducers/fieldValuesSlice"

export const Display = (props: {
    field: FormField,
    children: React.ReactElement
}) => {
    const values = useAppSelector(getAllFieldValues);

    var shouldBeDisplay = true;

    if (!shouldBeDisplay) {
        return;
    }

    return <React.Fragment>
        {props.children}
    </React.Fragment>
}