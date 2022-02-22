import 'bootstrap/dist/css/bootstrap.min.css';
import React, { Component } from 'react';
import {Navbar, Nav, Container, NavDropdown, Form, FormControl, Button} from 'react-bootstrap';

class HeaderComponent extends Component {
    render() {
        return (
            <Navbar bg="light" expand="lg">
            <Container fluid>
              <Navbar.Brand href="#">ShopApp</Navbar.Brand>
              <Navbar.Toggle aria-controls="navbarScroll" />
              <Navbar.Collapse id="navbarScroll">
                <Nav
                  className="me-auto my-2 my-lg-0"
                  style={{ maxHeight: '100px' }}
                  navbarScroll
                >
                  <Nav.Link href="#action1">Home</Nav.Link>
                  <Nav.Link href="#action2">Link</Nav.Link>
                  <NavDropdown title="Link" id="navbarScrollingDropdown">
                    <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                    <NavDropdown.Item href="#action4">Another action</NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="#action5">
                      Something else here
                    </NavDropdown.Item>
                  </NavDropdown>
                  <Nav.Link href="#" disabled>
                    Link
                  </Nav.Link>
                </Nav>
                <Form className="d-flex">
                <Nav.Link href="#action1">Login</Nav.Link>
                <Nav.Link href="#action2">Register</Nav.Link>
                  <FormControl
                    type="search"
                    placeholder="Search product"
                    className="me-2"
                    aria-label="Search"
                  />
                  <Button variant="outline-success">Search</Button>
                </Form>
              </Navbar.Collapse>
            </Container>
          </Navbar>
        );
    }
}

export default HeaderComponent;