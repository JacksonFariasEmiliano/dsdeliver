import React from "react";
import { BrowserRouter, Switch, Router, Route } from "react-router-dom";
import Home from "./Home";
import Navbar from "./Navbar";
import Orders from "./Orders";

function Routes(){
    return(
        <BrowserRouter>
        <Navbar></Navbar>
        <Switch>
            <Route path="/orders">
                <Orders />
            </Route>
            
            <Route paths="/">
                <Home />
            </Route>
        </Switch>
        </BrowserRouter>
    )
}

export default Routes;