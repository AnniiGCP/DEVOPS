# Program 5

## Introduction to Jenkins
**Topic:** What is Jenkins? Installing Jenkins on a local or cloud environment, configuring Jenkins for first use, and completely removing Jenkins from the system.

---

## Aim

To understand Jenkins and perform installation, configuration, and complete removal of Jenkins.

---

# How to Completely Remove Jenkins from Windows

## Step 1: Stop Jenkins Service

Press:

```text
Windows + R
```

Type:

```text
services.msc
```

- Press Enter.
- Scroll down and locate **Jenkins**.
- Right-click Jenkins and click **Stop**.

---

## Step 2: Delete Jenkins Files

- Enable **Hidden Files** in File Explorer.
- Delete the Jenkins folders from:

```text
C:\Program Files\
C:\ProgramData\
```

> Note: Jenkins may be installed in another location depending on your setup.

---

## Step 3: Remove Jenkins Registry Entry

Press:

```text
Windows + R
```

Type:

```text
regedit
```

Navigate to:

```text
Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Jenkins
```

- Delete the **Jenkins** registry entry.

---

## Step 4: Restart System

- Restart the computer.

---

## Step 5: Reinstall Jenkins (Optional)

- Download and install Jenkins again if required.

---

# What is Jenkins?

Jenkins is an open-source automation server used in DevOps to automate software development tasks such as:

- Building applications  
- Running tests  
- Deploying applications  

It is mainly used to implement **Continuous Integration (CI)** and **Continuous Deployment (CD)**.

In simple terms, Jenkins automatically builds and tests code whenever developers make changes.

---

# Why Jenkins is Used

- Automates the software build process  
- Detects errors early in development  
- Saves developer time  
- Supports many plugins for integration with tools like Git, Docker, Kubernetes, etc.

---

# Jenkins Installation Steps

## Step 1: Install Java

Jenkins requires Java.

Check Java installation:

```bash
java -version
```

If Java is not available (or the version is below 17), install **OpenJDK 17 or later** first.

After installation, restart the terminal and verify again:

```bash
java -version
```

---

## Step 2: Download Jenkins

Download Jenkins from the official website:

https://www.jenkins.io/download/

Download **Jenkins LTS (.msi)** for Windows.

---

## Step 3: Install Jenkins

Run the installer and complete the installation.

Jenkins runs on the default port:

```text
http://localhost:8080
```

Open the above URL in your browser.

---

# Initial Jenkins Configuration

## Step 1: Unlock Jenkins

When Jenkins starts for the first time, it asks for an admin password.

Password file location:

```text
C:\Program Files\Jenkins\secrets\initialAdminPassword
```

Copy the password and paste it into the browser.

---

## Step 2: Install Plugins

Select:

**Install Suggested Plugins**

This installs commonly used Jenkins plugins.

---

## Step 3: Create Admin User

Create the first administrator account for Jenkins.

Example:

```text
Username: admin
Password: admin123
```

---

# Jenkins Dashboard

After configuration, the Jenkins dashboard will appear.
