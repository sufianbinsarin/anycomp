-- Table: public.seller

-- DROP TABLE IF EXISTS public.seller;

CREATE TABLE IF NOT EXISTS public.seller
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT seller_pkey PRIMARY KEY (id),
    CONSTRAINT seller_email_key UNIQUE (email)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.seller
    OWNER to postgres;