import React from "react";
import { getAllFieldValues } from "./reducers/fieldValuesSlice"
import { useAppSelector } from "./store"
import { FormConfig } from "../client";

export const Progress = (props: {
    formConfig: FormConfig
}) => {
    const values = useAppSelector(getAllFieldValues);
    const nbFilled = values.filter(v => v.fieldValue != "").filter(v => v.valid).length;
    const fields = props.formConfig.sections.flatMap(s => s.fields).filter(f => f?.required).filter(f => f?.type!.indexOf("INPUT")! >= 0);
    const nbField = fields.length;
    const progress = (nbFilled * 100) / nbField;

    return (
        <div className="progress" role="progressbar" aria-label="Basic example" style={{ height: "3px" }} aria-valuenow={33} aria-valuemin={0} aria-valuemax={100}>
            <div className="progress-bar" style={{ width: `${progress}%` }}></div>
        </div>
    )
}