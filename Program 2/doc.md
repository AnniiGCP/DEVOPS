# Program 2: Maven Quickstart (Windows)

## Step 1: Create Folder

Open Command Prompt:

```bash
mkdir program2
cd program2
```

---

## Step 2: Create Maven Project

```bash
mvn org.apache.maven.plugins:maven-archetype-plugin:3.2.1:generate "-DgroupId=com.example" "-DartifactId=myapp" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

This creates:

```text
program2/
└── myapp/
```

---

## Step 3: Go Inside Project

```bash
cd myapp
```

---

## Step 4: Edit `pom.xml`

Open file:

```bash
notepad pom.xml
```

> **Important**
> - Delete everything inside `pom.xml`
> - Paste the full code below

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://www.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>myapp</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- JUnit Dependency -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Maven Surefire Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <redirectTestOutputToFile>false</redirectTestOutputToFile>
                    <useSystemOut>true</useSystemOut>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

Save and close.

---

## Step 5: Edit Main Java File

Open file:

```bash
notepad src\main\java\com\example\App.java
```

> **Important**
> - Delete everything inside `App.java`
> - Paste:

```java
package com.example;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        int result = app.add(2, 3);
        System.out.println("2 + 3 = " + result);
        System.out.println("Application executed successfully!");
    }
}
```

Save and close.

---

## Step 6: Edit AppTest File

Open file:

```bash
notepad src\test\java\com\example\AppTest.java
```

> **Important**
> - Delete everything inside `AppTest.java`
> - Paste:

```java
package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testAdd() {
        App app = new App();
        int result = app.add(2, 3);
        System.out.println("Running test: 2 + 3 = " + result);
        Assert.assertEquals(5, result);
    }
}
```

Save and close.

---

## Step 7: Compile

```bash
mvn compile
```

---

## Step 8: Run Test

```bash
mvn test
```

Expected output:

```text
Tests run: 1, Failures: 0
```

---

## Step 9: Package

```bash
mvn package
```

Expected output:

```text
BUILD SUCCESS
```

---

## Step 10: Run Application

```bash
java -cp target/myapp-1.0-SNAPSHOT.jar com.example.App
```

Final output:

```text
2 + 3 = 5
Application executed successfully!
```