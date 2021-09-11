import ReactDOM from 'react-dom';
import Routes from 'Routes';
import './core/custom.scss'
import './App.scss'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

ReactDOM.render(
  <>
    <ToastContainer/>
    <Routes/>
  </>,
  document.getElementById('root')
);
