CREATE TABLE Office(
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255),
                       capacity INTEGER,
                       address VARCHAR(255)
);

CREATE TABLE Employee(
                         cpf VARCHAR(255) PRIMARY KEY,
                         email VARCHAR(255),
                         business_unit VARCHAR(255),

                         CONSTRAINT UN_email UNIQUE (email)
);

CREATE TABLE Room(
                     id INTEGER PRIMARY KEY,
                     type INTEGER,
                     name VARCHAR(255),
                     capacity INTEGER,

                     office_id INTEGER,


                     CONSTRAINT FK_office FOREIGN KEY (office_id) REFERENCES Office(id)
);

CREATE TABLE Disponibility(
                              date_pk DATE,
                              hour_pk INTEGER,
                              office_pk INTEGER,
                              is_available BOOLEAN,

                              PRIMARY KEY(date_pk, hour_pk, office_pk),
                              CONSTRAINT FK_office FOREIGN KEY (office_pk) REFERENCES Office(id)
);

CREATE TABLE Booking(
                        id VARCHAR(255) PRIMARY KEY,
                        room INTEGER,
                        begin_time INTEGER,
                        end_time INTEGER,
                        employee_id VARCHAR(255),
                        moment DATE,
                        weight INTEGER,

                        CONSTRAINT FK_employee FOREIGN KEY (employee_id) REFERENCES Employee(cpf),
                        CONSTRAINT UN_employee_moment UNIQUE (employee_id,moment)
);

CREATE TABLE Disponibility_Booking(
                                      hour_id INTEGER,
                                      office_id INTEGER,
                                      moment_id DATE,
                                      booking_id VARCHAR(255),

                                      PRIMARY KEY(hour_id, office_id, moment_id, booking_id),

                                      CONSTRAINT FK_disponibility FOREIGN KEY (moment_id, hour_id, office_id) REFERENCES Disponibility,
                                      CONSTRAINT Fk_booking FOREIGN KEY (booking_id) REFERENCES Booking
);

CREATE TABLE Disponibility_Room(
                                   hour_pk INTEGER,
                                   office_pk INTEGER,
                                   date_pk DATE,
                                   room_pk INTEGER,

                                   capacity INTEGER,

                                   PRIMARY KEY(hour_pk, office_pk, date_pk, room_pk)
);

-- Escritórios
INSERT INTO Office(address,capacity,name) VALUES ('Rua Bela Cintra, 986 - 2º andar, Consolação, São Paulo - SP',25,'São Paulo');
INSERT INTO Office(address,capacity,name) VALUES ('Praça Dos Expedicionários, 192º andar, Gonzaga, Santos - SP',25,'Santos');

SELECT * FROM Office;

-- Cadeiras
INSERT INTO Room(id,capacity, name, office_id) VALUES (1,4,'Sala 1',3);
INSERT INTO Room(id,capacity, name, office_id) VALUES (2,4,'Sala 2',3);
INSERT INTO Room(id,capacity, name, office_id) VALUES (5,4,'Sala 5',3);
INSERT INTO Room(id,capacity, name, office_id) VALUES (35,4,'Sala 35',4);
INSERT INTO Room(id,capacity, name, office_id) VALUES (34,4,'Sala 34',4);

-- Funcionários
INSERT INTO Employee(cpf, business_unit, email) VALUES ('111','DEV','ana@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('222','DEV','carlos@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('333','SCRUM','miguel@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('444','UX','junior@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('555','UX','vanessa@gmail.com');
INSERT INTO Employee(cpf, business_unit, email) VALUES ('666','DEV','guilherme@gmail.com');

-- Disponibilidades de 13/09 a 17/09
-- Segunda
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',8,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',9,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',10,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',11,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',12,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',13,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',14,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',15,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',16,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',17,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',18,3,true);

-- Terça
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',8,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',9,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',10,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',11,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',12,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',13,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',14,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',15,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',16,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',17,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',18,3,true);

-- Quarta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',8,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',9,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',10,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',11,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',12,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',13,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',14,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',15,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',16,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',17,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',18,3,true);

-- Quinta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',8,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',9,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',10,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',11,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',12,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',13,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',14,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',15,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',16,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',17,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-16',18,3,true);

-- Sexta
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',8,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',9,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',10,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',11,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',12,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',13,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',14,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',15,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',16,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',17,3,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-17',18,3,true);

-- Segunda do Escritório 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',8,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',9,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',10,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',11,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',12,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',13,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',14,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',15,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',16,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',17,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-13',18,4,true);


-- Terça - Office 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',8,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',9,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',10,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',11,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',12,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',13,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',14,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',15,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',16,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',17,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-14',18,4,true);


-- Quarta - Office 2
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',8,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',9,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',10,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',11,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',12,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',13,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',14,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',15,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',16,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',17,4,true);
INSERT INTO Disponibility(date_pk, hour_pk, office_pk, is_available) VALUES ('2021-09-15',18,4,true);