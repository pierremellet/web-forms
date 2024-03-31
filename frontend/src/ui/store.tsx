import { configureStore } from '@reduxjs/toolkit';
import itemListReducer from './reducers/fieldValuesSlice';
import localReducer from './reducers/localSlice';
import authReducer from './reducers/authSlice';
import confReducer from './reducers/confSlice';
import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux';

 
 

const store = configureStore({
  reducer: {
    fieldValues: itemListReducer,
    local: localReducer,
    auth: authReducer,
    conf: confReducer
  },
  devTools: true
});

 

export default store;

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export type DispatchFunc = () => AppDispatch
export const useAppDispatch: DispatchFunc = useDispatch
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector

 
 

