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
    email      VARCHAR      NOT NULL,
    password   VARCHAR(128) NOT NULL,
    cafe_id    BIGINT REFERENCES cafe (id)
);

create table roles
(
    id   bigserial primary key,
    name varchar not null
);

CREATE TABLE users_roles
(
    user_id BIGSERIAL not null,
    role_id BIGSERIAL not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);