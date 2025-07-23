## 💾 Hibernate

**Hibernate** is a framework used for **persisting (saving) Java objects** to a database.

- Handles low-level **SQL operations** internally
- Minimizes the amount of **JDBC code** developers need to write
- Provides **Object-to-Relational Mapping (ORM)** between Java classes and database tables

---

## 📘 What is JPA?

**JPA** stands for **Jakarta Persistence API** (previously **Java Persistence API**).

- A **standard specification** for ORM (Object-to-Relational Mapping)
- Defines a set of **interfaces**
- Requires a concrete **implementation** (like Hibernate, EclipseLink, etc.) to work

---

## ✅ Benefits of Using JPA

- Promotes **portability and flexibility** by coding to a standard API
- Avoids **vendor lock-in** — you can switch implementations if needed
- Example: If Vendor ABC discontinues their JPA implementation, you can switch to Vendor XYZ with minimal code changes

---
## 🏷️ Common JPA Annotations

JPA provides a set of annotations to map Java classes to database tables and manage relationships.

### 📄 Entity & Table Mapping
| Annotation        | Purpose                                           |
|-------------------|---------------------------------------------------|
| `@Entity`         | Marks the class as a JPA entity (table in DB)     |
| `@Table(name="...")` | Specifies the table name in the database       |

### 🔑 Primary Key & Generation
| Annotation        | Purpose                                               |
|-------------------|-------------------------------------------------------|
| `@Id`             | Marks the primary key field                           |
| `@GeneratedValue` | Specifies how the primary key should be generated     |
| `@Column(name="...")` | Maps a field to a column in the database          |

### 🔁 Relationships
| Annotation        | Purpose                                         |
|-------------------|-------------------------------------------------|
| `@OneToOne`       | One-to-one relationship                        |
| `@OneToMany`      | One-to-many relationship                       |
| `@ManyToOne`      | Many-to-one relationship                       |
| `@ManyToMany`     | Many-to-many relationship                      |
| `@JoinColumn`     | Defines the foreign key column for a relationship |

### 🕵️ Other Useful Annotations
| Annotation        | Purpose                                            |
|-------------------|----------------------------------------------------|
| `@Transient`      | Excludes a field from being persisted              |
| `@Lob`            | Marks a field as Large Object (e.g. BLOB, CLOB)    |
| `@Temporal`       | Specifies date/time precision (for `Date` fields)  |

These annotations allow you to control how Java objects map to database tables and manage data relationships efficiently.

---
## 🔑 ID Generation Strategies in JPA

JPA provides multiple strategies for **automatically generating primary key values** using the `@GeneratedValue` annotation.

### 🧩 Syntax:
```java
@Id
@GeneratedValue(strategy = GenerationType.TYPE)
private Long id;
```
| Strategy         | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| `AUTO`           | Default strategy; lets the persistence provider choose the best strategy    |
| `IDENTITY`       | Uses the database's auto-increment feature for primary key generation       |
| `SEQUENCE`       | Uses a database sequence object to generate primary keys                    |
| `TABLE`          | Uses a separate table to generate and manage primary key values             |

---
