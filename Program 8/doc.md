# Program 8: Continuous Integration and Deployment using Jenkins and Ansible

---

## Aim

To automate build using Jenkins and deploy using Ansible.

---

## Prerequisites

* Java JDK installed
* Maven installed (Windows)
* Jenkins installed and running (Windows)
* Ubuntu (WSL) with Ansible installed

---

# Part A: Jenkins (Windows) – Build Process

---

## Step 1: Build Maven Project

```bat id="p8a1"
cd "B:\College\6 SEM\BCSL657D (DEVOPS)\Program 8\myapp"
mvn clean package
```

Output:

```id="p8a2"
BUILD SUCCESS
```

Generated:

```id="p8a3"
target/myapp-1.0-SNAPSHOT.jar
```

---

## Step 2: Configure Jenkins

Open:

```id="p8a4"
http://localhost:8080
```

Go to:
**Manage Jenkins → Tools**

Add Maven:

* Name: Maven
* Path:

```id="p8a5"
C:\Program Files\apache-maven-3.9.15
```

---

## Step 3: Create Jenkins Job

* New Item → Freestyle Project
* Name: Build-Job

### Build Step:

* Invoke top-level Maven targets

Goals:

```id="p8a6"
clean package
```

POM:

```id="p8a7"
B:\College\6 SEM\BCSL657D (DEVOPS)\Program 8\myapp\pom.xml
```

Click **Build Now**

---

# Part B: Ansible (Ubuntu/WSL) – Deployment

---

## Step 4: Open Ubuntu

```bash id="p8b1"
wsl
```

---

## Step 5: Create Working Directory

```bash id="p8b2"
mkdir -p ~/ansible-deploy
cd ~/ansible-deploy
```

---

## Step 6: Create Inventory File

```bash id="p8b3"
nano hosts
```

Add:

```ini id="p8b4"
[local]
localhost ansible_connection=local
```

---

## Step 7: Create Playbook

```bash id="p8b5"
nano deploy.yml
```

Code:

```yaml id="p8b6"
---
- name: Deploy Maven Artifact
  hosts: localhost
  connection: local

  tasks:
    - name: Create deployment directory
      file:
        path: /tmp/deployments
        state: directory

    - name: Copy JAR file
      copy:
        src: "/mnt/b/College/6 SEM/BCSL657D (DEVOPS)/Program 8/myapp/target/myapp-1.0-SNAPSHOT.jar"
        dest: "/tmp/deployments/myapp.jar"
```

---

## Step 8: Run Playbook

```bash id="p8b7"
ansible-playbook -i hosts deploy.yml
```

---

## Step 9: Verify Deployment

```bash id="p8b8"
ls /tmp/deployments/
```

Output:

```id="p8b9"
myapp.jar
```

---

## Output

* Jenkins → BUILD SUCCESS
* JAR file generated
* Ansible → Deployment successful

---

## Result

Jenkins successfully built the Maven project and generated a JAR file.
Ansible successfully deployed the JAR file on the system.

---
