import './style.css';
import Email from './Email';
import Confirmation from './Confirmation';
import { useState } from 'react';
import { Link } from 'react-router-dom';

export default function Modal({ setVisible }) {

  const [showEmail, setShowEmail] = useState(false);

  const handleInformation = () => {
    if (showEmail === false) {
      setShowEmail(true)
    }
  }

  return (
    <>
      <div className='modal-background'>
        <div className='modal-area'>
          <div className='modal-information'>
            {!showEmail ?
              <Confirmation />
              : <Email />}
          </div>
          <div className="buttons">
            <button className="back" type="submit" onClick={setVisible}>Voltar</button>

            <button className="next" type="button" onClick={handleInformation}>
              {showEmail ? <Link to='/ticket'>Próximo</Link> : 'Próximo'}
            </button>

          </div>
        </div>
      </div>
    </>
  )
}


