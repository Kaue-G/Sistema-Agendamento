import Aside from '../../components/Aside';
import './style.css';

import Disponibility from "../../components/Disponibility";

function Home() {
  return (
    // <>
    //   <main>
    //     <Disponibility />
    //   </main>
    // </>
    <div className="container">  
      <div className="page">
        <Aside />
        <div className="cancelarTicket">
          <div className ="txt">
            <h1>historico</h1>
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

export default Home;