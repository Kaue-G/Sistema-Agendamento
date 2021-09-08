import './style.css';
import { Link } from 'react-router-dom';
import { getOffices } from '../../services/offices';

function Disponibility() {

  const offices = getOffices();

  return (
    <>
      {offices.map((office) => {
        return (
          <div className='container'>
            <div className='box'>
              <p>Agendamento</p>
              <button>
                <Link to={`/office/${office.id}`}>
                  {office.name}
                </Link>
              </button>
            </div>
          </div>
        )
      })}


    </>
  )
}

export default Disponibility;