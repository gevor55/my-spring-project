CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    birth_date date         NOT NULL,
    status     VARCHAR      NOT NULL,
    email      VARCHAR      NOT NULL,
    password   VARCHAR(128) NOT NULL
);