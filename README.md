# Hibernate Concepts

This repository contains my learning implementations of core **Hibernate ORM concepts** using **Java, Maven, and MySQL**.

The goal of this project is to understand how Hibernate works internally by implementing different features step-by-step.

## Technologies Used

* Java
* Hibernate ORM
* Maven
* MySQL
* IntelliJ IDEA

## Concepts Implemented

### Hibernate Configuration

* Hibernate setup using **hibernate.cfg.xml**
* Hibernate setup using **hibernate.properties**
* **Programmatic configuration (Without XML)**

### Entity Loading & Retrieval

Implemented different ways of retrieving entities from the database:

* `session.get()` – immediately fetches the entity from the database
* `session.load()` – returns a proxy and loads the entity lazily when accessed
* `session.getReference()` – JPA method that returns a reference proxy to the entity

### Hibernate Caching

* **Level 1 Cache implementation**
* **Level 2 Cache experimentation**

### ID Generation Strategies

* `@GeneratedValue`
* `@SequenceGenerator`
* Table-based sequence simulation in MySQL

## Project Structure

```
src/main/java/com/isha
│
├── app
│   ├── GetRecordApp.java
│   ├── Level1Cache.java
│   ├── Level2Cache.java
│   ├── UsingHibernatePropertiesFile.java
│   └── WithoutXMLConfig.java
│
└── model
    ├── StudentDetail.java
    └── StudentDetailForWithoutXML.java
```

* **app package** → Contains runnable classes demonstrating Hibernate features
* **model package** → Contains entity classes mapped to database tables

## Learning Outcome

Through this project, I explored how Hibernate handles:

* Object–Relational Mapping (ORM)
* Session management
* Entity loading strategies
* Caching mechanisms
* Automatic primary key generation

## Author

**Isha Parihariya**
BTech Computer Science Student
