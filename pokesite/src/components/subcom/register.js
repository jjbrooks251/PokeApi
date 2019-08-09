import React, { Component } from 'react';
import axios from 'axios';
import { Col, Button, Form, FormGroup, Label, Input } from 'reactstrap';

export class Register extends Component {

    addUser = (e) => {
        e.preventDefault();

        let user = {
            name: e.target[0].value,
            aId: e.target[1].value,
        }

                axios.post("http://localhost:8080/user/createUser", user).then(res => {
                    console.log(res);
                }).then(() => {
                    window.location.reload();
                }).catch(res => {
                    console.log(res);
                })

    }

    nameEntry = (e) => {
        const re = /[a-zA-Z]+/g;
        if (!re.test(e.key)) {
            e.preventDefault();
            document.getElementById("firstError").innerText = "Username cannot contain " + e.key
            console.log(e.key + ' is not valid')
        }
    }

    aIdentry = (e) => {
        const re = /[0-9]+/g;
        if (!re.test(e.key)) {
            e.preventDefault();
            document.getElementById("lastError").innerText = "account id can only be numbers "
            console.log(e.key + ' is not valid')
        }
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.addUser} className="register-form">
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="Name">Name</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="Name" placeholder="Enter Name" onKeyPress={(e) => this.nameEntry(e)} required />
                        </Col>
                        <Col sm={3}>
                            <p id='firstError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="aid">account Id</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="aid" placeholder="Enter aid" onKeyPress={(e) => this.aIdentry(e)} required />
                        </Col>
                        <Col sm={3}>
                            <p id='lastError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup check row>
                        <Col sm={{ size: 2, offset: 2 }}>
                            <Button>Create Account</Button>
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}