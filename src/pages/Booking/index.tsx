import doRequest from 'core/utils/Requests'
import { Office } from 'core/utils/Types'
import { useEffect, useState } from 'react'
import OfficeCard from './components/OfficeCard'
import './style.scss'

const Booking = () => {
    const [officeResponse,setOfficeResponse] = useState<Office[]>([])

    useEffect(() => {
        doRequest({url: "/offices"})
        .then(r => setOfficeResponse(r.data))

        //officeResponse.forEach(o => o.days.sort)
    },[])

    return (
        <div className="booking-container">
            <div className="header-booking">
                <p>Verifique a disponibilidade de estações de trabalho e salas de reunião por unidade, dia e horário.</p>
            </div>
            <div className="content-booking">
                {officeResponse.map(o => (
                    <OfficeCard office={o} key={o.id}/>
                ))}
            </div>
        </div>      
    )
}

export default Booking


