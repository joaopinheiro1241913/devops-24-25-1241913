# CA2 Part 4: Docker Compose - Multi-Container Deployment with Docker Compose

---

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## Table of Contents

- [Introduction to Part 4](#introduction-to-part-4)
  - [Key Topics Covered](#-key-topics-covered)
- [H2 Database Dockerfile](#-h2-database-dockerfile-)
  - [Explanation - db Dockerfile (H2 Database)](#-explanation--db-dockerfile-h2-database)
- [Spring Boot Web App Dockefile](#-spring-boot-web-app-dockerfile)
  - [Explanation - web Dockerfile (Spring Boot App)](#-explanation---web-dockerfile-spring-boot-app)
- [Docker Compose](#-docker-compose)
  - [Explanation of Key Sections](#-explanation-of-key-sections)
  - [Compose Summary Table](#-compose-summary-table)
- [Building and Running the Services](#building-and-running-the-services)
  - [Result](#-result)
- [Tagging and Pushing Images to Docker Hub](#tagging-and-pushing-images-to-docker-hub)
  - [Verifying Local Images](#-1-verifying-local-images)
  - [Tagging the Images](#-2-tagging-the-images)
  - [Pushing the Images to Docker Hub](#-3-pushing-the-images-to-docker-hub)
- [Verifying Database File Placement in the Volume](#verifying-database-file-placement-in-the-volume)
  - [Acessing the DB Container](#-accessing-the-db-container)
  - [Copying the H2 JAR File to the Volume](#-copying-the-h2-jar-file-to-the-volume)
  - [Why this Matters](#-why-this-matters)
- [Alternative Solution - Kubernetes and Heroku](#-alternative-solution---kubernetes-and-heroku)
  - [Option 1: Kubernetes](#-option-1-kubernetes)
    - [Comparative Analysis](#-comparative-analysis)
    - [How Kubernetes Could Solve This Assignment](#-how-kubernetes-could-solve-this-assignment)
    - [Implementation Steps](#-implementation-steps)
  - [Option 2: Heroku Deployment](#-option-2-heroku-deployment)
    - [Overview](#-overview)
    - [Deployment to Heroku](#-deployment-to-heroku-)
- [Git Activity: Commits & Issues](#-git-activity-commits--issues)
  - [Completed Issues](#-completed-issues)
  - [Git Commits](#-git-commits)
- [Conclusion of Part 4](#conclusion-of-part-4)
  - [What Was Achieved](#-what-was-achieved)
  - [Alternative Technologies Explored](#-alternative-technologies-explored)
  - [Final Thoughts](#-final-thoughts)

---

## Introduction to Part 4
This part of the assignment focuses on containerizing a **full-stack web application** along with its **database** using **Docker** and **Docker Compose**. The primary objective is to demonstrate how to package, deploy, and manage multiple interconnected services in isolated, portable containers, ensuring consistency across different environments.

Unlike previous parts where single containers were managed, here we explore **multi-container orchestration** using Docker Compose, simplifying the setup and management of dependent services such as a web server and a database.

Additionally, this project briefly investigates alternative deployment approaches using:

- **Heroku**: a cloud platform that streamlines application deployment and maintenance
- **Kubernetes**: a powerful container orchestration tool widely used in cloud-native environments

---

### 📚 Key Topics Covered

- 🐳 **Creation of Dockerfiles** tailored for both the web application and the database service
- ⚙️ **Configuration of Docker Compose** to orchestrate and manage the multi-container environment
- 📦 **Building, tagging, and pushing Docker images** to a remote container registry
- ☁️ **Deployment exploration on Kubernetes** as an alternative orchestration solution
- 🚀 **Alternative deployment on Heroku**, showcasing cloud-based container deployment

---

By working through these steps, this assignment deepens practical understanding of containerization concepts, multi-service orchestration, and modern deployment workflows essential for scalable and maintainable application delivery.

This project extends previous learning by moving beyond single-container setups to orchestrating complete application stacks, enhancing knowledge of real-world DevOps practices with Docker Compose and cloud deployment alternatives. 🐋






To containerize the full-stack application and its accompanying database, I created two separate **Dockerfiles**: one for the **web application** and another for the **H2 database**. These define how each Docker image is built, including base images, dependencies, build steps, and runtime configuration.

To orchestrate both services, I used **Docker Compose**, which simplifies multi-container setups by defining all configurations in a single `docker-compose.yml` file.

Below is a breakdown of the configuration used in each file, along with detailed explanations of their purpose and structure.

---

## 🐳 H2 Database Dockerfile 

📍 Location: `CA2/Part4/db/Dockerfile`

```dockerfile
FROM amazoncorretto:17-alpine

WORKDIR /h2

RUN apk add --no-cache wget && \
wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar && \
apk del wget

EXPOSE 8082 9092

CMD ["java", "-cp", "h2-1.4.200.jar", "org.h2.tools.Server", "-web", "-webAllowOthers", "-tcp", "-tcpAllowOthers", "-ifNotExists"]
```



### 🔍 Explanation – `db` Dockerfile (H2 Database)
- **🐳 Base Image**: Uses Amazon Corretto with Alpine (`amazoncorretto:17-alpine`) for a lightweight and secure JDK 17 runtime.
- **📁 Working Directory**: `/h2` contains the database files.
- **📦 Dependencies**: Downloads the H2 `.jar` from Maven.
- **🔌 Ports**:
  - `8082` – 🌐 Web UI
  - `9092` – 🔗 TCP connections
- **🏁 Command**: Launches the H2 server with flags to:
  - Enable web and TCP access
  - Allow remote connections
  - Auto-create the database if it doesn't exist


---

## 🌐 Spring Boot Web App Dockerfile

📍 Location: `CA2/Part4/web/Dockerfile`

```dockerfile
FROM eclipse-temurin:17-jdk AS builder

# Create a directory for the project
WORKDIR /web

# Copy the repository and navigate to the project directory
COPY CA1/part3/react-and-spring-data-rest-basic /web

# Navigate to the project directory
WORKDIR /web

# Change the permissions of the gradlew file to make it executable
RUN chmod +x gradlew

# Run the gradle build command
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:17-jre

# Copy the generated JAR file to the Tomcat webapps directory
WORKDIR /web

COPY --from=builder /web/build/libs/*jar app.jar
# State the port that our application will run on
EXPOSE 8080

# Start Tomcat automatically when the container starts
CMD ["java", "-jar", "app.jar"]
```

### 🔍 Explanation - `web` Dockerfile (Spring Boot App)
- **🧱 Multi-stage Build**:
    - 🏗️ Stage 1: Uses `eclipse-temurin:17-jdk` to build the app with Gradle.
    - 🚀 Stage 2: Copies the generated `.jar` to a smaller jre runtime image.
- **🔌 Port 8080**: Exposed for HTTP traffic to the Spring Boot application.
- **🌐 Embedded Server**: No need for external Tomcat—Spring Boot includes its own embedded server.
- **📁 Build Context**: The project source is copied from host to `/web` for compilation

---

##  🧩 Docker Compose

📍 Location: `CA2/Part4/docker-compose.yml`

```yaml
version: '3.8'

services:
db:
build: ./db
ports:
- "8082:8082"
- "9092:9092"
volumes:
- ./data:/usr/src/data-backup
networks:
my_own_network:
ipv4_address: 192.168.56.11

web:
build:
context: ../../
dockerfile: CA2/Part4/web/Dockerfile
ports:
- "8080:8080"
networks:
- my_own_network
depends_on:
- db

networks:
my_own_network:
driver: bridge
ipam:
config:
- subnet: "192.168.56.0/24"
```


### 🧵 Explanation of Key Sections

**🔧 Version**
- Uses Docker Compose version `3.8` to leverage the latest features and compatibility.

**🛢️ DB Service**
- **Build context**: `./db` directory.
- **Ports exposed:**
  - `8082`: Web console access.
  - `9092`: TCP access for applications.
- **Volumes**:
  - Mounts `./data` on the host to `/usr/src/data-backup` inside the container for persistence.
- **Networking:**
  - Connected to `my_own_network` with static IP `192.168.56.11`.

**🌐 Web Service**
- **Build context**: Root project directory using a custom Dockerfile path.
- **Ports exposed:**
  - `8080`: Spring Boot web app.
- **Dependency:**
  - Waits for `db` service to be up (`depends_on`).
- **Networking:**
  - Shared network with the database for internal communication.
  
**🔗 Network Configuration**

- **Network name**: `my_own_network`
- **Driver**: `bridge` for container-to-container isolation.
- **Subnet**: `192.168.56.0/24` for predictable IP allocation within the Docker internal network.

### 📊 Compose Summary Table

| Section            | Component        | Description |
|--------------------|------------------|-------------|
| **Version**        | `3.8`            | Uses Docker Compose version 3.8 for modern features and compatibility. |
| **Service: db**    | `build`          | Builds the image from the `./db` directory containing the Dockerfile for the H2 database. |
|                    | `ports`          | Maps host ports `8082:8082` (web interface) and `9092:9092` (TCP server). |
|                    | `volumes`        | Mounts `./data` on the host to `/usr/src/data-backup` in the container for data persistence. |
|                    | `networks`       | Connects to a custom network `my_own_network` with a static IP `192.168.56.11`. |
| **Service: web**   | `build`          | Builds from the root project using `CA2/Part4/web/Dockerfile`. |
|                    | `ports`          | Maps container port `8080` to host for web access. |
|                    | `depends_on`     | Ensures the database container starts before the web application. |
|                    | `networks`       | Connects to `my_own_network` to enable communication with the database. |
| **Network**        | `driver`         | Uses `bridge` driver for container-to-container communication isolation. |
|                    | `subnet`         | Sets custom IP range `192.168.56.0/24` for deterministic IP addressing within the network. |

---

## Building and Running the Services

To build and run both the **web application** and the **H2 database** services using Docker Compose, I used the following command:

```bash
docker-compose up --build
```

![dockercomposebuild](https://i.postimg.cc/zG1F7y85/Screenshot-2025-05-19-at-03-36-55.png)

### ✅ Result
Once the services were up and running:

- **🌐 Web Application** was accessible at:
`http://localhost:8080/basic-0.0.1-SNAPSHOT/`

- **🛢️ H2 Database Console** was accessible at:
`http://localhost:8082`

These endpoints confirm that both the frontend/backend application and the database were successfully deployed and running in isolated containers.
Below are screenshots demonstrating successful access to both the application and the H2 web interface.

![dockercomposespringapp](https://i.postimg.cc/Hk44hTkM/josopinheiro-Joaos-MBP-4-part4-docker-compose-up-build.png)

![dockercomposeh2](https://i.postimg.cc/d3rTZ97C/Screenshot-2025-05-19-at-03-45-59.png)

---

##  Tagging and Pushing Images to Docker Hub

To make the Docker images available online, I verified, tagged, and pushed them to my Docker Hub repository.

---

### 📦 1. Verifying Local Images
After building the containers with Docker Compose, I opened **Docker Desktop** to confirm that the images had been successfully created.

- ✅ The `web` and `db` images were listed under **Images**, showing:
    - Image Name & Tag
    - Size
    - Creation Time

![dockercimages](https://i.postimg.cc/Dy3GkRDP/o-mayo.png)


You can also verify this via the terminal using:

```bash
docker images
```

![di](https://i.postimg.cc/fT054BZq/joaopinheiro1241913chat-server.png)

---

### 🏷️ 2. Tagging the Images
Even though the images appeared in Docker Desktop, they needed to be **tagged** correctly for Docker Hub.

#### 🔧 Using the CLI:

```bash
docker tag <image-id> <your-username>/<repository-name>:<tag>
```



In my case:

```bash
docker tag 5169ebb19aa4 joaopinheiro1241913/part4-web:web
docker tag a8618403f37a joaopinheiro1241913/part4-db:db
```

![dockercimages2](https://i.postimg.cc/XqfpY7hc/part4-neb.png)

✅ These commands:

- Assign readable names and tags.
- Don’t duplicate the image — just reference the same image ID with a new tag.

![dockercimageswithtags](https://i.postimg.cc/NG6MTFJR/minutes-ago.png)

---

### ☁️ 3. Pushing the Images to Docker Hub
Before pushing, I logged into my Docker Hub account:

```bash
docker login
```

Then I pushed both images:

```bash
docker push joaopinheiro1241913/part4-web:web
docker push joaopinheiro1241913/part4-db:db
```

![dockerpush](https://i.postimg.cc/9MGWGgpc/Screenshot-2025-05-19-at-04-07-08.png)

🔐 This uploaded the `web` and `db` images to **Docker Hub**, making them accessible from any machine with Docker.
Below is a screenshot showing the successful push of the images to Docker Hub:

![dockersearch2](https://i.postimg.cc/xTFSbS2K/Search-results-for-joaopinheiro1241913-Setttak-o.png)

---

## Verifying Database File Placement in the Volume
To ensure that the **H2 database JAR file** was correctly persisted across container restarts, I inspected the mounted volume within the running database container and manually copied the file if necessary.

---

### 🐚 Accessing the DB Container

I executed the following command to open a shell inside the running `db` container:

```bash
docker-compose exec db sh
```

---

### 📤 Copying the H2 JAR File to the Volume

Once inside the container shell, I used the `cp` command to place the H2 JAR file in the mounted volume directory:

```bash
cp h2-1.4.200.jar /usr/src/data-backup
exit
```

📌 This ensures that the file is stored **outside the container's ephemeral layer**, enabling persistence even after container removal or recreation.


![dockercomposecp](https://i.postimg.cc/HxjNmrrR/Screenshot-2025-05-19-at-04-19-55.png)

---

### ✅ Why This Matters

| 🧩 Step                     | 🔍 Description                                                                 |
|----------------------------|-------------------------------------------------------------------------------|
| `docker-compose exec db sh` | Enters the running database container for manual inspection or modification.  |
| `cp h2-1.4.200.jar ...`     | Copies the H2 JAR to the volume directory, making it persist on the host.     |
| `/usr/src/data-backup`      | Path inside the container mapped to the host volume (`./data`).              |
| `exit`                      | Closes the interactive shell session within the container.                    |
| 🛡️ Persistence Benefit      | Ensures the H2 JAR is retained even if the container is removed/rebuilt.     |

---


## 🚀 Alternative Solution - Kubernetes and Heroku

This section explores two popular alternatives to Docker-only workflows: **Kubernetes** and **Heroku**.

---

### ⚙️ Option 1: Kubernetes

#### 🔍 Comparative Analysis

| Feature                            | 🐳 Docker Compose                 | ☸️ Kubernetes                              |
|------------------------------------|----------------------------------|--------------------------------------------|
| Container Orchestration            | Basic (single-host)              | Advanced (multi-host, cloud-native)         |
| Scaling                            | Manual                           | Automated and declarative                   |
| Load Balancing                     | Requires external config         | Built-in via Services                       |
| Networking                         | Simple bridge                    | Advanced service discovery and networking   |
| Declarative Configuration          | YAML                             | YAML (more complex and granular)            |
| Ecosystem                          | Standalone                       | Cloud-native, integrates with Helm, etc.    |
| Best Use Case                      | Development, small projects      | Production-grade deployments                |

#### 🧠 How Kubernetes Could Solve This Assignment

Kubernetes could replicate and **enhance** the goals of this assignment by:

- Using **Deployments** and **Services** to manage both the `web` and `db` containers.
- Ensuring high availability with **replica sets** and **automatic restarts**.
- Allowing scalability by setting replicas for the Spring app.
- Exposing the services via **LoadBalancer** or **Ingress** for cloud access.
- Managing persistent data using **Persistent Volume Claims (PVCs)** for the H2 database.

#### ⚙️ Implementation Steps

1. Creating YAML files for:
  - `web-deployment.yaml` and `db-deployment.yaml`
  - `service-web.yaml` and `service-db.yaml`
2. Using `kubectl apply -f` to deploy them.
3. Exposing ports and configuring volumes for persistent data.

📘 *Explore further at:* https://kubernetes.io

---

### ☁️ Option 2: Heroku Deployment

#### 🔍 Overview

| Feature                     | Docker + Local                    | Heroku                                         |
|-----------------------------|-----------------------------------|-----------------------------------------------|
| Deployment Type             | Local containers                  | Cloud-managed container deployment            |
| Hosting                     | Developer's machine               | Heroku-managed infrastructure                 |
| Scaling                     | Manual or docker swarm            | One-click horizontal/vertical scaling         |
| Persistent Storage          | Host volumes                      | Add-ons (e.g., Heroku Postgres)               |
| Ease of Use                 | CLI-based, flexible               | Streamlined, developer-friendly               |
| Integration                 | Manual                            | GitHub, CI/CD pipelines built-in              |

#### ☁️ Deployment to Heroku 

1. **Create a Heroku app** with container support:

   ```bash
   heroku login
   heroku container:login
   heroku create your-app-name

2. **Tag your Docker image for Heroku:**
```bash
docker tag your-app-image registry.heroku.com/your-app-name/web
```

3. **Push the image to Heroku Container Registry:**

```bash
docker push registry.heroku.com/your-app-name/web
```

4. **Release the container** on Heroku:

```bash
heroku container:release web -a your-app-name
```

5. **Open your deployed app:**

```bash
heroku open -a your-app-name
```

💡 For database functionality, Heroku add-ons such as **Heroku Postgres** or external Dockerized databases hosted on other services can be used.

📘 Explore further at: https://www.heroku.com

---

##  Git Activity: Commits & Issues

Throughout the assignment, issues were created to manage tasks and commits were made to reflect progress and implementation steps.

---

### 📌 Completed Issues

A set of issues were created and resolved to guide the workflow, such as:

![ca2p4issues](https://i.postimg.cc/GhPqZFM9/Screenshot-2025-05-19-at-04-26-21.png)

---

### 🗂️ Git Commits

Commits were made incrementally to ensure each change was tracked and reversible, following best practices in version control. This includes:

![ca2p4commits](https://i.postimg.cc/Pfg7GrTV/Screenshot-2025-05-19-at-03-59-34.png)

---

## Conclusion of Part 4


This project provided **hands-on experience** with modern containerization and orchestration tools, highlighting essential DevOps practices.


### 🛠️ What Was Achieved

- ✅ Containerized a **React + Spring Boot web application** and an **H2 database** using custom Dockerfiles.
- ✅ Used **Docker Compose** to orchestrate and network the services in a shared, isolated environment.
- ✅ Configured **persistent volumes** to ensure database files and artifacts were retained across container restarts.
- ✅ Tagged and pushed Docker images to **Docker Hub**, showcasing container distribution and reuse.

---

### ☸️ Alternative Technologies Explored
- **🔄 Kubernetes** was analyzed as a more scalable alternative for orchestration, especially for production use.
- **☁️ Heroku** was explored as a simple cloud deployment option, demonstrating how containerized applications can be pushed and hosted in the cloud with minimal setup.

---

### 🎯 Final Thoughts
Through this assignment, I developed a strong understanding of:

- How to **build**, **orchestrate**, and **persist** containerized services.
- How to explore **cloud deployment alternatives** like Kubernetes and Heroku.
- The power of **Docker Compose** as a simple but effective orchestration tool in development and testing environments.

This hands-on experience strengthened my understanding of modern DevOps practices, container lifecycles, and deployment workflows.
