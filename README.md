Student Grade Management System (OOP Implementation)
👤 Developer Information
Name: Chalachew Belay

Email: chalachewbelay43@gmail.com

Institution: Wolaita Sodo University (WSU)

Course: Object-Oriented Programming (OOP)
📌 Project Overview
The Student Grade Management System is a Java-based console application designed to manage student academic records efficiently. The project focuses on the practical application of Object-Oriented Programming (OOP) principles to solve real-world data management problems.

The system allows administrators to register students, assign marks for various assessments, calculate grades based on a 100% scale, and manage records through a user-friendly menu.
🏗️ OOP Architecture
This project serves as a practical demonstration of the four pillars of OOP:

Abstraction: Implemented using an abstract class Person. This hides the complex implementation details of a human entity and only exposes necessary features like name to the rest of the system.

Encapsulation: All sensitive data (names, marks, IDs) are declared as private. Access to these variables is strictly managed through Getters and Setters, ensuring data integrity and protection against unauthorized modification.

Inheritance: The Student class inherits from the Person class. This promotes code reusability by allowing the Student class to use attributes of the Person class while adding its own specific attributes like studentID and ArrayList<Course>.

Polymorphism: Method Overriding is used with the @Override annotation on the displayDetails() method. This allows the system to provide specific behaviors for the Student class that differ from the base Person class.
⚙️ Features & Functionality
Student Registration: Add new students with unique IDs and character-based name validation.

Course & Mark Management: Assign multiple courses to a single student.

Weighted Grading Logic:

Mid Exam: 20%

Assignment: 20%

Project: 20%

Final Exam: 40%

Automated GPA Calculation: Computes the overall Grade Point Average based on university standards.

Search & Filter: Find student records instantly using their Unique ID.

Record Management (CRUD): Update or delete student records and marks easily.
📊 Grading Scale Reference
The system follows a standard 4.0 scale: | Marks Range | Letter Grade | Grade Point | | :--- | :--- | :--- | | 90 - 100 | A | 4.0 | | 80 - 89 | B | 3.0 | | 75 - 79 | C | 2.5 | | 70 - 74 | D | 2.0 | | 60 - 69 | E | 1.0 | | Below 60 | F | 0.0 |
🛠️ Technology Stack
Language: Java (JDK 8+)

Data Structure: ArrayList for dynamic data storage.

Input Handling: java.util.Scanner for interactive console input.
🚀 Installation & Usage
1,Clone the project:

Bash

git clone https://github.com/chacha-it-deve-2018/student-grade-system.git
2.Navigate to the directory:

cd student-grade-system
3.Compile the code
javac studentgradesystem/StudentGradeSystem.java
4.Run the application:
java studentgradesystem.StudentGradeSystem
