CREATE DATABASE university_management;
USE university_management;

CREATE TABLE login (
	username VARCHAR(25) NOT NULL UNIQUE,
    password VARCHAR(25) NOT NULL
);

CREATE TABLE student (
	Roll_no VARCHAR(10) NOT NULL UNIQUE,
    First_name VARCHAR(15) NOT NULL,
    Last_name  VARCHAR(15),
    Father_name VARCHAR(25),
    Date_of_birth DATE,
    Phone_number VARCHAR(15),
    Email VARCHAR(30),
    Address VARCHAR(75),
    Class_10 VARCHAR(5),
    Class_12 VARCHAR(5),
    Degree VARCHAR(10),
    Branch VARCHAR(50),
    aadhar VARCHAR(15),
    password VARCHAR(25),
    PRIMARY KEY(Roll_no)
);

CREATE TABLE teacher(
	Faculty_ID VARCHAR(10) NOT NULL UNIQUE,
    First_name VARCHAR(15) NOT NULL,
    Last_name  VARCHAR(15),
    Father_name VARCHAR(25),
    Date_of_birth DATE,
    Phone_number VARCHAR(15),
    Email VARCHAR(30),
    Address VARCHAR(75),
    Department VARCHAR(50),
    Course VARCHAR(20),
    Maritial_status VARCHAR(20),
    aadhar VARCHAR(15),
	password VARCHAR(25),
    PRIMARY KEY(Faculty_ID)
);

CREATE TABLE subject (
	subcode VARCHAR(10),
    Name VARCHAR(75)
);


CREATE TABLE student_attendance(
	Roll_no VARCHAR(25),
    subcode VARCHAR(10),
	DATE VARCHAR(30),
    P_A VARCHAR(10)
);


CREATE TABLE marks(
	Roll_no VARCHAR(10),
    subcode VARCHAR(10),
    semester VARCHAR(10),
	marks_scored DECIMAL(5,2),
	total_marks INT,
	percentage DECIMAL(5,2)
);

CREATE TABLE fee(
	Roll_no VARCHAR(10),
    First_name VARCHAR(15),
    Last_name  VARCHAR(15),
    Semester VARCHAR(10),
    Amount_Paid DECIMAL(8,2)
);

INSERT INTO login VALUES('admin','admin');





