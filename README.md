# Console Painting Program
# Author: Kyle Binns
A simple console version of a painting problem

This program uses Gradle to compile, run tests and execute. The gradlew command should automatically use the Gradle Wrapper to execute, so you will not need to manually download Gradle if you do not have in already installed.

System dependencies: JDK

Compile:
```
./gradlew assemble
```

Run all the unit tests (report is generated in the ./build/reports directory):
```
./gradlew build
```

Run:
```
./gradlew run -q
```
Note: the -q switch is important if you plan to run this using Gradle. It suppresses the Gradle output and allows for proper user input and output.

If the gradlew command is unable to be executed, please make sure you modify it's permissions.
