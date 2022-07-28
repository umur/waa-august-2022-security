create table category
(
    id   integer not null
        constraint category_pkey
            primary key,
    name varchar(255)
);

alter table category
    owner to postgres;

INSERT INTO public.category (id, name) VALUES (1, 'Category 1');
INSERT INTO public.category (id, name) VALUES (2, 'Category 2');
INSERT INTO public.category (id, name) VALUES (3, 'Category 3');
INSERT INTO public.category (id, name) VALUES (4, 'Category 4');