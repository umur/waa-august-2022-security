INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'amgalan@miu.edu', 'Amgalan', 'Bat-Erdene', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'saintur@miu.edu', 'Saintur', 'Batkhuu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (3, 'zolzaya@miu.edu', 'Zolzaya', 'Bayantsogt', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 2);

INSERT INTO product (id, name, price)
VALUES (1, 'iPhone', 1200);
INSERT INTO product (id, name, price)
VALUES (2, 'iPad', 900);
INSERT INTO product (id, name, price)
VALUES (3, 'Pen', 5);