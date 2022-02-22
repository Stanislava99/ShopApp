import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {BrowserRouter as Router, Route,Routes} from 'react-router-dom'
import HeaderComponent from './Components/HeaderComponent'
import LoginPageComponent from './Components/LoginPageComponent'

function App() {
  return (
    <Router>
      <HeaderComponent/>
      <LoginPageComponent/>
    </Router>
  );
}

export default App;
