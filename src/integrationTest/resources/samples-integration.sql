INSERT INTO users(id, username, password, role) VALUES (1, 'test1', 'test1', 'USER');
INSERT INTO users(id, username, password, role) VALUES (2, 'test2', 'test2', 'USER');
INSERT INTO users(id, username, password, role) VALUES (3, 'test3', 'test3', 'USER');

INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (4, 'test4', 'test4', 'CV000004', 'Logistics', 'Test 4', '00-004', 'Test4');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (5, 'test5', 'test5', 'CV000005', 'Logistics', 'Test 5', '00-005', 'Test5');
INSERT INTO employees(user_id, firstname, lastname, contract_id, department, street, post_code, city)
VALUES (6, 'test6', 'test6', 'CV000006', 'Logistics', 'Test 6', '00-006', 'Test6');

