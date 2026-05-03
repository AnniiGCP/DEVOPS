# BCSL657D – DevOps Lab

## Program 11: Continuous Deployment using Azure DevOps (Hosted Agent)

---

## 🎯 Aim

To implement Continuous Deployment (CD) using Azure DevOps by creating a multi-stage pipeline using a **Microsoft-hosted agent (ubuntu-latest)**.

---

## 📋 Prerequisites

* Azure DevOps account
* Project created (**Annii-App-Devops**)
* Maven project pushed to repository (**myapp folder**)
* Program 10 (CI pipeline) completed

---

## ⚙️ Step 1: Open Azure DevOps

1. Open browser
2. Go to: https://portal.azure.com
3. Click **Microsoft Cloud Menu (☰)**
4. Select **DevOps**
5. Open your project: **Annii-App-Devops**

---

## ⚙️ Step 2: Create Variable Group

Go to:

**Pipelines → Library → + Variable group**

Enter:

* **Name:** lab-secrets

### Add Variables

* **Variable 1:**

  * Name: appVersion
  * Value: 1.0-SNAPSHOT
  * Secret: No

* **Variable 2:**

  * Name: deployKey
  * Value: KSIT-LAB-2025
  * Secret: YES

Click **Save**

---

## ⚠️ Important (Authorization Step)

1. Open the variable group
2. Go to **Pipeline permissions**
3. Click **Authorize**

---

## ⚙️ Step 3: Update Pipeline YAML

Go to:

**Repos → Files → azure-pipelines.yml → Edit**

Replace with:

```yaml
trigger:
- master

pool:
  vmImage: 'ubuntu-latest'

variables:
- group: lab-secrets

stages:

- stage: Build
  displayName: 'Build and Test'
  jobs:
  - job: BuildJob
    steps:

    - task: Maven@4
      displayName: 'Compile and Test'
      inputs:
        mavenPomFile: 'myapp/pom.xml'
        goals: 'clean package'
        publishJUnitResults: true
        testResultsFiles: '**/surefire-reports/TEST-*.xml'

    - task: PublishPipelineArtifact@1
      displayName: 'Publish Artifact'
      inputs:
        targetPath: '$(System.DefaultWorkingDirectory)/myapp/target'
        artifact: 'student-app-jar'

- stage: Release
  displayName: 'Download and Deploy'
  dependsOn: Build
  condition: succeeded()
  jobs:
  - job: ReleaseJob
    steps:

    - task: DownloadPipelineArtifact@2
      displayName: 'Download Artifact'
      inputs:
        artifactName: 'student-app-jar'
        targetPath: '$(Pipeline.Workspace)/student-app-jar'

    - script: |
        echo "======================="
        echo "KSIT DevOps Lab - Release"
        echo "======================="
        echo "App Version : $(appVersion)"
        echo "Deploy Key  : $(deployKey)"
        ls $(Pipeline.Workspace)/student-app-jar/
        echo "Deployment Completed"
      displayName: 'Simulate Deployment'
```

---

## ⚙️ Step 4: Run Pipeline

* Click **Save**
* Click **Commit**
* Click **Run pipeline**

---

## ⚙️ Step 5: Verify Output

Go to:

**Pipelines → Runs**

### Build Stage Output

* Build SUCCESS
* Tests passed
* Artifact generated

### Release Stage Output

* App Version : 1.0-SNAPSHOT
* Deploy Key : ***
* Deployment Completed

---

## ⚙️ Step 6: Download Artifact

1. Open pipeline run
2. Click **1 artifact produced**
3. Download **student-app-jar**

---

## ❗ Errors Faced and Fixes

| Error                    | Fix                      |
| ------------------------ | ------------------------ |
| Variable group not found | Authorize variable group |
| Wrong pom.xml path       | Use `myapp/pom.xml`      |
| Artifact not found       | Use `myapp/target`       |
| Maven warning            | Use `Maven@4`            |

---

## ⚖️ Key Difference

| Self-hosted Agent      | Hosted Agent        |
| ---------------------- | ------------------- |
| Requires manual setup  | No setup required   |
| Install tools manually | Pre-installed tools |
| Maintenance needed     | Fully managed       |

---

## ✅ Output

* Multi-stage pipeline executed successfully
* Build stage successful
* Release stage successful
* Artifact generated
* Deployment simulated
* Secret variable masked

---

## 🧠 Conclusion

Continuous Deployment is implemented successfully using a Microsoft-hosted agent, simplifying the setup and execution process.
