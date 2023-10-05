import { useSelector } from "react-redux";
import React from "react";
import { FormValueListState } from "./reducers/fieldValuesSlice";

export const DisplayStore = () => {

    const items = useSelector((state: FormValueListState) => state);

    return (
        <div className="container">
            <h2>Store</h2>
            {JSON.stringify(items)}
        </div>
    )
}