import './style.css'

const ResultTable = (reservas) => {
    const renderReservas =  reservas.reserva == 0 ? '' : 
    (reservas.reserva.map ((a) => 
    <tr key = {a.id}>
        <th>{a.id}</th>
        <td>{a.begin === 8 && a.end === 18 ? 'Dia' : 'reuniao'}</td>
        <td>{`${a.begin} - ${a.end}`}</td>
        <td>{a.moment}</td>
        <td>{a.officeName}</td>
    </tr>));

    return <div className="result-container">
         <table className="table table-hover table-sm">
            <thead>
                <tr>
                    <th scope="col">N° do Ticket</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Horário</th>
                    <th scope="col">Dia</th>
                    <th scope="col">Unidade</th>
                </tr>
            </thead>
            <tbody>
                {renderReservas}
            </tbody>
        </table>
    </div>
}

export default ResultTable;