import './style.css';

export default function Confirmation() {
  return (

    <div className="confirmation">
      <p class="msg">Você selecionou:</p>
      <div className='info'>
        <div className='info1'>
          <p>Dia: </p>
          <p>Unidade:</p>
        </div>
        <div className='info2'>
          <p>Sala:</p>
          <p>Horário</p>
        </div>
      </div>
    </div>
  )
}