CREATE TABLE IF NOT EXISTS USERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL,
    username varchar(250) UNIQUE NOT NULL,
    email varchar(50) UNIQUE NOT NULL,
    password varchar(250) NOT NULL,
    roles varchar(250) not null,
    enabled BOOLEAN NOT NULL
);

insert
into
    users
(email, enabled, first_name, last_name, password, roles, username, id)
values
    ('admin@gmail.com', true, 'admin', 'admin', '$2a$10$/B44UB93wY.gaqXwmbR5x.BOqD2Q2HgnPE8L3zk/95nwWb4ylE1Ea', 'ROLE_ADMIN', 'admin', default);

insert
into
    users
(email, enabled, first_name, last_name, password, roles, username, id)
values
    ('tenchev@gmail.com', true, 'Tsvetelin', 'Enchev', '$2a$10$4RFb.wFhnBDwXQpsFjhIE.DxGN3cYeCBgkzdafjX41Wng693sCrH6', 'ROLE_USER', 'tenchev', default);

