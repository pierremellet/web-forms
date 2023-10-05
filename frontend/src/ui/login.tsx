import React from "react";
import { I18N } from "./i18n";
import { useParams } from "react-router";

export const Login = () => {

    const clientId = "4957456e3d9da0648731";
    const redirectURL = "http://localhost:3000/api/v1/callback";
    const scope = "read:user read:email"
    const { formId } = useParams();

    const handleLogin = () => {
        window.location.assign(`https://github.com/login/oauth/authorize?client_id=${clientId}&redirect_url=${redirectURL}&scope=${scope}&state=${formId}`);
    }

    return <React.Fragment>

        <h1><I18N label={{
            EN: "This form require user authentication",
            FR: "Ce formulaire demande à ce que vous soyez authentifié"
        }} /></h1>

        <div className="btn btn-primary" onClick={handleLogin}>Login</div>

    </React.Fragment>

}


export const Component = Login;
