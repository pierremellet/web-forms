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
 * @interface Condition
 */
export interface Condition {
    /**
     * 
     * @type {string}
     * @memberof Condition
     */
    type?: ConditionTypeEnum;
    /**
     * 
     * @type {Array<Condition>}
     * @memberof Condition
     */
    conditions?: Array<Condition>;
    /**
     * 
     * @type {string}
     * @memberof Condition
     */
    fieldId?: string;
    /**
     * 
     * @type {string}
     * @memberof Condition
     */
    operator?: ConditionOperatorEnum;
    /**
     * 
     * @type {string}
     * @memberof Condition
     */
    value?: string;
}


/**
 * @export
 */
export const ConditionTypeEnum = {
    And: 'AND',
    Or: 'OR'
} as const;
export type ConditionTypeEnum = typeof ConditionTypeEnum[keyof typeof ConditionTypeEnum];

/**
 * @export
 */
export const ConditionOperatorEnum = {
    Equal: 'EQUAL',
    NotEqual: 'NOT_EQUAL'
} as const;
export type ConditionOperatorEnum = typeof ConditionOperatorEnum[keyof typeof ConditionOperatorEnum];


/**
 * Check if a given object implements the Condition interface.
 */
export function instanceOfCondition(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function ConditionFromJSON(json: any): Condition {
    return ConditionFromJSONTyped(json, false);
}

export function ConditionFromJSONTyped(json: any, ignoreDiscriminator: boolean): Condition {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': !exists(json, 'type') ? undefined : json['type'],
        'conditions': !exists(json, 'conditions') ? undefined : ((json['conditions'] as Array<any>).map(ConditionFromJSON)),
        'fieldId': !exists(json, 'fieldId') ? undefined : json['fieldId'],
        'operator': !exists(json, 'operator') ? undefined : json['operator'],
        'value': !exists(json, 'value') ? undefined : json['value'],
    };
}

export function ConditionToJSON(value?: Condition | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'conditions': value.conditions === undefined ? undefined : ((value.conditions as Array<any>).map(ConditionToJSON)),
        'fieldId': value.fieldId,
        'operator': value.operator,
        'value': value.value,
    };
}

