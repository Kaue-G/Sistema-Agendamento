import './style.css';
import Aside from './Aside';

export default function DefaultPage(props) {
  return (
    <div className="page">
      <div className="images">
        <img className="logo" src="/images/logoLaranja.svg" alt="logo" />
        <img className="pontilhado" src="/images/pontilhado.svg" alt="pontilhado" />
      </div>
      <div className="container-page">
        <Aside />
        <div className="white-page">
          {props.children}
        </div>
      </div>
    </div>
  )

}