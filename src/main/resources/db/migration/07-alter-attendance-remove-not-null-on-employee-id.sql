--liquibase formatted sql
--changeset monaboiste:7

ALTER TABLE ATTENDANCE_RECORDS ALTER COLUMN employee_id DROP NOT NULL;
