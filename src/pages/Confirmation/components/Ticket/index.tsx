import './style.scss';

export default function Ticket() {
  return (
    <div className="ticket-boxes">
      <div className="box1">
        <div className="number">
          123456
        </div>
      </div>
      <div className="box2">
        <div className="box2-L">
          <div className="image-ticket">
            <img src="/images/ticketOk.svg" alt="" />
          </div>
          <div className="date">
            <p className="date-p1">09/09/2021</p>
            <p className="date-p2">quinta-feira</p>
          </div>
        </div>

        <div className="box2-R">
          <div className="office-p1">
            <p>Unidade</p>
          </div>
          <p className="office-p2">São Paulo</p>
        </div>
      </div>
    </div>
  )
}