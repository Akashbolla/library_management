# 📚 Library Management System

A complete web-based Library Management System built using **Java Servlets**, **JSP**, **JDBC**, and **Oracle DB** following the **3-Tier Architecture**. It allows users to register, log in, and manage books with full **CRUD operations**.

---

## 🔧 Tech Stack

- Java (Servlets, JSP)
- JDBC (Oracle Database)
- HTML, CSS, JavaScript
- Apache Tomcat
- Eclipse IDE
- Git + GitHub

---

## 🗂️ Features

### 👤 User Management
- Register new users
- Login and logout with session handling
- View all registered users (Admin only)

### 📘 Book Management
- Add new books
- View all books
- Update book details
- Delete books

### 🔐 Authentication
- Session-based login security
- Access restrictions via servlet filters

---

## 📁 Project Structure

Library_Management/
├── src/com/Lib_management/
│ ├── dao/
│ │ ├── BookDAO.java
│ │ └── UserDAO.java
│ ├── model/
│ │ ├── BookBean.java
│ │ └── UserBean.java
│ ├── servlet/
│ │ ├── LoginServlet.java
│ │ ├── RegisterServlet.java
│ │ ├── AddBookServlet.java
│ │ └── ViewBookServlet.java
│ ├── filter/
│ │ └── AuthFilter.java
│ └── DBConnection.java
├── WebContent/
│ ├── login.jsp
│ ├── register.jsp
│ ├── dashboard.jsp
│ ├── addBook.jsp
│ ├── viewBooks.jsp
│ ├── viewUsers.jsp
│ └── screenshots
└── README.md


---

## 🖼️ Screenshots

> Upload screenshots to `WebContent/screenshots/` and update below.

### 🔐 Login Page  
![Login](WebContent/screenshots/login.png)

### 📚 Dashboard  
![Dashboard](WebContent/screenshots/dashboard.png)

### ➕ Add Book  
![Add Book](WebContent/screenshots/addbooks.png)

---

## 🧩 JavaBeans

- `BookBean.java`: Model class for books (`id`, `title`, `author`, `quantity`)
- `UserBean.java`: Model class for users (`id`, `name`, `email`, `password`)

---

## 🛠️ Database Setup (Oracle)

### 🔹 Book Table

```sql
CREATE TABLE books (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR2(100),
    author VARCHAR2(100),
    quantity NUMBER
);
###🔹 User Table
CREATE TABLE users (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100)
);
🔌 Database Connection
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "your_username";
String password = "your_password";
🧱 Architecture
[Presentation Layer] → JSP
        ↓
[Business Layer] → Servlets
        ↓
[Data Layer] → DAO + JDBC + Oracle DB
👥 Sample Login
Username: admin
Password: admin123   i added like this only to read me.and how to add screenshots  ,
