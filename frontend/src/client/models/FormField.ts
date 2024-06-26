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
import type { Condition } from './Condition';
import {
    ConditionFromJSON,
    ConditionFromJSONTyped,
    ConditionToJSON,
} from './Condition';
import type { I18NString } from './I18NString';
import {
    I18NStringFromJSON,
    I18NStringFromJSONTyped,
    I18NStringToJSON,
} from './I18NString';

/**
 * 
 * @export
 * @interface FormField
 */
export interface FormField {
    /**
     * 
     * @type {string}
     * @memberof FormField
     */
    id?: string;
    /**
     * 
     * @type {string}
     * @memberof FormField
     */
    type?: string;
    /**
     * 
     * @type {boolean}
     * @memberof FormField
     */
    required?: boolean;
    /**
     * 
     * @type {Condition}
     * @memberof FormField
     */
    display?: Condition;
    /**
     * 
     * @type {I18NString}
     * @memberof FormField
     */
    description?: I18NString;
    /**
     * 
     * @type {I18NString}
     * @memberof FormField
     */
    label?: I18NString;
    /**
     * 
     * @type {object}
     * @memberof FormField
     */
    config?: object;
}

/**
 * Check if a given object implements the FormField interface.
 */
export function instanceOfFormField(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function FormFieldFromJSON(json: any): FormField {
    return FormFieldFromJSONTyped(json, false);
}

export function FormFieldFromJSONTyped(json: any, ignoreDiscriminator: boolean): FormField {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': !exists(json, 'id') ? undefined : json['id'],
        'type': !exists(json, 'type') ? undefined : json['type'],
        'required': !exists(json, 'required') ? undefined : json['required'],
        'display': !exists(json, 'display') ? undefined : ConditionFromJSON(json['display']),
        'description': !exists(json, 'description') ? undefined : I18NStringFromJSON(json['description']),
        'label': !exists(json, 'label') ? undefined : I18NStringFromJSON(json['label']),
        'config': !exists(json, 'config') ? undefined : json['config'],
    };
}

export function FormFieldToJSON(value?: FormField | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'type': value.type,
        'required': value.required,
        'display': ConditionToJSON(value.display),
        'description': I18NStringToJSON(value.description),
        'label': I18NStringToJSON(value.label),
        'config': value.config,
    };
}

