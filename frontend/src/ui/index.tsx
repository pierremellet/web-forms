import "./style/_custom.scss";
import React, { StrictMode } from 'react';
import ReactDOM from 'react-dom/client';
import {
  createBrowserRouter, RouterProvider
} from "react-router-dom";
import { SectionUI } from "./section";
import { loadAllFormConfig, loadFormConfig } from "../form-service";
import { Provider } from "react-redux";
import store from "./store";



const router = createBrowserRouter([
  {
    path: "/",
    id: "home",
    loader: async ({ params }) => await loadAllFormConfig(),
    lazy: () => import('./home')
  },
  {
    path: "/:formId",
    id: "entry",
    loader: async ({ params }) => {
      return await loadFormConfig(params.formId!);
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





const root = ReactDOM.createRoot(document.getElementById('root')!);


root.render(
  <StrictMode>
    <Provider store={store}>
      <RouterProvider router={router} />
    </Provider>
  </StrictMode>
);
