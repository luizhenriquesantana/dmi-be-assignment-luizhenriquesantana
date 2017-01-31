# dmi-be-assignment-luizhenriquesantana
A project for managing a books collection




1- Import the project to eclipse;
2- Change the connection configurations on the file “hibernate.cfg.xml”
3- Type “Run on Server” (the tomcat is embedded)
4- Call the services like the document specification below:



Server-Side DevelopmentTechnical RequirementsThe server side implementation should be done in J  ava  only. The project should be built with Gradle or Maven and should not contain any 3rd party libraries packed directly into the source code.Would be a big plus if application can start with embedded servlet container or application server. The persistence store of data is your choice but should not require third-party software to be installed. Using Spring Framework is recommended, but you can choose other alternative framework of your choice.Use any relevant frameworks to reduce the amount of code required. Be careful not to over complicate or over “engineer” your solution. However, do think about performance and efficiency.Provide clean code with all comments in it you feel are needed, but at the same time do not overload the code too much.Please submit two artifacts:1. A deployable war file named,  dmi-be-assignment-{your name}.war2. A zip file containing all your source code and build scripts named,dmi-be-assignment-{your name}.zipPlease implement server-side application which exposes REST API. Format of objects for the API should be JSON. Server should log events (incoming requests) using log4j or similar.Functional Requirements (all levels positions)The following functionality should be provided in REST API:● function to get list of books, pagination capability should be injected into the API● function to get book details by its id● API should contain versioningPlease refer to “Appendix B. REST API Specification” as an example.Functional Requirements (Senior level and Solutions Architect positions)For Senior level developer and for Solutions Architect position, in addition please provide the following functionality in REST API:● basic authentication to access API methods (username : usertest, password : secret)● function to add new book, unique id should be assigned to the item on server side● function to update existing book● function to delete existing book● object validation● in the list of objects, items should contain link to item detailsIt’s fully optional but would be a plus to get the code with unit tests for REST API functions.