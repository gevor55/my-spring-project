create table cafe
(
    id      serial  not null primary key,
    name    varchar not null,
    address varchar not null
);

insert into cafe(id, name, address)
values (1, 'The Garden', 'Mashtoc'),
       (2, 'Sorriso', 'North Avenue');