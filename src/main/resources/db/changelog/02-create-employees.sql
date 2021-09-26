--liquibase formatted sql
--changeset monaboiste:2

CREATE TABLE EMPLOYEES (
                           user_id BIGINT NOT NULL,
                           firstname VARCHAR(128) NOT NULL,
                           lastname VARCHAR(128) NOT NULL,
                           department VARCHAR(128) NOT NULL,
                           contract_id VARCHAR(128) NOT NULL UNIQUE,
                           post_code VARCHAR(6) NOT NULL,
                           street VARCHAR(128) NOT NULL
);

ALTER TABLE EMPLOYEES
    ADD CONSTRAINT user_employee_id
        FOREIGN KEY (user_id) REFERENCES USERS(id);
