import React, { useEffect } from "react";
import { FieldProps } from "../ui/types";
import { getFieldValue } from "../ui/reducers/fieldValuesSlice";
import { useAppDispatch, useAppSelector } from "../ui/store";
import 'leaflet/dist/leaflet.css';
import { Map, map, latLng, tileLayer, MapOptions, geoJSON, circleMarker } from "leaflet";
import { useDebounce } from 'usehooks-ts';
import { InputAddressConfig } from "../client";
import { updateFieldValue } from "../form-service";



var myMap: Map | undefined = undefined;

export const InputAdress = (props: FieldProps<InputAddressConfig, string>) => {

    if (!props.sectionId) {
        throw new Error(`Mission section ID for field ${props.field.id}`);
    }
    const ref = React.useRef(null);
    const options: MapOptions = {
        center: latLng(47.218371
            , -1.553621
        ),
        zoom: 12,
    };
    useEffect(() => {
        if (!myMap) {
            myMap = map(ref.current!, options);

            tileLayer(`https://tile.openstreetmap.org/{z}/{x}/{y}.png`, {
                maxZoom: 19,
                attribution: '© OpenStreetMap'
            }).addTo(myMap);

        }
    }, [])

    var geojsonMarkerOptions = {
        radius: 8,
        fillColor: "#ff7800",
        color: "#000",
        weight: 1,
        opacity: 1,
        fillOpacity: 0.8
    };

    const dispatch = useAppDispatch();

    const fieldValueState = useAppSelector(getFieldValue(props.field.id));
    var inputValue = "";
    if (fieldValueState) {
        inputValue = fieldValueState.fieldValue;
    }
    const handleChange = async (event: any) => {
        const value = event.target.value as string;
        await updateFieldValue<string>(dispatch, value, props.field, props.sectionId, props.formId);
    }

    const debouncedValue = useDebounce<string>(fieldValueState?.fieldValue!, 1000)


    useEffect(() => {
        if (debouncedValue && debouncedValue.length > 5) {
            fetch(`https://api-adresse.data.gouv.fr/search/?q=${debouncedValue}`).then(res => res.json()).then(res => {
                if (myMap) {
                    res.features.forEach((f: any) => {
                        geoJSON(f, {
                            pointToLayer: function (feature, latlng) {
                                return circleMarker(latlng, geojsonMarkerOptions);
                            }
                        }).addTo(myMap!);
                    });

                    if (res.features.length > 1) {
                        const point = res.features[0].geometry.coordinates;
                        myMap.panTo(latLng(point[1], point[0]));
                    }
                }

            })
        }
    }, [debouncedValue])

    return <React.Fragment>
        <input
            type="text"
            defaultValue={undefined}
            id={props.field.id}
            name={props.field.id}
            className={`form-control ${(fieldValueState?.valid || !fieldValueState) ? "" : "is-invalid"}`}
            value={fieldValueState ? fieldValueState.fieldValue : ""}
            required={props.field.required}
            onChange={handleChange} />

        <div ref={ref} className="mt-3" style={{
            height: "280px"
        }}></div>



    </React.Fragment>

}

export const Component = InputAdress;
export default Component;

