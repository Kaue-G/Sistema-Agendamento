import './style.scss';
import { Link, useLocation } from 'react-router-dom';
import Ticket from './components/Ticket';
import { Booking} from 'core/utils/Types';
import Rocket from 'core/assets/space.png'
import Hands from './assets/hands.png'
import Protect from './assets/protect.png'
import Wash from './assets/wash.png'


const TicketPage = () => {
    const location = useLocation<Booking>();

  return (
    <div className="ticket-page">
      <div className="ticket-page-header">
        <h1>CONFIRMADO!</h1>
        <img src={Rocket} alt="Rocket" />
        <p>Seu agendamento foi concluído com sucesso e gerou o ticket:</p>
      </div>
      <div className="ticket-page-content">
        <div className="img-ticket">
          {location.state && <Ticket booking={location.state}/>}
        </div>
        <img className="img-hands" src={Hands} alt="Rocket" />
        <img className="img-protect" src={Protect} alt="Protect" />
        <img className="img-wash" src={Wash} alt="Wash" />

      </div>
      <div className="ticket-page-footer">
        <p className="hard-text-info">Esse número é seu passe de entrada para o escritório, certo? Por isso, também <span>mandamos para o seu e-mail</span> essas informações.</p>
        <Link to="/" className="link-to-home">Voltar para a tela inicial</Link>
      </div>
    </div>
  )
}

export default TicketPage;