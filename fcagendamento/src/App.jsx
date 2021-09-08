import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import SaoPaulo from './pages/SaoPaulo';
import OfficeSP from './pages/OfficeSP';
import MeetSP from './pages/MeetSP';
import Santos from './pages/Santos';
import OfficeST from './pages/OfficeST';
import MeetST from './pages/MeetST';
import Ticket from './pages/Ticket';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path='/'><Home /></Route>
        <Route exact path='/saoPaulo'><SaoPaulo /></Route>
        <Route exact path='/saoPaulo/office'><OfficeSP /></Route>
        <Route exact path='/saoPaulo/meet'><MeetSP /></Route>
        <Route exact path='/santos'><Santos /></Route>
        <Route exact path='/santos/office'><OfficeST /></Route>
        <Route exact path='/santos/meet'><MeetST /></Route>
        <Route path='/ticket'><Ticket /></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
