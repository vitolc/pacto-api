# Documentação do Projeto Pacto-API

## Introdução

O projeto **Pacto-API** foi desenvolvido como parte do processo seletivo da Pacto Soluções e serve como o backend de um sistema de gerenciamento e candidatura de vagas internas.

## Pré-requisitos

Antes de iniciar, certifique-se de que você possui os seguintes requisitos:

- **Java 17 ou superior**: Com a variável `JAVA_HOME` configurada corretamente nas variáveis de ambiente do sistema.
- **Git**: Para clonar o repositório utilizando o comando `git clone`.
- **PostgreSQL 14 ou superior**: Para configurar e gerenciar o banco de dados.

## Instruções para Rodar a API

### 1. Clonar o Repositório

Clone o repositório do projeto usando o comando:

```bash
git clone https://github.com/vitolc/pacto-api.git
```

Ou, se preferir, faça o download do arquivo ZIP do projeto no mesmo link.

### 2. Configurar o Banco de Dados

Certifique-se de que você possui um banco de dados PostgreSQL criado com o nome **pacto**. Se não houver, siga os passos abaixo para criar um:

1. Abra o terminal e conecte-se ao PostgreSQL com o comando:

   ```bash
   psql -U postgres
   ```

2. Insira a senha do usuário `postgres` (por padrão, a senha é `postgres`).

3. Crie o banco de dados com o seguinte comando:

   ```sql
   create database pacto;
   ```

### 3. Iniciar a Aplicação

Com o banco de dados configurado, abra o terminal no diretório do projeto clonado e execute o seguinte comando para iniciar a aplicação:

```bash
./mvnw spring-boot:run
```

A API deve agora estar rodando na porta **8080** da sua máquina.

## Contas de Teste

Para facilitar o processo de teste, duas contas já foram pré-configuradas:

- **Conta Admin**:
  - **Email**: admin@example.com
  - **Senha**: admin

- **Conta User**:
  - **Email**: user@example.com
  - **Senha**: user

Agora você está pronto para explorar e testar a **Pacto-API**!
