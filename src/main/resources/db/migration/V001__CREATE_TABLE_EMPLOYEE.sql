CREATE TABLE employee
(
    id     SERIAL PRIMARY KEY NOT NULL,
    name   VARCHAR(100)       NOT NULL,
    salary DECIMAL(10, 2)     NOT NULL,
    age    INTEGER            NOT NULL,
    role   VARCHAR(50)        NOT NULL,
    email  VARCHAR(50)        NOT NULL
);