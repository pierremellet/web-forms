import React from "react";
import { useMatches, useParams } from "react-router-dom";
import { I18N } from "./i18n";
import { FormConfig } from "../client";

export const BreadCrumb = (props: {
    formConfig: FormConfig
}) => {

    const formConfig = props.formConfig;
    const { sectionId } = useParams();
    const match = useMatches();

    const entries: React.ReactElement[] = [];

    if (formConfig) {
        formConfig.sections.map(s => {
            const isActive = s.id == sectionId ? "active" : "";
            const className = `breadcrumb-item ${isActive}`;
            entries.push(<li key={s.id} className={className}><I18N label={s.name} /></li>)
        })
        entries.push(<li key={"summary"} className={match.find(m => m.id == "summary") ? "breadcrumb-item active" : "breadcrumb-item"}><I18N label={{
            EN: "Summary",
            FR: "Valider"
        }} /></li>)

    }
    return (
        <nav aria-label="breadcrumb" id="section-breadcrumb" className="">
            <ol className="breadcrumb justify-content-center">
                {entries}
            </ol>
        </nav>
    );
}