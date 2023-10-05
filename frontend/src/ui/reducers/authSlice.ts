import { createSlice, PayloadAction } from '@reduxjs/toolkit';

const initialState: {
  token: string | undefined
} = {
  token: undefined
};

const localSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    updateAuth: (state, action: PayloadAction<typeof initialState>) => {
      state = action.payload
      return state
    },

  },
});

export const { updateAuth } = localSlice.actions;
export default localSlice.reducer;