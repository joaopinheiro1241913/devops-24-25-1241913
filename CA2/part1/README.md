# CA2 Part 1: Virtualization with UTM - Practice with VM


---

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## Table of Contents

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


---

## 🧭 Introduction to Part 1 

This section of the assignment corresponds to **Part 1 of Class Assignment 2 (CA2)** for the DevOps course. It focuses on setting up and managing a **virtualized development environment** using **UTM** on **macOS (Apple Silicon)**.

The main goal was to gain practical experience with virtualization — a core DevOps skill — by deploying an **Ubuntu Server 18.04** virtual machine, configuring networking, enabling remote access, and running previous Spring Boot + Gradle projects inside the VM.

---

### 🎯 Main Objectives

- ✅ Practice using **UTM** (or VirtualBox for x86) to run a **Linux VM**.
- ✅ Install and configure **Ubuntu Server** (ARM64) inside the VM.
- ✅ Set up **networking (NAT + Host-only)** to allow both internet access and host communication.
- ✅ Enable **remote access** using SSH and optionally configure FTP.
- ✅ Reuse previous assignments by running a **Spring Boot + Gradle** project inside the VM.

This hands-on setup simulates a lightweight, isolated production-like environment suitable for DevOps workflows, CI/CD pipelines, or local development sandboxing.

---

## 🖥️ Virtual Machine Setup with UTM


### 🛠️ Tools Required

- **Platform:** macOS with Apple Silicon (M1/M2)
- **Tool Used**: [UTM](https://mac.getutm.app) – Virtual Machine Manager for macOS (compatible with ARM architecture)
- **ISO Image:** Ubuntu Server 18.04 ARM64 ISO – [Download here](https://cdimage.ubuntu.com/releases/18.04/release/)

---


### 📥 Step-by-Step Installation Guide

#### 1. Install UTM on macOS

- Visit: [https://mac.getutm.app](https://mac.getutm.app)
- Download and install the latest `.dmg` for UTM.
- Drag the UTM icon into your Applications folder.

#### 2. Download Ubuntu Server ISO (ARM)

- Go to: [Ubuntu 18.04 ARM Downloads](https://cdimage.ubuntu.com/releases/18.04/release/)
- Download the file: `ubuntu-18.04.6-server-arm64.iso`

---

### 🖥️ Creating the VM in UTM

#### 1. Open UTM and click **Create a New Virtual Machine**
#### 2. Configuration:

- **System**
  - Architecture: `ARM64 (aarch64)`
  - System: `Linux`
  - Memory: `2048 MB` (or more)
- **Storage**
  - Add a new disk (e.g., `20 GB`) → `Interface: VirtIO`
  - Boot ISO: Select the downloaded Ubuntu ISO
- **Shared Directory** (Optional): Add a folder to exchange files with host
- **Network**
  - Add **2 network adapters**:
    - Adapter 1: `NAT` (default) → internet access
    - Adapter 2: `Host Only` → isolated communication with macOS

#### 3. Start the VM

- Follow the Ubuntu installer steps to:
  - Select language and region
  - Create user and password
  - Use entire disk for installation
  - Complete the process and reboot

---


## 🌐 Network and Services Configuration 

This section outlines how the virtual machine’s network and essential services were configured using UTM on macOS for enhanced communication and remote access.

---

### 🔌 Host-Only Networking in UTM
Using UTM’s GUI:

1. Select your virtual machine.
2. Go to **Edit → Network**.
3. Set **Network Mode** to **Host Only**.

#### 📡 UTM Host-Only Network Configuration:

- **Guest Network**: `192.168.64.0/24`
- **DHCP Range**: `192.168.64.100` to `192.168.64.253`
- **Static IP Assigned**: `192.168.64.3` (chosen manually within the subnet)

---

### 🛠️ Network Configuration in Ubuntu VM
#### Step 1: Update System Packages

```bash
sudo apt update
```

#### Step 2: Install Network Tools

```bash
sudo apt install net-tools
```

#### Step 3: Configure Static IP with Netplan

Edit the Netplan configuration:

```bash
sudo nano /etc/netplan/50-cloud-init.yaml
```

Paste the following:

```yaml
network:
ethernets:
enp0s1:
dhcp4: true
enp0s2:
addresses:
- 192.168.64.3/24
version: 2
```

Apply changes:

```bash
sudo netplan apply
```

---

### 🔐 Remote Connection Configuration
#### 🧩 Install and Configure SSH

```bash
sudo apt install openssh-server
```

Enable password authentication:

```bash
sudo nano /etc/ssh/sshd_config
# Uncomment or set:
PasswordAuthentication yes
```

Restart SSH service:

```bash
sudo service ssh restart
```

####  SSH Access Example:

```bash
ssh youruser@192.168.64.3
```

---

### 📁 FTP Setup 
Install FTP server:

```bash
sudo apt install vsftpd
```

Enable write permissions:

```bash
sudo nano /etc/vsftpd.conf
# Uncomment:
write_enable=YES
```


Restart FTP service:

```bash
sudo service vsftpd restart
```

---



## 🔐 Cloning the Repository via SSH 


To clone the private repository securely from within the virtual machine (VM), I first configured SSH authentication between the VM and GitHub:

#### 1. Generate a New SSH Key Pair

```bash
ssh-keygen -t ed25519 -C "email@example.com"
```

#### 2. Add the Public Key to GitHub

Display the public key in the terminal:

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy the output, then:

- Go to `GitHub` → `Settings` → `SSH and GPG keys`
- Click **"New SSH key"**
- Paste the key, give it a name, and save

![keyy](https://i.postimg.cc/xdMY9GtP/My-VM-Ubuntu-SSH-Key.png)

#### 3. Clone the Repository

Once the SSH key is added to GitHub, clone the repo using:

```bash
git clone git@github.com:username/repository-name.git
```

This ensures secure, password-less access to your repository from the VM.

---

## ⚙️ Development Environment Setup
After cloning the repository, I installed the essential development tools:

### 🧱 System Update

```bash
sudo apt update
sudo apt upgrade
```

### 🔧 Install Git

```bash
sudo apt install git
```

### ☕ Install Java JDK & JRE (v17)

```bash
sudo apt install openjdk-17-jdk openjdk-17-jre
```

### 📦 Install Maven

```bash
sudo apt install maven
```

### ⚙️ Install Gradle

```bash
# Download the Gradle binary
wget https://services.gradle.org/distributions/gradle-8.6-bin.zip

# Create Gradle directory and unzip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-8.6-bin.zip

# Add Gradle to system PATH
echo "export GRADLE_HOME=/opt/gradle/gradle-8.6" >> ~/.bashrc
echo "export PATH=\$GRADLE_HOME/bin:\$PATH" >> ~/.bashrc
source ~/.bashrc
```

### ✅ Verify Installation
Check that everything is installed correctly:

```bash
git --version
java --version
mvn --version
gradle --version
```

With this setup, the virtual machine is ready for Java and Spring Boot development.


![versions](https://i.postimg.cc/zXSSvJYf/Apache-Maven.png)


---

##  Executing Spring Boot and Gradle Projects Inside the Virtual Machine

This section documents the process of running multiple Java-based projects from previous assignments within the Ubuntu Server virtual machine using both Maven and Gradle build tools.

---

### 📦 Execute the Spring Boot Tutorial Basic Project (Maven-Based)

This project was built and launched successfully within the VM using the following steps:

#### 📝 Steps Taken:

1. **Navigate to the Project Directory**:
   I accessed the `basic` directory, which contains the complete Spring Boot application setup.

2. **Run the Spring Boot Application:**

```bash
./mvnw spring-boot:run
```

3. **Check the VM’s IP Address** (used to access the app externally):

```bash
ip addr
```

4. **Access the Application from Host**:
Open your browser and visit:

Example URL to access the app in a browser from the host: http://192.168.64.3:8080/

![springapprunning](https://i.postimg.cc/G2VzFzXh/Screenshot-2025-05-13-at-11-12-31.png)
![sba](https://i.postimg.cc/fW1gmWPj/First-Name-Last-Name-Description-Job-Years.png)


The application loaded successfully, confirming:

- Spring Boot was properly set up.
- Networking between host and VM was functional.
- Backend services were operational.


---

### 💬 Execute the gradle_basic_demo Project – Part 1 
This project includes a server and a graphical client. Since the VM does not have a GUI, the server runs inside the VM and the client runs on the host.

#### ✅ Build and Run the Server (Inside VM)

```bash
./gradlew build
./gradlew runServer
```

#### 🖥️ Run the Client (From Host Machine)

Clone the project locally on the host (if not already cloned), then:

```bash
./gradlew runClient --args="192.168.64.3 59001"
```

Open multiple terminals and repeat to simulate multiple clients. Chat messages should flow in real-time between clients.

![chatter](https://i.postimg.cc/Th8mw4Cg/Screenshot-2025-05-13-at-12-51-04.png)


---

### 🌱 Execute the gradle_basic_demo Project – Part 2 

This project uses Gradle to build and run a Spring Boot backend.

#### ✅ Build and Run (Inside VM)

```bash
./gradlew build
./gradlew bootRun
```

#### 🌐 Access the Application

Use the IP address of the VM to open the app in your browser: http://192.168.64.3:8080/

If the landing page loads successfully, the app is running and serving requests correctly from the VM.




---

##  Git Activity: Issues

A set of issues were created and resolved to guide the workflow, such as:

![ca2p1issues](https://i.postimg.cc/RFFwbfW6/Closed-40.png)

---

## Conclusion of Part 1


This technical report documents the setup and execution of a virtual environment using **UTM** (on macOS for Apple Silicon) for **Class Assignment 2 – Part 1**.

### 🎯 Summary

The tasks completed included:
- Creating and configuring a virtual machine (VM).
- Setting up network and remote access capabilities.
- Installing and verifying essential development tools.
- Deploying and running Java-based projects (Spring Boot and Gradle).

These efforts provided valuable hands-on experience in managing virtual machines, networking, and DevOps tooling within a controlled and reproducible environment.

### 🧠 Key Learnings

- Gained practical understanding of **virtualization** and **VM provisioning**.
- Configured **host-guest networking** to enable communication between the VM and the host system.
- Installed and used **Maven**, **Gradle**, **Git**, and **Java SDK** in a headless Ubuntu Server environment.
- Identified and resolved issues related to IP configuration and SSH key setup.
- Successfully executed Spring Boot and Gradle projects, demonstrating realistic deployment and operations scenarios.

### 🔧 Challenges Overcome

- **Network Configuration**: Learned how to troubleshoot and configure static IPs and bridge adapters to allow web and terminal-based communication across environments.
- **SSH Access**: Enabled secure repository cloning via SSH by creating and linking SSH keys between GitHub and the VM.
- **Headless Environment**: Adjusted the development process to accommodate the lack of GUI in the Ubuntu Server VM, using host-based solutions where necessary (e.g., running Gradle clients on the host).

### 📈 Final Thoughts

Overall, this assignment enhanced my technical capabilities in virtualized DevOps environments and deepened my confidence in:
- Setting up isolated environments for development and testing.
- Managing Java project lifecycles using build tools.
- Troubleshooting cross-platform and cross-network development challenges.

These skills form a strong foundation for future DevOps tasks and will be crucial for both academic progression and professional readiness in the software development and operations field.

