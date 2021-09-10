import './style.css';
import { getOffice } from '../../services/offices';
import Aside from '../../components/Aside';

function CancelPage(props) {
  const officeId = props.match.params.officeId;
  const office = getOffice(officeId);

  return (
    // <h1>Cancelamento {office.name}</h1>
    <div className="container">  
      <div className="page">
        <Aside />
        <div className="cancelarTicket">
          <div className ="txt">
            <h1>cancelar ticket</h1>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. 
              Eveniet officiis veniam facere eum vitae soluta perferendis 
              reprehenderit ipsa unde! Quaerat doloribus atque id, nisi 
              quibusdam accusamus quod placeat inventore beatae.
            </p>
          </div>
          <div>
            <form className="form" action="">
              <input type="email" name="" id="" />
              <button>buscar pelo e-mail</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CancelPage;

