import { BrowserRouter, Switch, Route } from 'react-router-dom'
import MainBody from 'core/components/MainBody';
import Home from 'pages/Home';
import Cancel from 'pages/Cancel';
import Booking from 'pages/Booking';
import History from 'pages/History';
import TicketPage from 'pages/Confirmation';

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
               <History/>
           </MainBody>
           </Route>
           <Route path="/bookings/confirmation" exact>
               <TicketPage/>
           </Route>
           <Route path="/bookings/error" exact>
               <h1>DEU ERRADO SINTO MUITO</h1>
           </Route>
       </Switch>
    </BrowserRouter>
    )

export default Routes;

