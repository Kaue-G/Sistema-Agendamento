import './style.css';
import Aside from '../../components/Aside';
import { getOffice } from '../../services/offices';
import { Route, Switch, useRouteMatch } from 'react-router-dom';
import ChairPage from '../ChairPage';
import MeetPage from '../MeetPage';
import TicketPage from '../TicketPage';
import CancelPage from '../CancelPage';



function OfficePage(props) {
  const officeId = props.match.params.officeId;
  const office = getOffice(officeId);

  const { path } = useRouteMatch();

  return (
    <>
      <main className='office-page'>
        <Aside office={office} />
        <div className='office-page-content'>
          <Switch>
            <Route exact path={path}>
              <>
                <h1>Olá consultor!</h1>
                <p>Navegue no menu ao lado para agendar sua ida presencial à unidade da FCamara de {office.name}.</p>
                <p>Bom trabalho e não esqueça da máscara hein?</p>
                <span>{office.endereco}</span>
              </>
            </Route>
            <Route exact path='/office/:officeId/chair' component={ChairPage} />
            <Route exact path='/office/:officeId/meet' component={MeetPage} />
            <Route exact path='/office/:officeId/ticket' component={TicketPage} />
            <Route exact path='/office/:officeId/cancel' component={CancelPage} />
          </Switch>
        </div>
      </main>
    </>
  )
}

export default OfficePage;