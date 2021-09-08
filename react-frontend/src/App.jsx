import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import OfficePage from './pages/OfficePage';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Home} />
        <Route path='/office/:officeId' component={OfficePage} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
