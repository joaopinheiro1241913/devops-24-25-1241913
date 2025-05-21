<h1 style="font-size: 48px;">CA2: TECHNICAL REPORT</h1>

---

## 📌 Project Details

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## 🛠️ Technologies Used 

### 🛠️ **Virtualization & Infrastructure**
![UTM](https://img.shields.io/badge/UTM-FF5722?style=for-the-badge&logo=apple&logoColor=white)  
![QEMU](https://img.shields.io/badge/QEMU-FF0000?style=for-the-badge&logo=qemu&logoColor=white)  
![Vagrant](https://img.shields.io/badge/Vagrant-1563FF?style=for-the-badge&logo=vagrant&logoColor=white)  
![VMware Fusion](https://img.shields.io/badge/VMware%20Fusion-607078?style=for-the-badge&logo=vmware&logoColor=white)  
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)  
![Docker Compose](https://img.shields.io/badge/Docker%20Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)  
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)  
![Heroku](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)

---

### 💻 **Backend Development**
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)  
![Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)

---

### 📦 **Build Automation**
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

### 🗄️ **Database**
![H2 Database](https://img.shields.io/badge/H2%20Database-4479A1?style=for-the-badge&logo=datagrip&logoColor=white)

---

### **📂 Version Control**
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

---



## 📖 Table of Contents

This section provides a structured breakdown of CA2 assignment, which is divided into four main parts:

- **[Part 1: Virtualization with Vagrant - Practice with Virtual Machine]()**
- **[Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs]()**
- **[Part 3: Docker - Containerization with Docker]()**
- **[Part 4: Docker Compose - Multi-Container Deployment with Docker Compose]()**

---

### Full Table of Contents

Below is the complete breakdown, covering all tasks and requirements in detail.

- [Introduction](#introduction)
- [Project Structure and Documentation](#project-structure-and-documentation)


- **[Part 1: Virtualization with Vagrant - Practice with Virtual Machine]()**
  - [Introduction to Part 1](#introduction-to-part-1)
    - [Main Objectives](#-main-objectives)
  - [Virtual Machine Setup with UTM](#-virtual-machine-setup-with-utm)
    - [Tools Required](#-tools-required)
    - [Step-by-Step Installation guide](#-step-by-step-installation-guide)
    - [Creating the VM in UTM](#-creating-the-vm-in-utm)
  - [Network and Services Configuration](#-network-and-services-configuration-)
    - [Host-Only Networking in UTM](#-host-only-networking-in-utm)
    - [Network Configuration in Ubuntu VM](#-network-configuration-in-ubuntu-vm)
    - [Remote Connection Configuration](#-remote-connection-configuration)
    - [FTP Setup](#-ftp-setup-)
  - [Cloning the Repository via SSH](#-cloning-the-repository-via-ssh-)
  - [Development Environment Setup](#-development-environment-setup)
  - [Executing Spring Boot and Gralde Projects Inside the Virtual Machine](#executing-spring-boot-and-gradle-projects-inside-the-virtual-machine)
    - [Execute the Spring Boot Tutorial Basic Project (Maven-Based)](#-execute-the-spring-boot-tutorial-basic-project-maven-based)
    - [Execute the gradle_basic_demo Project - Part 1](#-execute-the-gradle_basic_demo-project--part-1-)
    - [Execute the gradle_basic_demo Project - Part 2](#-execute-the-gradle_basic_demo-project--part-2-)
  - [Git Activity: Issues](#-git-activity-commits--issues)
  - [Conclusion of Part 1](#conclusion-of-part-1)
    - [Summary](#-summary)
    - [Key Learnings](#-key-learnings)
    - [Challenges Overcome](#-challenges-overcome)
    - [Final Thoughts](#-final-thoughts)


- **[Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs]()**
  - [Introduction to Part 2](#introduction-to-part-2)
    - [Main Goals](#-main-goals)
  - [Environment Setup](#-environment-setup)
    - [Installing Vagrant](#-installing-vagrant)
    - [Keeping the Repository Clean](#-keeping-the-repository-clean)
    - [Project Directory Setup](#-project-directory-setup)
  - [Modifications for QEMU Compatibility](#-modifications-for-qemu-compatibility)
    - [Key Modifications](#-key-modifications)
    - [Summary of Results](#-summary-of-results)
  - [Configuring Spring Boot for H2 Database Connectivity](#-configuring-spring-boot-for-h2-database-connectivity)
    - [Spring Boot - application.properties](#-1-spring-boot--applicationproperties)
    - [React Frontend - App.js](#-2-react-frontend--appjs)
  - [Running the Project within the Virtualized Environment](#-running-the-project-within-the-virtualized-environment)
    - [Starting the Virtual Machines](#-1-starting-the-virtual-machines)
    - [Verifying the Application and Database](#-2-verifying-the-application-and-database)
      - [Accessing the Spring Boot Frontend](#-accessing-the-spring-boot-frontend)
      - [Accessing the H2 Database](#-accessing-the-h2-database)
  - [Alternative Virtualization Solution: VMware Fusion](#-alternative-virtualization-solution-vmware-fusion-apple-silicon)
    - [Comparison: QEMU vs VMware Fusion](#-comparison-qemu-vs-vmware-fusion)
    - [Using VMware Fusion with Vagrant](#-using-vmware-fusion-with-vagrant)
    - [Notes on Apple Silicon](#-notes-on-apple-silicon-m1m2m3)
    - [Final Remarks on Tool Comparison](#final-remarks-on-tool-comparison)
  - [Git Activity: Issues](#-git-activity-commits--issues)
  - [Conclusion of Part 2](#conclusion-of-part-2)
    - [Key Implementation Highlights](#-key-implementation-highlights)
    - [Alternative Tool Evaluation: VMware Fusion](#-alternative-tool-evaluation-vmware-fusion)

  
- **[Part 3: Docker - Containerization with Docker]()**
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


- **[Part 4: Docker Compose - Multi-Container Deployment with Docker Compose]()**
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


- [Overall Conclusion of CA2](#overall-conclusion-of-ca2)

---


## Introduction
This **CA2 assignment** delves into **advanced aspects of software development infrastructure and deployment**, structured into four distinct parts. The project emphasizes **virtualization**, **containerization**, and **orchestration**, leveraging tools such as **UTM**, **Vagrant**, **VMWare**, **Docker**, **Docker Compose**, **Kubernetes** and **Heroku**. By configuring **virtual machines**, creating **containerized environments**, and implementing **multi-container orchestration**, we aim to demonstrate how these technologies streamline **application deployment** and foster **scalable**, **cross-platform development workflows**.

#### Virtualization and Environment Setup
Virtualization is essential for creating isolated development environments, ensuring consistency across different systems. In this project, we utilize UTM and Vagrant to set up and manage virtual machines running Ubuntu Server (ARM). This approach allows for replicating production-like environments locally, facilitating testing and development. Additionally, we explore an alternative virtualization solution, comparing the capabilities of VMware and QEMU, focusing on compatibility with ARM processors and macOS.

#### Containerization and Deployment
Containerization streamlines application deployment by encapsulating code and dependencies in isolated containers. In this assignment, we implement Docker to package and deploy a Spring Boot application and a database service. We explore two containerization strategies: building the application within the container and deploying a pre-built JAR file from the host. This dual approach highlights the advantages and trade-offs of each method, such as build time, portability, and dependency management.

#### Multi-Container Orchestration
Orchestration simplifies the management of multiple containers, ensuring seamless communication and scaling. We leverage Docker Compose to define and run a multi-container environment consisting of a Spring Boot web server (Tomcat) and an H2 Database. Additionally, we investigate Kubernetes as a more advanced orchestration solution, assessing its potential for scaling, networking, and service discovery.

#### Deployment and Cloud Integration
Deploying containerized applications to the cloud provides scalability and accessibility. In this project, we explore deploying Docker containers to Heroku, analyzing how its platform-as-a-service (PaaS) capabilities can streamline deployment and simplify environment configuration. This section also discusses potential challenges and best practices for deploying multi-container applications in cloud environments.

---

## Project Structure and Documentation
To maintain clarity and organization, each part of this **CA2 assignment** has its own **README file**, providing detailed explanations, setup instructions, and implementation details relevant to that specific section. This README serves as a general overview of the entire assignment.


---

## 🧾 Overall Conclusion of CA2

This coursework provided a complete and practical journey through modern **DevOps workflows**, covering virtualization, containerization, service orchestration, and deployment.

Across the four parts:

- 🖥️ Virtual machines were provisioned using **UTM**, **Vagrant**, and **QEMU**, enabling isolated development environments tailored for Apple Silicon.
- ⚙️ Java and React applications were deployed and tested within these environments, simulating real-world infrastructure scenarios.
- 📦 Applications were successfully **containerized using Docker**, showcasing internal vs external build strategies and efficient image distribution.
- 🧩 **Docker Compose** was used to orchestrate multi-service architectures with persistent data storage and shared networks.
- ☁️ Alternative tools like **VMware Fusion**, **Kubernetes**, and **Heroku** were analyzed to broaden understanding of scalable, cloud-ready architectures.

This assignment strengthened my ability to provision infrastructure, deploy and manage services, and evaluate tooling decisions — skills essential for modern software development and operations.
