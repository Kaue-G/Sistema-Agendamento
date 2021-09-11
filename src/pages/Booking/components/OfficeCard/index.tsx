import RoomIcon from './components'
import './style.scss'

const OfficeCard = () => {
    return (
        <div className="office-card-container">
            <div className="office-header">
                <h3>São Paulo</h3>
                <span>&nbsp;&nbsp;*Lotação máxima: 240 pessoas</span>
            </div>
            <div className="office-information">
                <div className="work-day">
                    <span>Estações de trabalho</span>
                    <p>Escolha um dia</p>
                    <select className="form-select">
                        <option style={{display: 'none'}}>Escolha um dia</option>
                    </select>
                    <p>Lugares disponíveis: <b>14</b></p>
                    <button className="btn btn-primary btn-lg">Agendar</button>

                </div>
                <div className="work-reunion">
                    <span>Salas de reunião</span>
                    <p>Escolha um dia</p>
                    <select className="form-select">
                        <option style={{display: 'none'}}>Escolha um dia</option>
                    </select>

                    <div className="time-select">
                        <div>
                            <p><b>Hora inicial</b></p>
                            <select className="form-select">
                            </select>
                        </div>
                        <div>
                            <p><b>Hora final</b></p>
                            <select className="form-select">
                            </select>
                        </div>
                    </div>

                    <p>Disponibilidade: <b>14</b></p>

                    <div className="room-container">
                        <RoomIcon state="disable-icon"/>
                        <RoomIcon state="active-icon"/>
                        <RoomIcon state="disable-icon"/>
                        <RoomIcon state="active-icon"/>
                        <RoomIcon state="active-icon"/>
                    </div>
                    <button className="btn btn-secondary btn-lg">Agendar sala</button>

                </div>
            </div>
        </div>
    )
}

export default OfficeCard