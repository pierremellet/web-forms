import React from "react"
import { useOutletContext } from "react-router-dom";
import { I18N } from "./i18n";
import { FormConfig, FormField, FormSection, FormValue } from "../client";
import { getAllFieldValues } from "./reducers/fieldValuesSlice";
import { useAppSelector } from "./store";
import { SubmitBtn } from "./submit-btn";

export const Summary = () => {

    const { formConfig } = useOutletContext() as { formConfig: FormConfig };
    const items = useAppSelector(getAllFieldValues);
    const disabled = "";

    return (
        <div>
            <h3><I18N label={{
                FR: "Résumé",
                EN: "Summary"
            }} /></h3>
            <ul className="list-group mb-3">
                {
                    formConfig.sections.map((section: FormSection) => {
                        return (
                            <li key={section.id} className="list-group-item">
                                <h5><I18N label={section.name} /></h5>
                                <ul className="list-group list-group-flush">
                                    {
                                        section.fields?.filter(f => f.type!.includes("INPUT")).map((f: FormField) => {

                                            function findValue(id: string): string | undefined {
                                                return items.find(i => i.fieldId == id)?.fieldValue
                                            }

                                            return (
                                                <li key={f.id} className="list-group-item">
                                                    <I18N label={f.label} />: {JSON.stringify(findValue(f.id!))}
                                                </li>
                                            )
                                        })
                                    }
                                </ul>
                            </li>
                        )
                    })
                }
            </ul>
            <div className='text-center'>
                <div className="btn-group  btn-group-lg " role="group">
                    <SubmitBtn disabled={disabled} formConfig={formConfig} />
                </div>
            </div>
        </div>

    )
}

export const Component = Summary;
