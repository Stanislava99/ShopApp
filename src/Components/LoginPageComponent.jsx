import React, { Component } from 'react';
import {Form, Col, Row, Button} from 'react-bootstrap'

class LoginPageComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            name:"",
            surname:"",
            phoneNumber:undefined,
            emailAddress:"",
            password:"",
            repeatedPassword:""
        }

        this.registerUsername = this.registerUsername.bind(this);
        this.registerSurname = this.registerSurname.bind(this);
        this.registerPhoneNumber = this.registerPhoneNumber.bind(this);
        this.registerEmailAddress = this.registerEmailAddress.bind(this);
        this.registerPassword = this.registerPassword.bind(this);
        this.registerRepeatedPassword = this.registerRepeatedPassword.bind(this);
    }

    registerUsername = (event) => {
        this.setState({name: event.target.value});
    }

    registerSurname = (event) => {
        this.setState({surname: event.target.value});
    }

    registerPhoneNumber = (event) => {
        this.setState({phoneNumber: event.target.value});
    }

    registerEmailAddress = (event) => {
        this.setState({emailAddress: event.target.value});
    }

    registerPassword = (event) => {
        this.setState({password: event.target.value});
    }

    registerRepeatedPassword = (event) => {
        this.setState({repeatedPassword: event.target.value});
    }



    render() {
        return ( 
            <Form>
            <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
              <Form.Label column sm={2}>
                Email
              </Form.Label>
              <Col sm={10}>
                <Form.Control type="email" placeholder="Email" />
              </Col>
            </Form.Group>
          
            <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
              <Form.Label column sm={2}>
                Password
              </Form.Label>
              <Col sm={10}>
                <Form.Control type="password" placeholder="Password" />
              </Col>
            </Form.Group>
            <fieldset>
              <Form.Group as={Row} className="mb-3">
                <Form.Label as="legend" column sm={2}>
                  Radios
                </Form.Label>
                <Col sm={10}>
                  <Form.Check
                    type="radio"
                    label="first radio"
                    name="formHorizontalRadios"
                    id="formHorizontalRadios1"
                  />
                  <Form.Check
                    type="radio"
                    label="second radio"
                    name="formHorizontalRadios"
                    id="formHorizontalRadios2"
                  />
                  <Form.Check
                    type="radio"
                    label="third radio"
                    name="formHorizontalRadios"
                    id="formHorizontalRadios3"
                  />
                </Col>
              </Form.Group>
            </fieldset>
            <Form.Group as={Row} className="mb-3" controlId="formHorizontalCheck">
              <Col sm={{ span: 10, offset: 2 }}>
                <Form.Check label="Remember me" />
              </Col>
            </Form.Group>
          
            <Form.Group as={Row} className="mb-3">
              <Col sm={{ span: 10, offset: 2 }}>
                <Button type="submit">Sign in</Button>
              </Col>
            </Form.Group>
          </Form>
        );
    }
}

export default LoginPageComponent;