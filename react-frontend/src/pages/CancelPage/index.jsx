import ModalBody from '../../components/ModalBody/index.jsx';
import doRequest from '../../services/api.js';

import { useState } from 'react';
import DefaultPage from '../../components/DefaultPage'
import './style.css';

export default function CancelPage(props) {
  const [modalVisible,setModalVisible] =  useState(0);

  const [idTicket, setIdTicket] = useState([]);

  const button = idTicket == '' ? (
    <button 
    disabled
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
    setModalVisible(1);
  }

  const requisicao = () => {
    doRequest({url: `/offices/bookings/${idTicket}`, method: 'DELETE'})
    // .then(() => toast.success(`Ticket  ${idTicket} cancelado com sucesso`))
    // .catch(() => toast.error(`Ticket não encontrado`));  
  
  };

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
          />
          {button}
        </form>
      </div>
      { modalVisible == 0 ? '' : 
      <ModalBody 
      onClose={() => setModalVisible(0)} 
      onModalAction={ requisicao }
      > 
        <p>Tem certeza que deseja cancelar o ticket <strong>{idTicket}</strong></p>
        <span><strong>Atenção!</strong> Depois de confirmada, essa ação não poderá ser desfeita.</span>
      </ModalBody>}
    </DefaultPage>

  )
}


