INSERT INTO Office(name) VALUES ('MATRIZ - Rua Bela Cintra, 986 - 2º andar, Consolação, São Paulo - SP'), ('FILIAL - Praça Dos Expedicionários, 192º andar, Gonzaga, Santos - SP');
INSERT INTO Chair(local, is_available,office_id) VALUES ('Sala 3',true,1),('Sala 2',true,1),('Sala de reuniões 3',true,1),('Área de alimentação',true,1);
INSERT INTO Employee(cpf, business_unit, email) VALUES ('123','UX','ana@gmail.com'), ('456','DEV','douglas@gmail.com'), ('786','SCRUM','carlos@gmail.com'), ('TESTE','DEV','miguel@gmail.com'), ('TESTE2','DEV','joao@gmail.com');

INSERT INTO Disponibility(moment_pk, begin_pk, office_id, is_available) VALUES ('2020-07-21', 8, 1, true), ('2020-07-21', 9, 1, false), ('2020-07-21', 10, 1, true), ('2020-07-21', 11, 1, true), ('2020-07-21', 12, 1, true), ('2020-07-21', 13, 1, true);

INSERT INTO Booking(chair_id, moment, begin, end, employee_id) VALUES (1,'2021-07-21', 8, 10, '123'), (1,'2021-07-21', 8, 12, '456'), (1,'2021-07-21', 11, 13, '786'); --(1,'2021-07-21', 11, 13, '123');

INSERT INTO Disponibility(moment_pk, begin_pk, office_id, is_available) VALUES ('2020-07-21',16,2,true)
INSERT INTO Disponibility(moment_pk, begin_pk, office_id, is_available) VALUES ('2020-07-22',9,1,false)
INSERT INTO Disponibility(moment_pk, begin_pk, office_id, is_available) VALUES ('2020-07-22',10,1,false)

INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',8,1);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',9,1);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',10,1);

INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',8,2);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',9,2);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',10,2);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',11,2);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',12,2);

INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',11,3);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',12,3);
INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',13,3);

-- INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',11,4);
-- INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',12,4);
-- INSERT INTO tb_disp_booking(moment_id, begin_id, booking_id) VALUES ('2020-07-21',13,4);