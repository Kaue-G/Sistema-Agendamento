import './style.css';
import Aside from '../../components/Aside';
import { Link } from 'react-router-dom';


function Santos() {
  return (
    <>
      <main>
        <Aside city='santos' />
        <div className='central'>
          <div className='image'>
            <Link to='/'><img src='arrowBack.svg' alt='' /></Link>
          </div>
          <div className='text'>
            <h1>Olá consultor!</h1>
            <p>Navegue no menu ao lado para agendar sua ida presencial à unidade da FCamara de Santos.</p>
            <p>Bom trabalho e não esqueça da máscara hein?</p>
            <span>Prç. dos Expedicionários, 19 - Gonzaga, Santos-SP, 11065-500</span>
          </div>
        </div>
      </main>
    </>
  )
}

export default Santos;