import ReactDOM from 'react-dom';
import Routes from 'Routes';
import './core/custom.scss'
import './App.scss'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {ReactComponent as LogoImage} from 'core/assets/grupo-fcamara-laranja.svg'

ReactDOM.render(
  <>
    <LogoImage className="logo_image"/>
    <ToastContainer/>
    <Routes/>
  </>,
  document.getElementById('root')
);
