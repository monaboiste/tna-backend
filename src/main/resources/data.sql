INSERT INTO users (id, username, role, password) VALUES (1, 'ttarasenko678', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (2, 'mgala699', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (3, 'mzateus669', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (4, 'wdsw699', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (5, 'jwilku699', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (6, 'vyalanska654', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (7, 'oyanushkiewic254', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (8, 'obaranowsky345', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (9, 'oomelchenko344', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (10, 'akowalska432', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (11, 'bkowalski433', 'USER', 'test');
INSERT INTO users (id, username, role, password) VALUES (12, 'msumna669', 'USER', 'test');

INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (1, 'Tietiana', 'Tarasenko', 'CV12345678', 'Logistics', 'Gorgondona 12', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (2, 'Mateo', 'Gała', 'CV12345699', 'Logistics', 'Pogromcy Smoków i Dziewic 13/a', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (3, 'Mafetke', 'Zateus', 'CV12345669', 'IT', 'Wojska Polskiego 12/9', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (4, 'Wojtek', 'Dsw', 'CV22345699', 'IT', 'Święty Wojciech 77', '86-300', 'Głogów');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (5, 'Jacobi', 'Wilku', 'CV23345699', 'IT', 'Mazura i Pazura 43/222a', '86-300', 'Głogów');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (6, 'Valdena', 'Yalanska', 'CV22345654', 'Product Verification', 'Szona Kisielińska 18/300', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (7, 'Olena', 'Yanushkiewic', 'CV22345254', 'Product Verification', 'Szona Kisielińska 18/301', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (8, 'Oleksander', 'Baranowsky', 'CV22312345', 'Product Verification', 'Szona Kisielińska 18/302', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (9, 'Oleksander', 'Omelchenko', 'CV22312344', 'Product Verification', 'Szona Kisielińska 18/303', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (10, 'Anna', 'Kowalska', 'CV98765432', 'Product Verification', 'Zbrodniarza Radzieckiego 44a/12', '76-660', 'Zielona Góra');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (11, 'Bronisław', 'Kowalski', 'CV98765433', 'Product Verification', 'Zbrodniarza Radzieckiego 44a/12', '76-660', 'Zielona Góra');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (12, 'Monka', 'Sumna', 'CV98765669', 'IT', 'Skargi 12', '76-661', 'Zielona Góra');

INSERT INTO shifts (id, date, time_of_day) VALUES (1, '2021-06-04', 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (2, '2021-06-04', 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (3, '2021-06-04', 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (4, '2021-06-05', 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (5, '2021-06-05', 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (6, '2021-06-05', 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (7, '2021-06-06', 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (8, '2021-06-06', 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (9, '2021-06-06', 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (10, '2021-06-07', 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (11, '2021-06-07', 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (12, '2021-06-07', 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (13, '2021-06-08', 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (14, '2021-06-08', 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (15, '2021-06-08', 'NIGHT');

-- --------------- mon
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 06:00:02', '2021-06-03 14:00:08', 1, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 05:58:02', '2021-06-03 14:00:00', 2, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 05:59:22', '2021-06-03 14:10:04', 3, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 05:59:22', '2021-06-03 14:10:04', 10, 1);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 14:00:00', '2021-06-03 21:58:02', 12, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 13:57:08', '2021-06-03 22:00:02', 4, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 14:00:00', '2021-06-03 21:58:02', 5, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 13:48:04', '2021-06-03 22:59:22', 6, 2);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 22:00:02', '2021-06-04 07:57:08', 5, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 21:58:02', '2021-06-04 06:00:00', 6, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 22:59:22', '2021-06-04 07:48:04', 7, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-03 23:57:08', '2021-06-04 06:00:02', 11, 3);
-- --------------- tue
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 06:00:02', '2021-06-04 14:00:08', 1, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 05:58:02', '2021-06-04 14:00:00', 2, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 06:00:02', '2021-06-04 14:00:08', 8, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 05:58:02', '2021-06-04 14:00:00', 9, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 05:59:22', '2021-06-04 14:10:04', 10, 4);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 14:00:00', '2021-06-04 21:58:02', 12, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 13:57:08', '2021-06-04 22:00:02', 4, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 14:00:00', '2021-06-04 21:58:02', 5, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 13:48:04', '2021-06-04 22:59:22', 6, 5);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 22:00:02', '2021-06-05 07:57:08', 5, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 21:58:02', '2021-06-05 06:00:00', 6, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 22:59:22', '2021-06-05 07:48:04', 7, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-04 23:57:08', '2021-06-05 06:00:02', 11, 6);
-- --------------- wed
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 06:00:02', '2021-06-05 14:00:08', 1, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 05:58:02', '2021-06-05 14:00:00', 2, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 06:00:02', '2021-06-05 14:00:08', 8, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 05:58:02', '2021-06-05 14:00:00', 9, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 05:59:22', '2021-06-05 14:10:04', 10, 7);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 14:00:00', '2021-06-05 21:58:02', 12, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 13:57:08', '2021-06-05 22:00:02', 4, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 14:00:00', '2021-06-05 21:58:02', 5, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 13:48:04', '2021-06-05 22:59:22', 6, 8);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 22:00:02', '2021-06-06 07:57:08', 5, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 21:58:02', '2021-06-06 06:00:00', 6, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 22:59:22', '2021-06-06 07:48:04', 7, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-05 23:57:08', '2021-06-06 06:00:02', 11, 9);
-- --------------- thu
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 05:58:02', '2021-06-06 14:00:00', 2, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 05:59:22', '2021-06-06 14:10:04', 3, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 06:00:02', '2021-06-06 14:00:08', 8, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 05:58:02', '2021-06-06 14:00:00', 9, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 05:59:22', '2021-06-06 14:10:04', 10, 10);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 14:00:00', '2021-06-06 21:58:02', 12, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 13:57:08', '2021-06-06 22:00:02', 4, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 14:00:00', '2021-06-06 21:58:02', 5, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 13:48:04', '2021-06-06 22:59:22', 6, 11);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 22:00:02', '2021-06-07 07:57:08', 5, 12);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 21:58:02', '2021-06-07 06:00:00', 6, 12);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-06 23:57:08', '2021-06-07 06:00:02', 11, 12);
-- --------------- fri
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 06:00:02', '2021-06-07 14:00:08', 1, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 05:59:22', '2021-06-07 14:10:04', 3, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 06:00:02', '2021-06-07 14:00:08', 8, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 05:58:02', '2021-06-07 14:00:00', 9, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 05:59:22', '2021-06-07 14:10:04', 10, 13);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 14:00:00', '2021-06-07 21:58:02', 12, 14);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 13:57:08', '2021-06-07 22:00:02', 4, 14);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 13:48:04', '2021-06-07 22:59:22', 6, 14);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 22:00:02', '2021-06-08 07:57:08', 5, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 21:58:02', '2021-06-08 06:00:00', 6, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 22:59:22', '2021-06-08 07:48:04', 7, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ('2021-06-07 23:57:08', '2021-06-08 06:00:02', 11, 15);
