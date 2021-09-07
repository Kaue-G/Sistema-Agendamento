import React from 'react';
import '../styles/cardHome.css';

function CardHome () {
    return (
        <div className="container">
            <div className="escritorio-nome flex">Escritorio $Lugar</div>
            <div className="card flex">
                <div className="info">
                    <div className="quantidade">
                        <div className="estacao-esquerdo flex">
                            <div className="titulo flex">estacao de trabalho</div>
                            <div className="contador flex">000</div>
                        </div>
                        <div className="sala-direito flex">
                            <div className="titulo flex">sala de reuniao</div>
                            <div className="contador flex">000</div>
                        </div>
                    </div>
                    <div className="selecionar-data flex">
                        <h3>selecione a data</h3>
                        <div></div>
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
                <div className="btn-agendamento">
                    <h2>Agendar local</h2>
                </div>
            </div>
        </div>
    );
}

export default CardHome;