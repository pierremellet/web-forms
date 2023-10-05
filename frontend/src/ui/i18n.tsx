import React, { useState } from "react";
import { I18NString } from "../client"
import { RootState, useAppDispatch, useAppSelector } from "./store";
import { updateLocal } from "./reducers/localSlice";

export const I18N = (props: { label: I18NString | undefined }) => {

    const local = useAppSelector((state: RootState) => state.local);

    const label = () => {
        var l = ""
        if (props.label?.FR && local == "FR") {
            l = props.label.FR;
        }
        if (props.label?.EN && local == "EN") {
            l = props.label.EN;
        }

        if (l == "") {
            l = props.label?.FR!;
        }
        return l;
    }

    return <React.Fragment>{label()}</React.Fragment>
}

export const I18NSelector = () => {

    const [local, setLocal] = useState(useAppSelector((state: RootState) => state.local));
    const dispatch = useAppDispatch();

    const handleChange = (event: any) => {
        console.log(event.target.value);
        setLocal(event.target.value);
        dispatch(updateLocal(event.target.value));
    }

    return (
        <select id="i18n-selector" className="form-select position-absolute" onChange={handleChange}>
            <option key="FR">FR</option>
            <option key="EN">EN</option>
        </select>
    )
}