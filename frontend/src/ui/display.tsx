import React from "react"
import { FormField } from "../client"
import { useAppSelector } from "./store"
import { getAllFieldValues } from "./reducers/fieldValuesSlice"

import { parse } from "./dsl/display-parser";
export const Display = (props: {
    field: FormField,
    children: React.ReactElement
}) => {
    const values = useAppSelector(getAllFieldValues);

    var shouldBeDisplay = true;
    if (props.field.display) {
        const evaluatedDisplay = parse(props.field.display) as any;
        if (evaluatedDisplay.type == "comparison") {
            const left = values.find(f => f.fieldId == evaluatedDisplay.left.value)?.fieldValue;
            const right = evaluatedDisplay.right.value;
            shouldBeDisplay = left == right;
        }
    }
    if (!shouldBeDisplay) {
        return;
    }

    return <React.Fragment>
        {props.children}
    </React.Fragment>
}