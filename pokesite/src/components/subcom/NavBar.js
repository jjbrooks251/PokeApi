import React, { Component } from 'react';
import { NavLink as RRNavLink} from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink
} from 'reactstrap';


export class NavBar extends Component {
    constructor(props) {
        super(props);

        this.toggleNavbar = this.toggleNavbar.bind(this);
        this.state = {
            collapsed: true
        };
    }

    toggleNavbar() {
        this.setState({
            collapsed: !this.state.collapsed
        });
    }
    render() {
        return (
            <div>
                <Navbar color="light" light expand="md">
                    <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png"></img>
                    <NavbarBrand tag={RRNavLink} to="/">Pokemon Searcher</NavbarBrand>
                    <NavbarToggler onClick={this.toggle} />
                    <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/390.png"></img>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                        <NavItem>
                                <NavLink tag={RRNavLink} to="./search">
                                    <FontAwesomeIcon icon='list'></FontAwesomeIcon>
                                    <p>Search</p></NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink tag={RRNavLink} to="./register">
                                    <FontAwesomeIcon icon='user-plus'></FontAwesomeIcon>
                                    <p>Register</p></NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink tag={RRNavLink} to="./login">
                                    <FontAwesomeIcon icon='user'></FontAwesomeIcon>
                                    <p>Login</p></NavLink>
                            </NavItem>
                        </Nav>
                    </Collapse>
                </Navbar>
            </div>
        );
    }
}