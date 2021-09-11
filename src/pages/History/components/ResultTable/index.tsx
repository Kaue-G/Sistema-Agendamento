import { Booking } from 'core/utils/Types';
import './style.scss'

type Props = {
    bookings: Booking[];
}

const ResultTable = ({bookings} : Props) => {
    return <div className="result-container">
        <table className="table table-hover table-sm table-borderless">
            <thead>
                <tr>
                    <th scope="col">N° do Ticket</th>
                    <th scope="col">Tipo de agendamento</th>
                    <th scope="col">Horário</th>
                    <th scope="col">Data</th>
                    <th scope="col">Unidade</th>
                </tr>
            </thead>
            <tbody>
                {bookings.map(b => (
                    <tr key={b.id}>
                        <th scope="row">{b.id}</th>
                        <td>{b.begin === 8 && b.end === 18 ? 'Dia inteiro':'Reunião'}</td>
                        <td>{`${b.begin}h - ${b.end}h`}</td>
                        <td>{b.moment}</td>
                        <td>{b.officeName}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
}

export default ResultTable;