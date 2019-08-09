import React, { Component } from 'react';
import axios from 'axios';
import { Col, CustomInput, Button, Form, FormGroup, Label, Input } from 'reactstrap';

export class Search extends Component {

    constructor() {
        super()
        this.state = {
            pokemon: [],
            search: ""
        }
    }

    results = (e) => {
        e.preventDefault();
        let account = e.target[2].value;
        let query = e.target[3].value;

        console.log(account + query)
        if (this.state.search === "") {
            document.getElementById("error").innerText = "Please Select One search criteria"
           
        } else {
            axios.get("http://localhost:8080/user/poke" + this.state.search + "/" + account + "/" + query).then(res => {
                this.setState({
                    pokemon: res.data
                });
                console.log(this.state.pokemon)
            }).then(() => {
                document.getElementById("name").innerText = this.state.pokemon.name
                document.getElementById("abilities").innerText = this.state.pokemon.abilities[0].ability.name + ", " + this.state.pokemon.abilities[1].ability.name
                document.getElementById("type").innerText = this.state.pokemon.types[0].type.name
                document.getElementById('backSprite').src = this.state.pokemon.sprites.front_default


            }).then(() => {
                axios.post("http://localhost:8082/audit/makeAudit/" + account + "/" + this.state.pokemon.name).then(res => {
                    console.log(res)
                }).catch(res => {
                    console.log(res);
                })
            }).catch(res => {
                console.log(res);
            });
        }
    }

    updateSearch = (e) => {
        this.setState({
            search: e.target.name
        })
    }

    searchkeys = (e) => {
        const nam = /[a-zA-Z]+/g;
        const num = /[0-9]+/g;
        if (this.state.search === "Name") {
            if (!nam.test(e.key)) {
                e.preventDefault();
                document.getElementById("firstError").innerText = "Pokemon name cannot contain " + e.key
            }
        } else if (this.state.search === "Num") {
            if (!num.test(e.key)) {
                e.preventDefault();
                document.getElementById("firstError").innerText = "Dex number cannot contain " + e.key
            }
        } else {

            e.preventDefault();
            document.getElementById("firstError").innerText = "please select name or number"
        }
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.results} className="register-form">
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="exampleCheckbox">Select Search Criteria</Label>
                        </Col>
                        <Col sm={2}>
                            <div>
                                <CustomInput type="switch" id="Name" name="Name" label="Name" onChange={this.updateSearch} />
                                <CustomInput type="switch" id="Num" name="Num" label="Num" onChange={this.updateSearch} />
                            </div>
                        </Col>
                        <Col sm={3}>
                            <p id='error' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="serach">Enter account id</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="account" placeholder="" required />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="serach">Enter Search</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="search" placeholder="" onKeyPress={(e) => this.searchkeys(e)} required />
                        </Col>
                        <Col sm={3}>
                            <p id='firstError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup check row>
                        <Col sm={{ size: 2, offset: 2 }}>
                            <Button>Create Account</Button>
                        </Col>
                    </FormGroup>
                </Form>
                <br></br>
                <p id='name'></p>
                <p id='type'></p>
                <p id='abilities'></p>
                <img id='backSprite' src="this.state.pokemon.sprites.back_default"></img>
            </div>
        )
    }
}