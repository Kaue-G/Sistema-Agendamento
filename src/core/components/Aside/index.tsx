import './style.scss'
import {ReactComponent as HomeButton} from 'core/assets/NavImages/home.svg'
import {ReactComponent as BookingButton} from 'core/assets/NavImages/book.svg'
import {ReactComponent as CancelButton } from 'core/assets/NavImages/delete.svg'
import {ReactComponent as HistoryButton } from 'core/assets/NavImages/icon_clock.svg'
import { NavLink } from 'react-router-dom'

function Aside() {
  return (
    <nav className="nav-menu">
            <ul className="main-menu">
                <li>
                 <NavLink to="/" exact activeClassName="active"><HomeButton/></NavLink>
                </li>
                <li>
                  <NavLink to="/bookings" activeClassName="active"><BookingButton/></NavLink>
                </li>

                <li>
                  <NavLink to="/history" activeClassName="active"><HistoryButton style={{paddingLeft: '7px',transform: 'scale(1.3)'}}/></NavLink>
                </li>

                <li>
                  <NavLink to="/cancel" activeClassName="active"><CancelButton style={{paddingLeft: '7px',transform: 'scale(1.3)'}}/></NavLink>
                </li>
            </ul>
    </nav>)

}

export default Aside;