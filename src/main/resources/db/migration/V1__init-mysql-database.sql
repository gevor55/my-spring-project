CREATE TABLE cafe
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255)        NOT NULL,
    address VARCHAR(255) unique NOT NULL
);

insert into cafe(name, address)
values ('The Garden', 'Mashtoc'),
       ('Sorriso', 'North Avenue');