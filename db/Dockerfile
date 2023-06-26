# Use uma imagem base do MySQL
FROM mysql:latest

# Variáveis de ambiente para configurar o banco de dados
ENV MYSQL_ROOT_PASSWORD root1234
ENV MYSQL_DATABASE lanchonete
ENV MYSQL_USER user
ENV MYSQL_PASSWORD user

# Copie um script SQL para inicializar o banco de dados
COPY schema.sql /docker-entrypoint-initdb.d/

# Exponha a porta do MySQL (padrão é 3306)
EXPOSE 3306