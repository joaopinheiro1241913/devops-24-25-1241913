<h1 style="font-size: 48px;">CA3: TECHNICAL REPORT</h1>

---

## 📌 Project Details

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## 🛠️ Technologies Used

### 🔧 CI/CD

![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)

### ☕ Development

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)  
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

### 🐳 Containerization

![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### 🌐 Version Control

![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)  
![Bitbucket](https://img.shields.io/badge/Bitbucket-0052CC?style=for-the-badge&logo=bitbucket&logoColor=white)

### 🔌 Plugins

![Blue Ocean](https://img.shields.io/badge/Blue%20Ocean-0082C9?style=for-the-badge&logo=jenkins&logoColor=white)


---


## 📖 Full Table of Contents

Below is the structured breakdown of CA3 assignment, covering all tasks and requirements in detail.

- **[Introduction](#introduction)**
  - [Jenkins & Docker Integration](#jenkins--docker-integration)
- **[Project Overview & Pipeline Highlights](#project-overview--pipeline-highlights)**
- **[Setup & Prerequesites](#setup--prerequisites)**
  - [Git](#-git)
  - [Docker](#-docker)
  - [Jenkins (via Docker)](#-jenkins-via-docker)
  - [JDK 17 & Gradle Wrapper](#-jdk-17--gradle-wrapper)
  - [Required Jenkins Plugins](#-required-jenkins-plugins)
  - [Docker Hub Credentials](#-docker-hub-credentials)
- **[Part 1: Jenkins Pipeline for Gradle Basic Demo Application](#part-1-jenkins-pipeline-for-gradle-basic-demo-application)**
  - [Jenkinsfile](#jenkinsfile)
  - [Pipeline Stages Overview](#-pipeline-stages-overview-)
  - [Creating the Pipeline Job in Jenkins](#-creating-the-pipeline-job-in-jenkins)
  - [Running the Pipeline](#-running-the-pipeline)
  - [What does the Jenkins Pipeline Graph Show?](#-what-does-the-jenkins-pipeline-graph-show)
- **[Part 2: Jenkins Pipeline for React and Spring Data REST Basic Application](#part-2-jenkins-pipeline-for-react-and-spring-data-rest-basic-application)**
  - [Jenkinsfile](#jenkinsfile-1)
  - [Pipeline Stages Overview](#-pipeline-stages-overview--1)
  - [Custom Jenkins Master Image](#-custom-jenkins-master-image)
  - [Creating the Pipeline Job in Jenkins](#-creating-the-pipeline-job-in-jenkins-1)
  - [Running the Pipeline](#-running-the-pipeline-1)
- **[Overall Conclusion of CA3](#-overall-conclusion-of-ca3)**
  - [Key Achievements and Learnings](#key-achievements-and-learnings-)
  - [Impact](#impact-)

---

## Introduction

This **CA3 assignment** focuses on automating the **build, test, and deployment processes** of a Java-based application using **Jenkins**. By implementing a **Jenkins pipeline**, we aim to demonstrate **Continuous Integration (CI)** and **Continuous Delivery (CD)** best practices.

The pipeline is designed to streamline **code compilation**, **unit testing**, **documentation generation**, **artifact archiving**, and **Docker image creation**, enhancing development efficiency and ensuring consistent software delivery.

This approach exemplifies how modern **DevOps** tools facilitate **automation** and reliable **application lifecycle management**, enabling faster and higher-quality releases with reduced manual intervention.


### Jenkins & Docker Integration

To enable Docker commands inside Jenkins pipelines, Jenkins is deployed using a **custom Docker image** that includes the Docker CLI pre-installed. Docker Hub credentials are securely configured to allow authenticated image pushing.

---

## Project Overview & Pipeline Highlights

This hands-on assignment showcases two fully automated Jenkins CI/CD pipelines that cover every step from source code retrieval to final deployment. Each pipeline exemplifies best practices in automation, testing, and artifact management — critical components for modern DevOps workflows.

This practical assignment builds on two key applications:

- **Gradle Basic Demo Application** (from CA1 - Part 2), a lightweight Java project managed with Gradle.
- **React and Spring Data REST Basic Application** (from CA1 - Part 3), a full-stack app integrating a React frontend with a Spring Boot backend.

Using **Jenkins** as the orchestration tool, the pipelines automate essential software lifecycle stages:

- **Source code checkout** from GitHub.
- **Build and assemble** tasks, including frontend bundling with Webpack and backend packaging with Gradle.
- Running **unit tests** with JUnit 5, with test results published in Jenkins.
- Generating **Javadoc documentation** and publishing HTML reports.
- **Artifact archiving** for binaries and build outputs.
- Creating and pushing **Docker images** to Docker Hub.


---

## ⚙️ Setup & Prerequisites

Before diving into the pipeline setup, ensure the following components are properly installed and configured:


### 🧑‍💻 Git

Used to clone the repositories from GitHub.

✅ **Verify Installation**:
```bash
git --version
```

---

### 🐳 Docker
Required to:

Build and run Docker containers (including the Jenkins server itself)
Build and push the Spring Boot Docker image
✅ Verify Installation:

```bash
docker --version
```

---

### 🧩 Jenkins (via Docker)
We ran Jenkins inside a container using the official LTS image:
**jenkins/jenkins:lts**

```bash
docker run -d \
--name jenkins \
-p 8080:8080 \
-p 50000:50000 \
-v jenkins_home:/var/jenkins_home \
-v /var/run/docker.sock:/var/run/docker.sock \
jenkins/jenkins:lts
```

#### 🧾 What this does:

- 📦 Pulls the official Jenkins LTS image from Docker Hub (if not already available).
- 🧱 Creates a container named **jenkins**.
- 🌐 Exposes Jenkins on http://localhost:8080.
- 💾 Uses a Docker volume (```jenkins_home```) to persist Jenkins data (jobs, config, plugins, etc.).
- 🐳 Mounts the host's Docker socket (```/var/run/docker.sock```) inside the container — enabling Jenkins to execute Docker commands on the host system.  👉 This is essential for building and pushing Docker images during CI/CD.



#### 🔓️ Unlock Jenkins
- When Jenkins starts for the first time, it prompts for an admin unlock key.
- Run the following to retrieve it:

```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

![localhost](https://i.postimg.cc/vmyThRXR/Getting-Started.png)


---

### ☕ JDK 17 & Gradle Wrapper
Both applications require Java 17 to compile and run.

![jdk](https://i.postimg.cc/bvvJW0XL/JDK-installations.png)

**Manage Jenkins → Tools → JDK installations**

Each project already includes a Gradle wrapper, so a global Gradle installation isn't needed.

#### ✅ Verify Gradle Wrapper:

```bash
./gradlew --version
```

---


### 🔌 Required Jenkins Plugins

Make sure the following plugins are installed in Jenkins:

| Plugin                  | Purpose                                                             |
|-------------------------|---------------------------------------------------------------------|
| **Pipeline: Declarative** | Enables `Jenkinsfile` support                                      |
| **Git**                 | Enables code checkout from GitHub                                  |
| **HTML Publisher**      | Publishes Javadoc as HTML reports in Jenkins                       |
| **JUnit**               | Displays test results from Gradle test reports                     |
| **Docker Pipeline**     | Enables `docker.build()` and `docker.withRegistry()` in pipelines  |

#### 🧱 **Install via**:  
**Manage Jenkins → Plugin Manager → Available**

![plugins](https://i.postimg.cc/SRZqW3Rh/Plugins.png)

---

### 🔐 Docker Hub Credentials
To push Docker images to Docker Hub:

Go to Jenkins → Manage Jenkins → Credentials
Add a new credential of type: Username with password
Use the following ID:

```bash
dockerhub-creds-id
```

This ID is referenced in the pipeline script to authenticate the Docker push.



![credentials](https://i.postimg.cc/MpqNWdp0/Screenshot-2025-06-08-at-23-23-35.png)


---

## Part 1: Jenkins Pipeline for Gradle Basic Demo Application

The first stage of the **CA3 assignment** focused on configuring a **Jenkins CI/CD pipeline** for the **Gradle Basic Demo Application**, originally created in **CA1 - Part 2**.

This pipeline was fully defined using a **Declarative Jenkinsfile**, located at:  
📁 `CA3/gradle_basic_demo/Jenkinsfile`


### Jenkinsfile

```jenkinsfile
pipeline {
    agent any

    tools{
        jdk 'JDK17'
    }

    environment{
        JAVA_HOME = tool 'JDK17'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out from repository'
                git credentialsId: 'github-token', branch: 'main', url: 'https://github.com/joaopinheiro1241913/devops-24-25-1241913.git'
            }
        }
        stage('Assemble') {
            steps {
                dir('CA1/part2/gradle-basic') {
                    echo 'Assembling...'
                    sh 'chmod +x gradlew'
                    sh './gradlew clean assemble'
                }
            }
        }
        stage('Test') {
            steps {
                dir('CA1/part2/gradle-basic') {
                    echo 'Running Tests...'
                    sh './gradlew test'
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
        stage('Archive') {
            steps {
                dir('CA1/part2/gradle-basic') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
                }
            }
        }
    }
}
```

### 🚀 Pipeline Stages Overview 

The `Jenkinsfile` for the **Gradle Basic Demo Application** defines a **four-stage pipeline** that automates key CI tasks — from code checkout to artifact archiving.


| Stage     | Description                                                                                       |
|-----------|---------------------------------------------------------------------------------------------------|
| **Checkout** | Retrieves source code from GitHub using Jenkins Git plugin                                       |
| **Assemble** | Runs `./gradlew clean assemble` to clean and build the project artifacts                         |
| **Test**     | Executes unit tests with `./gradlew test` and publishes XML reports                              |
| **Archive**  | Archives the generated JAR as a build artifact for later retrieval and deployment                |

---

#### 🔄 1. Checkout

📥 In this initial stage, Jenkins uses the **Git plugin** to clone the source code from the specified GitHub repository.

---

#### 🛠️ 2. Assemble

🧱 Executes the command:

```bash
./gradlew clean assemble
```

This step cleans any previous builds and compiles the Java code, producing a ```.jar``` file via Gradle.

---

#### 🧪 3. Test
✅ Runs:

```bash
./gradlew test
```

This compiles and runs unit tests using **JUnit 5**, ensuring that the application behaves correctly.
📊 Test results are published to Jenkins using the **JUnit plugin**, enabling clear visibility of test outcomes.

---

#### 📦 4. Archive
🎯 The compiled ```.jar``` file is archived as a **build artifact** using the ```archiveArtifacts``` directive.
🔐 **Fingerprinting** is also enabled, ensuring traceability of artifacts across pipeline runs.


---

### 🏗️ Creating the Pipeline Job in Jenkins

To set up this pipeline in Jenkins:

1. 🔧 Go to the Jenkins dashboard and click **"New Item"**.
2. 📝 Enter a name (e.g., ```gradle-basic-demo```) and select **"Pipeline"**.
3. 🛠️ Under **Pipeline** → **Definition**, choose **"Pipeline script from SCM"**.
4. 🔗 Select **Git** as the SCM, then enter the repository URL.
5. 🌿 Set the branch to ```main``` or ```master``` (as applicable).
6. 📄 Set **Script Path** to:

```swift
CA3/gradle_basic_demo/Jenkinsfile
```

7. 💾 Save the configuration.

---

### ▶️ Running the Pipeline

Once the pipeline job is created:

1. Click **"Build Now"** to trigger the job.
2. Use the **Console Output** to monitor real-time logs of each stage.
3. After a successful build:
   - ✅ Test results will appear in the **Tests** tab.
   - 📦 The generated ```.jar``` file will be listed under **Build Artifacts**.


    


Below is an example screenshot of a successful Jenkins build for this pipeline:


![job](https://i.postimg.cc/0QwcGwN2/6-9-Jun-2025-000213.png)
![job2](https://i.postimg.cc/P50DWFvY/9-min-49-sec.png)


---

### 📊 What Does the Jenkins Pipeline Graph Show?

The **visual graph** you see after running a Jenkins pipeline — with green, blue, or red boxes — is known as:

- **Pipeline Visualization** (default Jenkins UI), or
- **Blue Ocean View**, if using the Blue Ocean plugin

![job3](https://i.postimg.cc/Cx85gMdn/Screenshot-2025-06-09-at-02-12-08.png)

---

#### ✅ Purpose

This graph gives you a quick and intuitive overview of your pipeline's execution:

🔎 **Each box represents a `stage` defined in your Jenkinsfile** (e.g., `Checkout`, `Assemble`, `Test`, `Archive`).

---

#### 🎨 Stage Status Colors

| Color / Icon              | Meaning                                  |
|---------------------------|-------------------------------------------|
| ✅ Green                  | Stage completed successfully              |
| ❌ Red                    | Stage failed                              |
| ⏳ Light Blue / Gray      | Stage in progress or not yet executed     |
| ⏭️ Circle with arrow      | Stage skipped (usually due to prior error)|

---

#### 🧠 Why Is This Useful?

- 📌 **Quick snapshot** of pipeline progress and health
- 🐞 **Easier debugging** when a stage fails
- ⏱️ **Shows duration** of each stage (hover over the box)
- 🔁 Helps identify **performance bottlenecks**



---

## Part 2: Jenkins Pipeline for React and Spring Data REST Basic Application

In the second phase of the CA3 assignment, the CI/CD configuration was expanded to support a full-stack application that combines a **React frontend** with a **Spring Data REST backend**. This project, originally built in ```CA1/part3/react-and-spring-data-rest-basic```, required a more advanced and integrated pipeline setup.

### Jenkinsfile

```jenkinsfile
pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin:$PATH"
        DOCKER_CREDENTIALS_ID = 'credentials-dockerhub'
        DOCKER_IMAGE          = 'joaopinheiro1241913/jenkins-custom'
        DOCKER_REGISTRY       = 'https://index.docker.io/v1/'
        REPO_URL              = 'https://github.com/joaopinheiro1241913/devops-24-25-1241913.git'
    }

    stages {

        stage('Checkout') {
            steps {
                cleanWs()
                echo 'Checking out...'
                git branch: 'main', url: env.REPO_URL
            }
        }

        stage('Create Dockerfile') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Writing Dockerfile...'
                    script {
                        writeFile file: 'Dockerfile', text: '''
   FROM eclipse-temurin:21-jdk
   WORKDIR /app
   COPY build/libs/*.jar app.jar
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","app.jar"]
   '''
                    }
                }
            }
        }

        stage('Assemble') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Assembling...'
                    sh 'chmod +x gradlew'
                    sh './gradlew clean assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Testing...'
                    sh './gradlew test'
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }

        stage('Javadoc') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Generating Javadoc…'
                    sh './gradlew javadoc'
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir:   'build/docs/javadoc',
                        reportFiles: 'index.html',
                        reportName:  'Javadoc'
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Archiving...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('CA1/part3/react-and-spring-data-rest-basic') {
                    echo 'Building & Pushing Docker image...'
                    withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        script {
                            def dockerBin = '/usr/local/bin/docker'
                            def imageTag = "${env.DOCKER_IMAGE}:${env.BUILD_NUMBER}"

                            sh "${dockerBin} build -t ${imageTag} ."
                            sh "echo \$DOCKER_PASSWORD | ${dockerBin} login ${env.DOCKER_REGISTRY} -u \$DOCKER_USERNAME --password-stdin"
                            sh "${dockerBin} push ${imageTag}"
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}

```

---

### 🚀 Pipeline Stages Overview 


#### 1. 🔄 Checkout
- Retrieves the source code from the GitHub repository specified by the `REPO_URL` environment variable.
- Clones the `master` branch into the Jenkins workspace.

#### 2. 🐳 Create Dockerfile
- Dynamically generates a `Dockerfile` for the Spring Boot application.
- Configures it to package the generated JAR and expose port `8080`.

#### 3. 🏗️ Assemble
- Builds the project using Gradle with `./gradlew clean assemble`.
- Compiles both the React frontend and Spring Boot backend components.

#### 4. ✅ Test
- Executes unit tests via `./gradlew test`.
- Collects and publishes the test results in Jenkins using the `junit` step.

#### 5. 📚 Javadoc
- Generates Java documentation using `./gradlew javadoc`.
- Publishes the HTML documentation using Jenkins' HTML Publisher plugin.

#### 6. 📦 Archive
- Archives the compiled JAR file (`build/libs/*.jar`) as a Jenkins build artifact.
- Enables future access to the artifact without recompilation.

#### 7. 🐋 Build Docker Image
- Builds a Docker image using the previously created Dockerfile.
- Tags the image with the Jenkins build number.
- Pushes the image to Docker Hub using stored credentials.

---

### 🧩 Custom Jenkins Master Image

To enable Jenkins to run Docker commands inside the pipeline, we created a custom Jenkins container:

```dockerfile
FROM jenkins/jenkins:lts
USER root

RUN apt-get update \
 && apt-get install -y docker.io \
 && rm -rf /var/lib/apt/lists/*

USER jenkins
```

By mounting the host's Docker socket into the container (```-v /var/run/docker.sock:/var/run/docker.sock```), the pipeline can build and push Docker images directly.

---

### ⚙️ Creating the Pipeline Job in Jenkins

To set up the pipeline for the React and Spring Data REST application, follow these steps:

1. Access the Jenkins Dashboard and click **New Item**.
2. Enter a name for the new job and select the **Pipeline** option.
3. In the **Pipeline** section, choose **Pipeline script from SCM**.
4. Under **SCM**, select **Git** and enter the repository URL.
5. Specify the branch as `main`.
6. Set the **Script Path** to:  
   `CA3/react-and-spring-data-rest-basic/Jenkinsfile`
7. Click **Save** to store and activate the pipeline configuration.

This setup allows Jenkins to automatically run the pipeline defined in the Jenkinsfile whenever it is triggered manually or by an SCM event.

---

### ▶️ Running the Pipeline

After configuring the pipeline job:

- Trigger the build manually by clicking **Build Now** in Jenkins.
- Monitor the execution progress through the **Console Output**, which shows detailed feedback for each pipeline stage.


![springbootdemo](https://i.postimg.cc/6qP8rwyv/image.png)

---

## 🔚 Overall Conclusion of CA3

This assignment provided **valuable hands-on experience** in configuring **CI/CD pipelines** using **Jenkins**, applied to two distinct applications. By automating pipelines for both projects, I was able to deepen my understanding of **Continuous Integration (CI)** and **Continuous Deployment (CD)** best practices.

### Key Achievements and Learnings 🎯

- **Pipeline as Code**  
  Defining every phase—checkout, build, test, documentation, artifact archiving, and Docker image creation—in a Jenkinsfile ensures consistent, repeatable automation with every code update.

- **Automated Quality Gates**  
  Running unit tests and publishing JUnit reports allow early detection of regressions, while generating and publishing Javadoc keeps documentation accurate and up-to-date.

- **Artifact Management**  
  Archiving JAR files with fingerprinting supports traceability, and dynamically creating Dockerfiles guarantees consistent container builds.

- **Docker Integration**  
  Building a custom Jenkins master image with Docker CLI enabled seamless image building and pushing directly from the pipeline, simplifying deployment workflows.

### Impact 🚀

Automating these steps **eliminated manual tasks**, **reduced the risk of human error**, and **accelerated the software delivery process**. This practical experience strengthened my proficiency with:

- Jenkins declarative pipelines
- Docker containerization workflows
- End-to-end CI/CD lifecycle automation

This project showcased how **Jenkins** and **Docker** together empower developers to implement reliable, efficient, and scalable **CI/CD pipelines** — a cornerstone of modern **DevOps** culture.  
