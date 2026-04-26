# DevOps Manual

## 3. Working with Gradle: Setting Up a Gradle Project, Understanding Build Scripts (Groovy and Kotlin DSL), Dependency Management and Task Automation

---

## Working with Gradle Project (Groovy DSL):

### 1. Create a new Project

Open command prompt and navigate to the created folder and give the following command to create the gradle project

```bash
gradle init --type java-application
```

Then it will ask some requirements:

* Enter target Java version (min: 7, default: 21): 17

* Project name (default: program3-groovy): groovyProject

* Select application structure:

  * 1: Single application project
  * 2: Application and library project
  * Enter selection (default: Single application project) [1..2] 1

* Select build script DSL:

  * 1: Kotlin
  * 2: Groovy
  * Enter selection (default: Kotlin) [1..2] 2

* Select test framework:

  * 1: JUnit 4
  * 2: TestNG
  * 3: Spock
  * 4: JUnit Jupiter
  * Enter selection (default: JUnit Jupiter) [1..4] 1

* Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no]

  * no

---

### 2. build.gradle (Groovy DSL)

Open the build.gradle file (projectFolder/app/build) and add the following code:

```groovy
plugins {
    id 'application'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.13.2'
}

application {
    mainClass = 'org.example.App'
}

test {
    outputs.upToDateWhen { false }
    testLogging {
        events "passed", "failed", "skipped"
        exceptionFormat "full"
        showStandardStreams = true
    }
}
```

---

### 3. App.java

Open src/main/java/org/example/
Write the below code and save:

```java
package org.example;

public class App {
    public static void main(String[] args) {
        double num1 = 5;
        double num2 = 10;
        double sum = num1 + num2;
        System.out.printf("The sum of %.2f and %.2f is %.2f%n", num1, num2, sum);
    }
}
```

---

### 4. AppTest.java (JUnit Test)

Open src/test/java/org/example/
Write the below code and save:

```java
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAddition() {
        double num1 = 5;
        double num2 = 10;
        double expectedSum = num1 + num2;
        double actualSum = num1 + num2;
        assertEquals(expectedSum, actualSum, 0.01);
    }
}
```

---

### 5. Run Gradle Commands

To build the project execute below command:

```bash
gradle build
```

To run the project execute below command:

```bash
gradle run
```

To test the project execute below command:

```bash
gradle test
```

---

## Working with Gradle Project (Kotlin DSL):

### 1. Create a new Project

```bash
gradle init --type java-application
```

Then it will ask:

* Enter target Java version (min: 7, default: 21): 17

* Project name (default: program3-kotlin): KotlinProject

* Select application structure:

    * 1: Single application project
    * 2: Application and library project
    * Enter selection (default: Single application project) [1..2] 1

* Select build script DSL:

    * 1: Kotlin
    * 2: Groovy
    * Enter selection (default: Kotlin) [1..2] 1

* Select test framework:

    * 1: JUnit 4
    * 2: TestNG
    * 3: Spock
    * 4: JUnit Jupiter
    * Enter selection (default: JUnit Jupiter) [1..4] 1

* Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no]

    * no

---

### 2. build.gradle.kts (Kotlin DSL)

```kotlin
plugins {
    kotlin("jvm") version "1.8.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit:junit:4.13.2")
}

application {
    mainClass.set("org.example.MainKt")
}

tasks.test {
    useJUnit()
    testLogging {
        events("passed", "failed", "skipped")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStandardStreams = true
    }
}
```

---

### 3. Main.kt

Open `src/main/java/org/example/` and **change the file name** `App.java` to `Main.kt`.

Write the below code and save:

```kotlin
package org.example

fun addNumbers(num1: Double, num2: Double): Double {
    return num1 + num2
}

fun main() {
    val num1 = 10.0
    val num2 = 5.0
    val result = addNumbers(num1, num2)
    println("The sum of $num1 and $num2 is: $result")
}
```

---

### 4. MainTest.kt

Open `src/test/java/org/example/` and **change the file name** `AppTest.java` to `MainTest.kt`.

Write the below code and save:

```kotlin
package org.example

import org.junit.Assert.*
import org.junit.Test

class MainTest {
    @Test
    fun testAddNumbers() {
        val num1 = 10.0
        val num2 = 5.0
        val result = addNumbers(num1, num2)
        assertEquals("The sum of $num1 and $num2 should be 15.0", 15.0, result, 0.001)
    }
}
```

---

### 5. Run Gradle Commands

To build the project, execute:

```bash
gradle build
```

To run the project, execute:

```bash
gradle run
```

To test the project, execute:

```bash
gradle test
```
