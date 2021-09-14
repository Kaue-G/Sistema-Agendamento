import ModalBody from '../../components/ModalBody/index.jsx';
import doRequest from '../../services/api.js';
import { toast } from 'react-toastify';

import { useState } from 'react';
import DefaultPage from '../../components/DefaultPage'
import './style.css';
// import { Button } from 'bootstrap';

export default function CancelPage(props) {
  const [modalVisible,setModalVisible] =  useState(true);

  const [idTicket, setIdTicket] = useState([]);

  const button = idTicket == '' ? (
    <button 
    type="button" 
    onClick={onClick} 
    style= {{opacity: '50%'}}
    >
      cancelar ticket
    </button>) 
    : 
    (<button 
      type="button" 
      onClick={onClick}
      style = {{cursor: 'pointer'}}
    >
      cancelar ticket
    </button>
    );


  
  function onChange(ev) {
    setIdTicket(ev.target.value);
  }

  function onClick() {
      if(idTicket == ""){

      }else{
        doRequest({url: `/offices/bookings/${idTicket}`, method: 'DELETE'})
        // .then(() => toast.success(`Ticket  ${idTicket} cancelado com sucesso`))
        // .catch(() => toast.error(`Ticket não encontrado`));

        setModalVisible(false);
      }
  }

  return (
    <DefaultPage>
      <div className="messageCP">
        <h1>cancelar ticket</h1>
        <p>Para cancelar uma reserva já realizada,
          por favor insira o número do ticket correspondente
          à esse agendamento no espaço abaixo.
        </p>
      </div>
      <div>
        <form className="formCP" action="">
          <input 
            type="text"
            placeholder="Insira o número do seu Ticket"
            name="" id="" onChange={onChange}
            required
          />
          {button}
        </form>
      </div>
    </DefaultPage>

  )
}


