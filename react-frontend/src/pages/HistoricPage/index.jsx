import './style.css'
import DefaultPage from '../../components/DefaultPage';
import ResultTable from '../../components/ResultTable';

export default function HistoricPage() {

  return (
    <DefaultPage>
      <div className="messageHP">
        <h1>Histórico</h1>
        <p>Busque seu histórico de agendamentos da última semana pelo e-mail utilizado na confirmação de sua reserva.</p>
      </div>
      <div className="inputHP">
        <label for="email"></label>
        <input type="text" placeholder="Insira aqui seu e-mail" name="email" />
        <button type="button">Buscar</button>
      </div>
      <ResultTable />
    </DefaultPage>
  )
}
