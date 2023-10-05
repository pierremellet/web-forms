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
/**
 * 
 * @export
 * @interface FormValue
 */
export interface FormValue {
    /**
     * 
     * @type {string}
     * @memberof FormValue
     */
    fieldId: string;
    /**
     * 
     * @type {string}
     * @memberof FormValue
     */
    fieldValue: string;
}

/**
 * Check if a given object implements the FormValue interface.
 */
export function instanceOfFormValue(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "fieldId" in value;
    isInstance = isInstance && "fieldValue" in value;

    return isInstance;
}

export function FormValueFromJSON(json: any): FormValue {
    return FormValueFromJSONTyped(json, false);
}

export function FormValueFromJSONTyped(json: any, ignoreDiscriminator: boolean): FormValue {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'fieldId': json['fieldId'],
        'fieldValue': json['fieldValue'],
    };
}

export function FormValueToJSON(value?: FormValue | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'fieldId': value.fieldId,
        'fieldValue': value.fieldValue,
    };
}

