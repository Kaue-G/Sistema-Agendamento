import Aside from './core/components/Aside';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Home from './pages/Home'
import Booking from './pages/Booking';

const Routes = () => (
    <div className="container-box">
    <BrowserRouter > 
    <Aside/>
       <Switch>
           <Route path="/" exact> 
                <Home/>
           </Route>    
           <Route path="/bookings" exact>
               <Booking/> 
           </Route>
       </Switch>
    </BrowserRouter>
    </div>
    )

export default Routes;

