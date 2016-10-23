# Console Painting Program
_Author: Kyle Binns_

A simple console version of a painting program

This program uses Gradle to compile, run tests and execute. The gradlew command should automatically use the Gradle Wrapper to execute, so you will not need to manually download Gradle if you do not have in already installed.

System dependencies: JDK 8

Assemble (assembles all the outputs of the project):
```
./gradlew assemble
```

Build (assembles and tests project - report is generated in the ./build/reports directory):
```
./gradlew build
```

Run (runs the application as a JVM application):
```
./gradlew run -q
```
Note: the -q switch is important if you plan to run this using Gradle. It suppresses the Gradle output and allows for proper user input and output.

If the gradlew command is unable to be executed, please make sure you modify it's permissions using chmod
