import 'babel-polyfill';
import 'moment/locale/zh-cn';
import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter as Router } from "react-router-dom";
import { Provider } from "mobx-react";
import { store,rehydrate } from "rfx-core";

import IndexRouter from './IndexRouter';
import IndexStore from './IndexStore';
// import './Style/Common.scss';

store.setup(IndexStore);
const storeApp = rehydrate();

const app = document.createElement('div');
app.id = "app";
document.body.appendChild(app);

if(!localStorage.appHost) {
    localStorage.appHost = window.location.protocol+"//"+window.location.host;
}

if(localStorage.userId){
    location.hash = "Login";
}

ReactDOM.render(
    <Router>
        <Provider store={storeApp}>
            <IndexRouter/>
        </Provider>
    </Router>, app);
