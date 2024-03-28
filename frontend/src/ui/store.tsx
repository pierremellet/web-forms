import { configureStore } from '@reduxjs/toolkit';
import itemListReducer from './reducers/fieldValuesSlice';
import localReducer from './reducers/localSlice';
import authReducer from './reducers/authSlice';
import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux';

 

const loadConfiguration = async (): Promise<any> => {
  const reponse = await fetch('config.json');
  const config = reponse.json();
  return {
    config: config
  }
}


 


const store = configureStore({
  reducer: {
    fieldValues: itemListReducer,
    local: localReducer,
    auth: authReducer
  },
  devTools: true
});

 

export default store;

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export type DispatchFunc = () => AppDispatch
export const useAppDispatch: DispatchFunc = useDispatch
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector

