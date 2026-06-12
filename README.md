Expense Tracker
A simple Java console-based Expense Tracker application developed as a Software Engineering and Java learning project.
Features
Expense Management

* Add Expense
* View Expenses
* Delete Expense
* Calculate Total Spending

Data Persistence

* Save expenses to CSV file
* Load expenses from CSV file on startup
* Automatic data restoration after restart

Sorting

* Sort by Amount (Ascending/Descending)
* Sort by Date (Ascending/Descending)
* Sort by Category (Ascending/Descending)

Validation

* Amount cannot be negative
* Description cannot be empty
* Null date defaults to current date
* Empty category defaults to “Uncategorized”

⸻

Project Structure

ExpenseTracker
├── src/
│   ├── Main.java
│   ├── Expense.java
│   └── ExpenseManager.java
│
├── data/
│   └── expenses.csv
│
└── README.md

⸻

Technologies Used

* Java
* Java Collections Framework (ArrayList)
* LocalDate API
* File Handling (BufferedReader, BufferedWriter)
* CSV Storage
* Object-Oriented Programming (OOP)

⸻

OOP Concepts Used

Encapsulation
* Private fields
* Getters and Setters

Association
* ExpenseManager manages Expense objects

Object Creation
* Expense objects created using constructors

⸻

Architecture

Main
↓
ExpenseManager
↓
ArrayList
↓
Expense Objects
↓
CSV Storage

⸻

CSV Format

date,category,description,amount

Example:

2026-06-10,Food,Pizza Hut,700.0

2026-06-11,Travel,Bus Ticket,150.0

⸻

Current Version

Version: V0

Implemented:

* Expense Model
* Expense Manager
* CSV Persistence
* Menu Driven Interface
* Sorting System

⸻

Planned Features (V0.1)

* Search Expense
* Category-wise Total
* Better Input Validation
* Improved User Interface
* Monthly Reports

⸻

Author : Harveer Singh
B.Tech Computer Science Engineering
Vivekananda Global University, Jaipur
