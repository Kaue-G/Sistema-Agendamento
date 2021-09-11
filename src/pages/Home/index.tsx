import './style.scss'
import {ReactComponent as HomeImage} from './assets/home_image.svg'
import {ReactComponent as DeleteIcon} from 'core/assets/NavImages/delete.svg'
import {ReactComponent as BookingIcon} from 'core/assets/NavImages/book.svg'
import {ReactComponent as HistoryIcon} from 'core/assets/NavImages/icon_clock.svg'
import { Link } from 'react-router-dom'

const Home = () => {

    return (
        <div className="home-wrapper">
            <div className="home-header">
                <h2>Olá, consultor!</h2>
                <p>Navegue pelos ícones abaixo ou no menu ao lado para agendar sua ida presencial aos escritórios da FCamara.</p>
            </div>
            <div className="home-button">
                <div>
                    <Link to="/bookings">
                    <BookingIcon className="booking-icon"/></Link>
                    <span>Realize seu agendamento</span>
                </div>
                <div>
                    <Link to="/history">
                    <HistoryIcon style={{paddingLeft: '7px'}}/></Link>
                    <span style={{paddingLeft: '14px'}}>Veja o histórico de reservas</span>
                </div>
                <div>
                    <Link to="/cancel"><DeleteIcon style={{paddingLeft: '7px'}}/></Link>
                    <span style={{paddingLeft: '14px'}}>Cancele um agendamento quando precisar</span>
                </div>
            </div>
            <div className="home-image"><HomeImage/></div>
        </div>
    )
}

export default Home;