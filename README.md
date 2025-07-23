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
