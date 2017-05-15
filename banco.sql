CREATE DATABASE tetrabd;


-- Foi utilizado o usuario tetra e senha tetra para acesso ao db
-- No arquivo de configuracao do hibernate.xml localizando na pasta src do projeto

CREATE USER 'tetra' IDENTIFIED BY 'tetra';

GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON tetrabd.* TO 'tetra';

USE tetrabd;

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
