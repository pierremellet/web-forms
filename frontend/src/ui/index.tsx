import "./style/_custom.scss";
import React, { StrictMode, useEffect } from 'react';
import ReactDOM from 'react-dom/client';
import {
  createBrowserRouter, RouterProvider
} from "react-router-dom";
import { SectionUI } from "./section";
import store, { useAppDispatch, useAppSelector } from "./store";
import FormService  from "../form-service";
import { Provider } from "react-redux";
import { getConf, updateConf } from "./reducers/confSlice";
import FormServiceContext from "./form-service-ctx";


fetch('ext/config.json').then(r => r.json()).then(conf => {
  store.dispatch(updateConf(conf))
})





const Nothing = (props: React.PropsWithChildren<any>) => {

  const conf = useAppSelector(getConf) as any
  const missingConf = !conf.API_HOSTNAME
  const missingMsg = <div>Waiting for configuration...</div>;

  const formService = new FormService(conf);

  const router = createBrowserRouter([
    {
      path: "/",
      id: "home",
      loader: async ({ params }) => {
        const conf = store.getState().conf; 
        return await formService.loadAllFormConfig(conf)
      }
      ,
      lazy: () => import('./home')
    },
    {
      path: "/:formId",
      id: "entry",
      loader: async ({ params }) => {
        return await formService.loadFormConfig(params.formId!);
      },
      lazy: () => import('./form'),
      children: [
        {
          path: "/:formId/summary",
          id: "summary",
          lazy: () => import('./summary')
        },
        {
          path: "/:formId/login",
          id: "login",
          lazy: () => import('./login')
        },
        {
          path: "/:formId/submit",
          id: "submit",
          lazy: () => import('./submit')
        },
        {
          path: "/:formId/:sectionId",
          element: <SectionUI />
        }
      ]
    },
    {
      path: "/error",
      id: "error",
      lazy: () => import('./error')
    },
  ]);

  const Content = missingConf ? missingMsg : 
  
  <FormServiceContext.Provider value={formService}>
    <RouterProvider router={router} />
    </FormServiceContext.Provider>;

  return (
    <React.Fragment>
      {Content}
    </React.Fragment>
  )
}

const root = ReactDOM.createRoot(document.getElementById('root')!);
root.render(
  <StrictMode>
    <Provider store={store}>
      <Nothing></Nothing>
    </Provider>
  </StrictMode>
);

