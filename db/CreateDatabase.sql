USE lanchonete;
CREATE TABLE usuarios (
    id integer not null auto_increment,
    cpf varchar(200),
    nome varchar(200),
    email varchar(200)
);

CREATE TABLE produtos (
    id integer not null auto_increment,
    nome varchar(200),
    descricao varchar(200),
    valor double,
    imagem varchar(200),
);
SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO user (cpf, nome, email) VALUES ("98765432111", "Diego", 'diego@teste.com');