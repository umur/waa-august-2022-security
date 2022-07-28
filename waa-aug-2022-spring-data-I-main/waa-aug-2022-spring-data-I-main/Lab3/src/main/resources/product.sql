create table product
(
    id          integer          not null
        constraint product_pkey
            primary key,
    name        varchar(255),
    price       double precision not null,
    rating      integer          not null,
    category_id integer
        constraint fk1mtsbur82frn64de7balymq9s
            references category
);

alter table product
    owner to postgres;

INSERT INTO public.product (id, name, price, rating, category_id) VALUES (3, 'product 3', 300, 3, 1);
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (1, 'product 1', 100, 1, 4);
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (2, 'product 2', 200, 2, 2);
INSERT INTO public.product (id, name, price, rating, category_id) VALUES (4, 'product 4', 400, 4, 1);