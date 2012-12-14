Gradle Setup
------------

1.Download the gradle jar and set up the environment variable for gradle.
         
springMVCGradle Setup
---------------------
1. Check out the project from:

    	https://github.com/anthonywoodard/postal.git

2. On the commandline, change the directory to springMVCGradle
		
3. Make sure that the folder structure should be like the following:

	src/main/java
	src/main/webapp/

	Note: All the config files and the views must be under src/main/webapp/WEB-INF

Build the application:
------------------------
1. Run the following commands from the command line/terminal:
   
   a. gradle build
   b. gradle eclipse

   'war' file is generated under build/libs/postal.war
   
2. Copy the war file from build/libs/postal.war to your application server

Start the server and access the application using:
----------------------------

View:

http://localhost:8080/postal/
