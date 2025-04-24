-- Table: public.buyer

-- DROP TABLE IF EXISTS public.buyer;

CREATE TABLE IF NOT EXISTS public.buyer
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT buyer_pkey PRIMARY KEY (id),
    CONSTRAINT buyer_email_key UNIQUE (email)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.buyer
    OWNER to postgres;