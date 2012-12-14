Gradle Setup
------------

1.Download the gradle jar and set up the environment varibable for gradle.
         
FreemarkerSpike Setup
---------------------
1. Check out the project from:

    	https://sjscm01.stjude.org/svn/cris-qa/spikes/ConceptSpikes/FreemarkerSpike
		
2. Make sure that the folder structure should be like the following:

	src/main/java
	src/main/webapp/

	Note: All the config files and the views must be under src/main/webapp/WEB-INF

Build the application:
------------------------
1. Run the following commands from the command line/terminal:
   
   a. gradle build
   b. gradle eclipse

   'war' file is generated under build/libs/FMSpike.war
   
2. Copy the war file from build/libs/FMSpike.war to your jboss server

Start the server and access the application using:
----------------------------

Xml View:

http://localhost:8080/FMSpike/xmlView

Json View:

http://localhost:8080/FMSpike/jsonView/natasha

Html View:

http://localhost:8080/FMSpike/message.html

   	
   