# ToDo.web
### any task any time

## Overview

It is a Java based web app developed on [**MVC Architecture**](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller). In this app main focus is on **user authentication**(and also basic security). Theme is a basic ToDOList, Hence a user can add some daily tasks with date and time. To run above project just follow the steps given in [Local setup](#local-setup). A demo of the project is [here](#demo).

## Technologies used

- Backend: JSP and Servlet
- Frontend: HTML and CSS
- Database: MySQL
- Server: Apache Tomcat

## Dependencies

1. [JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) or any other IDE
3. [MySQL](https://www.mysql.com/downloads/)
4. [JDBC connector](https://dev.mysql.com/downloads/connector/j/5.1.html)
5. [Apache Tomcat](https://tomcat.apache.org/download-80.cgi)

## Setup database schema

1. make a user named "toDoAdmin" and set password "toDoAdmin".
2. make a database named "toDoDatabase".
3. give all priveleges of this database to that user.
4. make a table "user ( email varchar(40), password(40) )".

**_Note:_**_you can also set database name, username, and password of your choice, just edit database name(line-13), username(line-14), and password(line-15) in [itemDbUtil](https://github.com/Sheldon1999/ToDoList/blob/master/src/com/toDoList/itemDbUtil.java)._

## Local setup

**_Note:_**_Do not install all of above dependencies._

Follow the steps below to run project in your local machine:
1. download and install MySQL.
2. setup database schema as mentioned.
3. download and install the [apache tomcat](https://tomcat.apache.org/download-80.cgi).
4. download [ToDoList.war](https://github.com/Sheldon1999/ToDoList/blob/master/ToDoList.war)
3. put it inside webapps folder given in directory where tomcat is installed.
4. run tomcat.
5. in browser run [http://localhost:8080/ToDoList/](http://localhost:8080/ToDoList/).

## Demo

- **welcome page**

![welcomPage](https://github.com/Sheldon1999/ToDoList/blob/master/welcome.png)

- **log in**

user can log in in app but only after he has signed in before. Demo video can be found be [here](https://drive.google.com/file/d/1q4gP3BiGupv8xoGkV9W6M4_dVytMRKjx/view?usp=sharing).

- **Sign up**

user can sign-up into the system and add tasks to his list. Demo is [here](https://drive.google.com/file/d/199TxxodMJT3xm1KPUo2T6YtuR05MOi_E/view?usp=sharing).

- **Additional**

if user is already login than home page can be accessed directly. Demo is [here](https://drive.google.com/file/d/1dQeYRDZhI_SI65dpxobcwOpfU8QuFuu4/view?usp=sharing).
