import './style.scss'

const Cancel = () => {

    return (
        <div className="cancel-container">
            <div className="header-cancel">
                <h2>Cancelar ticket de agendamento</h2>
                <p>Para cancelar uma reserva já realizada, por favor insira o número do ticket correspondente à esse agendamento no espaço abaixo.</p>
            </div>
            <div className="action-cancel">
                <input type="text" />
                <button className="btn btn-primary btn-lg">Cancelar ticket</button>
            </div>
        </div>      
    )
}

export default Cancel;