# Course-Registration-System-Creational-Design-Patterns
## Project Description

The **Course Registration System** is a Java-based application that simulates a university course registration process. It allows students to enroll in courses, instructors to manage their courses, and IT workers to create and clone courses into new sections. The system uses several design patterns such as **Factory**, **Singleton**, and **Prototype** to organize the different components efficiently. The application ensures that students can only enroll in courses if they are not on probation, and prevents multiple enrollments in different sections of the same course.

## Author

- **Arda Baran**

## Features
- **Person Creating by Type**: Different types of person in University can be created with Factory Pattern.
- **Student Enrollment**: Students can enroll in courses based on their GPA and earned credits, ensuring they meet probationary limits.
- **Instructor Management**: Instructors can manage courses and view course details, including the students enrolled in each course.
- **IT Worker Course Management**: IT workers can create new courses by Singleton Pattern and clone existing courses into new sections, assigning different instructors to each section.
- **Probation Check**: The system checks if a student is on probation based on their GPA and total credits before allowing enrollment.
- **Course Cloning**: Courses can be cloned into new sections using the Prototype Design Pattern, creating independent course sections.

## Technologies and Data Structures Used

- **Programming Language**: Java
- **IDE**: Eclipse
- **Data Structures And Design Patterns**:
  - **ArrayList**: Used to store and manage lists of students, instructors, and courses.
  - **Factory Design Pattern**: Utilized in `UniversityUserFactory` to create students, instructors, and IT workers.
  - **Singleton Design Pattern**: Used in `CourseManager` to ensure there is only one course management system.
  - **Prototype Design Pattern**: Implemented in `Course` to allow the cloning of courses into different sections.
  - **Polymorfizm**:Used in Driver class.
  - **Inheritence**:Used for Factory Pattern.
## Classes

- **Driver**: The main class that initializes the system, creates users (students, instructors, IT workers), and manages the flow of the application.
- **UniversityUserFactory**: Implements the Factory Design Pattern to create students, instructors, and IT workers.
- **UserTypesInTheRegistrationSystem**: An abstract class that defines the common properties of all users (students, instructors, and IT workers).
- **Student**: A class that represents a student. It handles student-specific actions such as enrolling in courses and checking probation status.
- **Instructor**: A class that represents an instructor. It manages courses and students enrolled in the instructor's courses.
- **ITWorker**: A class that represents an IT worker. It manages the creation and cloning of courses.
- **CourseManager**: A singleton class that manages all courses and ensures that courses are uniquely identified by name and section.
- **Course**: A class that represents a course, including attributes like course name, instructor, and list of enrolled students. It supports cloning for new sections.

## Usage

- Create students, instructors, and IT workers using the `UniversityUserFactory`.
- Manage course enrollment and cloning using the `ITWorker`.
- Run the `Driver` class to simulate a complete course registration workflow.

## Future Enhancements

- Add database integration to persist student and course data.
- Implement a graphical user interface (GUI) for easier interaction.
- Extend the system to allow for course prerequisites and scheduling conflicts.
