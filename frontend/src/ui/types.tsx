import { TypedFormField } from "../types"

export interface FieldProps<T extends Object, V> {
    sectionId: string
    field: TypedFormField<T>
    formId: string
}
