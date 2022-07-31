INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'CLIENT');

INSERT INTO users (id, email, name, password)
VALUES (1, 'akbarov@gmail.com', 'Mashrabbek', '$2a$10$y0F4LC/uHpAfFuRHV9T2mO3gz3WIAY77Tvq7l6dfrTe/Lq4d.asAu'); -- test123
--
INSERT INTO users_roles (users_id, roles_id) VALUES (1, 2);



