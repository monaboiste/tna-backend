--liquibase formatted sql
--changeset monaboiste:5

ALTER TABLE USERS
    ADD CONSTRAINT users_username_key
        UNIQUE (username);
