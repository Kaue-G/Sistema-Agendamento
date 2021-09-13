import { Link } from 'react-router-dom';
import './style.css'

function Aside() {

  return (
    <div className="aside-comp">
      <nav>
        <ul>
          <li><Link to='/'><img src="/images/home.svg" alt="" /></Link></li>
          <li><Link to='/booking' ><img src="/images/book.svg" alt="" /></Link></li>
          <li><Link to='/historic' ><img src="/images/clock.svg" alt="" /></Link></li>
          <li><Link to='/cancel' ><img src="/images/cancel.svg" alt="" /></Link></li>
        </ul>
      </nav>
    </div>
  )
}

export default Aside;