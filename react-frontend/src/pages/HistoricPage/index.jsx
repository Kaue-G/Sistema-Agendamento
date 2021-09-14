import { useState } from 'react';
import './style.css'
import doRequest from '../../services/api.js';
import { toast } from 'react-toastify';

import DefaultPage from '../../components/DefaultPage';
import ResultTable from '../../components/ResultTable';
import { set } from 'date-fns';

export default function HistoricPage() {
  const [email, setEmail] = useState('');
  const [reserva, setReserva] = useState([]);

  function onChange(ev) {
    setEmail(ev.target.value);
  }

  function onClick(){
    if(email == 0){

    }else{
      doRequest({url: '/offices/bookings', params: {email: email}})
        .then(r => setReserva(r.data))
        .catch(() => toast.error('Nenhum usuário com esse email'));
    }
  }

  return (
    <DefaultPage>
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
          onChange = {onChange}
        />
        <button 
          type="button"
          onClick = {onClick}
        >
          Buscar
        </button>
      </div>
      {
        reserva == 0 ? '' : <ResultTable reserva = {reserva}/>
      }
    </DefaultPage>
  )
}
