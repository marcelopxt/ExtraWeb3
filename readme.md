# Projeto Extra - Laravel & Java Desktop

Este repositório contém uma API desenvolvida em Laravel para gerenciar alunos e uma aplicação Java Desktop que consome essa API para realizar operações de CRUD.

## Estrutura do Projeto

- **Aula16_alunos/**: Diretório do projeto Laravel contendo a API do CRUD de alunos.
- **JavaDesktop_ProjetoAPI/**: Diretório da aplicação Java Desktop que interage com a API e realiza as operações CRUD com o banco de dados.

## Configuração da API (Laravel)

1. Acesse a pasta do projeto Laravel:
   ```sh
   cd Aula16_alunos
   ```
2. Instale as dependências:
   ```sh
   composer install
   ```
3. Configure o banco de dados no arquivo `.env`:
   ```env
   DB_CONNECTION=mysql
   DB_HOST=127.0.0.1
   DB_PORT=3306
   DB_DATABASE=aula16_alunos
   DB_USERNAME=root
   DB_PASSWORD=12345678
   ```
4. Execute as migrações para criar as tabelas:
   ```sh
   php artisan migrate
   ```
5. Inicie o servidor Laravel:
   ```sh
   php artisan serve
   ```
   A API estará disponível em: [http://127.0.0.1:8000/api/alunos](http://127.0.0.1:8000/api/alunos)

## Configuração da Aplicação Java Desktop

1. Acesse a pasta do projeto Java:
   ```sh
   cd JavaDesktop_ProjetoAPI
   ```
2. Se ocorrer erro na importação da biblioteca **GSON**, adicione o arquivo `.jar` da biblioteca que está na pasta do projeto:
   - No NetBeans/Eclipse/IntelliJ: Adicione o `.jar` às bibliotecas do projeto manualmente.

3. Execute a aplicação e utilize as funcionalidades de CRUD para interagir com a API.

## Endpoints da API
A API segue os padrões REST para manipulação dos alunos:

- **GET** `/api/alunos` - Lista todos os alunos
- **GET** `/api/alunos/{id}` - Retorna um aluno pelo ID
- **POST** `/api/alunos` - Cria um novo aluno
- **PUT** `/api/alunos/{id}` - Atualiza os dados de um aluno
- **DELETE** `/api/alunos/{id}` - Remove um aluno

## Tecnologias Utilizadas
- **Backend:** Laravel 5.10, MySQL
- **Frontend:** Java Swing (Java Desktop)
- **Bibliotecas:** GSON para manipulação de JSON no Java

## Autor
Desenvolvido por Marcelo Peixoto - Não doarei meus pontos.

