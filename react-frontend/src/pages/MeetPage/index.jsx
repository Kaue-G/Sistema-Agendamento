import { getOffice } from '../../services/offices';

function MeetPage(props) {
  const officeId = props.match.params.officeId;
  const office = getOffice(officeId);

  return (
    <h1>Agendamento trabalho {office.name}</h1>
  )
}

export default MeetPage;

