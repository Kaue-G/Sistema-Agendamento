import './style.css';
import Aside from '../../components/Aside';


function HomePage() {

  return (
    <>
      <main className='home-page'>
        <Aside />
        <div className="image">
          <img src="/images/imageHome.svg" alt="" />
        </div>
        <h1>Olá consultor!</h1>
        <p>Bom trabalho e não esqueça da máscara hein?</p>
      </main>
    </>
  )
}

export default HomePage;