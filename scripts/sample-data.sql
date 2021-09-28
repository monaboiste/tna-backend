INSERT INTO users (id, username, role, password) VALUES (1, 'ttarasenko678', 'USER', '$2a$10$dpSzo0xON4id.hA2DtjvtOm.2Yu68Fr6CNQjqQmneP58Vqhwx/kpu');
INSERT INTO users (id, username, role, password) VALUES (2, 'mgalczynski699', 'USER', '$2a$12$B9i.1bO/W/vdFRkFayFbmeOx8alU0oW2tMeJQQyng765ZH5Yav.va');
INSERT INTO users (id, username, role, password) VALUES (3, 'mzateus669', 'USER', '$2a$12$4YEytxcYxEWg2SyKnPrUu.BdGo01ldD1DEzfOP/joIQiZeSpO/gWW');
INSERT INTO users (id, username, role, password) VALUES (4, 'wopole699', 'USER', '$2a$12$YeT4sbafH7Bz8U2WHoMkzuRA2my1SNJEJ5b4vpfSAGXsOQlftRQo2');
INSERT INTO users (id, username, role, password) VALUES (5, 'jwilku699', 'USER', '$2a$12$hhxgtd3OMPHp1iK3Sox5IO4WWmyF.W4ogbe189dnPquiaitSZrcta');
INSERT INTO users (id, username, role, password) VALUES (6, 'kpalec654', 'USER', '$2a$12$tbuzIYKeg1Xk.SAvN34ITe.OGlpqXqAlLE99MsY7/wgieslTtPzu.');
INSERT INTO users (id, username, role, password) VALUES (7, 'oyanushkiewic254', 'USER', '$2a$12$2hVVFk.GQtW8NlQtkPOD1.Njq2O.jABARjLcTX/IJ7WLK/PmJHYX2');
INSERT INTO users (id, username, role, password) VALUES (8, 'obaranowsky345', 'USER', '$2a$12$ODH7qQKIuZtgqLmWeY6bZO8tpgKgqQa0L.aTqajtGBJ3cri2dtnIu');
INSERT INTO users (id, username, role, password) VALUES (9, 'akulczyk344', 'USER', '$2a$12$v.1FOuIc/qROBjmsdLl.3e85KhL3KmVQ6up/Ax62Tf3UEHYKciIHm');
INSERT INTO users (id, username, role, password) VALUES (10, 'akowalska432', 'USER', '$2a$12$nOC2KYqijgcfpZcndK94feYvvYNVGUTSWWldW/LOLZOhXCNAW/TLu');
INSERT INTO users (id, username, role, password) VALUES (11, 'bkowalski433', 'USER', '$2a$12$RdgcDBMvnDgdi5rFqbUeXut0Nr9lzaZmIp8ry5/V9aGyk1QYKt9Zu');
INSERT INTO users (id, username, role, password) VALUES (12, 'ttest001', 'ADMIN', '$2a$12$mmRcNVwNax.TELYAcCMThuRas2Vm8kJCOjco4jPH5etcu2cp3H23q');

INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (1, 'Tietiana', 'Tarasenko', 'CV12345678', 'Logistics', 'Gorgondona 12', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (2, 'Mateusz', 'Gałczyński', 'CV12345699', 'Logistics', 'Warszawska 13/a', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (3, 'Mateusz', 'Zateus', 'CV12345669', 'IT', 'Wojska Polskiego 12/9', '86-300', 'Kraków');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (4, 'Wojtek', 'Opole', 'CV22345699', 'IT', 'Święty Wojciech 77', '86-300', 'Głogów');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (5, 'Jacobi', 'Wilku', 'CV23345699', 'IT', 'Mazura i Pazura 43/222a', '86-300', 'Głogów');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (6, 'Katarzyna', 'Palec', 'CV22345654', 'Product Verification', 'Szona Kisielińska 18/300', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (7, 'Olena', 'Yanushkiewic', 'CV22345254', 'Product Verification', 'Szona Kisielińska 18/301', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (8, 'Oleksander', 'Baranowsky', 'CV22312345', 'Product Verification', 'Szona Kisielińska 18/302', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (9, 'Adrianna', 'Kulczyk', 'CV22312344', 'Product Verification', 'Szona Kisielińska 18/303', '12-304', 'Świebodzin');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (10, 'Anna', 'Kowalska', 'CV98765432', 'Product Verification', 'Zbrodniarza 44a/12', '76-660', 'Zielona Góra');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (11, 'Bronisław', 'Kowalski', 'CV98765433', 'Product Verification', 'Zbrodniarza 44a/12', '76-660', 'Zielona Góra');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (12, 'Test', 'Test', 'CV00000001', 'IT', 'Skargi 12', '76-661', 'Zielona Góra');

INSERT INTO shifts (id, date, time_of_day) VALUES (1, (SELECT current_date), 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (2, (SELECT current_date), 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (3, (SELECT current_date), 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (4, (SELECT current_date + 1), 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (5, (SELECT current_date + 1), 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (6, (SELECT current_date + 1), 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (7, (SELECT current_date + 2), 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (8, (SELECT current_date + 2), 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (9, (SELECT current_date + 2), 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (10, (SELECT current_date + 3), 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (11, (SELECT current_date + 3), 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (12, (SELECT current_date + 3), 'NIGHT');

INSERT INTO shifts (id, date, time_of_day) VALUES (13, (SELECT current_date + 4), 'MORNING');
INSERT INTO shifts (id, date, time_of_day) VALUES (14, (SELECT current_date + 4), 'AFTERNOON');
INSERT INTO shifts (id, date, time_of_day) VALUES (15, (SELECT current_date + 4), 'NIGHT');

-- --------------- mon
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '06:00:02'), (select current_date + time '14:00:08'), 1, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '05:58:02'), (select current_date + time '14:00:00'), 2, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '05:59:22'), (select current_date + time '14:10:04'), 3, 1);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '05:59:22'), (select current_date + time '14:10:04'), 10, 1);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '14:00:00'), (select current_date + time '21:58:02'), 12, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '13:57:08'), (select current_date + time '22:00:02'), 4, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '14:00:00'), (select current_date + time '21:58:02'), 5, 2);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '13:48:04'), (select current_date + time '22:59:22'), 6, 2);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '22:00:02'), (select current_date + time '07:57:08'), 5, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '21:58:02'), (select current_date + time '06:00:00'), 6, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '22:59:22'), (select current_date + time '07:48:04'), 7, 3);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + time '23:57:08'), (select current_date + time '06:00:02'), 11, 3);
-- --------------- tue
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '06:00:02'), (select current_date + 1 + time '14:00:08'), 1, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '05:58:02'), (select current_date + 1 + time '14:00:00'), 2, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '06:00:02'), (select current_date + 1 + time '14:00:08'), 8, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '05:58:02'), (select current_date + 1 + time '14:00:00'), 9, 4);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '05:59:22'), (select current_date + 1 + time '14:10:04'), 10, 4);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '14:00:00'), (select current_date + 1 + time '21:58:02'), 12, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '13:57:08'), (select current_date + 1 + time '22:00:02'), 4, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '14:00:00'), (select current_date + 1 + time '21:58:02'), 5, 5);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '13:48:04'), (select current_date + 1 + time '22:59:22'), 6, 5);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '22:00:02'), (select current_date + 1 + time '07:57:08'), 5, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '21:58:02'), (select current_date + 1 + time '06:00:00'), 6, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '22:59:22'), (select current_date + 1 + time '07:48:04'), 7, 6);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 1 + time '23:57:08'), (select current_date + 1 + time '06:00:02'), 11, 6);
-- --------------- wed
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '06:00:02'), (select current_date + 2 + time '14:00:08'), 1, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '05:58:02'), (select current_date + 2 + time '14:00:00'), 2, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '06:00:02'), (select current_date + 2 + time '14:00:08'), 8, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '05:58:02'), (select current_date + 2 + time '14:00:00'), 9, 7);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '05:59:22'), (select current_date + 2 + time '14:10:04'), 10, 7);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '14:00:00'), (select current_date + 2 + time '21:58:02'), 12, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '13:57:08'), (select current_date + 2 + time '22:00:02'), 4, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '14:00:00'), (select current_date + 2 + time '21:58:02'), 5, 8);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '13:48:04'), (select current_date + 2 + time '22:59:22'), 6, 8);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '22:00:02'), (select current_date + 2 + time '07:57:08'), 5, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '21:58:02'), (select current_date + 2 + time '06:00:00'), 6, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '22:59:22'), (select current_date + 2 + time '07:48:04'), 7, 9);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 2 + time '23:57:08'), (select current_date + 2 + time '06:00:02'), 11, 9);
-- --------------- thu
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '05:58:02'), (select current_date + 3 + time '14:00:00'), 2, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '05:59:22'), (select current_date + 3 + time '14:10:04'), 3, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '06:00:02'), (select current_date + 3 + time '14:00:08'), 8, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '05:58:02'), (select current_date + 3 + time '14:00:00'), 9, 10);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '05:59:22'), (select current_date + 3 + time '14:10:04'), 10, 10);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '14:00:00'), (select current_date + 3 + time '21:58:02'), 12, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '13:57:08'), (select current_date + 3 + time '22:00:02'), 4, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '14:00:00'), (select current_date + 3 + time '21:58:02'), 5, 11);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '13:48:04'), (select current_date + 3 + time '22:59:22'), 6, 11);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '22:00:02'), (select current_date + 3 + time '07:57:08'), 5, 12);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '21:58:02'), (select current_date + 3 + time '06:00:00'), 6, 12);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 3 + time '23:57:08'), (select current_date + 3 + time '06:00:02'), 11, 12);
-- --------------- fri
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '06:00:02'), (select current_date + 4 + time '14:00:08'), 1, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '05:59:22'), (select current_date + 4 + time '14:10:04'), 3, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '06:00:02'), (select current_date + 4 + time '14:00:08'), 8, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '05:58:02'), (select current_date + 4 + time '14:00:00'), 9, 13);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '05:59:22'), (select current_date + 4 + time '14:10:04'), 10, 13);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '14:00:00'), (select current_date + 4 + time '21:58:02'), 12, 14);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '13:57:08'), (select current_date + 4 + time '22:00:02'), 4, 14);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '13:48:04'), (select current_date + 4 + time '22:59:22'), 6, 14);

INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '22:00:02'), (select current_date + 4 + time '07:57:08'), 5, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '21:58:02'), (select current_date + 4 + time '06:00:00'), 6, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '22:59:22'), (select current_date + 4 + time '07:48:04'), 7, 15);
INSERT INTO attendance_records (entered_at, left_at, employee_id, shift_id) VALUES ((select current_date + 4 + time '23:57:08'), (select current_date + 4 + time '06:00:02'), 11, 15);

SELECT setval('users_id_seq', (SELECT max(id) FROM users));
SELECT setval('shifts_id_seq', (SELECT max(id) FROM shifts));
SELECT setval('attendance_records_id_seq', (SELECT max(id) FROM attendance_records));
