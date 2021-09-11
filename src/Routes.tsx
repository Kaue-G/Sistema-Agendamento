import Aside from './core/components/Aside';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import MainBody from 'core/components/MainBody';
import Home from 'pages/Home';
import Cancel from 'pages/Cancel';
import Booking from 'pages/Booking';

const Routes = () => (
    <BrowserRouter > 
       <Switch>
           <Route path="/" exact> 
           <MainBody>
               <Home/>
           </MainBody>
           </Route>    
           <Route path="/bookings" exact>
           <MainBody>
               <Booking/>
           </MainBody>
           </Route>
           <Route path="/cancel" exact>
           <MainBody>
               <Cancel/>
           </MainBody>
           </Route>
           <Route path="/history" exact>
           <MainBody>
               HISTORY
           </MainBody>
           </Route>
       </Switch>
    </BrowserRouter>
    )

export default Routes;

