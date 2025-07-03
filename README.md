# Student Management System

A console-based Student Management System built with Java and MySQL that allows you to perform CRUD (Create, Read, Update, Delete) operations on student records.

## Features

- **Insert Student Details**: Add new student records with name, branch, and total marks
- **Update Student Details**: Modify existing student's branch information
- **Delete Student Records**: Remove student records from the database
- **View Student Details**: Display all student records
- **Interactive Menu**: Easy-to-use console interface

## Technologies Used

- **Java**: Core programming language
- **MySQL**: Database management system
- **JDBC**: Database connectivity
- **Maven/Gradle**: Build tool (assumed)

## Project Structure

```
src/
├── com/elevateLabs/
│   ├── Utils/
│   │   └── DButils.java          # Database connection utility
│   ├── dao/
│   │   └── StudentDao.java       # Data Access Object for student operations
│   ├── entity/
│   │   └── Student.java          # Student entity class
│   └── main/
│       └── MainMenu.java         # Main application with menu system
```

## Database Schema

The application uses a MySQL database with the following table structure:

```sql
CREATE DATABASE elevateLabs_db;

USE elevateLabs_db;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    branch VARCHAR(50) NOT NULL,
    totalMarks INT NOT NULL
);
```

## Prerequisites

- Java 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC driver)

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd student-management-system
   ```

2. **Set up MySQL Database**
   - Install MySQL Server
   - Create a database named `elevateLabs_db`
   - Create the `student` table using the schema provided above

3. **Configure Database Connection**
   - Open `DButils.java`
   - Update the database credentials if necessary:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/elevateLabs_db";
     private static final String USERNAME = "root";
     private static final String PASSWORD = "root";
     ```

4. **Add MySQL Connector/J to your project**
   - Download MySQL Connector/J JAR file
   - Add it to your project's classpath

5. **Compile and Run**
   ```bash
   javac -cp ".:mysql-connector-java-x.x.x.jar" com/elevateLabs/main/MainMenu.java
   java -cp ".:mysql-connector-java-x.x.x.jar" com.elevateLabs.main.MainMenu
   ```

## Usage

1. Run the application
2. Choose from the menu options:
   - **1**: Insert new student details
   - **2**: Update existing student's branch
   - **3**: Delete a student record
   - **4**: View all student records
   - **5**: Exit the application

### Example Usage

```
***************************
1.Insert student details
2.Update student details
3.Remove student details
4.View student details
5.Exit....
***************************
Enter your choice: 1
Enter the name of student: John
Enter the branch name: Computer Science
Enter the total marks of the student: 85
Insertion successfull
```

## Class Descriptions

### Student.java
- Entity class representing a student
- Contains properties: id, name, branch, totalMarks
- Includes getter/setter methods and input validation

### StudentDao.java
- Data Access Object for database operations
- Implements AutoCloseable for resource management
- Methods: insertStudent(), getAllStudent(), updateStudent(), deleteStudent()

### DButils.java
- Utility class for database connection management
- Provides centralized database configuration

### MainMenu.java
- Main application class with console interface
- Handles user input and menu navigation
- Coordinates between user interface and data access layer

## Error Handling

The application includes basic error handling for:
- SQL exceptions during database operations
- Connection failures
- Invalid user input

## Future Enhancements

- Add input validation for student data
- Implement search functionality
- Add more update options (name, marks)
- Create a graphical user interface
- Add data export/import features
- Implement logging mechanism


---

**Note**: Make sure to update the database credentials and connection details according to your local MySQL setup before running the application.
