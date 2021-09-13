import './style.scss';
import { Link } from 'react-router-dom';
import Ticket from './components/Ticket';
import {ReactComponent as WashHandsImage} from './assets/lave.svg'
import {ReactComponent as LogoImage} from './assets/logo.svg'
import {ReactComponent as MaskImage} from './assets/mascara.svg'
import {ReactComponent as ProtImage} from './assets/proteja.svg'
import {ReactComponent as RocketImage} from './assets/space.svg'


type Props = {
    
}

function TicketPage() {


  return (
    <div className="ticket-page">

      <div className="top">
        <div className="logo">
          <LogoImage/>
        </div>
        <div className="msg">
          <h1>CONFIRMADO!</h1>
        </div>
        <div className="image-space">
          <RocketImage/>
        </div>
      </div>

      <div className="text">
        <p>Seu agendamento foi concluído com sucesso e gerou o ticket:</p>
      </div>

      <div className="middle">
        <div className="left">
          <MaskImage/>
        </div>

        <div className="ticket">
          <Ticket/>
        </div>

        <div className="right">
          <div className="r1">
            <ProtImage/>
          </div>
          <div className="r2">
            <WashHandsImage/>
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