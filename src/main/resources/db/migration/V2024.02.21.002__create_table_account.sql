CREATE TABLE departamento
(
    id_departamento character varying(36) NOT NULL,
    tx_name character varying(256),
    tx_description character varying(1024),
    id_professor character varying(36) NOT NULL,
    CONSTRAINT departamento_pkey PRIMARY KEY (id_departamento)
);