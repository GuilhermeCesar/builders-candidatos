# builders-clientes

> Api de cadasto de clientes

## Stack

* Java 16
* Maven
* Mysql

## Como acessar a API

## Rodar local

 ```sh
$ cd docker/
$ docker-compose up
 ```

Caso seu docker rode em uma VM, altere o ip do banco no [application](src/main/resources/application.yaml)

## Acessar documentação

* http://localhost:8080/api/swagger-ui/index.html

### Collection postman

[Collection](collection/builders.postman_collection.json)

## Relatório JACOCO(Precisa rodar localmente)

### Cobertura

 ```sh
$ install jacoco:report -f pom.xml
 ```

[Relatório(Precisa fazer build)](target/site/jacoco/index.html)




