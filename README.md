# 📧 Spring Boot ETL Email Alert System

This project is a **Java Spring Boot application** that monitors a MySQL database for new or updated records and sends **email alerts** using **Mailtrap (SMTP)**.

It simulates a real-world **ETL (Extract, Transform, Load)** pipeline with scheduling, database interaction, and automated notifications.

---

## 🚀 Features

- ⏰ Scheduled task that polls the database every 10 minutes
- 🛢️ Extracts new/updated records using `JdbcTemplate`
- 💌 Sends alert emails using `JavaMailSender` and Mailtrap SMTP
- 🧩 Modular Spring Boot architecture (`@Service`, `@Scheduled`, DI)
- 🧪 Easily testable / extendable to REST APIs or frontend

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3.3.10
- MySQL (local DB)
- Spring Data JDBC
- Spring Mail (JavaMailSender)
- Mailtrap.io (for SMTP testing)
- IntelliJ IDEA Community Edition
- Maven (build tool)

---

## 📁 Project Structure

