import { configureStore } from '@reduxjs/toolkit';
import itemListReducer from './reducers/fieldValuesSlice';
import localReducer from './reducers/localSlice';
import authReducer from './reducers/authSlice';
import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux';

function saveToLocalStorage(state: RootState) {
  try {
    const serialisedState = JSON.stringify(state);
    //localStorage.setItem("persistantState", serialisedState);
  } catch (e) {
    console.warn(e);
  }
}

function loadFromLocalStorage() {
  try {
    const serialisedState = localStorage.getItem("persistantState");
    if (serialisedState === null) return undefined;
    return JSON.parse(serialisedState);
  } catch (e) {
    console.warn(e);
    return undefined;
  }
}

const store = configureStore({
  reducer: {
    fieldValues: itemListReducer,
    local: localReducer,
    auth: authReducer
  },
  preloadedState: loadFromLocalStorage(),
  devTools: true
});

store.subscribe(() => saveToLocalStorage(store.getState()));


export default store;

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export type DispatchFunc = () => AppDispatch
export const useAppDispatch: DispatchFunc = useDispatch
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector

