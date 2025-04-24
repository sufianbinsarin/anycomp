-- Table: public.purchase

-- DROP TABLE IF EXISTS public.purchase;

CREATE TABLE IF NOT EXISTS public.purchase
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    buyer_id bigint NOT NULL,
    item_id bigint NOT NULL,
    quantity integer NOT NULL,
    purchasedate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT purchase_pkey PRIMARY KEY (id),
    CONSTRAINT purchase_buyer_id_fkey FOREIGN KEY (buyer_id)
    REFERENCES public.buyer (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE CASCADE,
    CONSTRAINT purchase_item_id_fkey FOREIGN KEY (item_id)
    REFERENCES public.item (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE CASCADE
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.purchase
    OWNER to postgres;