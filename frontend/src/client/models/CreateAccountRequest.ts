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
 * @interface CreateAccountRequest
 */
export interface CreateAccountRequest {
    /**
     * 
     * @type {string}
     * @memberof CreateAccountRequest
     */
    owner: string;
}

/**
 * Check if a given object implements the CreateAccountRequest interface.
 */
export function instanceOfCreateAccountRequest(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "owner" in value;

    return isInstance;
}

export function CreateAccountRequestFromJSON(json: any): CreateAccountRequest {
    return CreateAccountRequestFromJSONTyped(json, false);
}

export function CreateAccountRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): CreateAccountRequest {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'owner': json['owner'],
    };
}

export function CreateAccountRequestToJSON(value?: CreateAccountRequest | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'owner': value.owner,
    };
}
