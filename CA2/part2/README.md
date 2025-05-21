
# CA2 Part 2: Virtualization with Vagrant - Using Vagrant for Managing VMs

---

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

## Table of Contents

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



---

##  Introduction to Part 2

This technical report documents the processes and outcomes of **Class Assignment 2 - Part 2**, which focuses on virtualization using **Vagrant**. The objective of this assignment was to automate the provisioning of a virtualized environment for running a **Spring Boot application** connected to an **H2 database**, using **Vagrant** with multiple virtual machines (VMs).

### 🎯 Main Goals

- Use **Vagrant** to automatically provision a development environment with **two virtual machines**:
    - **VM 1:** Runs the Spring Boot application with **Tomcat**.
    - **VM 2:** Hosts the **H2 database server**.

- Demonstrate how to set up communication between the two VMs using Vagrant networking configuration.

- Analyze and implement an **alternative virtualization tool** to the default hypervisor (e.g., **QEMU**):
    - Present a working example using an alternative hypervisor (e.g., **VMware Fusion** for macOS on Apple Silicon).
    - Compare the alternative solution with QEMU in terms of virtualization features, performance, and ease of integration with Vagrant.

It builds upon the previous assignments, particularly **CA1 - Part 3**, which involved developing the **Gradle-based Spring Boot application**.

The main focus here is to:
- Deploy that application within a **virtualized multi-VM setup**.
- Use **Vagrant provisioning** to automate the setup process.
- Ensure proper **networking** and **communication** between the backend service (Spring Boot) and the database (H2).
- Explore the feasibility of using an **alternative hypervisor** on **macOS with Apple Silicon**, given the limitations of some default tools.



In the sections that follow, I detail the setup and execution process, challenges encountered, and insights gained from using Vagrant and alternative virtualization tools to manage multi-VM development environments effectively.

---

## 🧰 Environment Setup

This section outlines the steps taken to set up a virtualized environment using **Vagrant** with **QEMU** on **macOS**, as well as on a general system setup.

---

### 🛠️ Installing Vagrant

1. **Download Vagrant:**
    - I visited the official [Vagrant website](https://www.vagrantup.com/downloads) and downloaded the version appropriate for my operating system (macOS).

2. **Install Vagrant:**
    - I ran the installer and followed the provided setup instructions.
    - The installation was straightforward and required no advanced configuration.

3. **Verify Installation:**
    - To confirm that Vagrant was successfully installed, I ran the following command in the terminal:
      ```bash
      vagrant --version
      ```
    - This printed the installed Vagrant version, confirming a successful installation.

---

### 🧹 Keeping the Repository Clean

To avoid committing Vagrant-related files and unnecessary build artifacts, I updated the project's `.gitignore` file with the following lines:

```bash
.vagrant/
*.war
```

This ensures that temporary VM files and WAR artifacts are excluded from version control.

---

### 📂 Project Directory Setup

1. **Create Project Structure:**
- I created the following directory on my local machine to organize the files:

```bash
CA2/Part2/
```

2. **Clone the Base Project:**
- I cloned the base Vagrant multi-VM Spring Boot setup using the command:

```bash
git clone https://bitbucket.org/pssmatos/vagrant-multi-spring-tut-demo/
```

3. **Copy Vagrant Configuration Files:**
- I copied the necessary Vagrant configuration files from the cloned repository into my own project directory:

```bash
cp -r vagrant-multi-spring-tut-demo/* ~/devops-24-25-1241913/CA2/Part2/
```

- On macOS, I used the configuration inside the `macOs/` directory of the cloned repository, which is tailored for QEMU or compatible virtualization platforms.

---

## 🛠️ Modifications for QEMU Compatibility

After acquiring the base Vagrant configuration, I made several **key adjustments** to the `Vagrantfile` to meet the needs of our project.


### 🔧 Key Modifications:
1. **Repository URL Update:**
- Replaced the default Git repository URL with a link to my own Spring Boot project repository:
2. **Path Adjustments:**
- Updated file paths within provisioning scripts to match the structure of my local repository.
3. **Spring Boot Execution:**
- Added the command `./gradlew bootRun` to automatically run the application after provisioning.
3. **Java Version Upgrade:**
- Switched from default JDK to OpenJDK 17 to ensure compatibility with the Spring Boot application.


Here is a cleaned-up version of the final `Vagrantfile`, highlighting important configuration aspects:

```ruby
Vagrant.configure("2") do |config|
  config.vm.box = "perk/ubuntu-2204-arm64"

  # This provision is common for both VMs
  config.vm.provision "shell", inline: <<-SHELL
    sudo apt-get -y update
    sudo apt-get install -y iputils-ping avahi-daemon libnss-mdns unzip \
         openjdk-17-jdk-headless
    # ifconfig
  SHELL

  #============
  # Configurations specific to the database VM
  config.vm.define "db" do |db|
    db.vm.box = "perk/ubuntu-2204-arm64"
    db.vm.hostname = "db"

    db.vm.provider "qemu" do |qe|
      qe.arch = "aarch64"
      qe.machine = "virt,accel=hvf,highmem=off"
      qe.cpu = "cortex-a72"
      qe.net_device = "virtio-net-pci"
      qe.memory = "512"
      qe.ssh_port = 50122
      qe.extra_qemu_args = %w(-netdev vmnet-host,id=vmnet,start-address=192.168.56.1,end-address=192.168.56.255,subnet-mask=255.255.255.0 -device virtio-net-pci,mac=52:54:00:12:34:50,netdev=vmnet)
    end

    # We want to access H2 console from the host using port 8082
    # We want to connet to the H2 server using port 9092
    db.vm.network "forwarded_port", guest: 8082, host: 8082
    db.vm.network "forwarded_port", guest: 9092, host: 9092

    # We need to download H2 and configure host-network
    config.vm.provision "shell", inline: <<-SHELL
      wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar
    SHELL

    # The following provision shell will run ALWAYS so that we can execute the H2 server process
    # This could be done in a different way, for instance, setiing H2 as as service, like in the following link:
    # How to setup java as a service in ubuntu: http://www.jcgonzalez.com/ubuntu-16-java-service-wrapper-example
    #
    # To connect to H2 use: jdbc:h2:tcp://192.168.33.11:9092/./jpadb
    db.vm.provision "file", source: "provision/netcfg-db.yaml", destination: "/home/vagrant/01-netcfg.yaml"
    db.vm.provision "shell", :run => 'always', inline: <<-SHELL
      sudo mv /home/vagrant/01-netcfg.yaml /etc/netplan
      chmod 600 /etc/netplan/01-netcfg.yaml
      sudo netplan apply

      java -cp ./h2*.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists > ~/out.txt &
    SHELL
  end

  #============
  # Configurations specific to the webserver VM
  config.vm.define "web" do |web|
    web.vm.box = "perk/ubuntu-2204-arm64"
    web.vm.hostname = "web"

    web.vm.provider "qemu" do |qe|
      qe.arch = "aarch64"
      qe.machine = "virt,accel=hvf,highmem=off"
      qe.cpu = "cortex-a72"
      qe.net_device = "virtio-net-pci"
      qe.memory = "1G"
      qe.ssh_port = 50222
      qe.extra_qemu_args = %w(-netdev vmnet-host,id=vmnet,start-address=192.168.56.1,end-address=192.168.56.255,subnet-mask=255.255.255.0 -device virtio-net-pci,mac=52:54:00:12:34:51,netdev=vmnet)
    end

    # We want to access tomcat from the host using port 8080
    web.vm.network "forwarded_port", guest: 8080, host: 8080

    web.vm.provision "file", source: "provision/netcfg-web.yaml", destination: "/home/vagrant/01-netcfg.yaml"
    web.vm.provision "shell", inline: <<-SHELL, privileged: false
      sudo mv /home/vagrant/01-netcfg.yaml /etc/netplan
      chmod 600 /etc/netplan/01-netcfg.yaml
      sudo netplan apply

      #sudo apt-get install git -y
      #sudo apt-get install nodejs -y
      #sudo apt-get install npm -y
      #sudo ln -s /usr/bin/nodejs /usr/bin/node
      sudo apt install -y tomcat9 tomcat9-admin
      # If you want to access Tomcat admin web page do the following:
      # Edit /etc/tomcat9/tomcat-users.xml
      # uncomment tomcat-users and add manager-gui to tomcat user

      # Change the following command to clone your own repository!
      git clone https://github.com/joaopinheiro1241913/devops-24-25-1241913.git
      cd devops-24-25-1241913/CA1/part3/react-and-spring-data-rest-basic
      chmod u+x gradlew
      ./gradlew clean build
      ./gradlew bootRun
      # To deploy the war file to tomcat9 do the following command:
      sudo cp ./build/libs/basic-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps
    SHELL
  end
end
```

### 📌 Summary of Results

The configuration allowed for:

- **Automatic provisioning** of two ARM-compatible VMs using QEMU
- **Seamless communication** between Spring Boot and H2 VMs
- **Tomcat** deployment accessible via `localhost:8080`
- **H2 web console** accessible via `localhost:8082`
- Hands-on experience with **Vagrant multi-machine setup** and **ARM virtualization**

---

## 🔗 Configuring Spring Boot for H2 Database Connectivity

To connect the Spring Boot application to the H2 database running in a separate virtual machine (via Vagrant and QEMU on macOS), two main configurations were required: one in the Spring Boot backend and another in the React frontend.

---

### ⚙️ 1. Spring Boot – `application.properties`

The following properties were added to `src/main/resources/application.properties` to enable connectivity with the H2 database:

```properties
server.servlet.context-path=/basic-0.0.1-SNAPSHOT
spring.data.rest.base-path=/api
spring.datasource.url=jdbc:h2:tcp://192.168.56.11:9092/./jpadb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.jpa.hibernate.ddl-auto=create
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true
```

![h2connectivity2](https://i.postimg.cc/1XSs30D4/4-spring-jpa-hibernate-ddl-auto-create.png)

---

### 💻 2. React Frontend – App.js

To match the updated backend context and API path, the following change was made in `src/App.js`:

```javascript
client({ method: 'GET', path: '/basic-0.0.1-SNAPSHOT/api/employees' }).done(response => {
```

![h2connectivity](https://i.postimg.cc/Bv8qYnqZ/this-set-State-employees-response-entity-embeddec.png)


This ensures that the React frontend communicates correctly with the Spring Boot backend deployed at `/basic-0.0.1-SNAPSHOT/api`.

---

## 🚀 Running the Project within the Virtualized Environment

After setting up the Vagrant environment with QEMU on macOS, follow the steps below to run and validate the Spring Boot application and H2 database.

---

### 🧩 1. Starting the Virtual Machines

Before running the application, ensure you're inside the project root directory (where the `Vagrantfile` is located), then run:

```bash
sudo vagrant up
```

This command will:

- Boot both virtual machines (`web` and `db`)
- Provision each machine as per the configuration in the `Vagrantfile`
- Install dependencies and start the Spring Boot application

---

### 🌐 2. Verifying the Application and Database


#### ✅ Accessing the Spring Boot Frontend
Once provisioning completes, open your browser and visit:
http://localhost:8080/basic-0.0.1-SNAPSHOT/

![springapps](https://i.postimg.cc/65YtBvq5/localhost8080basic-0-0-1-SNAPSHOT.png)

This confirms that the Spring Boot application is running inside the web VM and is reachable from the host via the forwarded port `8080`.

---

#### 🛢️ Accessing the H2 Database
To open the H2 database web interface, go to:
http://localhost:8082

Use the following JDBC URL to connect:
`jdbc:h2:tcp://192.168.33.11:9092/./jpadb`

**Note:** Adjust the IP address if needed, based on the value defined in your Vagrantfile.

![h2s](https://i.postimg.cc/j50rM6gv/Screenshot-2025-05-19-at-03-48-19.png)

Once logged in, you can:

- Explore tables like `EMPLOYEE`
- Run queries
- Inspect inserted data from your Spring Boot application


---

By completing these steps, you confirm that:

- Both VMs are running properly
- **Spring Boot** is operational
- **The H2 database** is accessible and integrated with the backend

---

## 💡 Alternative Virtualization Solution: VMware Fusion (Apple Silicon)

In this section, we explore **VMware Fusion** as an alternative to **QEMU** on macOS for running Spring Boot applications with an H2 database using **Vagrant**.

We present a **comparative analysis**, highlight the **advantages and limitations**, and provide a **step-by-step guide** to configure your project with VMware Fusion.

---

### 📊 Comparison: QEMU vs VMware Fusion

| **Criteria**                   | **QEMU**                                                      | **VMware Fusion**                                                |
|-------------------------------|----------------------------------------------------------------|------------------------------------------------------------------|
| **License**                   | Free and open-source                                           | Commercial (Free personal use available)                         |
| **Performance**               | Good, requires manual tuning                                   | High performance, auto-optimized                                |
| **Ease of Use**               | Requires command-line config, complex setup                    | Intuitive GUI, easy to configure                                 |
| **Vagrant Integration**       | Requires unofficial `vagrant-qemu` plugin                      | Official `vagrant-vmware-desktop` plugin                         |
| **ARM Support (Apple Silicon)**| ✅ Native ARM support                                           | ⚠️ Limited to ARM64 Linux guests                                 |
| **Snapshots & Cloning**       | Available via CLI                                              | Advanced support with GUI integration                           |
| **Community & Support**       | Large open-source community, no official support               | Professional support available                                   |
| **Guest OS Compatibility**    | Broad (x86, ARM, more)                                         | Limited (no x86 guests on Apple Silicon)                        |

---

### ⚙️ Using VMware Fusion with Vagrant

VMware Fusion integrates well with Vagrant and provides a smoother virtualization experience compared to QEMU for supported systems.

####  Step 1: Install VMware Fusion

Download the appropriate version for your architecture (Intel or Apple Silicon) from:

🔗 https://www.vmware.com/products/fusion.html

---

####  Step 2: Install VMware Utility for Vagrant

For macOS:

```bash
curl -O https://releases.hashicorp.com/vagrant-vmware-utility/1.0.14/vagrant-vmware-utility_1.0.14_x86_64.dmg
sudo installer -pkg vagrant-vmware-utility_1.0.14_x86_64.dmg -target /
```

---

####  Step 3: Install VMware Plugin for Vagrant

```bash
vagrant plugin install vagrant-vmware-desktop
```

---

####  Step 4: Configure Your `Vagrantfile`
Example setup for a Spring Boot application (Ubuntu 20.04 ARM box):

```ruby
Vagrant.configure("2") do |config|
config.vm.box = "bento/ubuntu-20.04-arm64"

config.vm.provider "vmware_desktop" do |v|
v.vmx["memsize"] = "2048"
v.vmx["numvcpus"] = "2"
end
end
```
Replace with `ubuntu-20.04-arm64` for ARM-based Macs. Use x86_64 boxes for Intel.

---

### 🍏 Notes on Apple Silicon (M1/M2/M3)

While VMware Fusion now supports Apple Silicon:

- ✅ Only **ARM64-based Linux distributions** are supported.
- ❌ Cannot run **x86 guest VMs** (e.g., Windows x86, legacy apps).
- ❌ The `vagrant-vmware-desktop` plugin is **not yet officially compatible** with Apple Silicon.

#### 🛠️ Recommendation:
On **Apple Silicon Mac**s, **QEMU** remains the most flexible and stable choice for:

- Full ARM guest support.
- Cross-platform development with minimal GUI overhead.
- Compatibility with Vagrant via `vagrant-qemu`.

---

### Final Remarks on Tool Comparison


While **VMware Fusion** offers superior user experience and performance on **Intel-based Macs**, it presents notable limitations on **Apple Silicon**, particularly with guest OS compatibility.

For this reason, **QEMU** is recommended for Apple Silicon users until VMware and HashiCorp provide full support for ARM-based workflows via Vagrant.

---

##  Git Activity: Issues

A set of issues were created and resolved to guide the workflow, such as:

![ca2p2issues](https://i.postimg.cc/13bxzcQP/Screenshot-2025-05-14-at-02-15-48.png)

---

## Conclusion of Part 2

The completion of **Class Assignment 2 – Part 2** demonstrated the successful use of virtualization tools to support a Spring Boot application running with an H2 database. Through the provisioning of a virtualized environment via **Vagrant and QEMU on macOS**, it was possible to simulate a realistic development and deployment workflow using open-source technologies with ARM support.

---

### ⚙️ Key Implementation Highlights

- **Environment Setup**: Vagrant was used to provision a virtual machine configured to run on QEMU, tailored for macOS with Apple Silicon.

- **Spring Boot Integration**: The application was configured to connect to an external H2 database running within the virtual machine, using specific JDBC settings and enabling the H2 web console.

- **Frontend Alignment**: The React frontend was adapted to reflect the new API base path served through the virtualized backend, ensuring full-stack communication.

---

### 🔁 Alternative Tool Evaluation: VMware Fusion

As part of the assignment, an alternative virtualization solution was explored using **VMware Fusion**. While VMware offers a more user-friendly interface and stronger performance on Intel-based Macs, its **limited support for ARM-based operating systems** restricts its utility on Apple Silicon devices. The comparative analysis showed:

- ✅ **VMware Fusion excels** in usability and snapshot management on x86 platforms.
- ⚙️ **QEMU remains the most compatible solution** for ARM environments due to its native support and active community.

