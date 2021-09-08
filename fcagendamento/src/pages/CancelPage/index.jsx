import { getOffice } from '../../services/offices';

function CancelPage(props) {
  const officeId = props.match.params.officeId;
  const office = getOffice(officeId);

  return (
    <h1>Cancelamento {office.name}</h1>
  )
}

export default CancelPage;

