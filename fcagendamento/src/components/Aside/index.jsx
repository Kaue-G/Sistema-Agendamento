import { useState } from 'react';
import { Link } from 'react-router-dom';
import Modal from '../Modal';
import './style.css'

function Aside({ city }) {

  const [modalVisible, setModalVisible] = useState(false);

  const handleModal = (value) => {
    console.log('aside')
    setModalVisible(value);
  }

  return (
    <nav>
      <ul>
        <li><Link to='/'><img src="home.svg" alt="" /></Link></li>
        <li >
          <img src="book.svg" alt="" onClick={() => handleModal(true)} />
          <Modal visible={modalVisible} setVisible={handleModal} city='saoPaulo' />
        </li>
        <li><Link to={`/${city}/ticket`}><img src="clock.svg" alt="" /></Link></li>
        <li><Link to={`/${city}/cancel`}><img src="cancel.svg" alt="" /></Link></li>
      </ul>
    </nav>
  )
}

export default Aside;