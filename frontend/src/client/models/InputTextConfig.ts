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
 * @interface InputTextConfig
 */
export interface InputTextConfig {
    /**
     * Regex that value must match
     * @type {string}
     * @memberof InputTextConfig
     */
    regex?: string;
}

/**
 * Check if a given object implements the InputTextConfig interface.
 */
export function instanceOfInputTextConfig(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function InputTextConfigFromJSON(json: any): InputTextConfig {
    return InputTextConfigFromJSONTyped(json, false);
}

export function InputTextConfigFromJSONTyped(json: any, ignoreDiscriminator: boolean): InputTextConfig {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'regex': !exists(json, 'regex') ? undefined : json['regex'],
    };
}

export function InputTextConfigToJSON(value?: InputTextConfig | null): any {
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

