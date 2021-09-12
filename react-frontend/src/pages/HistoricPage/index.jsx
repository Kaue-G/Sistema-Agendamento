import React, { useState, useEffect } from 'react';
import Aside from '../../components/Aside';
import './style.css';

import Disponibility from "../../components/Disponibility";
import axios from 'axios';
import api from '../../services/api';


function Home() {
  const [agendados, setAgendados] =  useState([]);
  const [email, setEmail] =  useState([]);

  console.log(agendados);

  function onChange(ev) {
    const { name, value} = ev.target;    
    setEmail(value);
  }

  console.log(email);

  function onClick(){
    api.get(`/offices/bookings?email=${email}`)
    .then((agendamentos) => {
      setAgendados(agendamentos.data);
    });
    console.log(agendados);
    console.log(email);
  }
  

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
              Busque seu histórico de agendamentos da 
              última semana pelo e-mail utilizado na 
              confirmação de sua reserva.
            </p>
          </div>
          <div>
            <form className="form" action="">
              <input type="" name="email" id="" onChange={onChange}/>
              <button type="button" onClick={onClick}>buscar</button>
            </form>
          </div>



          <div>

          </div>



        </div>
      </div>
    </div>
  )
}

export default Home;