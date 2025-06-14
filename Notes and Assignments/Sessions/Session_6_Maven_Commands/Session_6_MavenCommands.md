# Session 6 : Maven Commands


## maven frequently used commands


1. mvn clean compile --> cleans the target folder and recompile everything
2. mvn clean compile -DskipTests --> cleans the target folder and recompile main classes excluding test
3. mvn clean compile -U --> clean compile, force download dependenciˀes
4. mcn dependency:tree --> list down dependencies as a tree depicting transient dependencies



# dependency divergence solutions:
1. exclude from one dependency
2. add dependency to the project explicitly
3. update one of the divergent dependency to latest version