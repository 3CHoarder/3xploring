# UCBL coding exercise

This small Spring Boot application is basically an starting point of the attempt to retrieve a GitHub user's recent event activities via <a href="https://developer.github.com/v3/activity/events">GitHub Events API</a>.

Its interface is simple. It has only one page, with a text field for inputting a GitHub user and a "Get Events" button to trigger jQuery AJAX
to fetch event information from server in form of Json. The result is displayed in the table within the same page.
 
At server side, there is a service which consumes Json date from GitHub's service and returns simpified processed Json info to the client. 

The application definitely needs refactoring to make it more readable, testable, and scalable. So that we can move forward with development of a production web service. 

This exercise uses Java 8 and expects that the system will have its JAVA_HOME environment variable set. It includes a Maven wrapper, 
so you do not need to have Maven installed on your system to run it:
1. on command line prompt, move to the application directory.
2. a. on Unix/Linx environment, run "start"<br/>
   b. on Windows environment, run "mvnw clean spring-boot:run"


