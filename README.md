# 🗃️ Database Systems Project

This is a desktop-based Database Systems project built using **Java Swing** for the UI and **Oracle MySQL** for the backend database. The application demonstrates core database functionality, including table creation and full CRUD operations.

---

## 💡 Project Overview

The goal of this project is to offer a practical, GUI-based approach to managing relational data. Users can interact with multiple tables — such as those for users, reservations, and trips — and perform operations directly through a simple interface.

---

## 🧰 Technologies Used

- 🎨 **Frontend**: Java Swing (Graphical User Interface)
- 🛢️ **Database**: Oracle MySQL
- 🔗 **Database Connectivity**: JDBC (Java Database Connectivity)
- ☕ **Programming Language**: Java

---

## ✨ Features

- 🗂️ **Create Tables**  
  Dynamically define and create new tables directly from the interface.

- ➕ **Add Records**  
  Insert new records into existing tables (e.g., Users, Reservations, Trips).

- 📝 **Update Records**  
  Modify existing data easily through the UI.

- ❌ **Delete Records**  
  Remove unwanted or outdated records from the database.

- 👀 **View Records**  
  Fetch and display table data in an organized format.

---

## ⚠️ Important Note

> **This project may not function out of the box after cloning.**

Because it connects to a local Oracle MySQL database via JDBC, you will need to:
1. Set up your own MySQL server.
2. Create the required schema and tables.
3. Update the **database connection details** (URL, username, password) in the code.

Without these steps, the application will not be able to connect to the database and will throw connection errors.

---

## 🧪 Setup Instructions (Optional)

If you want to run this project locally:
1. Clone the repository.
2. Install MySQL and create the required database/tables.
3. Modify the connection code:
   ```java
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/YOUR_DATABASE", "username", "password");
