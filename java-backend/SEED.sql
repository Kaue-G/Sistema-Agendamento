CREATE TABLE Office(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	capacity INTEGER,
	address VARCHAR(255)
);

CREATE TABLE Employee(
	cpf VARCHAR(255) PRIMARY KEY,
	email VARCHAR(255),
	business_unit VARCHAR(255)
);

CREATE TABLE Room(
	id SERIAL PRIMARY KEY,
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
	id SERIAL PRIMARY KEY,
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
	booking_id INTEGER,
	
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
INSERT INTO Office(name) VALUES ('MATRIZ - São Paulo');
INSERT INTO Office(name) VALUES ('FILIAL - Santos');

SELECT * FROM Office;

-- Salas
INSERT INTO Room(office_id,name,capacity) VALUES 
(1,'Sala 1',4),
(1,'Sala 2',2),
(2,'Sala 35',4),
(2,'Sala 38',1);

SELECT * FROM Room;

-- Funcionários
INSERT INTO Employee(cpf, business_unit, email) VALUES
('111','UX','miguel@gmail.com'),
('222','UX','carlos@gmail.com'),
('333','DEV','ana@gmail.com'),
('444','DEV','julia@gmail.com'),
('555','DEV','bob@gmail.com'),
('666','SCRUM','junior@gmail.com');

SELECT * FROM Employee;

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

SELECT * FROM Disponibility;
SELECT * FROM Booking;
SELECT * FROM Disponibility_Room;