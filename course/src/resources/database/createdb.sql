DROP SEQUENCE HIBERNATE_SEQUENCE;
DROP TABLE JOURNAL;
DROP TABLE STUDENT_COURSE;
DROP TABLE COURSES;
DROP TABLE STUDENTS;
DROP TABLE ADMINS;
DROP TABLE LECTURERS;
DROP TABLE STATUSES;
DROP TABLE THEMES;
DROP TABLE USERS;
DROP TABLE STATES;
DROP TABLE ROLES;

CREATE TABLE ROLES (
  id_role   INT PRIMARY KEY,
  name_role VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE STATES (
  id_state   INT PRIMARY KEY,
  name_state VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE USERS (
  id_user  INT PRIMARY KEY,
  login    VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(40) NOT NULL,
  email    VARCHAR(70),
  id_role  INT REFERENCES ROLES (id_role),
  id_state INT REFERENCES STATES (id_state)
);

CREATE TABLE THEMES (
  id_theme   INT PRIMARY KEY,
  name_theme VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE STATUSES (
  id_status   INT PRIMARY KEY,
  name_status VARCHAR(25) NOT NULL UNIQUE
);

CREATE TABLE LECTURERS (
  id         INT PRIMARY KEY,
  surname    VARCHAR(30) NOT NULL,
  name       VARCHAR(30) NOT NULL,
  patronymic VARCHAR(50),
  id_user    INT REFERENCES USERS (id_user) ON DELETE CASCADE
);

CREATE TABLE ADMINS (
  id         INT PRIMARY KEY,
  surname    VARCHAR(30) NOT NULL,
  name       VARCHAR(30) NOT NULL,
  patronymic VARCHAR(50),
  id_user    INT REFERENCES USERS (id_user) ON DELETE CASCADE
);

CREATE TABLE STUDENTS (
  id         INT PRIMARY KEY,
  surname    VARCHAR(30) NOT NULL,
  name       VARCHAR(30) NOT NULL,
  patronymic VARCHAR(50),
  id_user    INT REFERENCES USERS (id_user) ON DELETE CASCADE
);

CREATE TABLE COURSES (
  id_course   INT PRIMARY KEY,
  name_course VARCHAR(40) NOT NULL UNIQUE,
  start_date  DATE,
  end_date    DATE,
  price       INT,
  id_theme    INT REFERENCES THEMES (id_theme) ON DELETE CASCADE NOT NULL,
  id_lecturer INT REFERENCES LECTURERS (id) ON DELETE CASCADE NOT NULL,
  id_status   INT REFERENCES STATUSES (id_status) ON DELETE CASCADE NOT NULL
);

CREATE TABLE STUDENT_COURSE (
  id_student_course INT PRIMARY KEY,
  id_student        INT REFERENCES STUDENTS (id) ON DELETE CASCADE,
  id_course         INT REFERENCES COURSES (id_course) ON DELETE CASCADE
);

CREATE TABLE JOURNAL (
  id_student_course INT PRIMARY KEY REFERENCES STUDENT_COURSE (id_student_course) ON DELETE CASCADE,
  mark              INT NOT NULL
);

/*==================================================INSERT QUERIES==================================================*/

create or REPLACE VIEW lecturer_view as
  select STUDENTS.id_user, name_course, STUDENTS.surname, STUDENTS.name, STUDENTS.patronymic, LECTURERS.id_user as lecturer_id_user from LECTURERS
    INNER JOIN COURSES ON LECTURERS.id = COURSES.id_lecturer
    INNER JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course
    INNER JOIN STUDENTS ON STUDENT_COURSE.id_student = STUDENTS.id where id_status=2;

CREATE SEQUENCE hibernate_sequence
START WITH     1
INCREMENT BY   1
NOCACHE NOCYCLE;

SELECT * FROM MARKS_VIEW;

CREATE OR REPLACE VIEW MARKS_VIEW AS
  SELECT LECTURERS.id_user, name_course, start_date, end_date, STUDENTS.surname, STUDENTS.name, STUDENTS.patronymic, mark FROM LECTURERS
    INNER JOIN COURSES ON LECTURERS.id = COURSES.id_lecturer
    INNER JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course
    INNER JOIN JOURNAL ON STUDENT_COURSE.id_student_course = JOURNAL.id_student_course
    INNER JOIN STUDENTS ON STUDENT_COURSE.id_student = STUDENTS.id
  WHERE id_status=4;

select * from Marks_View where id_user=9;

CREATE OR REPLACE VIEW journal_view AS
  SELECT JOURNAL.id_student_course, id_course, id_student, mark from JOURNAL INNER JOIN STUDENT_COURSE ON JOURNAL.id_student_course = STUDENT_COURSE.id_student_course;

BEGIN
  INSERT INTO ROLES VALUES (0, 'Admin');
  INSERT INTO ROLES VALUES (1, 'Student');
  INSERT INTO ROLES VALUES (2, 'Lecturer');

  INSERT INTO STATES VALUES (0, 'locked');
  INSERT INTO STATES VALUES (1, 'unlocked');

  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'root', 'root', 'serhii.tatarinov@nure.ua', 0, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'student', 'student', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'lecturer', 'lecturer', NULL, 2, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'admin', 'admin', NULL, 0, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'qwerty', 'qwerty', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'teststudent', 'teststudent', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'testlecturer', 'testlecturer', NULL, 2, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, '123456', '123456', NULL, 1, 0);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'temp', 'temp', NULL, 2, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'dmitry', 'dmitry', NULL, 2, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'qadev', 'qadev', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'sharpbest', 'sharpbest', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'jslife', 'jslife', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'football', 'football', NULL, 2, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'sokol', 'sokol', NULL, 1, 1);
  INSERT INTO USERS VALUES (hibernate_sequence.nextval, 'nika', 'nika', NULL, 1, 1);

  INSERT INTO STATUSES VALUES (1, 'Opened');
  INSERT INTO STATUSES VALUES (2, 'In progress');
  INSERT INTO STATUSES VALUES (3, 'Closed');
  INSERT INTO STATUSES VALUES (4, 'Finished');

  INSERT INTO THEMES VALUES (1, 'Java developing');
  INSERT INTO THEMES VALUES (2, '.Net developing');
  INSERT INTO THEMES VALUES (3, 'Web developing');

  INSERT INTO LECTURERS VALUES (1, 'Kolesnikov', 'Dmitry', 'Olegovich', 10);
  INSERT INTO LECTURERS VALUES (2, 'Мищеряков', 'Юрий', 'Валентинович', 9);
  INSERT INTO LECTURERS VALUES (3, 'Ivanov', 'Ivan', 'Ivanovich', 7);
  INSERT INTO LECTURERS VALUES (4, 'Petrov', 'Petr', 'Petrovich', 3);
  INSERT INTO LECTURERS VALUES (5, 'Адаменко', 'Евгений', 'Игоревич', 14);

  INSERT INTO ADMINS VALUES (1, 'Татаринов', 'Сергей', 'Вячеславович', 1);
  INSERT INTO ADMINS VALUES (2, 'Админов', 'Админ', 'Админович', 4);

  INSERT INTO STUDENTS VALUES (1, 'Шендрик', 'Алексей', '', 11);
  INSERT INTO STUDENTS VALUES (2, 'Pischoha', 'Konstantin', 'Sergeevich', 2);
  INSERT INTO STUDENTS VALUES (3, 'Shylo', 'Rodion', '', 6);
  INSERT INTO STUDENTS VALUES (4, 'Radchenko', 'Vadim', '', 5);
  INSERT INTO STUDENTS VALUES (5, 'Serenko', 'Ivan', '', 8);
  INSERT INTO STUDENTS VALUES (6, 'Мирошниченко', 'Егор', '', 12);
  INSERT INTO STUDENTS VALUES (7, 'Кругликов', 'Данил', '', 13);
  INSERT INTO STUDENTS VALUES (8, 'Соколов', 'Дмитрий', 'Сергеевич', 15);
  INSERT INTO STUDENTS VALUES (9, 'Перцева', 'Вероника', 'Ильинична', 16);

  /*id_course name_course duration start_month, start_year id_theme id_lecutrer id_status*/
  INSERT INTO COURSES VALUES (1, 'Java Web developing',   TO_DATE('04-01-2016', 'DD-MM-YYYY'), TO_DATE('28-03-2016', 'DD-MM-YYYY'), 10000, 1, 1, 1);
  INSERT INTO COURSES VALUES (2, 'C# developing',         TO_DATE('11-01-2016', 'DD-MM-YYYY'), TO_DATE('04-04-2016', 'DD-MM-YYYY'), 9500,  2, 2, 1);
  INSERT INTO COURSES VALUES (3, 'ASP.Net',               TO_DATE('18-01-2016', 'DD-MM-YYYY'), TO_DATE('11-04-2016', 'DD-MM-YYYY'), 9000,  2, 3, 2);
  INSERT INTO COURSES VALUES (4, 'JavaScript developing', TO_DATE('25-01-2016', 'DD-MM-YYYY'), TO_DATE('18-04-2016', 'DD-MM-YYYY'), 9750,  3, 3, 3);
  INSERT INTO COURSES VALUES (5, 'HTML+CSS developing',   TO_DATE('01-02-2016', 'DD-MM-YYYY'), TO_DATE('25-04-2016', 'DD-MM-YYYY'), 8000,  3, 3, 1);
  INSERT INTO COURSES VALUES (6, 'Python developing',     TO_DATE('08-02-2016', 'DD-MM-YYYY'), TO_DATE('02-05-2016', 'DD-MM-YYYY'), 9250,  3, 2, 4);
  INSERT INTO COURSES VALUES (7, 'QA testing',            TO_DATE('15-02-2016', 'DD-MM-YYYY'), TO_DATE('09-05-2016', 'DD-MM-YYYY'), 10500, 3, 1, 4);
  INSERT INTO COURSES VALUES (8, 'PHP developing',        TO_DATE('22-02-2016', 'DD-MM-YYYY'), TO_DATE('16-03-2016', 'DD-MM-YYYY'), 5500,  3, 1, 3);
  INSERT INTO COURSES VALUES (9, 'Kotlin developing',     TO_DATE('29-02-2016', 'DD-MM-YYYY'), TO_DATE('23-05-2016', 'DD-MM-YYYY'), 3500,  1, 2, 1);
  INSERT INTO COURSES VALUES (10, 'Groovy developing',    TO_DATE('07-03-2018', 'DD-MM-YYYY'), TO_DATE('30-05-2018', 'DD-MM-YYYY'), 6000,  1, 2, 1);
  INSERT INTO COURSES VALUES (11, 'Scala developing',     TO_DATE('14-03-2001', 'DD-MM-YYYY'), TO_DATE('06-06-2016', 'DD-MM-YYYY'), 6500,  1, 5, 2);
  INSERT INTO COURSES VALUES (12, 'Ruby developing',      TO_DATE('21-03-2016', 'DD-MM-YYYY'), TO_DATE('13-06-2017', 'DD-MM-YYYY'), 8000,  3, 5, 1);

  INSERT INTO STUDENT_COURSE VALUES (1, 2, 1);
  INSERT INTO STUDENT_COURSE VALUES (2, 3, 1);
  INSERT INTO STUDENT_COURSE VALUES (3, 5, 1);
  INSERT INTO STUDENT_COURSE VALUES (4, 1, 6);
  INSERT INTO STUDENT_COURSE VALUES (5, 4, 3);
  INSERT INTO STUDENT_COURSE VALUES (6, 6, 2);
  INSERT INTO STUDENT_COURSE VALUES (7, 7, 4);
  INSERT INTO STUDENT_COURSE VALUES (8, 2, 2);
  INSERT INTO STUDENT_COURSE VALUES (9, 2, 6);
  INSERT INTO STUDENT_COURSE VALUES (10, 2, 3);
  INSERT INTO STUDENT_COURSE VALUES (11, 2, 7);
  INSERT INTO STUDENT_COURSE VALUES (12, 1, 7);
  INSERT INTO STUDENT_COURSE VALUES (13, 6, 7);
  INSERT INTO STUDENT_COURSE VALUES (14, 1, 11);
  INSERT INTO STUDENT_COURSE VALUES (15, 1, 12);
  INSERT INTO STUDENT_COURSE VALUES (16, 7, 1);
  INSERT INTO STUDENT_COURSE VALUES (17, 8, 5);
  INSERT INTO STUDENT_COURSE VALUES (18, 9, 2);
  INSERT INTO STUDENT_COURSE VALUES (19, 9, 7);
  INSERT INTO STUDENT_COURSE VALUES (20, 9, 3);
  INSERT INTO STUDENT_COURSE VALUES (21, 9, 5);
  INSERT INTO STUDENT_COURSE VALUES (22, 3, 8);
  INSERT INTO STUDENT_COURSE VALUES (23, 4, 9);
  INSERT INTO STUDENT_COURSE VALUES (24, 5, 10);
  INSERT INTO STUDENT_COURSE VALUES (25, 8, 11);
  INSERT INTO STUDENT_COURSE VALUES (26, 7, 12);
  INSERT INTO STUDENT_COURSE VALUES (27, 2, 11);
  INSERT INTO STUDENT_COURSE VALUES (28, 4, 12);

  INSERT INTO JOURNAL VALUES (4, 75);
  INSERT INTO JOURNAL VALUES (9, 90);
  INSERT INTO JOURNAL VALUES (11, 80);
  INSERT INTO JOURNAL VALUES (12, 95);
  INSERT INTO JOURNAL VALUES (13, 70);
  INSERT INTO JOURNAL VALUES (15, 85);

END;