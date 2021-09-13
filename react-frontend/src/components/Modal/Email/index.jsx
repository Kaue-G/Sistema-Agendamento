import './style.css';

export default function Email() {
  return (
    <>
      <div className="email">
        <div className='email-txt'>
          <p className="message1">Quase lá</p>
          <p className="message2">Agora só falta colocar o seu e-mail para confirmarmos o seu agendamento!</p>
        </div>
        <div className='email-input'>
          <label for="email">E-mail:</label><br />
          <input type="text" name="email" />
        </div>
      </div>
    </>
  )
}