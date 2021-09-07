import { Link } from 'react-router-dom';
import './style.css';
import Aside from '../../components/Aside';


function SaoPaulo() {
  return (
    <>
      <main>
        <Aside city='saoPaulo' />
        <div className='central'>
          <div className='image'>
            <Link to='/'><img src='arrowBack.svg' alt='' /></Link>
          </div>
          <div className='text'>
            <h1>Olá consultor!</h1>
            <p>Navegue no menu ao lado para agendar sua ida presencial à unidade da FCamara de São Paulo.</p>
            <p>Bom trabalho e não esqueça da máscara hein?</p>
            <span>R. Bela Cintra, 986 - 2º andar - Consolação, São Paulo-SP, 01415-906</span>
          </div>
        </div>
      </main>
    </>
  )
}

export default SaoPaulo;