# CA2 Part 3: Docker - Containerization with Docker

---

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## Table of Contents

- [Introduction to Part 3](#introduction-to-part-3)
  - [Why Containerization?](#why-containerization)
  - [Containerization Strategies Implemented](#containerization-strategies-implemented)
- [Environment Setup](#environment-setup)
  - [Install Docker](#-1-install-docker)
  - [Verify Docker Installation](#-2-verify-docker-installation)
  - [Clone the Chat Server Repository](#-3-clone-the-chat-server-repository)
- [Version 1 - Dockerfile (Internal Build Approach)](#version-1---dockerfile)
  - [Dockerfile Contents](#-dockerfile-contents)
  - [Building the Docker Image](#-building-the-docker-image)
  - [Running the Container](#-running-the-container)
  - [Testing the Chat Functionality](#-testing-the-chat-functionality)
  - [Pushing the Image to Docker Hub](#-pushing-the-image-to-docker-hub)
- [Version 2 - Dockerfile (External Build Approach)](#version-2---dockerfile)
  - [Pre-Build Steps](#-pre-build-steps)
  - [Dockerfile Contents](#-dockerfile-contents-1)
  - [Building the Docker Image](#-building-the-docker-image-1)
  - [Running the Container](#-running-the-container-1)
  - [Testing the Chat Client](#-testing-the-chat-client)
  - [Pushing to Docker Hub](#-pushing-to-docker-hub)
- [Git Activity: Commits & Issues](#-git-activity-commits--issues)
  - [Completed Issues](#-completed-issues)
  - [Git Commits](#-git-commits)
- [Conclusion of Part 3](#conclusion-of-part-3)

---

## Introduction to Part 3



This part of the assignment focuses on gaining **practical experience with Docker** by containerizing a chat application previously developed during the `CA1` coursework, hosted in a **Bitbucket repository**. This project provides a hands-on opportunity to explore **Docker tools and workflows** through the deployment and management of a real-world application in containerized environments.


---

### Why Containerization?
Containerization has become a fundamental practice in modern software development, offering key advantages such as:
- **✅ Environment consistency**
- **🔧 Simplified dependency management**
- **📦 Enhanced portability**
- **🔒 Process isolation**

By encapsulating the application and its dependencies into **Docker containers**, it becomes possible to eliminate issues related to **configuration discrepancies**, **version conflicts**, and **system compatibility**.

---

### Containerization Strategies Implemented
To structure this exploration, **two distinct containerization approaches** were implemented, and the assignment is divided into two versions:

**1. 🏗️ Building the chat server within the Dockerfile (Internal Build Approach)**
- The **chat server is compiled as part of the Docker image build process**. 
- The `Dockerfile` includes all necessary **build tools** and **source code**, ensuring the **entire application lifecycle** is encapsulated within the container.

**2. 🧾 Building the chat server on the host machine (External Build Approach)**
- The application is **first compiled on the host machine**
- The resulting `.jar` file is **copied into the Docker image**. 
- This approach mirrors real-world **CI/CD workflows** where builds are separated from runtime environments.

The assignment involves creating Dockerfiles for both strategies, building and tagging Docker images, and running containers from these images. Additional steps include testing the application's behavior in containerized environments and comparing both approaches.
This report documents the **entire workflow** — from environment setup and image construction to container execution — while highlighting the **benefits and trade-offs** of each method. The work provides **foundational experience** in Docker and prepares for more advanced topics in **DevOps** and **cloud-native deployment**.

---

## Environment Setup

To prepare the development environment for this project using **Docker**, follow the steps below. This setup ensures the system is ready to containerize and run the chat server developed during `CA1` coursework.

---

### ✅ 1. Install Docker

First, make sure **Docker Desktop** is installed on your system.

- 📥 Download it from the official Docker site: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)
- Follow the installation instructions for your specific operating system (macOS, Windows, or Linux).

---

### 🧪 2. Verify Docker Installation

To confirm that Docker is correctly installed and running, execute the following command in your terminal:

```bash
docker --version
```

You should see an output similar to:

```bash
Docker version 28.0.4, build b8034c0
```

---

### 📁 3. Clone the Chat Server Repository
You will need the **chat server source code** that was developed as part of `CA1`. The repository is hosted on Bitbucket and includes a Gradle-based Java application.

Clone the repository using the following command:

```bash
git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git
```

This completes the initial environment setup. With Docker installed and the project cloned locally, you're ready to proceed with building Docker images and running containers.

---

## Dockerfile - Version 1 

This section outlines the process of containerizing the chat server **by building it inside the Docker image**. This strategy uses a multi-stage build process to compile the application and produce an optimized runtime container.

---

### 📄 Dockerfile Contents

In the root of the repository, a `Dockerfile` was created to define the Docker image. Below is the complete content used for **version 1**:

```Dockerfile
# Use a Gradle image with JDK 17 to build the application
FROM gradle:jdk17 AS builder

# Set the working directory for the build
WORKDIR /CA2/Part3/V1

# Clone the repository
RUN git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git

# Set the working directory to the cloned repository
WORKDIR /CA2/Part3/V1/gradle_basic_demo

# Ensure the Gradle wrapper has the correct permissions
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Use a slim JRE image for the runtime
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /CA2/Part3/V1/gradle_basic_demo/build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

# Expose the port the server will run on
EXPOSE 59001

# Set the entry point to run the server
ENTRYPOINT ["java", "-cp", "/app/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
```

This Dockerfile defines a **multi-stage build**:

- The first stage compiles the chat server using Gradle and JDK 17.
- The second stage uses a **slim runtime (JRE)** to reduce the final image size.
- It exposes port `59001 and starts the chat server with the required entry point.

---

### 🏗️ Building the Docker Image
Once the Dockerfile was in place, the Docker image was built using:

```bash
docker build -t joaopinheiro1241913/chat-server:version1 .
```
✅ The `-t` flag tags the image with a repository name and version.

![dockerbuild](https://i.postimg.cc/V6SzVH4y/Screenshot-2025-05-19-at-00-29-17.png)

To confirm the image was built successfully:

```bash
docker images
```
Expected output:

![dockerimages](https://i.postimg.cc/P52hrkRs/REPOSITORY.png)

---

### ▶️ Running the Container
To launch the chat server inside a Docker container:

```bash
docker run -p 59001:59001 joaopinheiro1241913/chat-server:version1
```
- The `-p` flag maps **host port** to **container port** (`59001 in this case).
- The server output confirms that it's running and ready to accept client connections.

Below is the output of the command, which shows the Docker container running the chat server:

![dockerrun](https://i.postimg.cc/B61GgPQ4/Screenshot-2025-05-19-at-00-34-11.png)

---

### 💬 Testing the Chat Functionality
In a new terminal window:

1. Navigate to the cloned `gradle_basic_demo` directory.
2. Run the following commands to start the client:

```bash
./gradlew build
./gradlew runClient
```

✅ Two clients can be launched in separate terminals to test real-time chat communication through the Dockerized server. Below is a sample output from the chat client showing a successful connection and a sample message exchange:

![chatv1](https://i.postimg.cc/Sxt5vQPs/Chat-Client-App.png)

In the terminal where the Docker container was running, I could see the entrance and exit of new clients in the chat server.

![chatv1running](https://i.postimg.cc/tTFMJ34Z/Screenshot-2025-05-19-at-00-43-07.png)

---

### 📤 Pushing the Image to Docker Hub
After confirming that the image worked as expected, it was pushed to Docker Hub:

```bash
docker push joaopinheiro1241913/chat-server:version1
```

The image is now publicly available in the Docker Hub repository for reuse and deployment.

---

## Dockerfile - Version 2 

In this second approach, the chat server was **compiled on the host machine**, and only the resulting `.jar` file was added to the Docker image. This reflects a more common production workflow where builds are handled by a CI/CD pipeline or external build tool, keeping the runtime image smaller and simpler.

✅ This command generated the file:

```bash
build/libs/basic_demo-0.1.0.jar
```

This JAR file is then used as the application artifact for the Docker container.


---

### ⚙️ Pre-Build Steps

Before building the Docker image, the chat server had to be compiled locally:

```bash
./gradlew build
```

---

### 📄 Dockerfile Contents

Here’s the Dockerfile used for Version 2:

```Dockerfile
# Use a Gradle image with JDK 21 to build the application
FROM gradle:jdk21 AS builder

# Set the working directory
WORKDIR /app

# Copy the JAR file from the host machine to the Docker image
COPY CA1/part2/gradle-basic/build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

# Expose the port the server will run on
EXPOSE 59001

# Set the entry point to run the server
ENTRYPOINT ["java", "-cp", "/app/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
```
**Note:** Unlike version 1, this Dockerfile does **not** include build steps or clone the repository. It expects the `.jar to already exist on the host machine.

---

### 🏗️ Building the Docker Image
Navigate to the folder where the Dockerfile is located and run:

```bash
docker build -t joaopinheiro1241913/chat-server:version2 -f Dockerfile ../../../..
```

- `-t` assigns a tag: `joaopinheiro1241913/chat-server:version2`
- `-f` specifies the path to the Dockerfile
- `../../../..` sets the **build context** to ensure access to the compiled JAR file

To verify the image creation:

```bash
docker images
```

Expected output:

![dockerimagesv2](https://i.postimg.cc/kMFHdvHL/version2.png)


---

### ▶️ Running the Container
Run the image using:

```bash
docker run -p 59001:59001 joaopinheiro1241913/chat-server:version2
```

- Port `59001 is exposed and mapped just like in version 1.
- The container launches the chat server using the pre-compiled JAR.

Docker container running successfully, as shown below:


![dockerrunv2](https://i.postimg.cc/vZD2fFmd/Screenshot-2025-05-19-at-01-19-10.png)

---

### 💬 Testing the Chat Client
To test functionality, navigate to the directory where the client resides and run:

```bash
./gradlew runClient
```

Open two separate terminals to simulate multiple clients to test the chat functionality. You should see:

![chatv2](https://i.postimg.cc/cCXTtXyH/Chat-Client-App.png)

Inside the Docker container logs, messages will appear showing client connections and interactions.

![chatv2running](https://i.postimg.cc/gktNYSHt/Screenshot-2025-05-19-at-01-25-56.png)

---

### 📤 Pushing to Docker Hub
Once confirmed, the image was pushed to Docker Hub:

```bash
docker push joaopinheiro1241913/chat-server:version2
```

The image became publicly accessible in the Docker Hub repository, ready for sharing or deployment.

You can also manage your images visually through Docker Desktop, which shows metadata such as tags, size, and creation time, as shown below:

![dockerappimages](https://i.postimg.cc/ZRj6wnfs/Screenshot-2025-05-19-at-01-36-48.png)

---

##  Git Activity: Commits & Issues

Throughout the assignment, issues were created to manage tasks and commits were made to reflect progress and implementation steps.

---

### 📌 Completed Issues

A set of issues were created and resolved to guide the workflow, such as:

![ca2p3issues](https://i.postimg.cc/gkjHBybV/Implement-Dockerfile-for-Chat-Server-Deploy-Pre-Built-JAR-from-Host-Version-2.png)

---

### 🗂️ Git Commits

Commits were made incrementally to ensure each change was tracked and reversible, following best practices in version control. This includes:

![ca2p3commits](https://i.postimg.cc/W3V79Qsz/Add-Dockerfile-for-CA2-Part-3-Version-1-Readme-for-part3.png)

---

## Conclusion of Part 3

In this part of the assignment, the chat server was successfully containerized using Docker through **two different strategies**:

- **Version 1**: Built and compiled entirely within the Dockerfile (internal build).
- **Version 2**: Built locally on the host machine and only the JAR was copied into the image (external build).

Both approaches demonstrate Docker’s versatility in supporting different build pipelines and deployment needs. This project provides a practical foundation for adopting container-based workflows in future **DevOp** and **cloud-native environments**.














