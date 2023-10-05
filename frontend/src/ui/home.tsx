import React from "react";
import { Link, useLoaderData } from "react-router-dom"
import { FormConfig } from "../client";
import { I18N } from "./i18n";

export const Home = () => {
    const configs = useLoaderData() as FormConfig[];

    return <React.Fragment>
        <ul className="list-group">
            {
                configs.map(c => {
                    return <li className="list-group-item" key={c.formId}>
                        <div >
                            <div className="ms-2 me-auto">
                                <Link to={`/${c.formId}`} className="fw-bold"><I18N label={c.name} /></Link>
                            </div>
                            <I18N label={c.description} />

                        </div>
                        <span className="badge bg-primary rounded-pill">{c.formId}</span>

                    </li>
                })
            }
        </ul>
    </React.Fragment>
}

export const Component = Home;
