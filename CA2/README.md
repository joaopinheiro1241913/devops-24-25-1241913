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

### **💻 Virtualization & Infrastructure**
![UTM](https://img.shields.io/badge/UTM-1e1e1e?style=for-the-badge&logo=apple&logoColor=white)  
![QEMU](https://img.shields.io/badge/QEMU-FF6600?style=for-the-badge&logo=qemu&logoColor=white)  
![Vagrant](https://img.shields.io/badge/Vagrant-1868F2?style=for-the-badge&logo=vagrant&logoColor=white)  

![Lima](https://img.shields.io/badge/Lima-000000?style=for-the-badge&logo=linux&logoColor=white)  
![VMware Fusion](https://img.shields.io/badge/VMware%20Fusion-607078?style=for-the-badge&logo=vmware&logoColor=white)

---

### **🖥️ Back-End**
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)  
![Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)

---

### **🛠️ Build & Dependency Management**
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

### **🛢️ Database**
![H2 Database](https://img.shields.io/badge/H2-004C99?style=for-the-badge&logo=h2&logoColor=white)

---

### **📂 Version Control**
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

---

### **🔐 SSH & Provisioning**
![SSH](https://img.shields.io/badge/SSH-000000?style=for-the-badge&logo=openssh&logoColor=white)

---

## 📖 Table of Contents

This section provides a structured breakdown of CA2 assignment, which is divided into four main parts:

- **[Part 1: Virtualization with Vagrant - Practice with Virtual Machine]()**
- **[Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs]()**
- **[Part 3: Dockers]()**
- **[Part 4: ]()**

---

### Full Table of Contents

Below is the complete breakdown, covering all tasks and requirements in detail.

- [Introduction](#introduction)
- **[Part 1: Virtualization with Vagrant - Practice with Virtual Machine]()**
    - [Introduction to Part 1]()
    - [Final Results]()
    - [Overall Conclusion of Part 1]()

- **[Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs]()**
    - [Introduction to Part 2]()
    - [Final Results]()
    - [Overall Conclusion of Part 2]()
  
- **[Part 3: Dockers]()**
    - [Introduction to Part 3]()
    - [Final Results]()
    - [Overall Conclusion of Part 3]()
  
- **[Part 4:]()**
    - [Introduction to Part 4]()
    - [Final Results]()
    - [Overall Conclusion of Part 4]()

- [Overall Conclusion of CA2](#overall-conclusion-of-ca2)

---


## Introduction
This **CA1 assignment** aims to explore **key elements of modern software development** and to practice these, through three distinct parts. This project focuses on three core aspects: **version control**, **build automation**, and **workflow management**. By utilizing tools such as Git, Mercurial, Gradle and Ant, we seek to illustrate how each technology enhances an effective and cooperative development atmosphere.


---

# Part 1: Virtualization with Vagrant - Practice with VM

---

## Introduction to Part 1
This section corresponds to the part1 of the second class assignment (CA2) in the DevOps course, focusing on 


Main goal:
Practice with VirtualBox/UTM Virtual Machine with Ubuntu, using the same projects from the previous assignments, but now inside the VM.

Practice running your previous projects (Spring Boot and Gradle-based) inside a virtual machine (VM) running Ubuntu Server, using Virtual Box or UTM (for Apple Silicon / ARM64 Macs).


---


# Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs

---

## Introduction to Part 2
This section corresponds to the part2 of the second class assignment (CA2) in the DevOps course, focusing on

Main goal:
Use Vagrant to setup a virtual environment to execute the tutorial spring boot application, gradle “basic” version (developed in CA1, Part3).

Use Vagrant to automatically provision a development environment with two VMs:
- One for the **Spring Boot application** (with Tomcat)
- One for the **H2 database** server


**ALTERNATIVE**

We should also present an alternative technological solution for the virtualization tool (an hypervisor alternative to VirtualBox or Qemu for MacOS Arm processors), analyze how the alternative solution compares to the base solution (Qemu) regarding virtualization features, and implement it and show how it can be used with vagrant to solve the same goals presented for this assignment.

Analyze, describe and implement an alternative virtualizaiton tool (besides QEMU/UTM).


---

## Alternative Solution for Virtualization Tool: Lima/VMWare

### Introduction

For this assignment, it was asked to present an alternative virtualization tool (besides UTM/QEMU).

#### Must:
1. **Compare** it to UTM in terms of:
- Virtualization Features
- Performance
- Compatibility
- Integration with Vagrant

2. **Implement** the alternative and **describe** how the alternative solution can solve the same goals.

---