USE lanchonete;
CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(20),
    nome VARCHAR(200),
    email VARCHAR(200),
    PRIMARY KEY (id)
);

CREATE TABLE produtos (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200),
    descricao VARCHAR(200),
    valor double,
    imagem VARCHAR(200),
    PRIMARY KEY (id)
);

CREATE TABLE categorias (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200),
    descricao VARCHAR(200),
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO usuarios (cpf, nome, email) VALUES ("98765432111", "Diego", 'diego@teste.com');
INSERT INTO categorias (titulo, descricao) VALUES ("Lanches", "Lanches são compostos por pão, hamburguer e pode conter outros ingredientes como alface, tomate, queijo, bacon, entre outros");
INSERT INTO categorias (titulo, descricao) VALUES ("Bebidas", "Bebidas como água, refrigerantes, sucos e cervejas");
INSERT INTO categorias (titulo, descricao) VALUES ("Acompanhamentos", "Batatas fritas, batatas chips ou dadinhos de tapioca");
INSERT INTO categorias (titulo, descricao) VALUES ("Sobremesas", "Sorvetes e doces váriados");