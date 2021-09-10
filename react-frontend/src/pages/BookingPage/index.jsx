import './style.css';
import Aside from '../../components/Aside';
import Disponibility from '../../components/Disponibility';

function Home() {
  return (
    <div className="booking-page">
      <Aside />
      <div className="container">
        <div className="txt">
          <p>Verifique a disponibilidade de estações de trabalho e
            salas de reunião por unidade, dia e horário.
          </p>
        </div>
        <div className="boxes">
          <Disponibility />
        </div>
      </div>
    </div>

  )
}

export default Home;