# BCSL657D – DevOps Lab

## Program 10: Continuous Integration Using Azure DevOps

---

## 🎯 Aim

Implement Continuous Integration (CI) in Azure DevOps by building a Maven project through a pipeline.

---

## 📋 Prerequisites

- Java JDK installed  
- Maven installed  
- Git installed  
- Azure DevOps account  
- Self-hosted agent (Windows)

---

## ⚙️ Step 1: Create a Project in Azure DevOps

- Open: https://dev.azure.com  
- Create project: **Annii-App-Devops**

---

## ⚙️ Step 2: Push Maven Project to Repository

Project path:

```text
B:\College\6 SEM\BCSL657D (DEVOPS)\Program 10\myapp
```

Commands:

```bash
cd "B:\College\6 SEM\BCSL657D (DEVOPS)\Program 10\myapp"
git init
git add .
git commit -m "initial commit"
git branch -M main
git remote add origin https://dev.azure.com/AnniDevops/Annii-App-Devops/_git/Annii-App-Devops
git pull origin main --allow-unrelated-histories
git push -u origin main
```

If an editor opens during `git pull`:

- Press `Esc`
- Type `:wq`
- Press `Enter`

---

## ⚙️ Step 3: Create a Personal Access Token (PAT)

- Azure DevOps → Profile → Personal Access Tokens  
- Create token (**Full access**)

---

## ⚙️ Step 4: Set Up Self-Hosted Agent

Agent path:

```text
C:\azure-agent
```

Commands:

```powershell
cd C:\azure-agent
.\config.cmd
```

Enter:

```text
Server URL: https://dev.azure.com/AnniDevops
Authentication: PAT
(Paste token)
Agent Pool: Default
Agent Name: my-agent
Run as service: N
```

Start agent:

```powershell
.\run.cmd
```

Keep the agent running (do not close the window).

---

## ⚙️ Step 5: Configure Maven (Skip if Already Done)

Maven path:

```text
C:\Program Files\apache-maven-3.9.15
```

Add to `PATH`:

```text
C:\Program Files\apache-maven-3.9.15\bin
```

Verify:

```bash
mvn -v
```

---

## ⚙️ Step 6: Add Maven Capability

Go to:  
**Project Settings → Agent Pools → Default → Agent → Capabilities**

Add:

```text
Name: maven
Value: C:\Program Files\apache-maven-3.9.15\bin\mvn.cmd
```

---

## ⚙️ Step 7: Create Pipeline

Go to: **Pipelines → Create Pipeline**

YAML:

```yaml
trigger:
- main

pool:
    name: Default

steps:
- task: Maven@3
    inputs:
        mavenPomFile: 'pom.xml'
        goals: 'clean package'
        publishJUnitResults: true
        testResultsFiles: '**/surefire-reports/TEST-*.xml'
```

---

## ⚙️ Step 8: Run Pipeline

- Click **Save and Run**
- Click **Run new**

---

## ✅ Output

- Pipeline executed successfully
- Build status: **SUCCESS**
- Tests passed
- JAR file generated
