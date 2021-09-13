import './style.css';
import { Link, useLocation } from 'react-router-dom';
import Ticket from '../../components/Ticket';

function TicketPage() {

  const location = useLocation();

  return (
    <div className="ticket-page">

      <div className="top">
        <div className="logo">
          <img src="/images/logo.svg" alt="logo" />
        </div>
        <div className="msg">
          <h1>CONFIRMADO!</h1>
        </div>
        <div className="image-space">
          <img src="/images/space.svg" alt="foguete" />
        </div>
      </div>

      <div className="text">
        <p>Seu agendamento foi concluído com sucesso e gerou o ticket:</p>
      </div>

      <div className="middle">
        <div className="left">
          <img src="/images/mascara.svg" alt="use-mascara" />
        </div>

        <div className="ticket">
          <Ticket booking={location.state} />
        </div>

        <div className="right">
          <div className="r1">
            <img src="/images/proteja.svg" alt="se-proteja" />
          </div>
          <div className="r2">
            <img src="/images/lave.svg" alt="lave-mãos" />
          </div>
        </div>
      </div>

      <div className="bottom">
        <p className="text">Salve, anote ou copie este número, pois ele é seu passe de entrada para
          o escritório, certo? Porém, se não conseguir agora, tudo bem também, mandamos
          para o seu email.
        </p>
        <p className="link"><Link to="/">Voltar para a tela inicial</Link></p>
      </div>

    </div>
  )
}

export default TicketPage;