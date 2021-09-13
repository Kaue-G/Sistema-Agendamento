import './style.css';
import DefaultPage from '../../components/DefaultPage';
import { Link } from 'react-router-dom';


function HomePage() {

  return (
    <DefaultPage>
      <div className="box-top">
        <div className="message-home">
          <h1>Olá consultor!</h1>
          <p className="with-aside">Navegue pelos ícones abaixo ou no menu ao lado para
            agendar sua ida presencial aos escritórios da FCamara.
          </p>
          <p className="without-aside">Navegue pelos ícones abaixo para
            agendar sua ida presencial aos escritórios da FCamara.
          </p>
        </div>

        <div className="image">
          <img src="/images/imageHome.svg" alt="" />
        </div>
      </div>

      <div className="box-bottom">
        <div className="links">
          <Link to='/booking' className="to">
            <div className="link">
              <img src="/images/book.svg" alt="icone-calendario" />
              Realize seus(s) agendamentos
            </div>
          </Link>

          <Link to='/historic' className="to">
            <div className="link">
              <img src="/images/clock.svg" alt="icone-relogio" />
              Veja o histórico de reservas
            </div>
          </Link>

          <Link to='/cancel' className="to">
            <div className="link" >
              <img src="/images/cancel.svg" alt="icone-cancelamento" />
              <p> Cancele um agendamento já realizado</p>
            </div>
          </Link>
        </div>
      </div>
    </DefaultPage>
  )
}

export default HomePage;