import React, { useEffect, useState } from 'react';
import './style.css';
import api from '../../api';

import Disponibility from "../../components/Disponibility";
import CardHome from "../../components/CardHome";

function Home() {
  const [offices, setOffices] = useState([]);


  useEffect(() => {
    api.get("offices").then(({data}) => {
      setOffices(data);
    });
  }, []);

  // console.log(offices);
  // console.log(JSON.stringify(offices));

  
  const renderList = [];
  for(let i = 0; i < offices.length; i++){
    console.log(offices[i].name);
    renderList.push(<CardHome infoOffice = {offices[i]} />);
  }


  return (
    <>
      <main>
        <Disponibility />
        {renderList}
      </main>
    </>
  )
}

export default Home;