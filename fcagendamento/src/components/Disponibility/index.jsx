import './style.css';
import { Link } from 'react-router-dom';

function Disponibility(props) {
  return (
    <>
      <div className='containerSP'>
        <div className='box'>
          <p>Agendamento</p>
          <button>
            <Link to='/saoPaulo'>
              São Paulo
            </Link>
          </button>
        </div>
      </div>

      <div className='containerST'>
        <div className='box'>
          <p>Agendamento</p>
          <button>
            <Link to='/santos'>
              Santos
            </Link>
          </button>
        </div>
      </div>
    </>
  )
}

export default Disponibility;