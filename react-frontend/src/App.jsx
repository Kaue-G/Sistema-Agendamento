import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import HomePage from './pages/HomePage';
import TicketPage from './pages/TicketPage';
import BookingPage from './pages/BookingPage';
import CancelPage from './pages/CancelPage';
import HistoricPage from './pages/HistoricPage';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={HomePage} />
        <Route path='/booking' component={BookingPage} />
        <Route exact path='/ticket' component={TicketPage} />
        <Route exact path='/historic' component={HistoricPage} />
        <Route exact path='/cancel' component={CancelPage} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
