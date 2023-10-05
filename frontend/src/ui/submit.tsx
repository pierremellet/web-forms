import React from "react"
import { I18N } from "./i18n"
import { useOutletContext } from "react-router-dom";
import { FormConfig } from "../client";

export const Submit = () => {

    const { formConfig } = useOutletContext() as any;
    const redirectURL = (formConfig as FormConfig).redirectURL;


    const handleClose = () => {
        if (redirectURL) {
            window.location.assign(redirectURL!);
        }
    }

    const ExitBtn = () => {
        if (redirectURL) {
            return <div className='text-center'>
                <div className="btn-group  btn-group-lg " role="group">
                    <div className="btn btn-primary" onClick={handleClose}>
                        <I18N label={{
                            EN: "Close",
                            FR: "Fermer"
                        }} />
                    </div>
                </div>
            </div>
        } else {
            return;
        }
    }

    return (
        <div className="text-center">
            <h4 className="text"><I18N label={{
                "EN": "Form is submited !",
                "FR": "Formulaire envoyé",
            }} /></h4>

            <ExitBtn />

        </div>
    )
}

export const Component = Submit;
