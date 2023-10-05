import { FormConfig, FormField, FormValue } from "./client";

export type FieldType = string;

export interface TypedFormField<T extends Object> extends FormField {
    config: T
}

export type FormRouterResult = {
    errors: string[]
}

export interface FormRouterClass<C> {
    getRouterClassName(): string;
    validatedRouterConfig(config: any): string[];
    route(formId: string, formConfig: FormConfig, formRouterConfig: C, values: FormValue[]): Promise<FormRouterResult>;
}



