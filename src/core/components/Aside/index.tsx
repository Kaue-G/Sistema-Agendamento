import './style.scss'
import {ReactComponent as HomeButton} from 'core/assets/NavImages/home.svg'
import {ReactComponent as BookingButton} from 'core/assets/NavImages/book.svg'
import { NavLink } from 'react-router-dom'

function Aside() {
  const handleModal = () => {
    console.log('Modal')
    


  }

  return (
    <nav className="nav-menu">
            <ul className="main-menu">
                <li>
                 <NavLink to="/" exact activeClassName="active"><HomeButton/></NavLink>
                </li>
                <li>
                  <NavLink to="/bookings" activeClassName="active"><BookingButton onClick={handleModal}/></NavLink>
                  
                </li>
            </ul>
    </nav>)
}

export default Aside;