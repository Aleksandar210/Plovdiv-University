-- create database KinderGardenFmi;
use  KinderGardenFmi;

-- Addresses DDL
-- ------------------------------------------------
-- ------------------------------------------------

create table Addresses(
id integer,
city_name varchar(90),
postal_code integer,
street_name varchar(90),
street_number integer,
constraint pk_addresses primary key(id)
);


create table Users(
user_id int auto_increment,
user_name varchar(60),
email varchar(100),
user_password varchar(100),
constraint pk_users primary key(user_id)
);

-- ------------------------------------------------
-- ------------------------------------------------
create table Parents(
parent_id int,
user_name varchar(60),
email varchar(100),
user_password varchar(100),
date_of_birth date,
phone char(13),
first_name varchar(60),
last_name varchar(60),
egn char(10),
age tinyint,
gender char(1),
date_of_join date, 
address_id int,
current_status enum('active', 'vacation', 'non_active'),
constraint pk_parents primary key(parent_id),
constraint fk_parents_addresses foreign key(address_id) references Addresses(id)
);

create table Students(
student_id int,
user_name varchar(60),
email varchar(100),
user_password varchar(100),
date_of_birth date,
phone char(13),
first_name varchar(60),
last_name varchar(60),
egn char(10),
age tinyint,
gender char(1),
parent_id int,
date_of_join date, 
address_id int,
current_status enum('active', 'sick_leave', 'vacation', 'non_active'),
constraint pk_students primary key (student_id),
constraint fk_students_parents foreign key(parent_id) references parents(parent_id),
constraint fk_students_addresses foreign key(address_id) references Addresses(id)
);

-- TODO MAKE FOR ATTENDECES AND MORE pls
create table Attendences(
attendence_id int auto_increment,
attendence_date date,
student_id int,
attendence_status enum('attendent', 'non_attendent'),
remarks varchar(1000),
constraint pk_attendences primary key(attendence_id),
constraint fk_attendences_students foreign key(student_id) references Students(student_id)
);

create table Teachers(
teacher_id int,
user_name varchar(60),
email varchar(100),
user_password varchar(100),
date_of_birth date,
phone char(13),
first_name varchar(60),
last_name varchar(60),
egn char(10),
age tinyint,
gender char(1),
date_of_join date, 
address_id int,
current_status enum('sick_leave', 'vacation', 'on_work'),
constraint pk_teachers primary key (teacher_id),
constraint fk_teacher_addresses foreign key(address_id) references Addresses(id)
);

-- Courses DDL
-- ------------------------------------------------
-- ------------------------------------------------
create table Courses(
course_id int,
course_name varchar(90),
course_description varchar(1000),
constraint pk_courses primary key(course_id)
);

create table Classrooms(
classroom_id int auto_increment,
classroom_year smallint,
course_id int,
classroom_status enum('active', 'non_active'),
teacher_id int,
constraint pk_classrooms primary key(classroom_id),
constraint fk_classrooms_courses foreign key(course_id) references Courses(course_id),
constraint fk_classrooms_teachers foreign key(teacher_id) references Teachers(teacher_id)
);

-- Exam Types DDL and DML 
-- ------------------------------------------------
-- ------------------------------------------------
create table Exam_Types(
exam_type_id int auto_increment,
exam_type_name varchar(90),
exam_type_description varchar(1000),
constraint pk_exam_types primary key(exam_type_id)
);

create table Exams(
exam_id int auto_increment,
exam_type_id int, 
exam_name varchar(90),
start_date date,
constraint pk_exams primary key(exam_id),
constraint fk_exams_exam_types foreign key(exam_type_id) references Exam_Types(exam_type_id)
);

create table Exam_Results(
exam_results_id int auto_increment,
exam_id int,
student_id int, 
course_id int,
grade tinyint,
remarks varchar(1000),
constraint pk_exam_results primary key(exam_results_id),
constraint fk_exam_results_exams foreign key(exam_id) references Exams(exam_id),
constraint fk_exam_results_students foreign key(student_id) references Students(student_id),
constraint fk_exam_results_courses foreign key (course_id) references Courses(course_id)
);

-- -----------------------------------------------------------------------------------------
-- TODO Add AddressID's to Teachers, Parents and Students where the Parent and Students that are related have to have the same AddressID
-- Deletions and Rollback to original state
-- -----------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------


commit;
-- -----------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------