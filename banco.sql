CREATE DATABASE demonstracaodb;

-- Script testado no mysql
-- Foi utilizado o usuario testeuser e senha testeuser para acesso ao db
-- No arquivo de configuracao do hibernate.xml localizando na pasta src do projeto

CREATE USER 'testeuser' IDENTIFIED BY 'testeuser';

GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON demonstracaodb.* TO 'testeuser';

USE demonstracaodb;

create table cliente (
   codigo_cliente MEDIUMINT NOT NULL AUTO_INCREMENT,
   nome varchar(70) NOT NULL,
   email varchar(70) NOT NULL,
   endereco varchar (100),
   telefone varchar (20),
   sexo char,
   newsletter boolean NOT NULL,
   PRIMARY KEY (codigo_cliente)
);

INSERT INTO `tetrabd`.`cliente`
(
`nome`,
`email`,
`endereco`,
`telefone`,
`sexo`,
`newsletter`)
VALUES
(
"Alex Augusto Alves da Silva",
"alexaugustoti@gmail.com",
"Rua João Muniz da Costa",
"950498413",
"M",
1);
