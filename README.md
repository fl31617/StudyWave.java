# StudyWave Backend

StudyWave Backend is a REST API for a student study management application. It lets students manage their subjects, exams, tasks, study sessions, and notifications. The project is built with Spring Boot and MySQL and is designed to be run locally and tested with common tools like IntelliJ, Postman, and XAMPP.

---

## Technologies Used

The project uses **Java 21** and **Spring Boot 4.0.1**. The main dependencies are Spring Web (for the REST API), Spring Data JPA (for database access), and the MySQL connector. The build is handled by **Gradle**. The database is **MySQL**, and the schema is managed by Hibernate (e.g. `ddl-auto=update` in application.properties).

---

## Tools

- **IntelliJ IDEA** — recommended IDE for opening the project and running the application.
- **Postman** — for calling the API endpoints (GET, POST, PUT, DELETE) and testing request bodies.
- **XAMPP** — to run MySQL on your machine (or you can use a standalone MySQL installation).
- **phpMyAdmin** — to create the database, inspect tables, and run SQL (often used together with XAMPP).

---

## Setup

First, make sure MySQL is running (for example, start the MySQL module in XAMPP). Then create a database named **studywave**. You can do this in phpMyAdmin by creating a new database with that name, or by running something like `CREATE DATABASE studywave;` in MySQL.

Next, configure the application. Open `src/main/resources/application.properties` and set the MySQL password. You can either set `spring.datasource.password=YOUR_PASSWORD` in the file or use the environment variable `SPRING_DATASOURCE_PASSWORD`. The app is configured to run on port **8081** and to connect to `localhost:3306/studywave`.

To run the application, use the Gradle wrapper from the project root: `./gradlew bootRun`. Alternatively, open the project in IntelliJ and run the main class `DemoApplication`. Once it starts, the API is available at **http://localhost:8081**.

---

## API Endpoints

The API is organized by resource. All endpoints use the base URL **http://localhost:8081**.

**Student**

- GET `/hello` — returns a simple hello message.
- GET `/students` — returns the list of all students.
- GET `/student/{id}` — returns one student by ID.
- POST `/students` — creates a new student (send name and email in the JSON body).
- PUT `/student/{id}` — updates a student (e.g. email) by ID.
- DELETE `/student/{id}` — deletes a student by ID.

**Subject**

- GET `/subjects` — returns all subjects.
- POST `/subjects` — creates a new subject (send name and studentId in the body).

**Exam**

- GET `/exams` — returns all exams.
- POST `/exams` — creates a new exam (send title, examDate, studentId, and subjectId in the body).

**Task**

- GET `/tasks` — returns all tasks.
- POST `/tasks` — creates a new task (send description and studentId in the body).
- PUT `/task/{id}/complete` — marks the task with the given ID as completed.

**Study Session**

- GET `/study-sessions` — returns all study sessions.
- POST `/study-sessions` — creates a new study session (send date, durationMinutes, studentId, and subjectId in the body).

**Notification**

- GET `/notifications` — returns all notifications.
- POST `/notifications` — creates a new notification (send message, studentId, and optionally examId in the body).
- PUT `/notification/{id}/seen` — marks the notification with the given ID as seen.

When testing with Postman, use **Content-Type: application/json** for POST and PUT requests and send the fields mentioned above in the request body (e.g. for a student: `"name"` and `"email"`; for dates use format like `"YYYY-MM-DD"`).

---

## Entities

The application has six main entities, each mapped to a table in MySQL.

**Student** — Represents a user. It has an id (auto-generated), name, and email. A student can have many subjects, tasks, study sessions, and notifications.

**Subject** — Represents a subject (e.g. a course). It has an id and a name and belongs to one student. A subject can have many exams.

**Exam** — Represents an exam. It has an id, title, and exam date. It belongs to one student and one subject and can have many notifications (e.g. reminders).

**Task** — Represents a to-do item. It has an id, a description, and a completed flag. It belongs to one student.

**StudySession** — Represents a study session. It has an id, a date, and a duration in minutes. It belongs to one student and one subject.

**Notification** — Represents a notification (e.g. exam reminder). It has an id, a message, and a seen flag. It belongs to one student and optionally to one exam.

The tables created by Hibernate are named: student, subject, exam, task, study_session, notification.

---

## Controllers, Repositories, and Services

**Controllers** — There are six REST controllers in the package `com.example.demo.controller`: StudentController, SubjectController, ExamController, TaskController, StudySessionController, and NotificationController. Each one exposes the endpoints described above for its resource.

**Repositories** — There are six JPA repositories in `com.example.demo.repository`: StudentRepository, SubjectRepository, ExamRepository, TaskRepository, StudySessionRepository, and NotificationRepository. They extend Spring’s CrudRepository and provide methods like findAll() and findById (or findStudentById for students). The controllers use these repositories to read and save data.

**Services** — The project also has a service layer in `com.example.demo.service`. There are six interfaces (StudentService, SubjectService, ExamService, TaskService, StudySessionService, NotificationService) and their implementations (DefaultStudentService, DefaultSubjectService, and so on). These can be used for business logic and are used in tests; the controllers in this version talk to the repositories directly.

---

## DTOs (Request Objects)

The request bodies for creating or updating resources use simple DTO classes in `com.example.demo.pojo.dto`. For example: CreateStudentRequest (name, email), UpdateStudentRequest (email), CreateSubjectRequest (name, studentId), CreateExamRequest (title, examDate, studentId, subjectId), CreateTaskRequest (description, studentId), CreateStudySessionRequest (date, durationMinutes, studentId, subjectId), and CreateNotificationRequest (message, studentId, examId). When you send JSON in Postman, you use these field names so the API can map them correctly.

---

## Project Structure

The main code lives under `src/main/java/com/example/demo/`. You will find the main class DemoApplication, the six controllers in the controller package, the six entities in pojo/entity, the request DTOs in pojo/dto, the six repositories in the repository package, and the service interfaces and their default implementations in the service package. Configuration is in `src/main/resources/application.properties`.

---

## Authors

Fidane Latifi
Fatime Jusufi

---

## Conclusion

StudyWave Backend is REST API that helps students organize their studies through subjects, exams, tasks, study sessions, and notifications. It uses Spring Boot and MySQL and can be set up quickly with XAMPP and phpMyAdmin. You can develop and run it in IntelliJ and test all endpoints with Postman. This README gives an overview of technologies, tools, setup, endpoints, entities, and the main packages without going into heavy detail so you can get the API running and understand its structure in a straightforward way.
