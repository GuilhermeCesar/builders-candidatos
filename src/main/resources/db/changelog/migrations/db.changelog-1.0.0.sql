--liquibase formatted sql

--changeset medeiros:1
CREATE TABLE cliente.cliente
(
    id   int NOT NULL AUTO_INCREMENT,
    cpf  VARCHAR(11),
    nome VARCHAR(100),
    dataNascimento DATE,
    sexo varchar(1),
    PRIMARY KEY (id)
);