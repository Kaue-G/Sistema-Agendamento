import './style.css'
import DefaultPage from '../../components/DefaultPage';
import ResultTable from '../../components/ResultTable';
import doRequest from '../../services/api';
import { useState } from 'react';
import { toast } from 'react-toastify';

export default function HistoricPage() {

  const [email, setEmail] = useState('');
  const [booking, setBooking] = useState();

  const handleOnChange = (e) => {
    setEmail(e.target.value)
  }

  const getBookingInfo = () => {
    doRequest({ url: `/offices/bookings`, params: { email: email } })
      .then(r => setBooking(r.data))
      .catch(() => toast.error('Nenhum usuário com esse email'))
  }

  return (
    <DefaultPage>
      <div className="messageHP">
        <h1>Histórico</h1>
        <p>Busque seu histórico de agendamentos da última semana pelo e-mail utilizado na confirmação de sua reserva.</p>
      </div>
      <div className="inputHP">
        <label for="email"></label>
        <input type="text" value={email} onChange={handleOnChange} placeholder="Insira aqui seu e-mail" name="email" />
        <button type="button" className={`${email === '' ? 'disabled' : ''}`} onClick={getBookingInfo}>Buscar</button>
      </div>
      {booking && (
        <ResultTable bookings={booking} />
      )}
    </DefaultPage>
  )
}
