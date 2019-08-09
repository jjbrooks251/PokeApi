import React, { Component } from 'react';
import { BrowserRouter as Router, Route} from "react-router-dom";
import { NavBar } from './subcom/NavBar.js';
import { Home } from './subcom/home.js';
import { Register } from './subcom/register.js';
import { Search } from './subcom/Search.js';

export class RouterHome extends Component {
    render() {
        return (
            <Router>
                <div>
                    <NavBar />
                    <Route exact path='/' render={() => <Home />} />
                    <Route path='/register' render={() => <Register />} />
                    <Route path='/search' render={() => <Search />} />
                    </div>
            </Router>
        )
    }
}