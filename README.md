# SISTEMA DE AGENDAMENTO

Desafio proposto no Hackathon do Programa de Formação da empresa FCamara.

#### Problemática

Com a pandemia da Covid-19 o trabalho remoto foi necessário.
Porém com a vacinação em andamento, planeja-se fazer a reabertura dos escritórios 
seguindo a legislação vigente quanto ao números de pessoas máximas, evitando aglomeração além dos protocolos de segurança.

O objetivo do sistema de agendamento é permitir ao colaborador da empresa, o agendamento prévio do dia de trabalho ou de uma reunião em um dos escritórios.

### Regras de negócio

Há dois tipos de agendamentos: 
* Por dia
> Representa um dia inteiro de trabalho, tal que o sistema se inscreve em todos os horários disponíveis do dia e atribui ao agendamento o peso 1.
* Por Hora
> Representa o agendamento de uma reunião. Nesse caso, é importante informar a sala, início e término da estadia no escritório. Caso o peso do agendamento não seja informado, o sistema entenderá como 1.

### Fluxo do usuário

- Acessa o sistema
- Escolhe o escritório (São Paulo ou Santos)
- Verifica a disponibilidade
- Faz o agendamento
- Recebe o ticket com número da reserva.
- Pode consultar o histórico de agendamento por email
- Pode cancelar a reserva com o número do Ticket


###  REST API - BACKEND

Uma API de gerenciamento de lotação desenvolvida durante o Hackathon do grupo FCamara.

### Funcionamento
O sistema funciona através de um escritório que disponibiliza horários para receberem inscrições de agendamentos realizados por usuários e salas selecionadas. Um agendamento pode ou não conter uma sala e possui um 'peso' que indica a quantidade de pessoas. Por exemplo: um agendamento único tem peso 1 (para uma pessoa apenas) e um agendamento de reunião possui um peso x que representa a quantidade de pessoas que irão na reunião. Dessa forma, o sistema consegue organizar quantas pessoas estarão no escritório nas disponibilidades de horários que o agendamento se inscreveu. O controle de lotação das salas funciona da mesma maneira: a sala selecionada se inscreve nas disponibilidades, mas dessa vez, o sistema usa essas inscrições para quantificar a lotação e validar se o valor está dentro da capacidade.

![](https://github.com/Lourene-MCSchueler/Sistema-Agendamento/blob/main/java-backend/build/EsquemaAPI.jpg)

> Na imagem acima há o comportamento de 5 agendamentos. Dentre eles, o AG5 e o AG1 escolheram a sala S1.  Portando, o peso dos agendamentos se somam para verificar a lotação na faixa de horários selecionada.

> Dependendo do intervalo de horários selecionado, a informação é diferente.

Com isso dito, o ato de agendamento pode ser validado em vários critérios. Dentre eles:
* Uma pessoa só consegue fazer um agendamento por dia.
* O usuário que realiza o agendamento precisa existir no banco de dados da empresa.
* A sala precisa existir no banco de dados da empresa.
* A data e a disponibilidade precisam existir no banco de dados da empresa.
* A sala escolhida não pode estar lotada no intervalo de horários selecionado.
* Novos agendamentos só são possíveis se dado o intervalo de horários não há lotação que exceda a capacidade permitida. 
* Novos agendamentos com sala só são possíveis se a capacidade da sala não for excedida no intervalo de horários selecionado.

### Endpoints
* **/offices**
> Deve retornar informações do escritório e disponibilidades dos dias.

* **/offices/{id}/chairs**
> Deve retornar uma página com as salas de um escritório dada uma data específica. Também pode filtrar por intervalos de horários.

* **/offices/{id}/disps**
> Deve retornar as disponibilidades de horário em uma data específica. Contém a quantidade de pessoas presentes em cada hora das 8h as 18h. Também filtra só as disponibilidades livres.

* **/offices/{id}**
> Deve retornar informações de estado do escritório através de uma certa data e/ou intervalo de horários.

* **/offices/bookings**
> Retorna as reservas de um usuário dado o email

### Instalação

## BACKEND
É possível rodar a aplicação para testes utilizando Docker. Mas caso essa não seja uma opção, o jar está disponibilizado. 
>Run com *jar*, utilizando o banco H2 e consumindo a seed de testes

Baixe o projeto, e na pasta **java-backend** abra o terminal e digite 
```
$ java -jar ./build/DEMO-FC-0.0.1-SNAPSHOT.jar
```
>Montando imagem Docker

Baixe o projeto e acesse a pasta **java-backend**
No terminal, utilize o comando para montar a imagem Docker
```
$ docker build -t fcam-squad12:v1 .
```
Rodar container na porta 8081 com o banco H2 e seed de dados para testes
```
$ docker run -p 8081:8081 --name squad12-fcam fcam-squad12:v1
```
Rodar container utilizando um banco de dados postgress
```
$ docker run -p 8081:8081 --name squad12-fcam -e PROFILE=dev -e DB_URL= -e DB_USERNAME= -e DB_PASSWORD= fcam-squad12:v1
```
Variáveis de ambiente
1. **-e PROFILE**
_Perfil da aplicação, **dev** para usar Postgress e **test** para usar H2_
2. **-e DB_URL**
_jdbc:postgresql://{{host}}:{{port}}/{{database}}_
3. **-e DB_USERNAME**
4. **-e DB_PASSWORD**
5. **-e CAPACITY_RULE**
_Regra de capacidade restrita. Default = 40%_
6. **-e BEGIN**
_Abertura dos escritórios. Default = 8_
7. **-e END**
_Fechamento dos escritórios. Default = 18_

Parar container Docker
```
$ docker stop squad12-fcam
```
Excluir container
```
$ docker rm squad12-fcam
```
Excluir imagem
```
$ docker rmi fcam-squad12:v1
```
## FRONTEND

Clonar o projeto

```
git clone https://github.com/Lourene-MCSchueler/Sistema-Agendamento/tree/main/react-frontend
```

Instalar os pacotes com npm

```
$ npm install 
```
Executar a aplicação localmente

```
$ npm start
```

### Utilitários
Corpo de requisição (POST) simplificado para agendamento de um dia inteiro
~~~json
{
  "employee_id": "EMAIL",
  "moment": "DATA",
  "type": 1
}
~~~
Corpo de requisição (POST) simplificado para agendamento de uma sala e um determinado horário
~~~json
{
  "begin": 8,
  "chair": 2,
  "employee_id": "EMAIL",
  "end": 18,
  "moment": "DATA",
  "type": 0
}
~~~
> A API está disponível no Heroku

[![](https://img.shields.io/badge/FCBooking-SNAPSHOT-9370DB?logo=heroku&labelColor=9370DB&color=gray&style=for-the-badge)](http://fcam-booking.herokuapp.com/swagger-ui.html#/)

🚀[Postman](https://github.com/Lourene-MCSchueler/Sistema-Agendamento/blob/main/java-backend/build/FC-Postman.json), [Docs](https://github.com/Lourene-MCSchueler/Sistema-Agendamento/tree/main/java-backend/build)


## Tecnologias

- React
- Postgres
- Java
- Ecossistema Spring

## Projeto

[Clique neste link](http://xxxx/)

## Membros

- [Kauê Guede ](https://github.com/Kaue-G) 
- [Lourene Schueler](https://github.com/Lourene-MCSchueler)
- [Pedro Pereira ](https://github.com/NihwlCat)



