-- Table: public.item

-- DROP TABLE IF EXISTS public.item;

CREATE TABLE IF NOT EXISTS public.item
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    price numeric(38,2) NOT NULL,
    quantity integer NOT NULL,
    seller_id bigint NOT NULL,
    CONSTRAINT item_pkey PRIMARY KEY (id),
    CONSTRAINT item_seller_id_fkey FOREIGN KEY (seller_id)
    REFERENCES public.seller (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.item
    OWNER to postgres;