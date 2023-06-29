USE lanchonete;
CREATE TABLE clientes (
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(20),
    nome VARCHAR(200),
    email VARCHAR(200),
    PRIMARY KEY (id),
    UNIQUE KEY (cpf),
    UNIQUE KEY (email)
);

CREATE TABLE produtos (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    valor double NOT NULL,
    imagem_url VARCHAR(200),
    categoria_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE categorias (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    descricao VARCHAR(200),
    PRIMARY KEY (id)
);

CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200),
    senha VARCHAR(200),
    permissoes VARCHAR(200),
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO usuarios (nome, senha, permissoes) VALUES ("usuario", "$2y$10$apny7Z7eYoQP4MnGzgciEerREBrgAVl1rtD3OoEywjd2XLiHniMaO", "USER");
INSERT INTO usuarios (nome, senha, permissoes) VALUES ("admin", "$2y$10$AymKRLbdwvPArl8IOIq1k.gmsbN3ev7wGtrx4kpDo1f7Uz2/sSNeS", "ADMIN,USER");

INSERT INTO categorias (titulo, descricao) VALUES ("Lanches", "Lanches são compostos por pão, hamburguer e pode conter outros ingredientes como alface, tomate, queijo, bacon, entre outros");
INSERT INTO categorias (titulo, descricao) VALUES ("Bebidas", "Bebidas como água, refrigerantes, sucos e cervejas");
INSERT INTO categorias (titulo, descricao) VALUES ("Acompanhamentos", "Batatas fritas, batatas chips ou dadinhos de tapioca");
INSERT INTO categorias (titulo, descricao) VALUES ("Sobremesas", "Sorvetes e doces váriados");

#Lanches
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Hamburger", "Pão de brioche, hambúrguer Angus de 150g e queijo mussarela", 24.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e82a54605bc.jpg", 1);
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Hamburger MELT", "Pão australiano, hambúrguer Angus de 150g, queijo cheddar cremoso, cebola caramelizada, bacon super crocante e molho barbecue.", 29.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e83306d9650.jpg", 1);
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Hamburger GOUDA", "Pão brioche tostado na manteiga, maionese artesanal, hambúrguer Angus de 150g, queijo mussarela, almofadinhas de queijo Gouda e molho de pimenta agridoce.", 29.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e8341c19eb3.png", 1);
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Hamburger BACON", "Pão brioche tostado na manteiga, hambúrguer Angus de 150g, queijo cheddar, bacon, maionese artesanal e cebola caramelizada.", 29.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e833670fb01.png", 1);
#Bebidas
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Água", "Garrafa de água sem gás 500ml", 4.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e96fc6864d3.png", 2);
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Corona", "Cerveja Corona Extra", 9.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/638a76170d265.jpg", 2);
INSERT INTO produtos (nome, descricao, valor, imagem_url, categoria_id) VALUES ("Heineken", "Cerveja Heineken 330ml", 29.90, "https://storage.googleapis.com/grandchef-apps/gc11924/images/products/62e97027e6dc9.png", 2);
