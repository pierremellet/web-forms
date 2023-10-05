import config from "./config";
import { Configuration, FormConfig, FormConfigsApiControllerApi, FormField, FormSection, FormSubmit, FormSubmitApiControllerApi, FormValue, ValidateApiControllerApi } from "./client";
import { addFieldValue } from "./ui/reducers/fieldValuesSlice";

const apiClientConfig = new Configuration({
    basePath: config.api_hostname
})
const formConfigsApiClient = new FormConfigsApiControllerApi(apiClientConfig);
const formSubmitApiClient = new FormSubmitApiControllerApi(apiClientConfig);
const validateApiClient = new ValidateApiControllerApi(apiClientConfig);


export const loadFormConfig = async (formId: string): Promise<FormConfig> => {
    return formConfigsApiClient.getFormConfig({ formId: formId });
}

export const loadAllFormConfig = (): Promise<FormConfig[]> => {
    return formConfigsApiClient.listForms();
}

export const isSectionActive = (formConfig: FormConfig, section: FormSection, activeSectionIndex: number) => {
    const sectionId = section.id;
    const sectionIndex = formConfig.sections.findIndex(s => s.id === sectionId);
    return sectionIndex === activeSectionIndex;
}

export const isFirstSectionActive = (formConfig: FormConfig, activeSectionId: string): boolean => {
    return formConfig.sections[0].id === activeSectionId;
}


export const isLastSectionActive = (formConfig: FormConfig, activeSectionId: string): boolean => {
    return formConfig.sections[formConfig.sections.length - 1].id === activeSectionId;
}

export const isSectionValid = (formConfig: FormConfig, sectionId: string, fieldValues: FormValue[]): string[] => {
    const errors: string[] = [];
    const section = formConfig.sections.find(s => s.id === sectionId);
    section?.fields?.filter(f => f.required).map((f) => {
        const fieldValue = fieldValues.find(fv => fv.fieldId === f.id);
        if (!fieldValue && f.required) {
            errors.push(`Field ${f.id} is required`);
        }
    })
    return errors;
}

export const send = async (formId: string, fieldValues: FormValue[]): Promise<FormSubmit> => {
    return formSubmitApiClient.submitForm({
        formSubmit: {
            "formId": formId,
            "values": fieldValues
        }
    })


}

export const updateFieldValue = async <T>(dispatch: any, value: T, field: FormField, sectionId: string, formId: string) => {

    const response = await validateApiClient.validateField({
        formFieldValidation: {
            "formId": formId,
            "fieldValue": value as any,
            "fieldId": field.id
        }
    });
    dispatch(addFieldValue({
        formField: field,
        value: value,
        sectionId: sectionId,
        valid: response.valide!
    }));
}

