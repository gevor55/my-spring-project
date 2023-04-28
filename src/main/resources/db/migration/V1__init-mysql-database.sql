create table cafe
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255)        NOT NULL,
    address VARCHAR(255) UNIQUE NOT NULL
);


create table users
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
);

insert into cafe(name, address)
values ('The Garden', 'Mashtoc'),
       ('Sorriso', 'North Avenue');


insert into users(username, first_name, last_name, birth_date)
values ('Alex55','Alex', 'Alexanyan', '2000-10-10'),
       ('Bob55','Bob', 'Bob', '1993-10-10');