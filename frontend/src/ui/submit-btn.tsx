import React, { useContext } from "react"
import { useAppSelector } from "./store";
import { getAllFieldValues } from "./reducers/fieldValuesSlice";
 import { FormConfig } from "../client";
import { I18N } from "./i18n";
import { useNavigate } from "react-router";
import FormServiceContext from "./form-service-ctx";
import FormService from "../form-service";

export const SubmitBtn = (props: {
    disabled: string,
    formConfig: FormConfig
}) => {
    const formService = useContext(FormServiceContext) as FormService

    const items = useAppSelector(getAllFieldValues);
    const navigate = useNavigate();

    const submitForm = (e: any) => {
        formService.sendFormValues(props.formConfig.formId!, items).then((res: any) => {
            navigate(`/${props.formConfig.formId}/submit`);
        }).catch((err: any) => console.error(err));
    }


    return <React.Fragment>
        <div className={`btn btn-primary ${props.disabled}`} onClick={submitForm}><I18N label={{ "FR": "Envoyer", "EN": "Send" }} /></div >
    </React.Fragment>
}