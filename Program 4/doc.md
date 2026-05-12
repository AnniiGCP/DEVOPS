# DevOps Manual

## Practical 4: Build and Run a Java Application with Maven, then Migrate It to Gradle

---

## Step 1: Create a Maven Project

Run the following command to generate a basic Maven project:

```bash
mvn org.apache.maven.plugins:maven-archetype-plugin:3.2.1:generate "-DgroupId=com.example" "-DartifactId=maven-example" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

---

## Step 2: Update `pom.xml`

Open the `pom.xml` file in the `maven-example` project and replace its content with:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>
  <artifactId>maven-example</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

If needed, use:

```bash
cd maven-example
notepad pom.xml
```

---

## Step 3: Update `App.java`

Open `src/main/java/com/example/App.java` and use:

```java
package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Maven");
        System.out.println("This is a simple real-world example....");

        int a = 5;
        int b = 10;
        System.out.println("Sum of " + a + " and " + b + " is " + sum(a, b));
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}
```

> **Note:** Before building, make sure you are inside the project folder:
>
> ```bash
> cd maven-example
> ```

---

## Step 4: Build and Run with Maven

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn exec:java "-Dexec.mainClass=com.example.App"
```

---

## Step 5: Migrate the Maven Project to Gradle

### 5.1 Initialize Gradle

From the project directory (`maven-example`), run:

```bash
gradle init
```

When prompted, choose:

- **Generate a Gradle build from Maven?** → `yes`
- **Build script DSL** → `2` (Groovy)
- **Generate build using new APIs and behavior?** → `no`

### 5.2 Update `build.gradle`

Open `build.gradle` and use:

```groovy
plugins {
    id 'java'
}

group = 'com.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.12'
}

task run(type: JavaExec) {
    main = 'com.example.App'
    classpath = sourceSets.main.runtimeClasspath
}
```

---

## Step 6: Build and Run with Gradle

Build the project:

```bash
gradlew build
```

Run the application:

```bash
gradlew run
```

---

## Step 7: Verify Migration Output

Both Maven and Gradle should produce the same output:

```text
Hello, Maven
This is a simple real-world example....
Sum of 5 and 10 is 15
```
