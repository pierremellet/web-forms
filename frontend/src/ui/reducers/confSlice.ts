import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../store';

const initialState = {}

const confSlice = createSlice({
  name: 'conf',
  initialState,
  reducers: {
    updateConf: (state, action: PayloadAction<{}>) => {
      state = action.payload
      return state
    },

  },
});

export const getConf = (state: RootState) => state.conf;
export const { updateConf } = confSlice.actions;
export default confSlice.reducer;


 