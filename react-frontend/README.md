# SISTEMA DE AGENDAMENTO

Desafio proposto no Hackathon do Programa de Formação da empresa FCamara.

#### Problemática
Com a pandemia da Covid-19 o trabalho remoto foi necessário.
Porém com a vacinação em andamento, planeja-se fazer a reabertura dos escritórios seguindo a legislação vigente quanto ao números de pessoas máximas, evitando aglomeração além dos protocolos de segurança.

O objetivo do sistema de agendamento é permitir ao colaborador da empresa, o agendamento prévio do dia de trabalho ou de uma reunião em um dos escritórios.

### Regras do negócio

- Uma pessoa só consegue fazer um agendamento por dia e ela deve existir no banco de dados da empresa.
- O agendamento da sala reunião tem um peso "X" que equivale a quantidade de pessoas.
- O agendamento do dia de trabalho tem peso 1.
(O objetivo dos pesos é garantir a quantidade de pessoas máximas no escritório mesmo que estejam na sala de reunião.)

### Fluxo do usuário

- Acessa o sistema
- Escolhe o escritório (São Paulo ou Santos)
- Verifica a disponibilidade
- Faz o agendamento
- Recebe o ticket com número da reserva.
- Pode consultar o histórico de agendamento por email
- Pode cancelar a reserva com o número do Ticket

### Funcionalidades futuras

- Integração com banco de dados da empresa
- Automatização das datas disponíveis para agendamento
- Serviço de envio do ticket de confirmação por e-mail.


## Tecnologias

- [Express](https://expressjs.com/pt-br/)
- [Ejs](https://ejs.co/)
- [HTML5](https://developer.mozilla.org/pt-BR/docs/Web/HTML)
- [CSS3](https://developer.mozilla.org/pt-BR/docs/Web/CSS)
- [MySQL](https://www.mysql.com/)
- [Sequelize ORM](https://sequelize.org/master/)

## Como utilizar

### Pré Requisito

Para usar este repositório, você precisa instalar:

NodeJS
NPM
MySQL
Sequelize ORM

### Ambiente de desenvolvimento

Clonar o projeto

```
git clone https://github.com/Lourene-MCSchueler/ProjetoIntegrador
```

Instalar os pacotes com npm

```
$ npm install 
```
Executar a aplicação localmente

```
$ npm start
```
## Projeto

[Clique neste link](http://moovebike.app.br/)

## Membros

- [Kauê Guede ](https://github.com/Kaue-G) 
- [Lourene Schueler](https://github.com/Lourene-MCSchueler)
- [Pedro Pereira ](https://github.com/NihwlCat)

## Captura da página inicial




