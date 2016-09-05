File Scanner
=============

Command line application that scans file tree given a starting directory and reports stats thereof

# To setup in IntelliJ:
1. In mac terminal, navigate to your git directory and enter 'git clone https://github.com/mmyrland/file-scanner.git'

2. Open Intellij and close all projects

3. Select “Import Project”

4. Select the 'build.gradle' under the 'file-scanner' directory you just cloned

5. In the resulting dialog, check the following boxes/radio buttons:
     * Use Auto Import
     * Create directories automatically
     * Select “Use default grade wrapper (recommended)”

6. Ensure your Gradle JVM is pointed to your 1.8 directory

7. Hit OK and get to work.

## To build the application:
* From the root directory, run `./gradlew build` (for Unix systems) or `gradlew.bat build` (for Windows systems)


## To run the application:
* from project directory, run `./gradlew build jar`
* then run `java -jar build/libs/swiffer-service.jar and pass it a directory string as an argument`