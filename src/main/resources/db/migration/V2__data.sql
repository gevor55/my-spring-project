INSERT INTO cafe(name, address)
VALUES ('The Garden', 'Mashtoc'),
       ('Sorriso', 'North Avenue');


INSERT INTO users(username, first_name, last_name, birth_date, status, password, role, cafe_id)
VALUES ('admin', 'Alex', 'Alexanyan', '2000-10-10', 'ACTIVE', '{noop}123', 'ADMIN', 1),
       ('user', 'Bob', 'Bob', '1993-10-10', 'ACTIVE', '{noop}123', 'USER', 1);