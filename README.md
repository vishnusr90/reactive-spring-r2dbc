# reactive-spring-r2dbc

## Sample project using java, r2dbc and spring boot

Hit GET http://localhost:8080/api/tasks

The response will be returned in real time without  any blocking

### Set up of local MariaDB 

Start MariaDB 
````
 mysqld
````

Login
````
 mysql -u root -p
````
Create database
````
 CREATE DATABASE todo_db DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
````

Create user and grant privileges
````
 CREATE USER react@'%' IDENTIFIED BY 'pass';
 GRANT ALL PRIVILEGES ON todo_db.* TO 'react'@'%' WITH GRANT OPTION;
