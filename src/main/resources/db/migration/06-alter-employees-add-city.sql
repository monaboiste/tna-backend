--liquibase formatted sql
--changeset monaboiste:6

ALTER TABLE EMPLOYEES
ADD city VARCHAR(128) NOT NULL;
