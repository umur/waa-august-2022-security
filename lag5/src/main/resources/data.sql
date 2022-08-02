INSERT INTO public.users
VALUES (1, 'abdul@bca.com', 'Abdul','Kadir', '123');
INSERT INTO public.users
VALUES (2, 'mak@gmail.com', 'Mak','Rony', '123');

INSERT INTO public.role
VALUES (1, 'Admin');

INSERT INTO public.role
VALUES (2, 'User');

INSERT INTO public.users_roles
VALUES (1,2);

INSERT INTO public.users_roles
VALUES (2,1);

INSERT INTO public.category (id, name)
VALUES (1, 'CatA');
INSERT INTO public.category (id, name)
VALUES (2, 'CatB');

-- Products
INSERT INTO product (id, name, price, id_user)
VALUES (1, 'iPhone', 1200.45, 1);

INSERT INTO product (id, name, price, id_user)
VALUES (2, 'iPad', 900.56, 2);

INSERT INTO product (id, name, price, id_user)
VALUES (3, 'Pen', 5.0, 1);

--Product Category
INSERT INTO public.category_products
VALUES (2,1);
INSERT INTO public.category_products
VALUES (2,2);

INSERT INTO public.category_products
VALUES (1,3);

-- Review
INSERT INTO review (id,comment,number_of_stars, product_id)
VALUES (1,'awesome phone',5, 1);

INSERT INTO review (id,comment,number_of_stars, product_id)
VALUES (2,'amazing phone',4, 2);

INSERT INTO review (id,comment,number_of_stars, product_id)
VALUES (3,'awesome tablet',3, 3);
