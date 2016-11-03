Assignment 1.2 
This is sample java web application that exercises the Request-Reply Communication Paradigm.
In order to build and deploy the application on your local machine you need to have the following:
- Apache Tomcat 8.0.
- MySQL Server
- Maven build automation tool

I you have done the previous steps you should:
- start MySql server and run the script (located in /resources/mysql-database folder) to create a the database used by this application
- run "mvn clean install" (Maven commands) in a terminal opened in the project's folder; the result will be a target folder wich contains .war application. 
- copy the .war file from target folder to webapp (webapp folder is located on your Apache Tomcat installation directory);
- run tomcat server
- open chrome browser and write "www.localhost:8080/'name of .war file" and navigate in the application using credentials (username:admin, password:admin)