import './style.scss'
import { Office} from 'core/utils/Types';

type Props = {
    office: Office
}
const OfficeCard = ({office}:Props) => {

    //const onSelectChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        //let dayFound = office.days.find(d => d.day === Number(e.target.value))
    //}

    return <div className="office-container">
        <h2 className="office-title">{office.name}</h2>
        <div className="card-body">
            <div className="card-content-wrapper">
                <div className="card-element-top left left-top">
                        <p>Total de estações para trabalho</p>
                        <div className="total-box">{office.totalChairs}</div>
                </div>
                <div className="card-element-top">
                        <p>Total de salas de reunião</p>
                        <div className="total-box">{office.totalRooms}</div>
                </div>
                <div className="card-data-picker">
                    <p>SELECIONE A DATA QUE QUER VERIFICAR A DISPONIBILIDADE</p>
                    <select className="form-select form-select-lg">
                        <option style={{display: 'none'}}>Escolha um dia</option>
                        {office.days.map(day => (
                            <option value={day.day} key={day.day}>{day.date} - {day.verbose}</option>
                        ))}
                    </select>

                </div>
                <div className="card-element-bottom left">
                    <p>Disponível</p>
                    <div className="state-box">
                        
                    </div>
                </div>
                <div className="card-element-bottom">
                    <p>Disponível</p>
                    <div className="state-box">
                    </div>
                </div>
            </div>
        </div>
    </div>
}

export default OfficeCard;