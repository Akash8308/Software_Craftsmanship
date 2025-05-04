#  Session 4 - Maven
## Assignment
### What is pom
Pom in Maven also known as **Project Object Model** is central configuration file for a project.
Using pom.xml file we can make common configuration file which allows us to set up environment of the project.
It makes it easier for everyone working on the project to configure and code for specified version or dependencies.
Ex: If we use some feature available in later version of java than the version specified in the pom.xml file we will 
get compilation error.
Necessary information to manage our project effectively, from building it to deploying it.

It contains:
* **Project Information** : Project Name, Devs working on it, version and description of he projects. 
* **Dependencies** : Here libraries or frameworks required for our project are specified. For our project to 
function correctly, including their group ID, artifact ID, and version.
* **Build Configuration**: It specifies the build process, including plugins, goals, and how tests should be run.
* **Repositories**: It defines where Maven should look for dependencies, including external or private repositories.
* **Plugins** : It lists plugins that enhance the build process, such as those for code formatting, testing, or deployment.

-------------------------------------------------------------------------------------------------------------------------------------------------------

# Class Notes

**GroupId**: is team name

**artifactId**: is our program name (The name that our application will have once it is built)
version:


<maven.compiler.source>18</maven.compiler.source> -
<maven.compiler.target>17</maven.compiler.target> -
Here target indicates that we are build our program for specified version.
If we have used a feature present in Java 18 and our target version is 17 then
we will get compile error.