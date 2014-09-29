nodeAngularJS
--------------
nodeAngularJS includes the use of the following projects:

*   Node.js + Express.js - Web server + RESTful API
*   AngularJS - Client side MVC framework
*   Bootstrap - CSS
*   SQLite - a software library that implements a SQL database engine
    
Setup
---------------------
1.  Check out the project from:

        https://github.com/anthonywoodard/postal.git
        
2.  On the commandline, change the directory to nodeAngularJS.
        
3.  If you want to run the local web-server, you will need Node.js v0.10.29+.
    
    You can download a Node.js installer for your operating system from http://nodejs.org/download/.

    Check the version of Node.js that you have installed by running the following command:
    
        node --version
        
4.  Once you have Node.js installed on your machine you can download the tool dependencies by running:
        
        npm install
        
    This command will download the following tools, into the node_modules directory:
    
        *   express
        *   sqlite3
        *   morgan
        *   body-parser
        *   method-override
        
5.  Install the helper tools.
    
    The Bower module is an executable, which can be installed globally and run directly from a terminal/command prompt.

    To install the Bower command line executable you would do:
    
        sudo npm install -g bower
        
    Then you can run the bower tool directly, such as:
    
        bower install
        
    This command will download the following dependencies, into the public/libs directory:
    
        *   angular
        *   angular-resource
        *   angular-route
        *   bootstrap
        *   holderjs
        *   jquery
        
6.  Run the web server.
    
    While Angular applications are purely client-side code, and it is possible to open them in a web browser directly from the file system, it is better to serve them from a HTTP web server. In particular, for security reasons, most modern browsers will not allow JavaScript to make server requests if the page is loaded directly from the file system.

    The nodeAngularJS project is configured with a simple web server for hosting the application during development. Start the web server by running:
    
        node server.js
        
    This will create a local webserver that is listening to port 3000 on your local machine. You can now browse to the application at:
    
        http://localhost:3000
        
