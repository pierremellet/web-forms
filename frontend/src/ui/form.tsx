import React, { useEffect } from 'react';
import { FormConfig } from '../client';
import { I18N, I18NSelector } from './i18n';
import { Link, Outlet, useLoaderData, useLocation, useMatches, useNavigate, useParams } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from './store';
import { isSectionValuesValid } from './reducers/fieldValuesSlice';
import { Progress } from './progress';
import { BreadCrumb } from './breadcrumb';
import { SubmitBtn } from './submit-btn';
import { NextBtn } from './next-btn';
import { getAccessToken } from './reducers/localSlice';
import { updateAuth } from './reducers/authSlice';




export const Form = () => {

    const formConfig = useLoaderData() as FormConfig;
    const navigate = useNavigate();
    const match = useMatches();
    const accessToken = useAppSelector(getAccessToken);
    const dispatch = useAppDispatch();



    useEffect(() => {
        const urlParams = new URLSearchParams(window.location.search);
        const myParam = urlParams.get('token');
        const token = myParam;
        if (token) {
            dispatch(updateAuth({
                token
            }));
        }
    })

    useEffect(() => {
        if (formConfig.authentication && formConfig.authentication == true && !accessToken) {
            navigate(`/${formConfig.formId}/login`);
            return;
        }

        // Noting to display
        if (formConfig.sections.length == 0) {
            navigate(`/error`);
        }

        // Got to first section
        if (match.length == 1 && match[0].id == "entry" || match.length > 1) {
            navigate(`/${formConfig.formId}/${formConfig.sections[0].id}`);
        }
    }, [])

    useEffect(() => {
        // Crée un élément style
        const styleElement = document.createElement('style');

        // Insère le contenu CSS dans l'élément style
        styleElement.innerHTML = formConfig.customCSS || '';

        // Ajoute l'élément style au document head
        document.head.appendChild(styleElement);

        // Retourne une fonction de nettoyage pour supprimer l'élément style si nécessaire
        return () => {
            document.head.removeChild(styleElement);
        };
    }, [formConfig.customCSS]);

    return (
        <div className='container'>
            <I18NSelector />
            <h1 className='text-center'><I18N label={formConfig.name} /></h1>

            <div className='text-center mb-5'><I18N label={formConfig.description} /></div>
            <BreadCrumb formConfig={formConfig} />
            <Progress formConfig={formConfig} />
            <div className='mb-3 mt-3'>
                <Outlet context={{
                    formConfig: formConfig
                }} />
            </div>
        </div>)

}


export const Component = Form;
