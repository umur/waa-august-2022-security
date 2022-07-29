INSERT INTO public.role (id, name) VALUES (1, 'admin');
INSERT INTO public.role (id, name) VALUES (2, 'user');

INSERT INTO public.users (id, first_name, last_name, password, username, role_id) VALUES (1, 'Alikhan', 'Amandyk', '$2a$10$./agFWx28ZOZzvEFhlBsiuOqEyEL7nIyct/zCTy5eigXyVmotCs3C', 'alih107', 1);
INSERT INTO public.users (id, first_name, last_name, password, username, role_id) VALUES (2, 'Daniyar', 'Abdikhalikov', '$2a$10$aywo.SnlH3l1q43qo4McZebECXWT7APA7UdjTG4gCvLGeUfXXHiwG', 'aqa808', 2);

INSERT INTO public.product (id, name, user_id) VALUES (1, 'Bread', 2);
INSERT INTO public.product (id, name, user_id) VALUES (2, 'Milk', 1);
