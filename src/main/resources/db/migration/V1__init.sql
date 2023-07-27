create table cafe
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255)        NOT NULL,
    address VARCHAR(255) UNIQUE NOT NULL
);


create table users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    birth_date date         NOT NULL,
    status     VARCHAR      NOT NULL,
    role       VARCHAR      NOT NULL,
    cafe_id    BIGINT REFERENCES cafe (id)
);