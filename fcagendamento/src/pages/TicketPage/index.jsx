import { getOffice } from '../../services/offices';

function TicketPage(props) {
  const officeId = props.match.params.officeId;
  const office = getOffice(officeId);

  return (
    <h1>Confirmação de Agendamento {office.name}</h1>
  )
}

export default TicketPage;