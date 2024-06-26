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


import * as runtime from '../runtime';
import type {
  FormValue,
} from '../models/index';
import {
    FormValueFromJSON,
    FormValueToJSON,
} from '../models/index';

export interface ListFormResultsRequest {
    formId: string;
}

/**
 * 
 */
export class FormResultsApiControllerApi extends runtime.BaseAPI {

    /**
     */
    async listFormResultsRaw(requestParameters: ListFormResultsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<FormValue>>> {
        if (requestParameters.formId === null || requestParameters.formId === undefined) {
            throw new runtime.RequiredError('formId','Required parameter requestParameters.formId was null or undefined when calling listFormResults.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/formResults/{formId}`.replace(`{${"formId"}}`, encodeURIComponent(String(requestParameters.formId))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(FormValueFromJSON));
    }

    /**
     */
    async listFormResults(requestParameters: ListFormResultsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<FormValue>> {
        const response = await this.listFormResultsRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
