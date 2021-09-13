import './style.css';

export default function Email() {
  return (
    <>
      <div className="email">
        <div className='email-txt'>
          <p className="message">Está quase lá</p>
          <p className="message">Agora só falta colocar o seu e-mail para confirmarmos o seu agendamento!</p>
        </div>
        <div className='email-input'>
          <label for="email">Email:</label>
          <input type="text" name="email" />
        </div>
      </div>
    </>
  )
}