import './style.css';
import api from '../../services/api.js'
import DefaultPage from '../../components/DefaultPage'
import { useState } from 'react';

export default function CancelPage(props) {
  const [idTicket, setIdTicket] = useState([]);

  function onChange(ev) {
    setIdTicket(ev.target.value);
  }

  function onClick() {
    api.delete(`/offices/bookings/${idTicket}`)
    // .then(

    // });
  }

  return (
    <DefaultPage>
      <div className="messageCP">
        <h1>Cancelar Ticket</h1>
        <p>Para cancelar uma reserva já realizada,
          por favor insira o número do ticket correspondente
          à esse agendamento no espaço abaixo.
        </p>
      </div>
      <div>
        <form className="formCP" action="">
          <input type="number"
            placeholder="Insira o número do seu Ticket"
            name="" id="" required onChange={onChange}
          />
          <button type="button" onClick={onClick} disabled>
            Cancelar Ticket
          </button>
        </form>
      </div>
    </DefaultPage>

  )
}


