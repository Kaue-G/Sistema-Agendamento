import React from 'react';
import '../styles/cardHome.css';

function CardHome () {
const monthNames = ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'];
const weekNames = ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'];

// const date = new Date();
console.log(monthNames);

// const dayWeek = date.getDay();
// const day = date.getDate();
// const year = date.getFullYear();
// const month = date.getMonth();
// const nameMonth = monthNames[month];
// const week = weekNames[dayWeek];

// const first = date.getDate() - date.getDay();

// function getWeeks() {
//     const arrayWeeks = [];

//     for (let i = 0; i < 7; i++) {
//         let next = new Date(date.getTime());
//         next.setDate(first + i);

//         const nameWeek = weekNames[next.getDay()];
//         arrayWeeks.push(nameWeek);
//     }
//     return arrayWeeks;
// }

// function getNumber() {
//     const numbersWeek = [];

//     for (let i = 0; i < 7; i++) {
//         let next = new Date(date.getTime());
        
//         next.setDate(first + i);

//         const numberWeek = next.getDate();

//         numbersWeek.push(numberWeek);
//     }

//     return numbersWeek;
// }

// const weekDays = getWeeks();
// const numberDays = getNumber();

// document.querySelector(".title").innerText = nameMonth;
// document.querySelector(".subititle").innerText = year;

// // weekDays.map((date) => ('
// //     <li class="list-item">
// //       <span>{date}</span>
// //     </li>'
// // ));

// function postHtml(info) {
//     let printhtml = '';

//     for (let i = 0; i < 7; i++){
//         let post = info[i];
//         let active = day === info[i] ? 'active' : '';

//         let html = '<li class="list-item '+active+'">'+
//         '<span>'+info[i]+'</span>'+
//         '</li>';
    
//         printhtml += html;
//     }
//     return printhtml;
// }

// document.querySelector("#nameDias").innerHTML = postHtml(weekDays);
// document.querySelector("#dataDias").innerHTML = postHtml(numberDays);


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
                        <h3 className="titulo flex">selecione a data</h3>
                        <div className="seletor flex">
                            
                            <select className="btn" name="cars" id="cars">
                                <option value="volvo">XX/XX/XXX</option>
                                <option value="saab">11/11/1111</option>
                                <option value="opel">22/22/2222</option>
                                <option value="audi">33/33/3333</option>
                            </select>
                              
                        </div>
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
                <div className="btn-agendamento flex">
                    <button className="btn">Agendar</button>
                </div>
            </div>
        </div>
    );
}

export default CardHome;