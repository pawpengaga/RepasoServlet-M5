CREATE DATABASE repaso_svl_db;

---------------------------------------

CREATE TABLE public.usuarios (
    id serial NOT NULL PRIMARY KEY,
    nombre varchar(100),
    usuario varchar(100),
    clave varchar(100),
);

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;