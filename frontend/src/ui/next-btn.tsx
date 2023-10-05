import React from "react";
import { Link, useMatches } from "react-router-dom";
import { I18N } from "./i18n";
import { isSectionValuesValid } from "./reducers/fieldValuesSlice";
import { useAppSelector } from "./store";
import { FormConfig } from "../client";

export const NextBtn = (props: {
    formConfig: FormConfig,
    sectionId: string
}) => {
    const sectionIdx = props.formConfig.sections.findIndex(s => s.id == props.sectionId);
    var disabled = "";
    var next = "";
    const match = useMatches();
    const currSectionValid = useAppSelector(isSectionValuesValid(props.formConfig, props.sectionId!));

    if (!currSectionValid) {
        disabled = "disabled";
    }

    if (sectionIdx + 1 >= props.formConfig.sections.length) {
        next = "summary";
    }

    if (sectionIdx + 1 <= props.formConfig.sections.length - 1) {
        next = props.formConfig.sections[sectionIdx + 1].id;
    }

    return (
        <Link className={`btn btn-primary ${disabled}`} to={`/${props.formConfig.formId}/${next}`}><I18N label={{ "FR": "Continuer", "EN": "Next" }} /></Link >
    )
}