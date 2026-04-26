## 1. Install the Java JDK

If you have not installed the Java JDK yet, download and install it first:

- [Download Java JDK (Oracle)](https://www.oracle.com/java/technologies/javase-downloads.html)

## 2. Maven Setup (Windows)

1. Download Maven:  
    [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

2. Extract it to:

    ```text
    C:\Program Files\Apache\Maven
    ```

3. Set environment variables:

    - `MAVEN_HOME = C:\Program Files\Apache\Maven`
    - Add to `PATH`:
      `C:\Program Files\Apache\Maven\bin`

4. Verify Java installation:

    ```powershell
    java -version
    ```

5. Restart PowerShell and verify Maven:

    ```powershell
    mvn -version
    ```

## 3. Gradle Setup (Windows)

1. Download Gradle:  
    [https://gradle.org/releases/](https://gradle.org/releases/)

2. Extract it to:

    ```text
    C:\Gradle\gradle-8.x
    ```

3. Set environment variables:

    - `GRADLE_HOME = C:\Gradle\gradle-8.x`
    - Add to `PATH`:
      `C:\Gradle\gradle-8.x\bin`

4. Verify Java installation:

    ```powershell
    java -version
    ```

5. Restart PowerShell and verify Gradle:

    ```powershell
    gradle -version
    ```
