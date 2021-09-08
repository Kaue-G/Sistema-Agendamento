import doRequest from 'core/utils/Requests'
import { Office } from 'core/utils/Types'
import OfficeCard from './components/Office'
import { useEffect, useState } from 'react'
import './style.scss'

const Home = () => {
    const [officeResponse,setOfficeResponde] = useState<Office[]>([])

    useEffect(() => {
        doRequest({url: '/offices'})
        .then(response => setOfficeResponde(response.data))
    },[])

    return <div>
        <div className="home-container">
            <div className="title-body">
                <h2 className="title">Olá consultor!</h2>
                <p className="description">Navegue no menu ao lado para agendar sua ida presencial em uma unidade da FCamara.</p>
                <p className="description">Bom trabalho e não se esqueça da máscara hein?</p>
            </div>
            <div className="office-body">
                {officeResponse.map(office => (
                    <OfficeCard office={office} key={office.id}/>
                ))}
            </div>
        </div>
    </div>
}
export default Home