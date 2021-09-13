import './style.css';
import DefaultPage from '../../components/DefaultPage';
import doRequest from '../../services/api';
import { useEffect, useState } from 'react';
import OfficeCard from '../../components/OfficeCard';

export default function Booking() {
  const [officeResponse, setOfficeResponse] = useState([])
  const [activeOffice, setActiveOffice] = useState(0)


  useEffect(() => {
    doRequest({ url: "/offices" })
      .then(r => setOfficeResponse(r.data))
  }, [])

  return (

    <DefaultPage>
      <div className="booking-container">
        <div className="header-booking">
          <p>Verifique a disponibilidade de estações de trabalho e salas de reunião por unidade, dia e horário.</p>
          <div className="office-pagination">
            {officeResponse && officeResponse.map(o => (
              <div
                className={`office-pagination-element ${activeOffice === o.id ? 'active' : ''}`}
                key={o.id}
                id={`${o.id}`}
                onClick={office => setActiveOffice(Number(office.currentTarget.id))}
              >{o.name}</div>
            ))}
          </div>
        </div>
        <div className="content-booking">
          {officeResponse !== undefined && activeOffice !== 0 ? <OfficeCard office={officeResponse.find(o => o.id === activeOffice)} /> : ''}
        </div>
      </div>
    </DefaultPage>
  )
}


