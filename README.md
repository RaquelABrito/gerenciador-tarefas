## API GERENCIADOR DE TAREFAS COM SPRING 

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



## Apos a configuração inicie a Aplicação GerenciadorTarefasApplication.java.

## O endereço da api é que esta configurado na minha maquina é

## http://localhost:8080/tarefa

Listar tarefas


Get

Put

Delete
