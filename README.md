📝 To-Do List Application (Java + JDBC)
📌 Overview

This is a console-based To-Do List application developed using Java and JDBC with PostgreSQL as the database.
The project demonstrates real-world CRUD operations, secure database interaction, and proper date handling in Java.

Initially, the To-Do List was implemented using an ArrayList, which provided only temporary (in-memory) storage. To enable persistent data storage and understand real database connectivity, JDBC integration was added.

✨ Features

➕ Add new tasks

✏️ Update existing tasks

❌ Delete tasks

📄 Fetch and display tasks

💾 Persistent storage using PostgreSQL

🔐 Secure SQL queries using PreparedStatement

📅 Date handling using LocalDate and java.sql.Date

🛠️ Technologies Used

Java

JDBC

PostgreSQL

java.time API

Scanner (for user input)

🗂️ Database Schema
CREATE TABLE task (
    id INT PRIMARY KEY,
    name TEXT,
    descr TEXT,
    status BOOLEAN,
    tdate DATE
);

⚙️ How to Run the Project

Clone the repository:

git clone https://github.com/gitvivek123-hub/TODOLIST_JDBC.git


Create the PostgreSQL database and table.

Update database credentials in the Java code:

String url = "jdbc:postgresql://localhost:5432/your_db";
String user = "postgres";
String password = "your_password";


Compile and run the Java program.

🎯 Learning Outcomes

Understanding JDBC architecture

Performing CRUD operations using Java

Secure database interaction with PreparedStatement

Handling date formats and conversions

Transitioning from in-memory storage to database-backed applications

🔗 GitHub Repository

👉 https://github.com/gitvivek123-hub/TODOLIST_JDBC/tree/main

🚀 Future Enhancements

Add GUI using Swing / JavaFX

Implement user authentication

Add task priority and categories

Export tasks to file (PDF/CSV)

👤 Author

Vivek Wakchaure
