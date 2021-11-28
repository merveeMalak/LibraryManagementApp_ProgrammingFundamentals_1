# CENG211 – Programming Fundamentals
# Homework 1 - Library Management App

In this homework you are expected to implement an “Library Management App” in Java.

You should fulfill the concepts of:

* Defining Classes

* CSV file I/O

* Arrays

* 2-dimensional Arrays

* Constructors, Getters & Setters

In the Library Management App, there are the records of the three libraries that are located in different areas in a university campus. The libraries are called L1 which is the Central Library, L2 which is the School of Foreign Languages Library and L3 which is the Computer Science Library.

In this homework, you are expected to implement necessary classes to load the data from the given CSV files and create the desired queries. The given CSV files are listed below.

* In “L1_Books.csv”, the information is as follows: ID,Title,Author,Publisher,Edition,Genre,Quantity

* In “Members.csv” the information is as follows:

ID,Name,Email

In “L1_Issues.csv”, the information is as follows: ID,Member ID,Book ID,Issue Date,Returning Date

* Format of other CSV files for the remaining 2 libraries are the same with the first one.

* The IDs in the Books files are referring the same book in the Issues files. Similarly, it holds for Members IDs and Issues as well.

You are expected to implement classes for Member, Book, Issue, Library, LibraryManagement, LibraryQuery, LibraryManagementApp (the class with main method) and other helper classes (e.g. FileIO) with the information given below:

Member:

- ID

- Name

- Email

Book:

- ID

- Title

- Author

- Publisher

- Edition

- Genre

- Quantity

Issue:
- ID

- Member

- Book

- Issue Date

- Returning Date

Library:

- Book

- Note: One-dimensional array that holds Book objects.

LibraryManagement:

- Issue

- Note: Two-dimensional array that holds Issue objects for each Library.

- Ex: For 3rd library’s 7th issue, it is [2][6]

Implement necessary methods to respond the following queries in LibraryQuery class:

1- The most issued book (among the three libraries).

2- The member who issues the most books (for all three libraries and all years).

3- Highest penalty for late returning (Note that borrowing period of a book is 14 days. After 14 days, 0.50 TL penalty for each day is charged).

4- The book with the most copies (among the three libraries).

5- The book with the fewest copies of previously issued books.

6- The member who issues the least number of books from the Computer Science Library.

# Important Notes:
1. Do NOT request inputs in your app. Printing the results of the queries will be enough. You should print names of the results instead of printing IDs or indices. 
 
2. You are NOT allowed to use List / ArrayList interfaces in this homework. You can implement helper methods to increase the capacity of arrays when it is needed.
 
3. You can use standard java.io packages to read files. Do NOT use other 3rd party libraries.

4. You should use relative paths (e.g. Files/sample.csv) instead of absolute paths (e.g. C:\\user\\eclipse-workspace\\MyProject\\Files\\sample.csv).

5. To support Turkish characters, you may need to change your project’s text file encoding to UTF8: Right click on your project (in package explorer) → Properties → Text file encoding → Other → UTF8 → Apply.

6. You are expected to write clean, readable, and tester-friendly code. Please try to maximize reusability and prevent from redundancy in your methods.
