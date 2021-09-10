import './style.css';
// import { Link } from 'react-router-dom';
import { getOffices } from '../../services/offices';

function Disponibility() {

  const offices = getOffices();

  return (
    <>
      {offices.map((office) => {
        return (
          <div className="dispon">
            <h1>{office.name}</h1>
            <div className="dispon-boxes">
              <div className="msg">
                <p>Lotação máxima: 240 pessoas </p>
              </div>
              <div className="boxes">
                <div className="box-left">

                  <div className="boxL1">
                    <p>Estações de trabalho</p>
                  </div>

                  <div className="boxL2">
                    <div className="date">
                      <form action="/#">
                        <label for="date">Escolha uma data:</label>
                        <select id="date" name="date">
                          <option value=""></option>
                          <option value="13/09/2021">13/09/2021 - Segunda</option>
                          <option value="14/09/2021">14/09/2021 - Terça</option>
                          <option value="15/09/2021">15/09/2021 - Quarta</option>
                          <option value="16/09/2021">16/09/2021 - Quinta</option>
                          <option value="17/09/2021">17/09/2021 - Sexta</option>
                        </select>
                      </form>
                    </div>
                  </div>

                  <div className="boxL3">
                    <p>Disponíveis: <strong>{office.chairs}</strong> </p>
                    <button type="submit">Agendar</button>
                  </div>
                </div>

                <div className="box-right">
                  <div className="boxR1">
                    <p>Salas de reunião</p>
                  </div>

                  <div className="boxR2">
                    <div className="date">
                      <form action="/#">
                        <label for="date">Escolha uma data:</label>
                        <select id="date" name="date">
                          <option value=""></option>
                          <option value="13/09/2021">13/09/2021 - Segunda</option>
                          <option value="14/09/2021">14/09/2021 - Terça</option>
                          <option value="15/09/2021">15/09/2021 - Quarta</option>
                          <option value="16/09/2021">16/09/2021 - Quinta</option>
                          <option value="17/09/2021">17/09/2021 - Sexta</option>
                        </select>
                      </form>


                    </div>
                    <div className="time">
                      <form action="/#">
                        <label for="time">Hora inicial</label>
                        <select id="time" name="time">
                          <option value=""></option>
                          <option value="8">08:00</option>
                          <option value="9">09:00</option>
                          <option value="10">10:00</option>
                          <option value="11">11:00</option>
                          <option value="12">12:00</option>
                          <option value="13">13:00</option>
                          <option value="14">14:00</option>
                          <option value="15">15:00</option>
                          <option value="16">16:00</option>
                          <option value="17">17:00</option>
                          <option value="18">18:00</option>
                        </select>
                      </form>
                      <form action="/#">
                        <label for="time">Hora final</label>
                        <select id="time" name="time">
                          <option value=""></option>
                          <option value="8">08:00</option>
                          <option value="9">09:00</option>
                          <option value="10">10:00</option>
                          <option value="11">11:00</option>
                          <option value="12">12:00</option>
                          <option value="13">13:00</option>
                          <option value="14">14:00</option>
                          <option value="15">15:00</option>
                          <option value="16">16:00</option>
                          <option value="17">17:00</option>
                          <option value="18">18:00</option>
                        </select>
                      </form>

                    </div>

                  </div>

                  <div className="boxR3">
                    <p>Disponíveis: <strong>{office.meetRoom}</strong></p>
                    <button>Agendar sala de reunião</button>
                  </div>

                </div>
              </div>
            </div>
            <p className="address">{office.address}</p>
            <p className="compl">{office.compl}</p>
          </div>
        )
      })}


    </>
  )
}

export default Disponibility;