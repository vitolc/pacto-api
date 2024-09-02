# Documentação do Projeto
## Introdução
Este documento descreve o projeto Pacto-API , desenvolvido para o processo seletivo da Pacto Soluções. Este backend foi construído para ser a api para um sistema de gerenciamento e candidatura de vagas internas.

Como rodar essa API na sua maquina?
### Pré requisitos:
Ter o JAVA 17 ou superior instalado e a variável JAVA_HOME configurado nas variáveis de ambiente da sua máquina.
Ter o git instalado, para ter acesso ao comando git clone no terminal.
Ter o PostgreSQL 14 ou superior instalado.
Clone o repositório usando o comando:

`git clone https://github.com/vitolc/pacto-api.git`

Ou se preferir baixe o zip do projeto deste mesmo link.

### Iniciar Aplicação:
Certifque-se de que há um banco de dados criado no postgres com nome pacto
caso não houver, você pode criar um banco com este nome usando os seguintes comandos:

`psql -U postgres`

após esse comando você terá que inserir a senha do usuario postgres(a senha padrão é postgres)

`create database pacto;`

Abra o terminal no diretório do projeto e execute o comando:

`./mvnw spring-boot:run`

Feito isso a api já deve estar rodando na porta 8080 da sua máquina.
