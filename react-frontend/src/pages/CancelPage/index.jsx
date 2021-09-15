import Background from '../../components/Background';
import ModalBody from '../../components/ModalBody/index.jsx';
import doRequest from '../../services/api.js';
import { useHistory } from 'react-router';
import { useState } from 'react';
import './style.css';

export default function CancelPage(props) {
  const [idTicket, setIdTicket] = useState([]);
  const [modalInfo, setModalInfo] = useState([]);

  const button = idTicket == '' ? (
    <button disabled style={{ opacity: '50%' }}>cancelar ticket</button>)
    :
    (<button type="button" onClick={onClick} style={{ cursor: 'pointer' }}>cancelar ticket</button>);

  function onChange(ev) {
    setIdTicket(ev.target.value);
  }

  function onClick() {
    setModalInfo(
      <ModalBody 
      onClose={() => setModalInfo([])} 
      onModalAction={ requisicao }
      > 
        <p>Tem certeza que deseja cancelar o ticket <strong>{idTicket}</strong>?</p>
        <span><strong>*Atenção!</strong> Depois de confirmada, essa ação não poderá ser desfeita.</span>
      </ModalBody>
    );
  }

  const requisicao = () => {
    doRequest({ url: `/offices/bookings/${idTicket}`, method: 'DELETE' })
    .then(resposta =>
      setModalInfo( 
        <ModalBody 
        onClose={() => setModalInfo([])} 
        onModalAction={ requisicao }
        btnConfirmVisible = {0} 
        > 
          <p>O ticket <strong>{idTicket}</strong> foi cancelado com sucesso</p>
          <span><strong>Atenção!</strong> Você receberá um e-mail com a confirmação do cancelamento..</span>
        </ModalBody>
      )
    )
    .catch( erro =>
      setModalInfo(
        <ModalBody 
        onClose={() => setModalInfo([])}
        btnConfirmVisible = {0} 
        > 
          <p>O Ticket <strong>{idTicket}</strong> não foi encontrado.</p>
          <span><strong>Atenção!</strong> verifique o numero do ticket e tente novamente.</span>
        </ModalBody>
      )
    )  
  };

  return (
    <Background>
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
        {modalInfo}
      </div>
    </Background>
  );
}


