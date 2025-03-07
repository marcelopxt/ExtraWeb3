# Projeto Extra - Laravel & Java Desktop

Este repositório contém uma API desenvolvida em Laravel para gerenciar alunos e uma aplicação Java Desktop que consome essa API para realizar operações de CRUD.

## Estrutura do Projeto

- **Aula16_alunos/**: Diretório do projeto Laravel contendo a API do CRUD de alunos.
- **JavaDesktop_ProjetoAPI/**: Diretório da aplicação Java Desktop que interage com a API e realiza as operações CRUD.

## Capturas de Tela
<table style="width: 100%; text-align: center; border-collapse: collapse;">
   <thead>
      <tr>
      <th colspan="2" style="text-align: center;">API</th>
    </tr>
   </thead>
  <tr>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/1fa736d0-e870-46a3-8a85-7cbbd1c2d275" alt="API GET" style="max-width: 100%; height: auto;">
      <p align="center">API GET</p>
    </td>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/e17dc207-4e38-4b01-8378-883b3791d497" alt="API POST" style="max-width: 100%; height: auto;">
       <p align="center">API POST</p>
    </td>
  </tr>
  <tr>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/f0c1bd70-4c05-4245-ad5c-291c92845976" alt="API PUT" style="max-width: 100%; height: auto;">
      <p align="center">API PUT</p>
    </td>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/6ea2704e-3679-4a9e-8b44-84b47e9a8eda" alt="API DELETE" style="max-width: 100%; height: auto;">
       <p align="center"> API DELETE</p>
    </td>
  </tr>
</table>


<table style="width: 100%; text-align: center; border-collapse: collapse;">
   <thead>
      <tr>
      <th colspan="2" style="text-align: center;">APLICACAO JAVA</th>
    </tr>
   </thead>
  <tr>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/a0593d82-865a-42b8-bbb9-4081ab7e534d" alt="INDEX" style="max-width: 100%; height: auto;">
      <p align="center">INDEX</p>
    </td>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/fba27b61-d941-4919-92af-e2cd141a0db9" alt="NEW" style="max-width: 100%; height: auto;">
      <p align="center">NEW</p>
    </td>
  </tr>
  <tr>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/a79b762c-d4d2-45df-9de1-2f2cf8ae4fc1" alt="EDIT" style="max-width: 100%; height: auto;">
       <p align="center">EDIT</p>
    </td>
    <td style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/9d3811fb-cb6b-4b84-b07a-af2e21da66f4" alt="DELETE" style="max-width: 100%; height: auto;">
       <p align="center">DELETE</p>
    </td>
  </tr>
</table>


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
Desenvolvido por Marcelo Peixoto.

