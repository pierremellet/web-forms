import { FormField } from "../client";

type regEntry<T> = () => Promise<T>;
const fieldRegistry = new Map<string, regEntry<any>>();

export function registerField(name: string, uiPromise: () => Promise<any>) {
    fieldRegistry.set(name, uiPromise);
}

export const getFieldTypes = (): string[] => {
    return Array.from(fieldRegistry.keys());
}

export const getFieldUI = (field: FormField) => {
    const fieldModule = fieldRegistry.get(field.type!);
    if (!fieldModule) {
        throw new Error(`Missing field module for type : ${field.type}`);
    }
    return fieldModule()
}

registerField("INPUT_TEXT", () => import('./input-text'));
registerField("INPUT_TEXTAREA", () => import('./input-textarea'));
registerField("INPUT_SELECTMONO", () => import('./input-select-mono'));
registerField("INPUT_DATE", () => import('./input-date'));
registerField("INPUT_ADDRESS", () => import('./input-adress'));
registerField("INPUT_CHECKBOX", () => import('./input-checkbox'));