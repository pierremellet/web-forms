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
 * @interface InputTextAreaConfig
 */
export interface InputTextAreaConfig {
    /**
     * Regex that value must match
     * @type {string}
     * @memberof InputTextAreaConfig
     */
    regex?: string;
}

/**
 * Check if a given object implements the InputTextAreaConfig interface.
 */
export function instanceOfInputTextAreaConfig(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function InputTextAreaConfigFromJSON(json: any): InputTextAreaConfig {
    return InputTextAreaConfigFromJSONTyped(json, false);
}

export function InputTextAreaConfigFromJSONTyped(json: any, ignoreDiscriminator: boolean): InputTextAreaConfig {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'regex': !exists(json, 'regex') ? undefined : json['regex'],
    };
}

export function InputTextAreaConfigToJSON(value?: InputTextAreaConfig | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'regex': value.regex,
    };
}
