# Session 5: Maven

### Local Maven Repositories
Default path
```commandline
users/akash/.m2/repositories
```
Here maven repositories are stored 
( all dependencies are stored here, then it is linked to our project)

### Corporate Repositories 
Also known as remote repository
As companies have diff repo than maven that we use for local our dependants will be downloaded from that location

corporate repo/ Repositories

------------------

## Build Life Cycle
Maven build FifeCycle has following stages:
1. Validate 
2. Compile 
3. Test 
4. Package
   * Resources (img,jsom, yml)
5. Deploy

validate pom.xml, copy resources, compile main java, copy test resources, compile test java,
run tests, create jar

## Different Stages in Maven Build Lifecycle:

✅ validate Phase
Purpose: Basic project validation.

What happens:

Ensures pom.xml is valid.

Ensures directories exist.

Not much processing happens here — resources are not validated or compiled here.

✅ compile Phase
Purpose: Compile the main source code (src/main/java).

What happens:

Resources are copied from src/main/resources to target/classes.

Java code is compiled from src/main/java to .class files in target/classes.

So, resources are handled and compiled during the compile phase, not validate.

🛠 How Maven Does It
The resource copying is handled by:

bash
Copy
Edit
maven-resources-plugin:resources
The compilation is handled by:

bash
Copy
Edit
maven-compiler-plugin:compile
These plugins are bound to the default lifecycle phases automatically.