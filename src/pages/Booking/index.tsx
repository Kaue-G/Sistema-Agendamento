import doRequest from 'core/utils/Requests'
import { Office } from 'core/utils/Types'
import { useEffect, useState } from 'react'
import OfficeCard from './components/OfficeCard'
import './style.scss'

const Booking = () => {
    const [officeResponse,setOfficeResponse] = useState<Office[]>([])
    const [activeOffice,setActiveOffice] = useState(0)


    useEffect(() => {
        doRequest({url: "/offices"})
        .then(r => setOfficeResponse(r.data))
    },[])

    return (
        <div className="booking-container">
            <div className="header-booking">
                <p>Verifique a disponibilidade de estações de trabalho e salas de reunião por unidade, dia e horário.</p>
                <div className="office-pagination">
                    {officeResponse && officeResponse.map(o => (
                        <div 
                        className={`office-pagination-element ${activeOffice === o.id ? 'active':''}`} 
                        key={o.id}
                        id={`${o.id}`}
                        onClick={office => setActiveOffice(Number(office.currentTarget.id))}
                        >{o.name}</div>
                    ))}
                </div>
            </div>
            <div className="content-booking">
                {officeResponse !== undefined  && activeOffice !== 0 ? <OfficeCard office={officeResponse.find(o => o.id === activeOffice)}/> : ''}
            </div>
        </div>      
    )
}

export default Booking


