import './style.scss';
import { Link, useLocation } from 'react-router-dom';
import Ticket from './components/Ticket';
import {ReactComponent as WashHandsImage} from './assets/lave.svg'
import {ReactComponent as LogoImage} from './assets/logo.svg'
import {ReactComponent as MaskImage} from './assets/mascara.svg'
import {ReactComponent as ProtImage} from './assets/proteja.svg'
import {ReactComponent as RocketImage} from './assets/space.svg'
import { useState } from 'react';
import { Booking, Office } from 'core/utils/Types';


const TicketPage = () => {
    const location = useLocation<Booking>();

  return (
    <div className="ticket-page">
        {location.state && <Ticket booking={location.state}/>}
    </div>
  )
}

export default TicketPage;