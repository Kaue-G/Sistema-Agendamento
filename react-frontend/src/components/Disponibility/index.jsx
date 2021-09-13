import { useState } from 'react';
import Modal from '../Modal';
import './style.css';


export default function Disponibility() {

  const [modalVisible, setModalVisible] = useState(false);

  return (
    <div className="dispon">
      {modalVisible ?
        <Modal setVisible={() => setModalVisible(false)} /> : null}
      <button className="box" onClick={() => setModalVisible(true)}>
        Agendar
      </button>
      <button className="box" onClick={() => setModalVisible(true)}>
        Agendar sala de reunião
      </button>
    </div >
  )
};

