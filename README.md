## Itens implementados

a) Criar uma aplicação Front-end utilizando Angular na versão mais recente. Link Repositorio:

https://github.com/RaquelABrito/gerenciador-tarefas-angular

b) Desenvolver o backend utilizando Java 11 e Spring Boot.

c)Os endpoints devem ser em REST.

e)Utilizar persistência em um banco de dados PostgreSQL e persistência JPA.



## API GERENCIADOR DE TAREFAS COM SPRING 
Primeiro importe o projeto maven para sua ide de preferencia, configure a versão do java para 11.

Para inicializar o spring boot sem erros é necessário Criar um banco local gerenciador-tarefas
no PostgreSql e configurar ele no arquivo application.properties: 


"pring.datasource.platform=postgres

spring.jpa.show-sql=true

spring.database.driverClassName=org.postgresql.Driver

spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciador-tarefas

spring.datasource.username=postgres

spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect"



Apos a configuração inicie a Aplicação GerenciadorTarefasApplication.java.

## Endereço da api

O endereço da api é que esta configurado na minha maquina é http://localhost:8080/api/tarefas

Listar tarefas


## Get

http://localhost:8080/api/tarefas/listartarefas

http://localhost:8080/api/tarefas/{id}

Pegar tarefa por id exemplo:

http://localhost:8080/api/tarefas/1

## Put

http://localhost:8080/api/tarefas/{id}

## Delete

 http://localhost:8080/api/tarefas/{id}

## Post
http://localhost:8080/api/tarefas/




