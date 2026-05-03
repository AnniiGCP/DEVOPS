# BCSL657D – DevOps Lab

## Program 11: Continuous Deployment using Azure DevOps (Multi-Stage Pipeline)

---

## 🎯 Aim

To implement Continuous Deployment (CD) using Azure DevOps by extending a CI pipeline into a multi-stage pipeline with artifact publishing and deployment simulation.

---

## 📋 Prerequisites

* Program 10 (CI Pipeline) completed successfully
* Azure DevOps account and project created
* Maven project available in repository
* Self-hosted agent configured and running
* Maven installed and added to PATH

---

# ⚙️ Step 1: Start Self-Hosted Agent

Open PowerShell and run:

```powershell
cd C:\azure-agent
.\run.cmd
```

👉 Keep this window open
👉 You should see: **Listening for Jobs**

---

# ⚙️ Step 2: Create Variable Group

Go to:

```text
Pipelines → Library
```

Click:

```text
+ Variable group
```

Enter:

```text
Name: lab-secrets
```

---

## Add Variables

**Variable 1**

```text
Name: appVersion
Value: 1.0-SNAPSHOT
Secret: No
```

**Variable 2**

```text
Name: deployKey
Value: KSIT-LAB-2025
Secret: YES (Enable 🔒)
```

---

## Authorize Variable Group

Enable:

```text
Allow access to all pipelines ✔
```

Click **Save**

---

# ⚙️ Step 3: Update Pipeline YAML

Go to:

```text
Repos → Files → azure-pipelines.yml
```

Click **Edit** and replace with:

---

## ✅ Final YAML Configuration

```yaml
trigger:
- main

pool:
  name: Default   # Self-hosted agent

variables:
- group: lab-secrets

stages:

# -------- BUILD STAGE --------
- stage: Build
  displayName: 'Stage 1 - Build'
  jobs:
  - job: BuildJob
    displayName: 'Build and Test'
    steps:

    - task: Maven@3
      displayName: 'Compile and Test'
      inputs:
        mavenPomFile: 'pom.xml'
        goals: 'clean package'
        publishJUnitResults: true
        testResultsFiles: '**/surefire-reports/TEST-*.xml'

    - task: PublishPipelineArtifact@1
      displayName: 'Publish Artifact'
      inputs:
        targetPath: '$(System.DefaultWorkingDirectory)/target'
        artifact: 'student-app-jar'

# -------- RELEASE STAGE --------
- stage: Release
  displayName: 'Stage 2 - Release'
  dependsOn: Build
  condition: succeeded()

  jobs:
  - job: ReleaseJob
    displayName: 'Download and Deploy'
    steps:

    - task: DownloadPipelineArtifact@2
      displayName: 'Download Artifact'
      inputs:
        artifactName: 'student-app-jar'
        targetPath: '$(Pipeline.Workspace)/student-app-jar'

    - script: |
        echo =======================
        echo KSIT DevOps Lab - Release
        echo =======================
        echo App Version : $(appVersion)
        echo Deploy Key  : $(deployKey)
        echo Listing files:
        dir $(Pipeline.Workspace)\student-app-jar\
        echo Deployment Completed
      displayName: 'Simulate Deployment'
```

---

# ⚙️ Step 4: Save and Run Pipeline

Click:

```text
Save → Commit → Run new
```

---

# ⚙️ Step 5: Verify Output

## Stage 1: Build

✔ Build successful
✔ Tests passed
✔ Artifact generated

---

## Stage 2: Release

✔ Artifact downloaded
✔ Variables printed

Output:

```text
App Version : 1.0-SNAPSHOT
Deploy Key  : ***
Deployment Completed
```

---

# ⚠️ Common Errors and Fixes

### ❌ Variable group not found

✔ Fix: Enable **Allow access to all pipelines**

---

### ❌ Agent stuck / waiting

✔ Fix:

```powershell
.\run.cmd
```

---

### ❌ Cmd.exe exited with code 9009

✔ Fix: Replace `ls` with `dir` (Windows agent)

---

### ❌ Trigger failed

✔ Fix: Open pipeline → Click **Save**

---

# ✅ Output

* Multi-stage pipeline executed successfully
* Build and Release stages completed
* Artifact created and accessed
* Secret variable masked

---

# 🧠 Conclusion

Continuous Deployment is successfully implemented using a multi-stage Azure DevOps pipeline. The system automates build, test, artifact creation, and deployment simulation using a self-hosted agent.

---
