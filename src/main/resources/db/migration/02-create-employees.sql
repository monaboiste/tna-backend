--liquibase formatted sql
--changeset monaboiste:2

CREATE DOMAIN zipcode varchar(6)
    CONSTRAINT valid_zipcode
    CHECK (VALUE ~ E'^\\d{2}\-+\\d{3}$');

CREATE TABLE EMPLOYEES (
                           user_id BIGINT NOT NULL UNIQUE,
                           firstname VARCHAR(128) NOT NULL,
                           lastname VARCHAR(128) NOT NULL,
                           department VARCHAR(128) NOT NULL,
                           contract_id VARCHAR(128) NOT NULL UNIQUE,
                           post_code zipcode NOT NULL,
                           street VARCHAR(128) NOT NULL
);

ALTER TABLE EMPLOYEES
    ADD CONSTRAINT user_employee_id
        FOREIGN KEY (user_id) REFERENCES USERS(id);
