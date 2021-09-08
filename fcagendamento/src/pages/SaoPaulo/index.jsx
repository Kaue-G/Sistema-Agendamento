import './style.css';
import Aside from '../../components/Aside';


function SaoPaulo() {
  return (
    <>
      <main className='sao-paulo-page'>
        <Aside city='saoPaulo' />
        <div className='central'>
          <h1>Olá consultor!</h1>
          <p>Navegue no menu ao lado para agendar sua ida presencial à unidade da FCamara de São Paulo.</p>
          <p>Bom trabalho e não esqueça da máscara hein?</p>
          <span>R. Bela Cintra, 986 - 2º andar - Consolação, São Paulo-SP, 01415-906</span>
        </div>

      </main>
    </>
  )
}

export default SaoPaulo;