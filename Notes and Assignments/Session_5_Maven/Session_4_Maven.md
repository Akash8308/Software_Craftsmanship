# Session 5: Maven
## Class Notes
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

validate pom.xml > copy resources, compile main java, copy test resources > compile test java,
run tests, create jar

----------------------
# Assignment
## ✅ Default Maven Lifecycle Phases

| Phase                      | Description |
|----------------------------|-------------|
| **validate**               | Validates the project is correct and all necessary info is available |
| **initialize**             | Initializes build state (e.g., create directories, set properties) |
| **generate-sources**       | Generates any source code needed for compilation |
| **process-sources**        | Processes source files (e.g., filtering) |
| **generate-resources**     | Generates resources (non-Java files) to include in the JAR/WAR |
| **process-resources**      | Copies and processes resources to `target/classes` |
| **compile**                | Compiles Java source code (`src/main/java`) |
| **process-classes**        | Post-processing on compiled classes (e.g., bytecode enhancement) |
| **generate-test-sources**  | Generates test source code |
| **process-test-sources**   | Processes test source files |
| **generate-test-resources**| Generates resources for testing |
| **process-test-resources** | Copies and processes test resources to `target/test-classes` |
| **test-compile**           | Compiles test source code (`src/test/java`) |
| **test**                   | Runs unit tests using a test framework (e.g., JUnit) |
| **prepare-package**        | Prepares for packaging (e.g., code obfuscation, etc.) |
| **package**                | Packages the compiled code (e.g., into a JAR, WAR) |
| **pre-integration-test**   | Setup before integration tests |
| **integration-test**       | Runs integration tests |
| **post-integration-test**  | Clean up after integration tests |
| **verify**                 | Verifies the project meets quality criteria |
| **install**                | Installs the package into the local Maven repository (`~/.m2`) |
| **deploy**                 | Deploys the final artifact to a remote repository |
