INSERT INTO cafe(name, address)
VALUES ('The Garden', 'Mashtoc'),
       ('Sorriso', 'North Avenue');


INSERT INTO users(username, first_name, last_name, birth_date, status, email, password, cafe_id)
VALUES ('admin', 'admin', 'admin', '2000-10-10', 'ACTIVE', 'admin@gmail.com',
        '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 1),
       ('user', 'user', 'user', '1993-10-10', 'ACTIVE', 'user@gmail.com',
        '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 2);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);