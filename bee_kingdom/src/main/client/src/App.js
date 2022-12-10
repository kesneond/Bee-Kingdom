import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Routes, Route, Outlet, Link} from "react-router-dom";
import Header from "./component/Header";
import {Alert, Button, Col, Form, Row, Table} from "react-bootstrap";
import Container from "react-bootstrap/Container";
import {Component} from "react";
import axios from 'axios';

function App() {
  return (
    <div className="App">
      <Header/>
      <Container>
        <Row>
            <Col>
                <Routes>
                    <Route index element={<Home/>}/>
                    <Route path="colonies/add" element={<AddColonies/>}/>
                    <Route path="colonies" element={<Colonies/>}/>
                    <Route path="*" element={<NoMatch/>}/>
                </Routes>
            </Col>
        </Row>
      </Container>
    </div>
  );
}

function Home() {
    return(
        <div>
            <h2>Home</h2>
            <p>This is page from semestral work in subject TJV</p>
        </div>
    )
}


class AddColonies extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            extensionsNumber: '',
            availability: '',
            status: null,
        };

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        console.log(this.state);
        const payload = this.state;
        axios.post(`http://localhost:8080/colonies`, payload)
            .then(res => {
                let colonies =
                    this.setState({status: res.status})
            })

    }

    render() {
        let flashMessage;
        if (this.state.status === 200) {
            flashMessage = <Alert key={"success"} variant={"success"}>
                Bee colony created
            </Alert>
        } else if (this.state.status != null) {
            flashMessage = <Alert key={"danger"} variant={"danger"}>
                Bee colony creation error
            </Alert>
        }

        return (
            <div>
                <h2>Add colony</h2>
                {flashMessage}
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group className="mb-3" controlId="name">
                        <Form.Label>Name</Form.Label>
                        <Form.Control type="text" placeholder="Name" value={this.state.name}
                                      onChange={(e) => this.setState({name: e.target.value})}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="extensionsNumber">
                        <Form.Label>Extensions Number</Form.Label>
                        <Form.Control type="text" placeholder="Extensions Number" value={this.state.extensionsNumber}
                                      onChange={(e) => this.setState({extensionsNumber: e.target.value})}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="availability">
                        <Form.Label>Availability</Form.Label>
                        <Form.Control type="text" placeholder="Availability" value={this.state.availability}
                                      onChange={(e) => this.setState({availability: e.target.value})}/>
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Add
                    </Button>
                </Form>
            </div>
        );
    }
}

class Colonies extends Component{

    constructor(props) {
        super(props);
        this.state = {
            colonies: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/colonies`)
            .then(res => {
                console.log(res);
                this.setState({colonies: res.data.embed.colonies})
            })
    }

    render() {
        return (
            <div>
                <h2>Colonies</h2>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Extensions Number</th>
                        <th>Availability</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.colonies.map((colony) => {
                            return <tr key={colony.links.self.href}>
                                <td>{colony.name}</td>
                                <td>{colony.extensionsNumber}</td>
                                <td>{colony.availability}</td>
                                <td></td>
                            </tr>
                        })
                    }
                    </tbody>
                </Table>
            </div>
        );
    }

}

function NoMatch() {
    return (
        <div>
            <h2>Nothing to see here!</h2>
            <p>
                <Link to="/">Go to the home page</Link>
            </p>
        </div>
    );
}


export default App;
