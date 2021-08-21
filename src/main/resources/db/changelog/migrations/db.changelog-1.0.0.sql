--liquibase formatted sql

--changeset medeiros:1
CREATE TABLE cliente.cliente
(
    id   int NOT NULL AUTO_INCREMENT,
    cpf  VARCHAR(11),
    nome VARCHAR(100),
    data_nascimento DATE,
    sexo varchar(9),
    PRIMARY KEY (id)
);