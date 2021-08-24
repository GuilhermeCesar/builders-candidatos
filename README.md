# builders-clientes

> Api de cadasto de clientes

## Stack

* Java 16
* Maven
* Mysql

## Como acessar a API

## Verificar

> validar se existe outro MYSQL na sua máquina, por causa do conflito de portas

## Rodar

 ```sh
$ cd docker/
$ docker-compose up
 ```

Caso seu docker rode em uma VM, altere o ip do banco no [application](src/main/resources/application.yaml)

## Portas

- 8080 - docker compose - prd(Profile Spring)
- 8090 - local - default(Profile Spring)

## Acessar documentação

* http://localhost:8080/api/api-docs

### Collection postman

[Collection](collection/builders.postman_collection.json)

## Relatório JACOCO(Precisa rodar localmente)

### Cobertura

 ```sh
$ install jacoco:report -f pom.xml
 ```

[Relatório(Precisa fazer build)](target/site/jacoco/index.html)




