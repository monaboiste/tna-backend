--liquibase formatted sql
--changeset monaboiste:1

CREATE TYPE user_role AS ENUM ('ADMIN', 'USER');

CREATE TABLE USERS (
                       id BIGSERIAL PRIMARY KEY,
                       password VARCHAR(128) NOT NULL,
                       role user_role NOT NULL,
                       username VARCHAR(128) NOT NULL
);
