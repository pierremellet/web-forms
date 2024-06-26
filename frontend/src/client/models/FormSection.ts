/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { FormField } from './FormField';
import {
    FormFieldFromJSON,
    FormFieldFromJSONTyped,
    FormFieldToJSON,
} from './FormField';
import type { I18NString } from './I18NString';
import {
    I18NStringFromJSON,
    I18NStringFromJSONTyped,
    I18NStringToJSON,
} from './I18NString';

/**
 * 
 * @export
 * @interface FormSection
 */
export interface FormSection {
    /**
     * 
     * @type {string}
     * @memberof FormSection
     */
    id: string;
    /**
     * 
     * @type {I18NString}
     * @memberof FormSection
     */
    name: I18NString;
    /**
     * 
     * @type {I18NString}
     * @memberof FormSection
     */
    description?: I18NString;
    /**
     * 
     * @type {Array<FormField>}
     * @memberof FormSection
     */
    fields?: Array<FormField>;
}

/**
 * Check if a given object implements the FormSection interface.
 */
export function instanceOfFormSection(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "name" in value;

    return isInstance;
}

export function FormSectionFromJSON(json: any): FormSection {
    return FormSectionFromJSONTyped(json, false);
}

export function FormSectionFromJSONTyped(json: any, ignoreDiscriminator: boolean): FormSection {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'name': I18NStringFromJSON(json['name']),
        'description': !exists(json, 'description') ? undefined : I18NStringFromJSON(json['description']),
        'fields': !exists(json, 'fields') ? undefined : ((json['fields'] as Array<any>).map(FormFieldFromJSON)),
    };
}

export function FormSectionToJSON(value?: FormSection | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'name': I18NStringToJSON(value.name),
        'description': I18NStringToJSON(value.description),
        'fields': value.fields === undefined ? undefined : ((value.fields as Array<any>).map(FormFieldToJSON)),
    };
}

