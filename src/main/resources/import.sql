-- Escritórios
INSERT INTO Office(name) VALUES ('MATRIZ - Rua Bela Cintra, 986 - 2º andar, Consolação, São Paulo - SP');
INSERT INTO Office(name) VALUES ('FILIAL - Praça Dos Expedicionários, 192º andar, Gonzaga, Santos - SP');

-- Cadeiras
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 3, piso 1',true,1);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 2, piso 1',true,1);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 7, piso 2',true,1);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala de reunião',true,1);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Área de alimentação',true,1);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 31, piso 4',true,2);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 5, piso 4',true,2);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 14, piso 3',true,2);
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 2, piso 3',true,2);

-- Funcionários

INSERT INTO Employee(cpf, business_unit, email) VALUES ('123','DEV','ana@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('456','DEV','carlos@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('789','SCRUM','miguel@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('222','UX','junior@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('333','UX','vanessa@gmail.com');

-- Horários livres (06/09/2021 - 11/09/2021)

-- Segunda
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-06',18,1,true);

-- Terça
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-07',18,1,true);

-- Quarta
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',18,1,true);

-- Quinta
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-09',18,1,true);

-- Sexta
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-10',18,1,true);

-- Sábado
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',8,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',9,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',10,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',11,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',12,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',13,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',14,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',15,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',16,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',17,1,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-11',18,1,true);

-- Office 2 na quarta

INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',8,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',9,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',10,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',11,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',12,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',13,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',14,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',15,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',16,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',17,2,true);
INSERT INTO Disponibility(moment_pk, begin_pk, office_pk, is_available) VALUES ('2021-09-08',18,2,true);

-- Booking - Terça feira
INSERT INTO Booking(chair_id, moment, begin, end, employee_id) VALUES (3,'2021-09-07', 8, 12, '123');


-- Disp X Booking
INSERT INTO TB_DISP_BOOKING(begin_id, moment_id, office_id, booking_id) VALUES (8,'2021-09-07',1,1);
INSERT INTO TB_DISP_BOOKING(begin_id, moment_id, office_id, booking_id) VALUES (9,'2021-09-07',1,1);
INSERT INTO TB_DISP_BOOKING(begin_id, moment_id, office_id, booking_id) VALUES (10,'2021-09-07',1,1);
INSERT INTO TB_DISP_BOOKING(begin_id, moment_id, office_id, booking_id) VALUES (11,'2021-09-07',1,1);
INSERT INTO TB_DISP_BOOKING(begin_id, moment_id, office_id, booking_id) VALUES (12,'2021-09-07',1,1);