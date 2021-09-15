import { useState } from 'react';
import './style.css'
import doRequest from '../../services/api.js';
import { toast } from 'react-toastify';
import Background from '../../components/Background';
import ResultTable from '../../components/ResultTable';
import { set } from 'date-fns';

export default function HistoricPage() {
  const [email, setEmail] = useState('');
  const [reserva, setReserva] = useState([]);
  const [booking, setBooking] = useState();

  const button = email == '' ? (
    <button disabled style={{ opacity: '50%' }}>buscar</button>) :
    (<button type="button" onClick={onClick} style={{ cursor: 'pointer' }}>buscar</button>);


  function onChange(ev) {
    setEmail(ev.target.value);
  }

  function onClick() {
    if (email == 0) {

    } else {
      doRequest({ url: '/offices/bookings', params: { email: email } })
        .then(r => setReserva(r.data))
        .catch(() => toast.error('Nenhum usuário com esse email'));
    }
  }

  const handleOnChange = (e) => {
    setEmail(e.target.value)
  }

  const getBookingInfo = () => {
    doRequest({ url: `/offices/bookings`, params: { email: email } })
      .then(r => setBooking(r.data))
      .catch(() => toast.error('Nenhum usuário com esse email'))
  }

  return (
    <Background>
      <div className="messageHP">
        <h1>Histórico</h1>
        <p>Busque seu histórico de agendamentos da última semana pelo e-mail utilizado na confirmação de sua reserva.</p>
      </div>
      <div className="inputHP">
        <label for="email"></label>
        <input
          type="text"
          placeholder="Insira aqui seu e-mail"
          name="email"
          onChange={onChange}
        />
        {button}
      </div>
      {
        reserva == 0 ? '' : <ResultTable reserva={reserva} />
      }
    </Background>
  )
}