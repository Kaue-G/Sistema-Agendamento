import React, { Children } from 'react';
import '../styles/cardHome.css';

function CardHome (props) {
    // console.log(props.infoOffice.name);
    // console.log(info);
    console.log(props.infoOffice);
    // console.log(info[0].name);

    const renderList = [];
    for(let i = 0; i < props.infoOffice.days.length; i++){
        const idDia = props.infoOffice.days[i].day;
        console.log(props.infoOffice.days[i].day);
        renderList.push(<option value= {props.infoOffice.days[i].day}>
            {props.infoOffice.days[i].date} -
            {props.infoOffice.days[i].verbose}
            </option>);
    }
    return (
        <div className="container">
            <div className="escritorio-nome flex">{props.infoOffice.name}</div>
            <div className="card flex">
                <div className="info">
                    <div className="quantidade">
                        <div className="estacao-esquerdo flex">
                            <div className="titulo flex">estacao de trabalho</div>
                            <div className="contador flex">{props.infoOffice.totalChairs}</div>
                        </div>
                        <div className="sala-direito flex">
                            <div className="titulo flex">sala de reuniao</div>
                            <div className="contador flex">{props.infoOffice.totalRooms}</div>
                        </div>
                    </div>
                    <div className="selecionar-data flex">
                        <h3 className="titulo flex">selecione a data</h3>
                        <div className="seletor flex">
                            
                            <select className="btn" name="cars" id="cars">
                                <option value="volvo"> Dias </option>
                                {renderList}
                                
                            </select>
                              
                        </div>
                    </div>
                    <div className="disponivel ">
                        <div className="estacao-esquerdo flex">
                            <div className="titulo flex">disponivel mesa</div>
                            <div className="contador flex">000</div>
                        </div>
                        <div className="sala-direito flex">
                            <div className="titulo flex">estacao de trabalho</div>
                            <div className="contador flex">000</div>
                        </div>
                    </div>
                </div>
                <div className="btn-agendamento flex">
                    <button className="btn">Agendar</button>
                </div>
            </div>
        </div>
    );
}

export default CardHome;