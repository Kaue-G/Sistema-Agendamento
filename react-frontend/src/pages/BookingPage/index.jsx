import './style.css';
import Disponibility from '../../components/Disponibility';
import DefaultPage from '../../components/DefaultPage';

export default function BookingPage() {
  return (
    <DefaultPage>
      <div className="messageBP">
        <p>Verifique a disponibilidade de estações de trabalho e
          salas de reunião por unidade, dia e horário.
        </p>
      </div>
      <div className="boxesBP">
        <Disponibility />
      </div>
    </DefaultPage>

  )
}
