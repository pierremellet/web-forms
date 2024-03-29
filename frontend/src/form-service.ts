import { Condition, ConditionOperatorEnum, ConditionTypeEnum, Configuration, FormConfig, FormConfigsApiControllerApi, FormField, FormSection, FormSubmit, FormSubmitApiControllerApi, FormValue, ValidateApiControllerApi } from "./client";
import { FieldValueValid, addFieldValue } from "./ui/reducers/fieldValuesSlice";


export default class FormService {
    formConfigsApiClient: FormConfigsApiControllerApi;
    formSubmitApiClient: FormSubmitApiControllerApi;
    validateApiClient: ValidateApiControllerApi;

    constructor(conf: any) {
        const apiClientConfig = new Configuration({
            basePath: conf.API_HOSTNAME
        })
        this.formConfigsApiClient = new FormConfigsApiControllerApi(apiClientConfig);
        this.formSubmitApiClient = new FormSubmitApiControllerApi(apiClientConfig);
        this.validateApiClient = new ValidateApiControllerApi(apiClientConfig);
    }



    loadFormConfig = async (formId: string): Promise<FormConfig> => {
        return this.formConfigsApiClient.getFormConfig({ formId: formId });
    }

    loadAllFormConfig = (conf: any): Promise<FormConfig[]> => {

        const apiClientConfig = new Configuration({
            basePath: conf.API_HOSTNAME
        })

        return new FormConfigsApiControllerApi(apiClientConfig).listForms();
    }

    isSectionActive = (formConfig: FormConfig, section: FormSection, activeSectionIndex: number) => {
        const sectionId = section.id;
        const sectionIndex = formConfig.sections.findIndex(s => s.id === sectionId);
        return sectionIndex === activeSectionIndex;
    }

    isFirstSectionActive = (formConfig: FormConfig, activeSectionId: string): boolean => {
        return formConfig.sections[0].id === activeSectionId;
    }


    isLastSectionActive = (formConfig: FormConfig, activeSectionId: string): boolean => {
        return formConfig.sections[formConfig.sections.length - 1].id === activeSectionId;
    }

    static isSectionValid = (formConfig: FormConfig, sectionId: string, fieldValues: FormValue[]): string[] => {
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

    sendFormValues = async (formId: string, fieldValues: FormValue[]): Promise<FormSubmit> => {
        return this.formSubmitApiClient.submitForm({
            formSubmit: {
                "formId": formId,
                "values": fieldValues
            }
        })


    }

    updateFieldValue = async <T>(dispatch: any, value: T, field: FormField, sectionId: string, formId: string) => {

        const response = await this.validateApiClient.validateField({
            formFieldValidation: {
                "formId": formId,
                "fieldValue": value as any,
                "fieldId": field.id!
            }
        });
        dispatch(addFieldValue({
            fieldId: field.id!,
            fieldValue: value as any,
            sectionId: sectionId,
            valid: response.valide!
        }));
    }

    evalDisplayRule = (condition: Condition | undefined, values: FieldValueValid[]): boolean => {
        if (!condition) {
            return true;
        }

        if (condition.type === ConditionTypeEnum.And) {
            //May be a group
            return condition.conditions?.map(c => this.evalDisplayRule(c, values)).reduce((accumulator, currentValue) => accumulator && currentValue, true)!;
        }

        if (condition.type === ConditionTypeEnum.Or) {
            //May be a group
            return condition.conditions?.map(c => this.evalDisplayRule(c, values)).reduce((accumulator, currentValue) => accumulator || currentValue, true)!;
        }

        //May be a condition
        const fieldValue = values.find(v => v.fieldId == condition.fieldId);
        if (!fieldValue) {
            return false;
        }
        if (condition.operator === ConditionOperatorEnum.Equal) {
            return fieldValue?.fieldValue === condition.value;
        }

        if (condition.operator === ConditionOperatorEnum.NotEqual) {
            return fieldValue?.fieldValue !== condition.value;
        }

        return true;
    }


}
 