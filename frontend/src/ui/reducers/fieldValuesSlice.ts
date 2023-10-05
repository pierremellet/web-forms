// redux/reducers/itemListSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { FormConfig, FormField, FormValue } from '../../client';
import { RootState } from '../store';
import { isSectionValid } from '../../form-service';

export type FieldValueValid = {
  valid: boolean,
  sectionId: string
} & FormValue;

export type FormValueListState = FieldValueValid[];

const initialState: FormValueListState = [];

const itemListSlice = createSlice({
  name: 'fieldValues',
  initialState,
  reducers: {
    addFieldValue: (state, action: PayloadAction<{
      value: any,
      sectionId: string,
      formField: FormField,
      valid: boolean
    }>) => {
      const value = state.find(i => i.fieldId === action.payload.formField.id);
      if (value) {
        value.fieldValue = action.payload.value;
        value.valid = action.payload.valid;
        value.sectionId = action.payload.sectionId;
      } else {
        state.push({
          fieldId: action.payload.formField.id,
          fieldValue: action.payload.value,
          sectionId: action.payload.sectionId,
          valid: action.payload.valid
        });
      }
    },

  },
});

export const getAllFieldValues = (state: RootState) => state.fieldValues;
export const getFieldValue = (fieldId: string) => (state: RootState): FieldValueValid | undefined => state.fieldValues.find(v => v.fieldId === fieldId)!;
export const isSectionValuesValid = (formConfig: FormConfig, sectionId: string) => (state: RootState): boolean => {
  return isSectionValid(formConfig, sectionId, state.fieldValues).length === 0;
}
export const { addFieldValue } = itemListSlice.actions;

export default itemListSlice.reducer;

