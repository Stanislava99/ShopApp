-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.product
(
    id bigint NOT NULL DEFAULT nextval('product_id_seq'::regclass),
    company_name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    discount_days integer,
    discount_percentage integer,
    discount_price integer,
    image_url character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price integer,
    product_type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users_table
(
    id bigint NOT NULL DEFAULT nextval('users_table_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    login character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    role character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_table_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users_table_product_cart
(
    id bigint NOT NULL DEFAULT nextval('users_table_product_cart_id_seq'::regclass),
    product_cart_id bigint,
    user_id bigint,
    CONSTRAINT users_table_product_cart_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.users_table_product_cart
    ADD CONSTRAINT fk2yg5ko693knovcx7j9sdiue7j FOREIGN KEY (product_cart_id)
    REFERENCES public.product (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.users_table_product_cart
    ADD CONSTRAINT fkk3vwpf5td8mrulvxbmysye77a FOREIGN KEY (user_id)
    REFERENCES public.users_table (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;