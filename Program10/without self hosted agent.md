# BCSL657D – DevOps Lab

## Program 10: Continuous Integration using Azure DevOps (Hosted Agent)

---

## 🎯 Aim

To implement Continuous Integration (CI) using Azure DevOps by building and testing a Maven project using a Microsoft-hosted agent.

---

## 📋 Prerequisites

* Java JDK installed (for development)
* Maven project created (**myapp**)
* Git installed
* Azure DevOps account
* Project created in Azure DevOps

---

## ⚙️ Step 1: Open Azure DevOps

1. Open browser
2. Go to: https://portal.azure.com
3. Click **Microsoft Cloud Menu (☰)**
4. Select **DevOps**
5. Open your project: **Annii-App-Devops**

---

## ⚙️ Step 2: Push Maven Project to Repository

**Project Path:**
`B:\College\6 SEM\BCSL657D (DEVOPS)\Program 10\myapp`

### Commands:

```bash
cd "B:\College\6 SEM\BCSL657D (DEVOPS)\Program 10\myapp"
git init
git add .
git commit -m "initial commit"
git branch -M master
git remote add origin https://dev.azure.com/AnniDevops/Annii-App-Devops/_git/Annii-App-Devops
git pull origin master --allow-unrelated-histories
git push -u origin master
```

### If editor opens:

* Press `Esc`
* Type `:wq`
* Press `Enter`

---

## ⚙️ Step 3: Create Pipeline

* Go to **Pipelines → Create Pipeline**
* Select your repository
* Choose **Starter Pipeline**

---

## ⚙️ Step 4: Configure YAML Pipeline

Replace with:

```yaml
trigger:
- master

pool:
  vmImage: 'ubuntu-latest'

steps:
- task: Maven@4
  displayName: 'Build and Test'
  inputs:
    mavenPomFile: 'myapp/pom.xml'
    goals: 'clean package'
    publishJUnitResults: true
    testResultsFiles: '**/surefire-reports/TEST-*.xml'
```

---

## ⚙️ Step 5: Run Pipeline

* Click **Save**
* Click **Commit**
* Click **Run pipeline**

---

## ⚙️ Step 6: Verify Output

Go to:

**Pipelines → Runs**

### Build Output

* BUILD SUCCESS
* Tests passed
* JAR file generated in `target` folder

### Test Output

* Test results displayed in pipeline
* Reports generated in:
  `target/surefire-reports/`

---

## ⚖️ Key Concept

**Microsoft-hosted agent (ubuntu-latest):**

* No manual setup required
* Maven and Java pre-installed
* Runs on Azure cloud

---

## ❗ Errors Faced and Fixes

| Error                   | Fix                          |
| ----------------------- | ---------------------------- |
| Wrong pom.xml path      | Use `myapp/pom.xml`          |
| Pipeline not triggering | Ensure branch is `master`    |
| Tests not visible       | Enable `publishJUnitResults` |

---

## ✅ Output

* Pipeline executed successfully
* Build completed
* Tests executed
* Reports generated
* JAR file created

---

## 🧠 Conclusion

Continuous Integration is successfully implemented using Azure DevOps with a Microsoft-hosted agent. The pipeline automates building, testing, and report generation, improving development efficiency and code quality.
