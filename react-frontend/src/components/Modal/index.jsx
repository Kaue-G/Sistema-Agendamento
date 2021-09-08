import './style.css';
import { Link } from 'react-router-dom';


function Modal({ visible, setVisible, office }) {

  const handleBackgroundClick = () => {
    console.log('passou')
    setVisible(false);
  }

  return (
    <>
      {visible ? (
        <div className='modalBackground' onClick={handleBackgroundClick} >
          <div className='modalArea'>

            <p className='title'>O que você quer marcar?</p>
            <p className='msg'>Escolho que tipo de agendamento você quer fazer.</p>

            <div className='images'>
              <div className='office'>
                <Link to={`/office/${office.id}/chair`}>
                  <img src='/office.svg' alt='' />
                </Link>
              </div>
              <div className='meet'>
                <Link to={`/office/${office.id}/meet`}>
                  <img src='/meet.svg' alt='' />
                </Link>
              </div>
            </div>

          </div>
        </div>
      ) : null}
    </>
  )
}

export default Modal;
