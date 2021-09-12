import './style.css';
import api from '../../services/api.js'
import Aside from '../../components/Aside';
import { useState } from 'react';

function CancelPage(props) {
  const [idTicket, setIdTicket] = useState([]);

  function onChange(ev) {
    setIdTicket(ev.target.value);
  }

  function onClick(){
    
    api.delete(`/offices/bookings/${idTicket}`)
    // .then(
      
    // });
   
  }

  return (
    <div className="container">  
      <div className="page">
        <Aside />
        <div className="cancelarTicket">
          <div className ="txt">
            <h1>cancelar ticket</h1>
            <p>
            Para cancelar uma reserva já realizada, 
            por favor insira o número do ticket correspondente 
            à esse agendamento no espaço abaixo.
            </p>
          </div>
          <div>
            <form className="form" action="">
              <input 
              type="number" 
              placeholder = "insira o numero do seu Ticket"
              name="" id="" onChange={onChange}
              />
              <button 
              type="button" 
              onClick={onClick}
              disabled
              >
                cancelar ticket
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CancelPage;

