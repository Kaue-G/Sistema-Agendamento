import '../Cancel/style.scss'
import ResultTable from './components/ResultTable';

const History = () => {

    return (
        <div className="cancel-container">
            <div className="header-cancel">
                <h2>Histórico</h2>
                <p>Busque seu histórico de agendamentos da última semana pelo e-mail utilizado na confirmação de sua reserva.</p>
            </div>
            <div className="action-cancel">
                <input type="text" />
                <button className="btn btn-primary btn-lg">Buscar</button>
            </div>
            <ResultTable/>
        </div>      
    )
}

export default History;