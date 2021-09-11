import doRequest from 'core/utils/Requests';
import { Booking } from 'core/utils/Types';
import { useState } from 'react';
import { toast } from 'react-toastify';
import '../Cancel/style.scss'
import ResultTable from './components/ResultTable';

const History = () => {
    const [email,setEmail] = useState('');
    const [booking,setBooking] = useState<Booking[]>();

    const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setEmail(e.target.value)
    }

    const getBookingInfo = () => {
        doRequest({url: `/offices/bookings`, params: {email: email}})
        .then(r => setBooking(r.data))
        .catch(() => toast.error('Nenhum usuário com esse email'))

    }


    return (
        <div className="cancel-container">
            <div className="header-cancel">
                <h2>Histórico</h2>
                <p>Busque seu histórico de agendamentos da última semana pelo e-mail utilizado na confirmação de sua reserva.</p>
            </div>
            <div className="action-cancel">
                <input type="text" value={email} onChange={handleOnChange}/>
                <button className="btn btn-primary btn-lg" onClick={getBookingInfo}>Buscar</button>
            </div>
            {booking && (
                <ResultTable bookings={booking}/>
            )}
            
        </div>      
    )
}

export default History;