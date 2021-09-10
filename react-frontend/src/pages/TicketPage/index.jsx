import './style.css';
import { Link } from 'react-router-dom';

function TicketPage() {


  return (
    <div className="ticket-page">

      <div className="top">
        <div className="logo">
          <img src="/images/logo.svg" alt="logo" />
        </div>
        <div className="msg">
          <h1>CONFIRMADO!</h1>
          <p>Seu agendamento foi concluído com sucesso e gerou o ticket:</p>
        </div>
        <div className="image-space">
          <img src="/images/space.svg" alt="foguete" />
        </div>
      </div>

      <div className="middle">
        <div className="left">
          <img src="/images/mascara.svg" alt="use-mascara" />
        </div>

        <div className="ticket">
          <div className="number">
            123456
          </div>

          <div className="infos">

            <div className="box1">
              <div className="image-ticket">
                <img src="/images/ticketOk.svg" alt="" />
              </div>
              <div className="date">
                <p className="date-p1">09/09/2021</p>
                <p className="date-p2">quinta-feira</p>
              </div>
            </div>

            <div className="box2">
              <p className="office-p1">Unidade</p>
              <p className="office-p2">São Paulo</p>
            </div>

          </div>
        </div>

        <div className="right">
          <img className="r1" src="/images/proteja.svg" alt="se-proteja" />
          <img className="r2" src="/images/lave.svg" alt="lave-mãos" />
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