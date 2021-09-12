import stringToDate from 'core/utils/DataFormat'
import doRequest from 'core/utils/Requests'
import { Office, OfficeState, RoomResponse } from 'core/utils/Types'
import React, { useEffect, useState } from 'react'
import RoomIcon from './components'

import './style.scss'

type Props = {
    office: Office;
}

type ReunionArgs = {
    date?: string,
    begin?: number,
    end?: number
} 

const OfficeCard = ({office}: Props) => {
    const[officeState, setOfficeState] = useState<OfficeState>()
    const[reunionArgs, setReunionArgs] = useState<ReunionArgs>({})
    const[reunionState, setReunionState] = useState<OfficeState>()
    const[roomContent, setRoomContent] = useState<RoomResponse>()

    const onSimpleSelect = (e: React.ChangeEvent<HTMLSelectElement>) =>{
        let date = stringToDate(e.target.value)
        doRequest({url: `/offices/${office.id}`, params: {date} })
        .then(r => setOfficeState(r.data))
    }

    const onMultipleSelect = (e: React.ChangeEvent<HTMLSelectElement>) => {
        const name = e.target.name
        const value = e.target.value
        
        setReunionArgs(data => ({...data, [name]: value}))
    }

    useEffect(() =>{
        if(reunionArgs.date !== undefined && reunionArgs.begin !== undefined && reunionArgs.end){
            const date = stringToDate(reunionArgs.date);
            const begin = reunionArgs.begin;
            const end = reunionArgs.end;

            doRequest({url: `/offices/${office.id}`, params: {date, begin, end}})
            .then(r => setReunionState(r.data))

            doRequest({url: `/offices/${office.id}/chairs`, params: {date, begin, end}})
            .then(r => setRoomContent(r.data))
        
        }

    },[reunionArgs, office])

    return (
        <div className="office-card-container">
            <div className="office-header">
                <h3>{office.name}</h3>
                <span>&nbsp;&nbsp;*Lotação restrita: {office.restrictedCapacity} pessoas</span>
            </div>
            <div className="office-information">
                <div className="work-day">
                    <span>Estações de trabalho</span>
                    <p>Escolha um dia</p>
                    <select className="form-select" onChange={onSimpleSelect}>
                        <option style={{display: 'none'}}>Escolha um dia</option>
                        {office.days.map(day => (
                            <option value={day.date} key={day.dayNumber}>{day.date}</option>
                        ))}
                    </select>
                    <p>Lugares disponíveis: {officeState && <b>{officeState.restrictedCapacity - officeState.totalEmployees}</b>}</p>
                    <button 
                    className={`btn btn-primary btn-lg ${officeState !== undefined && officeState.totalEmployees >= officeState?.restrictedCapacity ? 'disabled':''}`}>Agendar</button>

                </div>
                <div className="work-reunion">
                    <span>Salas de reunião</span>
                    <p>Escolha um dia</p>
                    <select className="form-select" onChange={onMultipleSelect} name="date" value={reunionArgs.date}>
                        <option style={{display: 'none'}}>Escolha um dia</option>
                        {office.days.map(day => (
                            <option value={day.date} key={day.dayNumber}>{day.date}</option>
                        ))}
                    </select>

                    <div className="time-select">
                        <div>
                            <p><b>Hora inicial</b></p>
                            <select className="form-select" name="begin" value={reunionArgs.begin} onChange={onMultipleSelect}>
                            <option style={{display: 'none'}}></option>
                            <option value='8'>8h</option>
                            <option value='9'>9h</option>
                            <option value='10'>10h</option>
                            <option value='11'>11h</option>
                            <option value='12'>12h</option>
                            <option value='13'>13h</option>
                            <option value='14'>14h</option>
                            <option value='15'>15h</option>
                            <option value='16'>16h</option>
                            <option value='17'>17h</option>
                            <option value='18'>18h</option>
                            </select>
                        </div>
                        <div>
                            <p><b>Hora final</b></p>
                            <select className="form-select" name="end" value={reunionArgs.end} onChange={onMultipleSelect}>
                            <option style={{display: 'none'}}></option>
                            <option value='8'>8h</option>
                            <option value='9'>9h</option>
                            <option value='10'>10h</option>
                            <option value='11'>11h</option>
                            <option value='12'>12h</option>
                            <option value='13'>13h</option>
                            <option value='14'>14h</option>
                            <option value='15'>15h</option>
                            <option value='16'>16h</option>
                            <option value='17'>17h</option>
                            <option value='18'>18h</option>
                            </select>
                        </div>
                    </div>

                    <p>Disponibilidade: {reunionState && <b>{reunionState.totalRooms}</b>}</p>

                    <div className="room-container">
                        {roomContent && roomContent.content.map(room => (
                            <RoomIcon  key={room.id} room={room.name} state={`${room.available ? 'active-icon':'disable-icon'}`}/>
                        ))}
                    </div>
                    <button 
                    className={`btn btn-secondary btn-lg ${reunionState !== undefined && (reunionState.totalRooms < 1 || reunionState?.totalEmployees  >= reunionState?.restrictedCapacity) ? 'disabled' : ''}`}>Agendar sala</button>
                </div>
            </div>
        </div>
    )
}

export default OfficeCard