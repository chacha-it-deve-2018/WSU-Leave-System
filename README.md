# 🎓 Student Grade Management System (OOP Implementation)

### 👤 Developer Information
* **Name:** Chalachew Belay
* **Email:** [chalachewbelay43@gmail.com](mailto:chalachewbelay43@gmail.com)
* **Institution:** Wolaita Sodo University (WSU)
* **Course:** Object-Oriented Programming (OOP)

---

## 📌 Project Overview
The **Student Grade Management System** is a Java-based console application designed to manage student academic records efficiently. The project focuses on the practical application of **Object-Oriented Programming (OOP)** principles to solve real-world data management problems.

---

## 🏗️ OOP Architecture
This project serves as a practical demonstration of the four pillars of OOP:

### 1. Abstraction
Implemented using an `abstract class Person`. This hides the complex implementation details and only exposes necessary features like `name` to the rest of the system.

### 2. Encapsulation
All sensitive data (names, marks, IDs) are declared as `private`. Access is managed through **Getters** and **Setters**, ensuring data integrity.

### 3. Inheritance
The `Student` class inherits from the `Person` class, promoting code reusability.

### 4. Polymorphism
Method Overriding is used with the `@Override` annotation on the `displayDetails()` method to provide student-specific behavior.

---

## ⚙️ Features & Functionality
* **Student Registration:** Add new students with unique IDs.
* **Course Management:** Assign multiple courses to a single student.
* **Weighted Grading Logic:** * Mid (20%), Assignment (20%), Project (20%), Final (40%).
* **GPA Calculation:** Automated calculation based on university standards.

---

## 📊 Grading Scale
| Score Range | Grade | Point |
| :--- | :--- | :--- |
| 90 - 100 | A | 4.0 |
| 80 - 89 | B | 3.0 |
| 75 - 79 | C | 2.5 |
| 70 - 74 | D | 2.0 |
| Below 60 | F | 0.0 |

---

## 🛠️ Technology Stack
* **Language:** Java (JDK 8+)
* **Data Structure:** `ArrayList`
* **Input:** `java.util.Scanner`
