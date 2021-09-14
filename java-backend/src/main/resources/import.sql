-- Escritórios
INSERT INTO Office(address,capacity,name) VALUES ('Rua Bela Cintra, 986 - 2º andar, Consolação, São Paulo - SP',25,'São Paulo');
INSERT INTO Office(address,capacity,name) VALUES ('Praça Dos Expedicionários, 192º andar, Gonzaga, Santos - SP',25,'Santos');

-- Cadeiras
INSERT INTO Room(id,capacity, name, office_id) VALUES (1,4,'Sala 1',1);
INSERT INTO Room(id,capacity, name, office_id) VALUES (2,4,'Sala 2',1);
INSERT INTO Room(id,capacity, name, office_id) VALUES (5,4,'Sala 5',1);
INSERT INTO Room(id,capacity, name, office_id) VALUES (35,4,'Sala 35',2);
INSERT INTO Room(id,capacity, name, office_id) VALUES (34,4,'Sala 34',2);

-- Funcionários
INSERT INTO Employee(cpf, business_unit, email) VALUES ('111','DEV','ana@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('222','DEV','carlos@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('333','SCRUM','miguel@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('444','UX','junior@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('555','UX','vanessa@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('666','DEV','guilherme@gmail.com');

-- Disponibilidades de 13/09 a 17/09
-- Segunda
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',8,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',9,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',10,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',11,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',12,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',13,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',14,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',15,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',16,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',17,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',18,1,true);

-- Terça
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',8,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',9,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',10,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',11,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',12,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',13,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',14,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',15,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',16,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',17,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',18,1,true);

-- Quarta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',8,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',9,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',10,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',11,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',12,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',13,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',14,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',15,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',16,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',17,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',18,1,true);

-- Quinta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',8,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',9,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',10,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',11,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',12,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',13,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',14,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',15,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',16,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',17,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',18,1,true);

-- Sexta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',8,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',9,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',10,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',11,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',12,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',13,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',14,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',15,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',16,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',17,1,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',18,1,true);

-- Segunda do Escritório 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',8,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',9,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',10,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',11,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',12,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',13,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',14,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',15,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',16,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',17,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',18,2,true);

-- Terça - Office 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',8,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',9,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',10,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',11,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',12,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',13,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',14,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',15,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',16,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',17,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',18,2,true);

-- Quarta - Office 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',8,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',9,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',10,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',11,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',12,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',13,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',14,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',15,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',16,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',17,2,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',18,2,true);