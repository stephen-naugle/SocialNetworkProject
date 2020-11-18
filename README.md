Sticky Social Network (Backend)
===============================

Sticky is a social network we developed to connect individuals within a centralized webapp.

This is the repository for our custom backend API, developed in conjunction with the React application (link towards the bottom of this document).

Features
-------------------------------

 - Secure Password Encrryption
 - Spring ORM Database Connectivity
 - Over 60% Tested Code Coverage
 - Create posts visible to all other users, Share images, customize your profile, and more

Intructions To Run
-------------------------------

 1. Download files from repository.
 2. From a command line in the current directory, do `mvn clean install` in order to build the project.
 3. From there, the application can be run on a Server (in our case, we utilized a simple tomcat server which was configured with the project in Eclipse).
 4. Additionally, the user can connect a custom database configuration by altering the connection tags within src/main/resources/config.xml.
 
 Features We Would Like To Add
 ------------------------------
  - Additional security measures beyond simple MD5 hashing
  - (For the front end) Better Styling and more user-friendly feedback on inputs.
  - Faster load times via reconfiguring of Availability Zone hosting.
 
 

 [Repository for Front End of Sticky](https://github.com/BenderPaul/Project2FrontEnd)
 ------------------------------------------------------------
 
