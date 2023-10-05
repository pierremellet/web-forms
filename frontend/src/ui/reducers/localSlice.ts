import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../store';

const initialState: string = "FR";

const localSlice = createSlice({
  name: 'local',
  initialState,
  reducers: {
    updateLocal: (state, action: PayloadAction<string>) => {
      state = action.payload
      return state
    },

  },
});

export const getAccessToken = (state: RootState) => state.auth.token;
export const { updateLocal } = localSlice.actions;
export default localSlice.reducer;