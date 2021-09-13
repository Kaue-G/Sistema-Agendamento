import './style.css';


export default function Ticket({ booking }) {
  return (
    <div className="ticket-box">
      {/* <div className="ticket-number">{booking.id}</div>
      <div className="ticket-left">
        <img src="/images/ticketOK" alt="" />
        {booking.begin !== undefined ? <span>{booking.moment} <br /> {booking.begin}h - {booking.end}h</span> : <span>{booking.moment}</span>}</div>
      <div className="ticket-right">
        <div className="ticket-right-info-header">
          <span>Unidade</span>

          {booking.chair !== undefined ? <span>Sala</span> : ''}
        </div>
        <div className="ticket-right-info">
          {booking.officeName.substring(9)}
          {booking.chair !== undefined ? <span>{booking.chair}</span> : ''}
        </div>
      </div> */}
    </div>

  )
}