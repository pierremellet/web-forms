import React, { Suspense, lazy } from "react"
import { FormConfig, FormField, FormSection } from "../client"
import { I18N } from "./i18n"
import { getFieldUI } from "../fields"
import { Link, useOutletContext, useParams } from "react-router-dom"
import { FieldValidator } from "./field-validator"
import { Display } from "./display"
import { NextBtn } from "./next-btn"


export const SectionUI = () => {

    const { formConfig } = useOutletContext() as any;
    const { sectionId } = useParams();
    const section = (formConfig as FormConfig).sections.find(s => s.id === sectionId)!;

    const PreviousBtn = () => {
        const sectionIdx = formConfig.sections.findIndex((s: FormSection) => s.id == sectionId);

        if (sectionIdx - 1 < 0) {
            return;
        }
        const previousSectionId = formConfig.sections[sectionIdx - 1].id;
        return (
            <Link className="btn btn-secondary" to={`/${formConfig.formId}/${previousSectionId}`}><I18N label={{ "FR": "Précédent", "EN": "Return" }} /></Link >
        )

    }

    return (
        <section>
            <div className="h3 text-center mt-1 mb-5 description"><I18N key="description" label={section.description} /></div>
            {
                section.fields?.map((field: FormField) => {
                    const FieldInstance = lazy(() => getFieldUI(field));
                    return (
                        <Display key={field.id} field={field}>
                            <div className="form-group">
                                <label className="field-label" htmlFor={field.id}><I18N label={field.label} />{field.required ? "*" : ""}</label>
                                <Suspense fallback={<div>Chargement...</div>}>
                                    <FieldInstance field={field} sectionId={sectionId} formId={formConfig.formId} />
                                </Suspense>
                                <small className="form-text text-muted"><I18N label={field.description} /></small>
                                <FieldValidator field={field} />
                            </div>
                        </Display>)
                })
            }
            <div className='text-center'>
                <div className="btn-group  btn-group-lg " role="group">
                    <PreviousBtn />
                    <NextBtn formConfig={formConfig} sectionId={sectionId!} />
                </div>
            </div>
        </section>

    )
}