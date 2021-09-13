import { Booking } from 'core/utils/Types';
import './style.scss';
import {ReactComponent as IconImage} from 'core/assets/NavImages/book.svg'


type Props = {
  booking: Booking;
}
export default function Ticket({booking} : Props) {
  return (
    <div className="ticket-box">
      <div className="ticket-number">{booking.id}</div>
      <div className="ticket-left">
        <IconImage/> 
        {booking.begin !== undefined ? <span>{booking.moment} <br/> {booking.begin}h - {booking.end}h</span> : <span>{booking.moment}</span>}</div>
      <div className="ticket-right">
        <div className="ticket-right-info-header">
          <span>Unidade</span> 
          
          {booking.chair !== undefined ? <span>Sala</span> : ''}
        </div>
        <div className="ticket-right-info">
          {booking.officeName.substring(9)}
          {booking.chair !== undefined ? <span>{booking.chair}</span> : ''}
        </div>
        </div>
    </div>
  )
}