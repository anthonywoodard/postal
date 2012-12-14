springMVCMaven
--------------
springMVCMaven uses a number of open source projects to work properly:

*   jQuery + [requireJS] [(AMD)] - JavaScript library and module loader
*   Maven - a software project management and comprehension tool
*   Spring Web MVC framework - a model-view-controller framework
*   SQLite - a software library that implements a SQL database engine
    
Setup
---------------------
These instructions assume you are using the Apache Tomcat web server and have Maven installed

1. Check out the project from:

        https://github.com/anthonywoodard/postal.git

2. On the commandline, change the directory to springMVCMaven
		
3. The folder structure should be like the following:

        - pom.xml
        - src/main/java
        - src/main/resources
        - src/main/webapp/
        - src/test/java
        - src/test/resources
    
4. Run the following command from the command line/terminal:
    
        mvn clean tomcat:run
   
View:
-----
http://localhost:8080/postal/
    