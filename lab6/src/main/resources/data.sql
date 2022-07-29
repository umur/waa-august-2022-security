insert into public.address (id, city, street, zip)
values  (1, 'city 1', 'street 1', 123),
        (2, 'city 2', 'street 2', 200),
        (3, 'city 3', 'street 3', 200);

insert into public.user (id, email, first_name, last_name, password, address_id)
values  (1, 'admin@gmail.com', 'admin', 'admin', '12345', 1),
        (2, 'user1@gmail.com', 'user1', 'user 1', '12345', 2),
        (3, 'user2@gmail.com', 'user2', 'user 1', '12345', 3);

insert into public.category (id, name)
values  (1, 'cate 1'),
        (2, 'cate 2'),
        (3, 'cate 3'),
        (4, 'cate 4'),
        (5, 'cate 5'),
        (6, 'cate 6');

insert into public.product (id, name, price, rating, category_id)
values  (1, 'product 1', 200, 5, 2),
        (2, 'product 2', 220, 3, 3);

insert into public.review (id, comment, product_id)
values  (1, 'comment 1', 1),
        (2, 'comment 2', 1),
        (3, 'comment 3', 1),
        (4, 'comment 4', 2),
        (5, 'comment 5', 2),
        (6, 'comment 6', 2);

insert into public.role (id, role)
values  (2, 'ADMIN'),
        (1, 'USER');

insert into public.user_roles (user_id, roles_id)
values  (1, 2),
        (2, 1),
        (3, 1);


SELECT setval('hibernate_sequence', (SELECT last_value FROM hibernate_sequence) + 1000, true);