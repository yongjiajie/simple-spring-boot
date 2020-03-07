# A Simple Spring Boot Project

This repository contains a simple Spring Boot project that has a single endpoint: GET `http://localhost:8080/users`.

## Features

* On start, the `users.csv` file located in `src/main/resources` is loaded to populate a JPA repository.
* The `/users` endpoint returns a JSON with salary between 0 and 4000 (inclusive).

## Technologies

* [Spring Boot](https://start.spring.io/)
    * [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
    * [Spring Web](https://spring.io/guides/gs/serving-web-content/)
* [Lombok](https://projectlombok.org/)
* [OpenCSV](http://opencsv.sourceforge.net/)

## Caveats

* For IntelliJ IDEA users, `Lombok` annotations may result in `Method not found` or `Reference not found` errors. Please download the `Lombok` plugin from the Marketplace to resolve this.

## References

* [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)
* [JPA Query Creation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
* [OpenCSV: Reading into beans](http://opencsv.sourceforge.net/#reading_into_beans)