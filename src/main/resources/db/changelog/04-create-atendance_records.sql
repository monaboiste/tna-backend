--liquibase formatted sql
--changeset monaboiste:4

CREATE TABLE ATTENDANCE_RECORDS (
                                    id BIGSERIAL PRIMARY KEY,
                                    employee_id BIGINT NOT NULL,
                                    shift_id BIGINT NOT NULL,
                                    entered_at timestamp NOT NULL,
                                    left_at timestamp NOT NULL
);

ALTER TABLE ATTENDANCE_RECORDS
    ADD CONSTRAINT attendance_employee_id
        FOREIGN KEY (employee_id) REFERENCES EMPLOYEES(user_id),
    ADD CONSTRAINT attendance_shift_id
        FOREIGN KEY (shift_id) REFERENCES SHIFTS(id);
