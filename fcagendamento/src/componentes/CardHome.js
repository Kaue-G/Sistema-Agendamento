import React from 'react';
import '../styles/cardHome.css';

function CardHome () {
    return (
        <div className="container">
            <div className="escritorio-nome">Escritorio $Lugar</div>
            <div className="card">
                <div className="info">
                    <div className="quantidade">
                        <div className="estacao-trabalho"></div>
                        <div className="sala-reuniao"></div>
                    </div>
                    <div className="selecionar-data">
                        <h3>selecione a data</h3>
                        <div></div>
                    </div>
                    <div>
                        <div className="disponivel"></div>
                        <div className="disponivel"></div>
                    </div>
                </div>
                <div className="btn-agendamento">
                    <h2>Agendar local</h2>
                </div>
            </div>
        </div>
    );
}

export default CardHome;