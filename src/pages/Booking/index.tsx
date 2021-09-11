import OfficeCard from './components/OfficeCard'
import './style.scss'

const Booking = () => {

    return (
        <div className="booking-container">
            <div className="header-booking">
                <p>Verifique a disponibilidade de estações de trabalho e salas de reunião por unidade, dia e horário.</p>
            </div>
            <div className="content-booking">
                <OfficeCard/>
                <OfficeCard/>
            </div>
        </div>      
    )
}

export default Booking


