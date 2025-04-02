<h1 style="font-size: 48px;">CA1: TECHNICAL REPORT</h1>

---

## 📌 Project Details

**🧑‍🎓 Author:** João Pinheiro

**📚 Course:** DevOps

**📆 Program Edition:** [SWitCH DEV 2024/2025](https://portotechhub.com/switch/switch-dev/)

**🏛 Institution:** [ISEP - Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)

**👨‍🏫 Professors:** Joaquim Santos & Paulo Matos

---

##  🛠️ Technologies Used

### **🖥️ Back-End**
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### **🎨 Front-End**
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)  
![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black)

### **🛠️ Build & Dependency Management**
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)  
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)  
![Ant](https://img.shields.io/badge/Ant-A81C7D?style=for-the-badge&logo=apache-ant&logoColor=white)

### **📂 Version Control**
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)  
![Mercurial](https://img.shields.io/badge/Mercurial-999999?style=for-the-badge&logo=mercurial&logoColor=white)

---

## 📖 Table of Contents

This section provides a structured breakdown of CA1 assignment, which is divided into three main parts:

- **[Part 1: Version Control with Git](#part-1-version-control-with-git)**
- **[Part 2: Build Tools with Gradle - Gradle Basics](#part-2-build-tools-with-gradle---gradle-basics)**
- **[Part 3: Build Tools with Gradle - Maven to Gradle Migration](#part-3-build-tools-with-gradle---maven-to-gradle-migration)**

---

### Full Table of Contents

Below is the complete breakdown, covering all tasks and requirements in detail.

- [Introduction](#introduction)
- **[Part 1: Version Control with Git](#part-1-version-control-with-git)**
    - [Introduction to Part 1](#introduction-to-part-1)
    - [Environment Setup](#environment-setup)
    - [Part 1.1: Development Without Branches](#part-11-development-without-branches)
        - [Goals and Requirements](#goals-and-requirements)
        - [Create a Repository Folder for Part 1](#create-a-repository-folder-for-part-1)
        - [Develop A New Feature: Adding a New Field to the Application](#develop-a-new-feature-adding-a-new-field-to-the-application)
        - [Unit Tests for Employee Creation and Validation](#unit-tests-for-employee-creation-and-validation)
        - [Add Support to the new jobYears field](#add-support-to-the-new-jobyears-field)
        - [Debugging the Server and Client Components](#debugging-the-server-and-client-components)
        - [Commit the changes and tag (v1.2.0)](#commit-the-changes-and-tag-v120)
        - [End of Assignment: Mark repository with the Tag (ca1-part1.1)](#end-of-assignment-mark-repository-with-the-tag-ca1-part11)
    - [Part 1.2: Development Using Branches](#part-12-development-using-branches)
        - [Goals and Requirements](#goals-and-requirements-1)
        - [Verifying the Active Branch](#verifying-the-active-branch)
        - [Develop new feature in Branch email-field](#develop-new-feature-in-branch-email-field)
        - [Implement Email Field](#implement-email-field)
        - [Unit Tests for testing the creation of Employees and the validation of their attributes](#unit-tests-for-testing-the-creation-of-employees-and-the-validation-of-their-attributes)
        - [Merging into the Master Branch](#merging-into-the-master-branch)
        - [Create a New Branch fix-invalid-email to fix a bug](#create-a-new-branch-fix-invalid-email-to-fix-a-bug)
        - [Unit tests for email validation](#unit-tests-for-email-validation)
        - [Debugging Process: Server and Client](#debugging-process-server-and-client)
        - [Merging into the Master Branch](#merging-into-the-master-branch-1)
    - [Final Results](#final-results)
    - [Alternative Solution for Version Control: Mercurial](#alternative-solution-for-version-control-mercurial)
        - [Introduction](#introduction-1)
        - [Analysis of the Alternative](#analysis-of-the-alternative)
        - [Implementation of the Alternative](#implementation-of-the-alternative)
        - [Final Thoughts on Mercurial as an Alternative](#final-thoughts-on-mercurial-as-an-alternative)
    - [Overall Conclusion of Part 1](#overall-conclusion-of-part-1)

- **[Part 2: Build Tools with Gradle - Gradle Basics](#part-2-build-tools-with-gradle---gradle-basics)**
    - [Introduction to Part 2](#introduction-to-part-2)
    - [Environment Setup](#environment-setup-1)
    - [Gradle Basic Demo](#gradle-basic-demo)
    - [Add a new task to execute the server](#add-a-new-task-to-execute-the-server)
    - [Add unit tests for the server execution task](#add-unit-tests-for-the-server-execution-task)
    - [Add a new task of type Copy](#add-a-new-task-of-type-copy)
    - [Add a new task of type Zip](#add-a-new-task-of-type-zip)
    - [Final Results](#final-results-1)
    - [Overall Conclusion of Part 2](#overall-conclusion-of-part-2)

- **[Part 3: Build Tools with Gradle - Maven to Gradle Migration](#part-3-build-tools-with-gradle---maven-to-gradle-migration)**
    - [Introduction to Part 3](#introduction-to-part-3)
    - [Set Up Initial Gradle Project](#set-up-initial-gradle-project)
    - [Integrate Existing Code](#integrate-existing-code)
    - [Configure Frontend Plugin for Gradle](#configure-frontend-plugin-for-gradle)
    - [Add Gradle Tasks for File Management](#add-gradle-tasks-for-file-management)
    - [Final Results](#final-results-2)
    - [Alternative Solution for Build Automation: Ant](#alternative-solution-for-build-automation-ant)
        - [Introduction](#introduction-2)
        - [Analysis of the Alternative](#analysis-of-the-alternative-1)
        - [Implementation of the Alternative](#implementation-of-the-alternative-1)
        - [Final Thoughts on Ant as an Alternative](#final-thoughts-on-ant-as-an-alternative)
    - [Overall Conclusion of Part 3](#overall-conclusion-of-part-3)

- [Overall Conclusion of CA1](#overall-conclusion-of-ca1)
- [Final Submission](#final-submission)

---


## Introduction
This **CA1 assignment** aims to explore **key elements of modern software development** and to practice these, through three distinct parts. This project focuses on three core aspects: **version control**, **build automation**, and **workflow management**. By utilizing tools such as Git, Mercurial, Gradle and Ant, we seek to illustrate how each technology enhances an effective and cooperative development atmosphere.

#### Version Control
Version control is a fundamental practice in software development, allowing developers to track changes, collaborate, and manage project versions efficiently. By utilizing Git, this project demonstrates how version control enables the tracking of code history, seamless collaboration, and the safe integration of new features and fixes. Moreover, as part of the project requirements, an alternative solution for version control is explored. By comparing GitHub with another version control system, this project highlights the strengths and weaknesses of both approaches, focusing on factors such as user-friendliness, branching features, performance, and community support. This comparison provides valuable insights regarding the scenarios where one system might be favored over the other.

#### Build Automation
Automating the build process enhances development efficiency and consistency. In this project, we use both Maven and Gradle for build automation. Maven is known for its simplicity and convention-based approach, whereas Gradle provides modern features such as dependency management, incremental builds, and flexibility in build scripts.
Additionally, as required by the assignment, we compare Gradle with an alternative build automation tool. This comparison emphasizes the distinctions between Gradle and the alternative in terms of flexibility, user-friendliness, and performance. By exploring the alternative solution, we gain insights into which tool may be better suited for different project scenarios, particularly when managing complex build processes or integrating with modern tools.

#### Workflow Management and Tool Integration
Effective workflow management is vital for scalable, maintainable, and high-quality software development. This assignment highlights the ways in which modern software development practices can be optimized through the right choice of tools and workflows. We discuss how each tool contributes to improving productivity, quality, and collaboration within development teams.

---


# Part 1: Version Control With Git

---

## Introduction to Part 1
This section corresponds to the part1 of the first class assignment (CA1) in the DevOps course, focusing on Version Control with Git. This assignment part is split into three sections: **Part1** introduces the fundamentals of version control without the use of branching, while **Part 2** involves applying branches to implement features and resolve bugs. Additionally, I investigated an **Alternative Version Control System**, Mercurial, by comparing its features with those of Git and assessing its ability to meet the same goals outlined in this assignment.

---

## Environment Setup

Before starting **Part 1**, it’s essential to set up the local Git repository. Below is the step-by-step detailed process to prepare your environment.

### Clone the Example Repository and Test the Application

To begin, I cloned the existing repository containing the **Tutorial React.js and Spring Data REST** application, to have a local copy of the tutorial project.

```bash
git clone https://github.com/spring-guides/tut-react-and-spring-data-rest 
```

After cloning, you can successfully run the application to test it.

```bash
# Navigate to the basic folder
cd tut-react-and-spring-data-rest 

# Run the application
./mvnw spring-boot:run
```

Once the application starts, you can view the results in your browser at http://localhost:8080/.

### Create a Repository on GitHub

Now, create the repository on **GitHub** to store your project:
1. Go to [GitHub](https://github.com) and log in to your account.
2. Click on **New** to create a new repository.
3. Name the repository `devops-24-25-<student-number>`.

Ensure that the teachers Joaquim Santos and Paulo Matos are granted. Access as collaborators by going to **Settings -> Collaborators -> Add**.

### Create the Local Folder

Set up a new directory on your local machine where the project will reside.

```bash
mkdir ~/myDevOpsRepo
```

### Initialize the Local Repository, Add README, and Link it

Initialize the local Git repository and create the `README.md` file, and link it to the remote GitHub repository. Stage and push the initial commit labeled "First commit: AddREADME”, which marks the oficial start of the assignment.

```bash
# Navigate to the new repository directory
cd ~/myDevOpsRepo

# Create README File 
echo "# devops-24-25-<student-number>" >> README.md

# Initialize the Git Repository locally
git init

# Add README.md to the staging area
git add README.md

# Commit the changes
git commit -m "First commit: AddREADME"

# Link to the Remote GitHub repository
git remote add origin <git-repository-url>

# Set the default Branch to Main
git branch -M main

# Push to GitHub
git push -u origin main
```

---

## Part 1.1 Development Without Branches

### Goals and Requirements

- The initial phase of this assignment is centered on **mastering fundamental version control operations** while working exclusively within the **main branch**, without using **feature branches**.

- **Key tasks** include **setting up the project environment**, making **direct modifications** to the **main branch**, and **committing changes systematically**. A crucial part of this process involves **implementing a new feature**—such as adding a **jobYears** field to the **Employee** object—and managing versioning through proper **tagging**. This begins with an **initial version** and progresses with an **updated tag** after integrating the new functionality.

- The **primary objective** is to develop a **solid understanding** of **commit practices, commit history tracking,** and **effective version management using Git tags**.

---

### Create a Repository Folder for Part 1

#### Copy the basic folder of the Tutorial application into a new directory structure CA1/part1

Create a new directory structure `CA1/part1` and copy the **Tutorial React.js and Spring Data REST** application’s basic folder into it.

```bash
# Create the necessary subdirectories
mkdir -p CA1/part1

# Copy the tutorial basic folder to CA1/part1
cp -r ~/tut-react-and-spring-data-rest/basic ~/myDevOpsRepo/CA1/part1

# Copy the global pom.xml file to the same folder
cp -r ~/tut-react-and-spring-data-rest/pom.xml ~/myDevOpsRepo/CA1/part1
```

#### Add a README in the CA1 Folder

Navigate to the **CA1** directory and create a **README.md** file that will serve as the Technical Report for the entire assignment.

```bash
# Navigate to the CA1 directory
cd ~/myDevOpsRepo/CA1

# Create and add content to README.md 
echo "README CA1" >> README.md
```

#### Create the `.gitignore` File
Create a `.gitignore` file both for **CA1** and **CA1/part1** subdirectory to avoid unnecessary files in the Git repository.

```bash
# Navigate to the root directory of the repository
cd ~/myDevOpsRepo

# Create the .gitignore file
touch .gitignore

# Edit the .gitignore file to exclude unnecessary files
nano .gitignore
``

Repeat the same process for the **CA1/part1** subdirectory.

#### Commit and Push Changes

After organizing the **CA1/part1** folder and adding the `.gitignore` files, proceed to commit these changes.

```bash
# Add all changes to the staging area
git add .

# Commit the changes
git commit -m "Add React.js and Spring Data REST tutorial to CA1/part1 folder and include .gitignore"

# Push the changes to the remote repository
git push
```

#### Create Initial Version Tag (v1.1.0)

Once the repository is set up and organized, following the versioning pattern outlined in the assignment create the first version tag `v1.1.0`, to mark the initial version of the project.

```bash
# Create the initial tag v1.1.0 
git tag -a v1.1.0 -m "v1.1.0"

# Push the tag to GitHub
git push origin v1.1.0
```

---

### Develop A New Feature: Adding a New Field to the Application

#### Managing Issues

To track the task of adding a new field (`jobYears`) to the application, create a new issue.

```bash
gh issue create --title "Add new field to record the years of the employee in the company (jobYears)" --body "To track the years an employee has been with the company, we need to add a new field called jobYears to the Employee class." --label "enhancement"
```

#### Implement the `jobYears` Field in the `Employee` Class

The main goal of this phase was to introduce a new feature by adding the `jobYears` field to the **Employee** class. This field will capture the number of years an employee has been with the company.

The following modifications were made to the `Employee` class:
- Added the `jobYears` attribute.
- Introduced validateJobYears method - Ensures jobYears attribute only accepts integer values.
- Introduced validateParameter method - Ensures string-type attributes cannot be null or empty.
- Update constructors to incorporate the new field.
- Applied validations before setting the field values.
- Updated `equals()`, `hashCode()`, and `toString()` methods to include jobYears.
- Included `jobYears` in the getters and setters.

These changes ensure that the new field is well-integrated into the application.

![jobYears](https://i.postimg.cc/mgnPNbsj/Pasted-Graphic.png)
![jobYears2](https://i.postimg.cc/YSbMfRYH/Pasted-Graphic-1.png)

---

### Unit Tests for Employee Creation and Validation

To ensure the proper creation and validation of **Employee** objects, including the newly added `jobYears` attribute, a total of **38 unit tests** were implemented, covering various scenarios:

#### Constructor Tests

These tests verify that the **Employee** object is properly initialized, both with the default and parameterized constructors.

- **Examples**:
    - `shouldCreateEmployeeWithDefaultConstructor`,`shouldCreateEmployeeWithValidArguments`

#### Attribute Validation Tests

These tests focus on ensuring that the **Employee** attributes adhere to defined constraints. Any invalid input (such as `null`, `empty` strings, or `negative` values) should trigger appropriate exceptions.

- **Examples**:
    - `shouldThrowExceptionWhenFirstNameIsEmpty`,`shouldThrowExceptionWhenJobYearsIsNegative`

#### equals() and hashCode() Tests

These tests ensure that the **equals()** and **hashCode()** methods function correctly:
- Employees with identical attributes should be considered equal.
- The hash code should remain consistent when the employee’s attributes differ.

- **Examples**:
    - `shouldReturnTrueIfSameEmployeeAttributes`,`shouldReturnDifferentHashCodeForDifferentEmployees`

#### Getters and Setters Tests

These tests verify that the **getters** and **setters** for each attribute work as expected. They also ensure that attributes cannot be set with invalid values, providing validation at the setter level.

- **Examples**:
    - `shouldThrowExceptionWhenSetWithEmptyDescription`,`shouldThrowExceptionWhenSetWithNegativeJobYears`

#### toString() Method Test

This test ensures that the **toString()** method returns the correct and expected string representation of an **Employee**.

- **Example**:
    - `shouldReturnEmployeeToString`

---

### Add Support to the new jobYears field

In this step, we made the necessary changes to incorporate and process the `jobYears` field within various parts of the application, including the database loader, front-end JavaScript components (`app.js`), and the bundling process.

#### Update DatabaseLoader to load and save the jobYears field

- **DatabaseLoader.java:** This class, responsible for pre-loading the database with sample data, was modified to include the `jobYears` information for sample employees. This ensures that the application demonstrates the functionality of the new field right from the start. The `run` method of the class was updated to initialize the data with the new field.

```java
public class DatabaseLoader implements CommandLineRunner { // <2>

    private final EmployeeRepository repository;

    @Autowired // <3>
    @Override
    public void run(String... strings) throws Exception { // <4>
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer", 5));
    }
}
```

#### Modify app.js and bundle.js to include and process the jobYears field

- **app.js:** The React components in `app.js` were updated to support displaying the new `jobYears` field in the employee list. Specifically, the `EmployeeList` and `Employee` components were modified to include a new column for `jobYears` in the rendered table. This enhancement enables users to see how long an employee has been with the company, alongside their other details.

```javascript
class EmployeeList extends React.Component {
    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee._links.self.href} employee={employee}/>
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Description</th>
                        <th>Job Years</th>
                    </tr>
                    {employees}
                </tbody>
            </table>
        )
    }
}
```
```javascript
class Employee extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.employee.firstName}</td>
                <td>{this.props.employee.lastName}</td>
                <td>{this.props.employee.description}</td>
                <td>{this.props.employee.jobYears}</td>
            </tr>
        )
    }
}
```

- **bundle.js:** The necessary adjustments were also made to bundle.js to ensure the **jobYears** field is correctly bundled and can be processed on the front-end. These changes enable the front-end JavaScript to interact with the updated data structure and display the **jobYears** field properly.

![bundle](https://i.postimg.cc/yxjmtmwq/Screenshot-2025-03-20-at-14-21-10.png)

---

### Debugging the Server and Client Components

To ensure the seamless integration of the `jobYears` field, I executed the application using:

```bash
./mvnw spring-boot:run
```
This allowed real-time testing of the feature at https://localhost:8080/, ensuring smooth operation, compatibility with existing features, and proper synchronization between the **backend (Spring Boot REST API)** and **frontend (React.js application)**.

![debug1](https://i.postimg.cc/7YpRVDMg/First-Name.png)

A more detailed debugging breakdown, covering both frontend (UI table, browser console, network tab, and React components) and backend (server logs and API testing with `cURL`), will be provided in **Part 1.2**.

However, the primary objectives at this stage were to validate:

- **Frontend (React.js UI):** Verify that the UI correctly fetches and displays employee data.

Open in the browser: https://localhost:8080

- **Backend (Spring Boot REST API):** Ensure the API processes requests correctly.

```bash
curl localhost:8080/api/employees
```

To guarantee proper functionality and seamless integration of the new feature, I combined multiple debugging techniques, including:

- **Manual API testing** using `cURL`
- **Browser Developer Tools**, including the Chrome extension **React Developer Tools**
- **Backend log analysis** during server startup

These steps ensured that the application remained fully functional, with the `jobYears` field properly integrated across all components.

---

### Commit the changes and tag (v1.2.0)
Once the task is completed and tested, commit the changes and tag (`v1.2.0`) to mark the completion of the feature.
```bash
# Crete a v1.2.0 tag
git tag -a v1.2.0 -m "v1.2.0"

# Push the tag to the remote repository
git push origin v1.2.0
```

---

###	End of Assignment: Mark repository with the Tag (ca1-part1.1)
Finalize the assignment with tag `ca1-part1.1` to mark the completion of Part 1 of the assignment.
```bash
# Create a ca1-part1.1 tag
git tag -a ca1-part1.1 -m “ca1-part1.1”

# Push the tag to the remote repository
git push origin ca1-part1.1
```


---

## Part 1.2 Development Using Branches


### Goals and Requirements

- **Feature Branches:** All new features and bug fixes should be developed in **separate branches**, preventing disruptions to the **main codebase**. This ensures that changes are only **merged once they are fully tested and stable**.

- **Efficient Merging:** Proper **merge techniques** need to be applied to **integrate updates smoothly**, ensuring **code stability** and **minimizing potential conflicts**.

- **Version Control Best Practices:** After merging, **version tags** should be created to **mark significant updates**, maintaining a **well-structured and organized project history**.

---

### Verifying the Active Branch
Before proceeding with development, it was crucial to confirm that I was on the correct branch—particularly, the **main branch**, which is used for releasing stable versions. To do this, I ran `git branch` command.

![gitbranch](https://i.postimg.cc/TPvkWhk5/joaopinheiro-Joaos-Mac-Book-Pro-4-my-Dev0ps-Repo-git-branch.png)

The output of this command highlights the **currently active branch** with an asterisk (*). This verification step was particularly important in the second phase of the assignment, as it ensured that all stable updates were made in the appropriate branch, maintaining an organized and structured workflow.

---

### Develop new feature in Branch email-field 

When developing the **email field** feature, proper branch management was essential to keep the main codebase stable. To achieve this, I created a dedicated **feature branch**, ensuring that all modifications were contained separately from the stable version.

Before implementing the new field, I initialized a branch named **email-field** and switched to it. To confirm that I was working in the correct branch, I used the `git branch` command, which allowed me to verify my development environment and maintain a structured workflow:

![gitbranch2](https://i.postimg.cc/ncbb1VwZ/joaopinheiro-Joaos-Mac-Book-Pro-4-ny-Dev0ps-Repo-git-branch-email-field.png)

This methodical approach guaranteed that all changes stayed within the **email-field** branch until they were **fully implemented, tested, and prepared for seamless integration** into the main codebase.

---

### Implement Email Field 

The process of integrating the **email** field into the application and ensuring its proper validation closely followed the approach used for the **jobYears** field in Part 1.1. Below are the key steps taken to implement and validate this feature:

- **Code Implementation:** In line with the existing development structure, I extended the **Employee** class to include an **email** field, along with the corresponding getter and setter methods. Additionally, I made the necessary changes to incorporate and process the **email** field within various parts of the application. This included updating the **database loader**, modifying front-end **JavaScript components** (such as `app.js`), and adjusting the **bundling process** to ensure seamless integration across both the **frontend** and **backend components** of the application.


- **Validation:** Validation rules were applied to enforce that the email attribute cannot be null or empty


![emailfield](https://i.postimg.cc/LsJB8PFM/Screenshot-2025-03-20-at-14-06-56.png)


- **DatabaseLoader**

![database2](https://i.postimg.cc/Dyg00Qs4/Screenshot-2025-03-20-at-14-26-25.png)


- **app.js**

![appjs2](https://i.postimg.cc/XvTdLKs7/Pasted-Graphic-2.png)


- **bundle.js**

![bundle2](https://i.postimg.cc/mgKypGDs/Screenshot-2025-03-20-at-14-25-54.png)


![table2](https://i.postimg.cc/8CRDjNfk/First-Name.png)


The **server** and **client** components were meticulously debugged to address any issues introduced by the addition of the **email field**. This process was crucial for ensuring seamless performance, correct data handling, and an enhanced user experience.

---

### Unit tests for testing the creation of Employees and the validation of their attributes

To ensure the integrity of the Employee entity, the email field was incorporated into existing unit tests. As well, new tests were created to properly validate this attribute, including:

#### Attribute Validation:
Ensures exceptions are thrown when the email is null or empty.
- **Examples**:
    - `shouldThrowExceptionWhenEmailIsNull`,`shouldThrowExceptionWhenEmailIsEmpty`

#### Equality Check (equals() Method):
Ensures that two Employee objects with different emails are not considered equal.
- **Example**:
    - `shouldReturnFalseIfDifferentEmail`

##### Getters and Setters
Validates that the email is correctly returned and set, and ensures exceptions are thrown when setting null or empty emails.
- **Examples**:
    - `shouldReturnEmployeeEmail`
    - `shouldSetEmployeeEmail`
    - `shouldThrowExceptionWhenSetWithNullEmail`
    - `shouldThrowExceptionWhenSetWithEmptyEmail`

---

### Merging into the Master Branch
To finalize the integration of the email field feature, a series of steps were taken to merge the changes into the main branch and update the application's version. Initially, all final changes made in the `email-field` branch were committed and pushed to the remote repository. To maintain a clear and comprehensive commit history, a no-fast-forward merge strategy was employed. Once the merge was successfully completed, the updated main branch was pushed to the remote repository. Finally, a new version tag (`v1.3.0`) was applied and pushed to mark the completion of this feature and ensure version control consistency.

```bash
# Commit the feature changes:
git add .
git commit -m "feat: add email field and attribute validations in Employee, update DatabaseLoader"

# Push the feature branch upstream:
git push -u origin email-field

# Switch to the main branch and merge changes:
git checkout main
git merge --no-ff email-field

# Push the merged changes to update the main branch:
git push

# Tag the new version and push the tag:
git tag -a v1.3.0 -m "v1.3.0"
git push origin v1.3.0
```

---


### Create a New Branch fix-invalid-email to fix a bug

To fix the issue with email validation in the `Employee` class, a new branch named **fix-invalid-email** was created. The focus of this bug fix was to implement validation logic within the Employee class to enforce proper email formatting, ensuring that the email field contains an "@" symbol. This enhancement prevents the entry of invalid email addresses, contributing to better data consistency and overall application reliability.

```java
// Helper method to validate email format
private void validateEmail(String email) {
    if (email == null || email.isEmpty()) {
        throw new IllegalArgumentException("Email cannot be empty or null");
    }
    if (!email.contains("@")) {
        throw new IllegalArgumentException("Email must contain an '@' sign");
    }
}
```

By addressing the issue through a **dedicated branch**, the development process maintained its integrity, and the fix was thoroughly tested and merged back into the main branch, ensuring the stability of the application while improving its data validation capabilities.


---

### Unit tests for email validation

To ensure the proper validation of the email field, unit tests were created to check that the email adheres to the required format, specifically ensuring it contains the "@" symbol. The tests validate both the attribute and setter functionality:

#### Attribute Validation: 
Ensures that an exception is thrown when the email does not contain the "@" symbol.
- **Example**:
    - `shouldThrowExceptionWhenEmailDoesNotContainAtSymbol`
  
#### Getter and Setter Validation: 
Verifies that the setter method throws an exception if an invalid email (missing the "@" symbol) is provided.
- **Example**:
    - `shouldThrowExceptionWhenSetWithEmailMissingAtSymbol`

---


### Debugging Process: Server and Client

This section outlines the debugging steps performed to verify that both the **backend (Spring Boot REST API)** and **frontend (React.js application)** function correctly after the integration of the new fields. The primary goal was to ensure that:

**✅ Frontend (React.js)** - The UI correctly fetches and displays employee data, including the new field email.

**✅ Backend (Spring Boot REST API)** - The API properly handles requests and persists the new field in the database.

To achieve this, a combination of **manual API testing, browser DevTools, React Developer Tools, and backend log analysis** was employed, ensuring a smooth and synchronized application workflow.



### 1. Frontend Debugging (Client-side)

#### 1.1 UI Table (React Frontend Output)

The React app dynamically generates an **employee table** based on API data.

![UITable](https://i.postimg.cc/L8trf584/First-Name.png)


 **Key Observations:**  
✔️ The **email** field is displayed properly, confirming successful integration.  
✔️ Each row represents an **employee retrieved from the backend API**.

**Conclusion:** The frontend correctly renders API data, demonstrating proper synchronization between the backend and UI.

---

#### 1.2 Fetching Data from the API

To validate data retrieval, the following command was executed in the **browser console**:

![Console](https://i.postimg.cc/ZR6LCBc4/Screenshot-2025-03-24-at-13-15-48.png)


**Results:**  
✔️ The API request was **successful**, and the frontend received the correct employee data.  
✔️ The `email` field was present, confirming proper backend processing.
---

#### 1.3 Inspecting API Requests in the Network Tab

The **Network tab** in Chrome DevTools was used to inspect the API request and response:

![NetWork](https://i.postimg.cc/hGXk3BLN/Access-Control-Request-Method.png)

![NetWork2](https://i.postimg.cc/FzTG4fmp/Screenshot-2025-03-23-at-00-09-51.png)

✔️ The request to `http://localhost:8080/api/employees` **returned a 200 OK**, confirming a successful API response.  
✔️ The **Response tab** displayed the expected JSON data, including the **email field**, proving that the backend returned the correct information.

---

#### 1.4 Inspecting React Components

Using **React DevTools**, the EmployeeList component was inspected to ensure it correctly processed the API data.

![Components](https://i.postimg.cc/ZqY8Tb7D/rendered-by.png)

✔️ The **EmployeeList component successfully received and rendered** the new field (`email`).

---

### 2. Backend Debugging (Server-side)

#### 2.1 Server Startup Logs

Spring Boot logs were examined to confirm correct backend initialization:

✔️ **Application launched successfully on port 8080**.  
✔️ **Spring Data JPA and H2 database initialized correctly**.  
✔️ **REST API was ready to handle requests**.

![Logs](https://i.postimg.cc/gjyyzxWQ/Screenshot-2025-03-23-at-00-20-51.png)

---

#### 2.2 Testing the API with cURL

To manually validate the API response, the following **cURL command** was executed in a terminal:

![cURL](https://i.postimg.cc/JnVBsRPL/description-ring-bearer.png)


✔️ The API **returned employee data correctly**, including **jobYears** and **email**.



---

### Debugging Summary

#### ✅ Client-side (React.js)
✔️ UI correctly **displays updated employee data**.  
✔️ **Browser console fetch** confirmed API connectivity.  
✔️ **Network tab** showed a **successful API response**.  
✔️ **React component displayed updated data correctly**.

#### ✅ Server-side (Spring Boot)
✔️ Application started **without errors**.  
✔️ API correctly handled **requests** and included **new fields**.  
✔️ **cURL request confirmed expected JSON output**.



### Final Conclusion of Debugging:

Following a comprehensive debugging process, the **full-stack application** is **fully functional** after integrating the new fields. Both the **backend (Spring Boot API)** and **frontend (React.js)** are properly **synchronized** and working as expected. 

---

### Merging into the Master Branch

After implementing the fix and conducting thorough testing to confirm its effectiveness, the changes were merged into the master branch, and the application version was updated to `v1.3.1` to indicate the minor fix. This version increment highlights the continuous improvement of the application's functionality and reliability. At the end of the assignment I marked the repository with the tag `ca1-part2`.

---


## Final Results


### Branches

To effectively manage development stages and features, **specific branches** were created within the repository.

![Branches](https://i.postimg.cc/tRw6ntJb/email-field.png)

The image above shows the **current active branches** in the repository, which can be viewed by running the command `git branch`.

---

### Tags 

Specific versions were **tagged** using semantic versioning to track key milestones in the development process.

![TagsOverview](https://i.postimg.cc/7PQTFv2w/cal-part1-1.png)

They can be viewed by running the command `git tag`.


---

### Commits

A series of commits were made, adhering to best practices by using **descriptive messages** to document each change.

![commits](https://i.postimg.cc/L55h4MXt/Screenshot-2025-03-19-at-23-21-35.png)


---

### Issue Tracking

GitHub Issues were used to **document tasks**, **track progress**, and **manage improvements**.

![issueTracking](https://i.postimg.cc/05hJ5bYr/Pasted-Graphic-3.png)


#### The Importance of Issues in Project Management

Issues in project management are critical because they help **identify** and **resolve** problems that may arise during a project's lifecycle. By **documenting** and managing issues, teams can **prioritize tasks** and ensure **timely resolutions**. Issues provide **visibility into potential risks**, allowing for **proactive mitigation strategies**, and contribute to maintaining **project timelines** and **quality**. Additionally, tracking issues fosters **communication** within the team, ensuring that everyone is aligned on the challenges being addressed.

---

## Alternative Solution for Version Control: Mercurial

### Introduction
Version Control Systems (VCS) play a critical role in managing code changes, enabling collaboration, and maintaining a detailed history of a project's development. Among the most popular VCS tools, Git is widely recognized for its flexibility, robustness, and decentralized nature, making it the go-to choice for many teams. However, seeking an alternative to Git, **Mercurial (Hg)** offers an alternative approach to version control, providing a simpler yet effective solution. While **Git** operates in a fully decentralized manner, **Mercurial** combines features from both centralized and decentralized models, offering a hybrid system.
This section will compare the version control features of **Git** and **Mercurial**, highlighting their strengths and differences. It will also explore how **Mercurial** can serve as a viable alternative to Git in fulfilling the goals and requirements set forth in this assignment.

![mercurial](https://i.postimg.cc/gcC6Bwxt/MERCURIAL.png)

---

### Analysis of the Alternative

#### GitHub (Git) vs Mercurial - Version Control Systems Comparison

| **Feature**               | **GitHub (Git)**                                   | **Mercurial**                                    |
|---------------------------|---------------------------------------------------|-------------------------------------------------|
| **Version Control Model**  | Distributed (Git)                                 | Distributed (Mercurial)                         |
| **Interface**              | Rich graphical interface (GitHub platform)        | Command line (graphical tools available)         |
| **Branching**              | Advanced and flexible                             | Simple, less flexible                           |
| **Performance**            | Fast, but can slow with large binary files        | Fast, great for small to medium-sized repositories |
| **Learning Curve**         | Steeper due to flexibility                        | Easier to learn, simpler commands               |
| **Community**              | Large and active, especially for open-source      | Smaller, but still active                       |
| **Hosting Platform**       | GitHub (large ecosystem)                          | Bitbucket and others (less popular)             |
| **Support for Large Repositories** | Handles large repositories well, but can be slow with massive binary files without special configuration (e.g., Git LFS) | Generally faster for small to medium repositories but struggles with very large repos and high branching activity. |
| **Support for Binary Files** | Git is not optimized for large binary files, but Git LFS (Large File Storage) can handle it. | Mercurial does not have an official counterpart like Git LFS, but there are third-party solutions |
| **Popularity in Open Source** | GitHub is *the* platform for open-source projects with millions of public repositories. | Mercurial is less common in open-source, though it was used by some projects like Mozilla before transitioning to Git |
| **Integration with IDEs**  | Wide support with all major IDEs and text editors (e.g., Visual Studio Code, IntelliJ, etc.) | Support in some IDEs and tools, but generally less integrated than Git |
| **Web Interface**          | GitHub's web interface is user-friendly and rich with features like pull requests, issues, wikis, and more | Mercurial's web interface (e.g., via Bitbucket) is simpler and lacks some of the advanced features found in GitHub |
| **Commercial Use**         | GitHub has strong enterprise offerings (GitHub Enterprise), making it the choice for many large organizations | Mercurial is used in some enterprises, but it's less commonly chosen for large-scale commercial use |

### Summary:
- **GitHub (Git)** is the dominant choice in modern software development, especially for open-source projects, larger teams, and enterprises. It offers flexibility, scalability, and integration with a vast ecosystem, making it suitable for complex workflows and large repositories.
- **Mercurial** provides a simpler and intuitive interface, ideal for small to medium-sized projects. However, with its declining support across major platforms and fewer integrations, it is becoming less popular for large-scale or future-proof development.
- For most new projects, **GitHub** is the preferred choice due to its wide adoption, rich feature set, and strong community support.
- **Mercurial** could still be useful for smaller teams or simpler projects but may face challenges as the ecosystem continues to evolve.


---

### Implementation of the Alternative

#### How Mercurial Can Achieve the Same Goals as Git for Version Control


1. **Create a Repository on SourceForge**
    - **Step 1:** If you don’t already have an account, sign up for one at [SourceForge](https://sourceforge.net).
    - **Step 2:** Once logged in, go to your profile and select **Create a New Project** and fill in the necessary fields (project name, description), and choose **Mercurial** as the version control system.
    - **Step 3:** After creating your project, SourceForge will provide you with a URL:

      ```bash
      https://joaopin1241913@hg.code.sf.net/p/joaopinheiro-devops-1241913/code
      ```
   
![mercurialrepo](https://i.postimg.cc/Kvy8wtcH/joaopinheiro-devops-1241913-Code.png)

2. **Install Mercurial**
    - Download and install Mercurial from [Mercurial SCM](https://www.mercurial-scm.org).

    - Once installed, verify that Mercurial was installed correctly by running:

      ```bash
      hg --version
      ```

![mercurialrepo2](https://i.postimg.cc/FsD8QQgJ/Debian-Ubuntu.png)
![mercurialrepo3](https://i.postimg.cc/qR4WTBYy/see-httpsmercurial-scm-org-for-more-information.png)      


3. **Initialize a Local Repository**
    - In your project directory, initialize a Mercurial repository with the command:
      ```bash
      hg init
      ```

4. **Add Files and Make The First Commit**
    - Create the **README** file:
      ```bash
      touch README
      ```      
    - To add all project files to Mercurial, use the command:
      ```bash
      hg add
      ```
    - Make the initial commit:
      ```bash
      hg commit -m "Initial commit of the project"
      ```


5. **Create a .hgignore File**
    - Create a `.hgignore` file to tell Mercurial which files and directories to ignore. For example:
      ```bash
      echo "*.log" > .hgignore
      echo "*.class" >> .hgignore
      echo "node_modules/" >> .hgignore
      ```

6. **Move the Project Folder into the Local Repository**
    - Transfer the `basic` folder from your cloned tutorial repository into the local project directory:
      ```bash
      mv ~/git-tutorial/tut-react-and-spring-data-rest/basic ~/DevOpsMercurial/devops-24-25-1241913
      ```
    - Also, copy the global `pom.xml` file:
      ```bash
      cp ~/git-tutorial/tut-react-and-spring-data-rest/pom.xml ~/DevOpsMercurial/devops-24-25-1241913
      ```
    - Commit the changes:
      ```bash
      hg commit -m "Add Tutorial basic folder to repository and .gitignore"
      ```
7. **Link the Local Repository to SourceForge**
    - To link your local Mercurial repository to the SourceForge remote repository, run the following:
      ```bash
      hg remote add origin https://joaopin1241913@hg.code.sf.net/p/joaopinheiro-devops-1241913/code
      ```

8. **Push Your Code to SourceForge**
    - Push your local changes to the remote SourceForge repository with:
      ```bash
      hg push origin
      ```

![repomecurial](https://i.postimg.cc/t4cYfCqg/Screenshot-2025-03-31-at-22-33-45.png)

9. **Create a New Branch**
    - Create a new branch for feature development:
      ```bash
      hg branch email-field
      ```
    - Commit the changes:
      ```bash
      hg commit -m “Add email-field branch”
      ```
    - Push the branch to the remote repository:  
      ```bash
      hg push --new-branch
      ```
10. **Switch Between Branches**
    - To switch to a different branch, use:
      ```bash
      hg update feature-branch
      ```

11. **Create and Push Tags**
    - To mark a specific point in the project, create a tag:
      ```bash
      hg tag v1.0
      ```
    - Push the tags to the remote repository:
      ```bash
      hg push --tags
      ```

![tagsmercu](https://i.postimg.cc/BZ5Jr55y/Branches.png)

12. **Merge the Branch Back to Main**
    - Once your feature development is complete, merge the feature branch back to the main branch:
      ```bash
      # Switch to the main branch
      hg update default
      
      # Merge the feature branch
      hg merge email-field
      hg commit -m "Merged email field feature into default branch"
      hg push
      ```
      
By using Mercurial branches and tags along with SourceForge, you can efficiently manage different features or releases of your project while keeping track of its progress with versioned milestones.


---

#### Branches

To view the active branches in your **Mercurial (hg)** repository, you can use the following command:

```bash
hg branches
```

This command will list all the branches in the local repository, indicating which one is active and showing the commits associated with each branch.

![br](https://i.postimg.cc/Zqvvk6ws/joaopinheiro-Joaos-MBP-4-joaopinheiro-devops-1241913-code-hg-branches.png)

---

#### Tags

To list all the **tags** in your **Mercurial (hg)** repository, use the following command:

```bash
hg tags
```
This command displays all the existing **tags**, along with their associated revision numbers and commit hashes.

![tg](https://i.postimg.cc/DfPJKvch/joaopinheiro-Joaos-MBP-4-joaopinheiro-devops-1241913-code-hg-tags.png)

---

#### Commits

To view the complete **commit history** of your repository, use the following command:
```bash
hg log
```

This will display a list of all previous commits, showing details such as:

- **Revision number** (e.g., `3`)
- **Commit hash** (e.g., `b17e2e8b8e1e`)
- **Author** of the commit
- **Date and time** of the commit
- **Commit message**

![cm](https://i.postimg.cc/GhM4HXNS/changeset.png)

---

### Final Thoughts on Mercurial as an Alternative
Choosing the right version control system depends on the specific needs of the project. Both **Mercurial** and **Git** are powerful control systems than can achieve the same goals, but come with different workflows and strengths. **Mercurial** strikes a balance by offering the flexibility of a distributed system while maintaining a more user-friendly interface. Its simpler command set and straightforward branching model make it an excellent alternative for smaller projects or teams that prioritize ease of use and simplicity.
However, **Git** remains the most flexible and widely adopted version control system. It offers robust features, especially for large, distributed development environments. Git's powerful branching model, performance, and extensive integration with modern development tools have made it the preferred choice for many developers, especially in large teams and more complex projects.
In summary, while **Mercurial** is a solid alternative with a more intuitive workflow, **Git** offers superior flexibility, scalability, and widespread industry adoption, making it the go-to choice for most modern development teams. Ultimately, the best choice between **Git** and **Mercurial** will depend on factors such as project size, team structure, and preferred workflow.

---

## Overall Conclusion of Part 1

In this section, we explored two fundamental approaches to version control: **development without branches** and **development using branches**.

- In **Part 1.1**, we focused on working directly within the main branch, emphasizing the importance of structured commits, systematic version tagging, and understanding commit history. This approach helped in grasping core version control concepts without the complexity of managing multiple branches.

- In **Part 1.2**, we introduced **feature branches** to improve workflow efficiency by isolating new features and bug fixes. This method ensures stability in the main branch, enables parallel development, and minimizes conflicts through structured merging strategies and proper versioning practices.

Additionally, we explored an **alternative version control solution: Mercurial**, comparing its capabilities with Git. While **Git** remains the industry standard due to its flexibility and robust ecosystem, **Mercurial** offers a more streamlined and user-friendly experience, particularly suited for teams seeking simplicity. However, with Mercurial's declining adoption and limited integrations, Git remains the preferred choice for modern software development.

---

# Part2: Build Tools with Gradle - Gradle Basics

---

## Introduction to Part 2
This section corresponds to Part 2 of the first class assignment (CA1) in the DevOps course, focusing on using **Gradle** for **build automation**. It explores key Gradle features such as **task creation**, **unit testing**, and **file management** to streamline development workflows.

Following the initial **environment setup**, explores the creation of the **Gradle Basic Demo**, which features a **multithreaded chat server**. This section illustrates the process of building, running, and connecting multiple clients, highlighting how Gradle can handle **real-world application management**. Following this, details the addition of a **custom Gradle task**, demonstrating how Gradle's functionality can be extended to suit specific project needs. The section on **unit testing** emphasizes how Gradle was used to incorporate tests into the build process, enhancing the project's reliability. The following parts, which cover adding **Copy** and **Zip tasks**, focus on using Gradle for efficient **file handling**, crucial for **project distribution** and upkeep.


Finally, concludes by summarizing the key lessons learned, challenges overcome, and the practical skills gained in utilizing Gradle for **software development tasks**.

---

## Environment Setup
To begin, the first step involved creating a new subdirectory for the assignment, **/CA1/Part2**, followed by cloning the example application from the provided Bitbucket repository. This repository included a **build.gradle** file and the **Gradle Wrapper**, ensuring a consistent build environment across various systems.

The project was then imported into an Integrated Development Environment (IDE) that supports Gradle, allowing access to its built-in tools and features for streamlined development.

To confirm that the environment was set up correctly, the `./gradlew -v` command was executed. This verified that Gradle was properly installed and displayed the version information, ensuring that the setup was functional and ready for the next steps in the assignment. With this validation complete, the environment was fully configured for further development tasks.

```bash
# Clone the Gradle example repository
git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git

# Navigate to the project directory where the code will be placed
cd ~/myDevOpsRepo/CA1

# Create a new folder for Part 2 of the assignment
mkdir part2

# Copy the contents of the cloned repository into the new 'part2' folder
cp -r ~/gradle_basic_demo ~/myDevOpsRepo/CA1/part2

# Access the 'part2' directory where the files have been copied
cd part2

# Remove the '.git' directory to ensure the repository history isn't included
rm -rf .git

# Check the Gradle version to ensure that the installation is correct
./gradlew -v
```

![gradlewv](https://i.postimg.cc/nzrf1H8Y/joaopinheiro-Joaos-Mac-Book-Pro-4-part2-gradlew-v.png)

```bash
# Go back to the main directory (CA1)
cd ..

# Add the modified files (the 'part2' directory) to the version control
git add .

# Commit the changes with an explanatory message
git commit -m "Add Gradle example application to CA1/part2 folder"

# Push the changes to the remote repository (Bitbucket)
git push
```

---

## Gradle Basic Demo

The Gradle Basic Demo provided a hands-on exercise to build and run a multi-threaded chat server, which is capable of managing multiple clients simultaneously. This demo was designed to showcase Gradle’s capabilities in automating the build process and handling real-world application management.


### Gradle Build Process
To prepare the demo for execution, I ran the following command from the project’s root directory:

```bash
./gradlew build
```

![gradlebasicdemo](https://i.postimg.cc/4xnJ5bzh/BUILD-SUCCESSFUL-in-Ss.png)


### Server Startup

Once the build was complete, the chat server was started using the following command: 
```bash
java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp 59001
```

### Client Connections
For the client side, I established connections to the chat server by executing `./gradlew runClient`, ensuring each client connected to localhost on port 59001. 

The `build.gradle` file was configured to facilitate easy adjustments for different connection settings, enabling flexibility in how the server interacts with clients. This configuration makes it simple to modify parameters such as connection timeouts, ports, and the number of concurrent clients the server can handle.

![joao](https://i.postimg.cc/0NFdQfCG/Pedro-has-joined.png)

![pedro](https://i.postimg.cc/s2r3rFk5/Chatter-Pedro.png)

---

## Add a new task to execute the server

To streamline the development workflow, I introduced a `runServer` task in the `build.gradle` file. This enhancement simplifies the process of launching the chat server, allowing it to be started directly with a Gradle command. By automating this step, developers no longer need to manually execute Java commands each time the server is run.

The `runServer` task utilizes **JavaExec** to run Java applications and is designed to depend on the `classes` task. This ensures that all required classes are compiled before the server starts. The task is configured to launch the **ChatServerApp** main class on **port 59001**, as shown below:

```java
task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens on port 59001"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```

To test this new functionality, I executed the task using the following command:

```bash
./gradlew runClient
```

![newtask2](https://i.postimg.cc/mZ7Cb120/joaopinheiro-Joaos-Mac-Book-Pro-4-part2-gradlew-run-Client.png)

The terminal output confirmed that the server started **successfully**, as shown in the screenshot.

---


## Add unit tests for the server execution task

To verify the functionality of the **App** class, a unit test was added in the following directory:

```bash
src/test/java/basic_demo/AppTest.java
```

This test ensures that the **App** class returns a **non-null greeting message**, validating a key feature.

### Configuring the Test Environment

To enable unit testing, the **JUnit** dependency was added to the `build.gradle` file:

```gradle
dependencies {
    testImplementation 'junit:junit:4.12'
}
```

![dependencies](https://i.postimg.cc/pdDR9vhX/dependencies.png)

This inclusion ensures that the project recognizes and executes JUnit tests seamlessly, providing a stable testing environment.

```java
package basic_demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void testAppHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}    
```

To run the test, I executed the command:

```bash
./gradlew test
```

The terminal output confirmed that the test **passed successfully**, as shown in the screenshot below.

![unitteststask2](https://i.postimg.cc/FsDZ4kTh/joaopinheiro-Joaos-Mac-Book-Pro-4-part2-gradlew-test.png)

---

## Add a new task of type Copy


To improve project reliability and ensure a backup mechanism, a **backup task** was added to the `build.gradle` file. This task utilizes **Gradle’s Copy task type** to create a snapshot of the project's source code, allowing for quick recovery in case of unexpected issues during development.

### Backup Task Definition

The `backup` task copies the entire `src` directory into a designated backup location within the build folder:

```java
task backup(type: Copy) {
    group = "DevOps"
    description = "Copies the sources of the application to a backup folder"

    from 'src'
    into 'backup'
}
```

### Execute the Backup Task

To execute the backup task and create a copy of the source files, use the following command:

```bash
./gradlew backup
```

This will generate a **backup of the** `src` *directory* inside the `build/backup` folder, ensuring a reliable recovery point for the project.

![copy2](https://i.postimg.cc/j5097JVG/joaopinheiro-Joaos-Mac-Book-Pro-4-part2-gradlew-backup.png)

### Backup Verification

Although the **backup folder** is not committed to the remote repository, it is successfully created in the local development environment.

After executing the backup task, a quick inspection of the local file system confirmed that the folder was generated correctly, ensuring a reliable recovery point for the project.

The screenshot below demonstrates the presence of the **backup folder** after running the task.


![copy3](https://i.postimg.cc/1z67s5gM/gradlew-bat.png)


### Impact of the Backup Task

Integrating the **backup task** into the Gradle build script has greatly enhanced the project's resilience. By automating source code backups, it ensures that developers always have a reliable recovery point before making significant changes or updates. This added layer of security minimizes the risk of data loss and facilitates a more efficient development workflow.


---

## Add a new task of type Zip

The final step was the creation of a **Zip task** to package the project's source code into a compressed `.zip` file. This task streamlines the process of archiving the `src` directory, making it easier to store backups or distribute the project efficiently.

```java
task archive(type: Zip) {
group = "DevOps"
description = "Creates a zip archive of the source code"

    from 'src'
    archiveFileName = 'src_backup.zip'
    destinationDir(file('build'))
}
```

### Executing the Zip Task

To verify the functionality of the archive task, I ran the following command:

```bash
./gradlew archive
```

The terminal output confirmed its successful execution, indicating that the src directory was successfully compressed into a `.zip` archive.

![zip2](https://i.postimg.cc/N03M2bjB/Screenshot-2025-03-24-at-03-16-19.png)

### Impact of the Zip Task

While the generated ZIP file is not committed to the remote repository, it was successfully created in the local development environment. After executing the task, the `src_backup.zip` file appeared in the `build` directory, confirming that the archiving process worked as expected.


![zip3](https://i.postimg.cc/hGd4nxbw/Screenshot-2025-03-24-at-03-17-22.png)

This task streamlines the archiving process by packaging the `src` directory into a `.zip` file, making it easier to store, distribute, and manage versions.

---

## Final Results

### Tags
At the conclusion of the assignment, the repository was tagged with **ca1-part2** to mark the completion of this phase.
![tagsgradle2](https://i.postimg.cc/15XQPwyH/ca1-part2-ca1-part2.png)

---

### Commits
A series of commits were made, adhering to best practices by using **descriptive messages** to document each change.

![commitsgradle2](https://i.postimg.cc/MGM08sLS/feat-add-new-task-of-type-Copy-to-make-a-backup-of-the-sources-of-the-application.png)

---

### Issue Tracking

GitHub Issues were used to **document tasks**, **track progress**, and **manage improvements**.

![issuesgradle2](https://i.postimg.cc/rmy8rbL6/Add-new-task-of-type-Zip-to-be-used-to-make-an-archive-of-the-sources-of-the-application.png)

---

## Overall Conclusion of Part 2

Completing this assignment provided key insights into the practical use of **Gradle** as a build automation tool. Throughout the tasks, Gradle’s flexibility and versatility in managing various stages of the development process were clearly demonstrated.

The automation of build processes, integration of unit tests, and handling of file operations showcased how Gradle can streamline workflows and maintain project efficiency. By extending the `build.gradle` file with custom tasks, such as `runServer`, `backup`, and `archive`, the development process was further simplified, while also enhancing the project's resilience and distribution capabilities.

The integration of unit testing into the build pipeline highlighted the importance of automated testing in software development and how Gradle facilitates this essential practice.

In conclusion, this assignment has significantly deepened my understanding of Gradle’s role in modern software development. The skills and knowledge gained will be invaluable in future projects, enabling the creation of more efficient, reliable, and scalable development workflows.

---

# Part3: Build Tools with Gradle - Maven to Gradle Migration

---

## Introduction to Part 3

This document provides a comprehensive overview of the tasks completed in the **third segment of Class Assignment 1** for the **DevOps course**, focusing on the transition from **Maven to Gradle** as a **build automation tool**.

The assignment follows a structured approach to migrating a **Spring Boot application**, demonstrating the **practical benefits** and **real-world applications** of Gradle in the **software development lifecycle**.

### Overview

- **Set Up Initial Gradle Project** – Covers the foundational steps required to set up the project with Gradle.
- **Integrate Existing Code** – Details the process of adapting the application's source code to fit the Gradle project structure.
- **Configure Frontend Plugin for Gradle** – Explains how a Gradle plugin was integrated to manage frontend assets effectively.
- **Add Gradle Tasks for File Management** – Introduces custom Gradle tasks designed to streamline project maintenance and file handling.
- **An Alternative Solution** – Explores other potential build tools and compares them with Gradle.
- **Conclusion** – Reflects on the learning experience and the role of Gradle in modern software development practices.


---

## Set Up Initial Gradle Project

The **transition from a Maven-based structure to Gradle** involved several key steps to ensure a smooth migration.

### **Creating a Dedicated Branch**
To maintain a structured workflow, a new **Git branch** was created specifically for this part of the assignment. This approach helped **isolate changes** and keep the modifications **organized and manageable**.

```bash
# Create a new directory for Part 3 of the assignment  
mkdir part3  

# Navigate into the newly created directory  
cd part3  

# Create and switch to a new Git branch named 'tut-basic-gradle'  
# This ensures that changes remain isolated from the main branch  
git checkout -b tut-basic-gradle  
```

![tutbasicgradle](https://i.postimg.cc/yYz8fqL4/image.png)

### **Generating a Spring Boot Project**
A new **Spring Boot project** was generated using [**Spring Initializr**](https://start.spring.io/), with the essential dependencies selected to ensure full functionality within the Gradle ecosystem:

#### **Selected Dependencies:**
- **Spring Web** (*Rest Repositories*)
- **Thymeleaf**
- **Spring Data JPA**
- **H2 Database**


![dependenciesspringboot](https://i.postimg.cc/1Rf2TMW9/Exposing-Spring-Data-repositories-over-REST-via-Spring-Data-REST.png)

These dependencies ensure that the application retains its core functionality while leveraging **Gradle for dependency management and build automation**.



Once the project structure was generated, the downloaded **.zip file** was extracted into the `CA1/Part3/` directory within the repository. This provided the foundational structure for a minimal **Spring Boot application**, ready to be built using **Gradle**.

To confirm the correct setup and view the available Gradle tasks, the following command was executed from the project's root directory:

```bash
./gradlew tasks
```
The output verified that multiple tasks related to **building and running the application** were successfully created. This detailed list of tasks highlighted the functionalities now accessible through the **Gradle build tool**, laying the foundation for further customization and development in the next stages of the project.

![output](https://i.postimg.cc/NMqM2LCV/test-Runs-the-test-suite.png)

---

## Integrate Existing Code

This phase focused on **integrating the existing codebase** from a basic tutorial setup into the newly structured **Gradle project**. The process was carefully executed to ensure all components functioned correctly within the new **build management system**.

###  Steps Taken

1. **Replace the Source Directory**
    - The original `src` directory of the Gradle project was removed to allow for the integration of the established codebase.
    - The `src` folder, along with its subdirectories, was copied from the tutorial project into the new Gradle project structure.

2. **Copy Necessary Configuration Files**
    - Key configuration files such as `webpack.config.js` and `package.json` were transferred to the project's root directory.
    - This retained the **frontend build setup** and dependencies.

3. **Remove Unnecessary Directories**
    - The `src/main/resources/static/built` directory was deleted.
    - Since **Webpack** automatically generates this directory during the build process, it should not be manually included in version control to prevent redundancy and potential conflicts.

![structure](https://i.postimg.cc/L5Khk89q/E-gradlew-bat.png)

4. **Modify Import Statements**
    - To align with updated project dependencies and the transition from **Java EE to Jakarta EE**, adjustments were made to the Java classes.
    - In `Employee.java`, import statements were changed from:
      ```java
      import javax.persistence.*;
      ```
      to:
      ```java
      import jakarta.persistence.*;
      ```

5. **Update Package Manager Configuration**
    - The `package.json` file was updated to define a fixed version of the package manager by adding:
      ```json
      "packageManager": "npm@9.6.7"
      ```
    - You should check your npm version using:
      ```bash
      npm -v
      ```
    - This guarantees consistency across different development environments.

6. **Start the Application**
    - The following command was executed to **compile and launch the backend**:
      ```bash
      ./gradlew bootRun
      ```

![bootrun](https://i.postimg.cc/LsVMQ43Y/Screenshot-2025-03-25-at-03-52-24.png)

7. **Check the Frontend**
    - Navigating to **[http://localhost:8080](http://localhost:8080)** in a web browser should display a **blank page**.
    - This is expected at this stage since the **Gradle setup is missing a plugin** needed to manage the frontend code, which will be addressed in the next steps of the project configuration.

![blankfront](https://i.postimg.cc/B6D77m0h/Screenshot-2025-03-25-at-03-52-57.png)

---

## Configure Frontend Plugin for Gradle

To integrate the **frontend build process** into the newly adopted **Gradle system**, the `org.siouan.frontend-gradle-plugin` was implemented. This plugin plays a similar role to the **frontend-maven-plugin** in Maven-based projects, enabling Gradle to manage frontend assets.

###  Steps Taken

1. **Incorporating the Plugin**
    - The `build.gradle` script was updated to include the **`org.siouan.frontend`** plugin, compatible with the project's **Java version**.
    - For **Java 17**, the following line was added to the `plugins` section of the `build.gradle` file:
      ```groovy
      id "org.siouan.frontend-jdk17" version "8.0.0"
      ```

2. **Setting Up the Plugin**
    - The following configuration was added to properly manage the **frontend assets**:
      ```groovy
      frontend {
          nodeVersion = "16.20.2"
          assembleScript = "run build"
          cleanScript = "run clean"
          checkScript = "run check"
      }
      ```
    - This setup defines:
        - **Node.js version** (`16.20.2`)
        - **Scripts** to assemble, clean, and check the frontend code.

3. **Modifying `package.json`**
    - The `scripts` section of `package.json` was updated to handle the execution of **Webpack** and other frontend-related tasks:
      ```json
      "scripts": {
          "webpack": "webpack",
          "build": "npm run webpack",
          "check": "echo Checking frontend",
          "clean": "echo Cleaning frontend",
          "lint": "echo Linting frontend",
          "test": "echo Testing frontend"
      }
      ```
    - These scripts ensure the proper execution of frontend tasks during the build process.

###  Testing the Setup

1. **Build Verification**
    - Running the following command verified that the project successfully built, including the **frontend integration**:
      ```bash
      ./gradlew build
      ```

![buildd](https://i.postimg.cc/59Pgfc2h/Screenshot-2025-03-25-at-04-01-13.png)

2. **Application Launch**
    - The **Gradle task** `./gradlew bootRun` was executed to launch the application.
    - The application was then accessed at **[http://localhost:8080](http://localhost:8080)**.
    - Unlike earlier stages, the webpage now displayed **frontend content**, confirming that the **Gradle plugin** successfully managed the frontend assets during both the build and serve processes.

![launch](https://i.postimg.cc/RhVzKrrr/Screenshot-2025-03-25-at-04-01-38.png)

![launch2](https://i.postimg.cc/mDmnxtnq/Screenshot-2025-03-25-at-04-01-54.png)

---

## Add Gradle Tasks for File Management

### 1. Task: `copyJar`

This custom Gradle task was created to copy the `.jar` file produced by the **bootJar** task to the **dist** directory. This ensures that the build artifact is properly organized and ready for distribution.

#### Steps to Define the Task

1. Open the `build.gradle` file located in the **root folder** of the project.
2. Add the following task definition at the end of the file, after any existing configurations:
   ```groovy
   task copyJar(type: Copy) {
       dependsOn bootJar
       from bootJar.outputs
       into file("dist")
   }
   ```
This task performs the following:

- It **depends on** the `bootJar` task, meaning that `bootJar` must run first.
- It **copies** the generated `.jar` file from `bootJar`'s outputs.
- It **places** the `.jar` file in the `dist` directory.

#### Verifying the Task

To verify that the `copyJar` task works correctly, run the following command:

```bash
./gradlew copyJar
```

![copyj](https://i.postimg.cc/7ZGbfRrt/Screenshot-2025-03-25-at-04-10-03.png)

![copyj2](https://i.postimg.cc/sfL48tmw/Screenshot-2025-04-02-at-11-48-12.png)

As expected, the `.jar` file produced by the `bootJar` task will be copied to the `dist` directory. This confirms that the task handles the artifact correctly and relocates it for distribution.

---

### 2. Task: `cleanWebpack`

This task is designed to remove all files generated by Webpack that are stored in the `src/main/resources/static/built` directory. By doing so, it helps maintain a **clean build environment** and ensures that only the required files are included in each build, avoiding issues caused by outdated or unnecessary files.

#### Defining the Task

In the `build.gradle` file, add the following task definition:

```groovy
task cleanWebpack(type: Delete) {
    delete 'src/main/resources/static/built'
}
clean.dependsOn cleanWebpack
```

This task performs the following actions:

- It **deletes the contents** of the `src/main/resources/static/built` directory, ensuring no old or unwanted files remain.
- It is **integrated** into the Gradle `clean` task, meaning it runs automatically when you invoke the standard Gradle `clean` task, streamlining the cleanup process.

#### Verifying the Task

To verify that the `cleanWebpack` task is working correctly, run the following command:

```bash
./gradlew cleanWebpack
```

![cleanw](https://i.postimg.cc/8ChthtVN/1-actionable-task-1-executed.png)

This will remove all files within the `src/main/resources/static/built` directory. If successful, this confirms that the task is functioning as expected, effectively clearing outdated files and maintaining a **clean, organized build environment**.


---

## Final Results

### Branches
The new branch `tut-basic-gradle` will now appear.

![b3](https://i.postimg.cc/VsT9Xznm/email-field.png)

---

### Tags
At the conclusion of the assignment, the repository was tagged with **ca1-part3** to mark the completion of this phase.

![t3](https://i.postimg.cc/mkRPy6L3/cal-part1-1.png)

---

### Commits
A series of commits were made, adhering to best practices by using **descriptive messages** to document each change.


![c3](https://i.postimg.cc/sDMr04M5/Screenshot-2025-03-25-at-04-27-13.png)

---

### Issue Tracking
GitHub Issues were used to **document tasks**, **track progress**, and **manage improvements**.


![i3](https://i.postimg.cc/Hk0PSr9Q/Update-scripts-section-in-package-json-to-manage-the-execution-of-Webpack-and-other-frontend.png)

---


## Alternative Solution for Build Automation: Ant


### Introduction

**Build automation tools** play a crucial role in modern software development, streamlining processes such as **compilation, dependency management, packaging, and deployment**.
This section explores **Ant** as an alternative build automation tool for managing the backend (Spring Boot) and frontend (Webpack) tasks, replacing the standard **Gradle** solution. While **Gradle** is widely used in modern development due to its flexibility and features, **Ant** remains a popular choice for many legacy projects because of its simplicity and control. The goal of this section is to demonstrate how Ant can be leveraged for build automation and dependency management, similar to what is commonly achieved with Gradle.

![ant](https://i.postimg.cc/P5HqRZHs/APACHE-ANT.png)

---

### Analysis of the alternative
Below is a comparison of Ant and Gradle based on key factors relevant for build automation:
#### Gradle vs Ant - Build Automation Tools Comparison

| **Feature**               | **Gradle**                                       | **Ant**                                          |
|---------------------------|-------------------------------------------------|-------------------------------------------------|
| **Configuration Language** | Groovy (or Kotlin DSL)                          | XML (Ant build scripts)                         |
| **Ease of Use**            | Easier to read and maintain, with a more modern and expressive syntax. | More verbose and harder to maintain due to XML configuration. |
| **Build Speed**            | Faster than Ant due to incremental builds and advanced caching techniques. | Generally slower, as it does not have built-in support for incremental builds. |
| **Flexibility**            | Highly flexible with plugin support for different types of builds (Java, Android, etc.). | Flexible but less so than Gradle, as it requires manual configuration for tasks and dependencies. |
| **Dependency Management**  | Built-in dependency management using Maven or Ivy repositories. | No built-in dependency management (requires external tools like Ivy). |
| **Parallel Execution**     | Supports parallel task execution out of the box, improving performance for multi-task builds. | Does not natively support parallel task execution. |
| **Extensibility**          | Extensible through plugins written in Java, Groovy, or Kotlin. A large ecosystem of plugins. | Extensible, but generally requires more configuration for custom tasks. |
| **Integration with IDEs**  | Good integration with major IDEs like IntelliJ IDEA, Eclipse, and Android Studio. | Supported by IDEs like Eclipse, IntelliJ, but less seamless compared to Gradle. |
| **Build Scripts**          | More concise and easier to maintain (Groovy or Kotlin-based DSL). | Longer, more verbose XML configuration, harder to maintain for large projects. |
| **Community & Ecosystem**  | Modern ecosystem with strong support for CI/CD tools, cloud, and Android builds. | Older ecosystem with limited support for modern tools like Android or cloud-native builds. |
| **Popular Use Cases**      | Java, Android, web applications, and any other JVM-based builds. | Primarily used for Java-based applications, but can be adapted for other languages. |
| **Learning Curve**         | Generally easier to learn compared to Ant due to its more expressive DSL. | Steeper learning curve due to XML configuration and more manual setup for dependencies and tasks. |

#### Summary:
- **Gradle automates more aspects of the build process** (e.g., dependency management, incremental builds), while **Ant requires explicit configuration for each task**.
- **Gradle uses plugins to extend functionality**, whereas **Ant requires scripting everything manually**.
- **Ant, when paired with Ivy, can replicate some Gradle-like dependency management features**, but it lacks native support.
- **Gradle** is generally the preferred choice for modern projects, especially for larger, more complex builds or when working with Android and other JVM-based ecosystems.
- **Ant** may still be suitable for smaller or legacy projects that have an existing Ant-based setup, but for new projects, **Gradle** is the more future-proof option due to its flexibility, speed, and modern features.

---

### Implementation of the alternative

```bash
touch build.xml
touch ivy.xml
touch ivysettings.xml

brew install ant

ant -version
```

![antversion](https://i.postimg.cc/44QDvqXw/joaopinheiro-Joaos-Mac-Book-Pro-4-ant-alternative-ant-version.png)


```bash
mkdir lib

# Install ivy 2.5.3 
```

``` 
"scripts": {
```


``` bash
ant build
```

![antbuild](https://i.postimg.cc/hj9H53TD/Screenshot-2025-04-01-at-23-39-50.png)

``` bash
ant run
```

![antrun](https://i.postimg.cc/HL7GQLL7/Screenshot-2025-04-01-at-23-42-06.png)


#### Copy JAR Task:

```xml
<!-- === Optional: Copy Jar to dist folder === -->
<target name="copyJar" depends="jar">
    <copy file="${dist.dir}/my-spring-boot-app.jar" todir="${dist.dir}"/>
</target>
```

```bash
ant copyJar
```

![cpj](https://i.postimg.cc/02pbC8bF/Screenshot-2025-04-01-at-23-54-38.png)

![lsdist](https://i.postimg.cc/FHN1W2SR/joaopinheiro-Joaos-Mac-Book-Pro-4-ant-alternative-ls-dist.png)

---

#### Delete Webpack Files Task:

```xml
<!-- === Delete Webpack build directory === -->
<target name="deleteWebpackFiles">
    <echo message="Deleting the entire built directory"/>
    <delete dir="${src.dir}/main/resources/static/built"/>
</target>

<!-- === Delete Webpack build directory === -->
<target name="clean" depends="deleteWebpackFiles">
    <delete dir="${build.dir}"/>
    <delete dir="${dist.dir}"/>
    <delete>
        <fileset dir="${lib.dir}" includes="*.jar" excludes="ivy-*.jar"/>
    </delete>
</target>
```

```bash
ant clean
```

![antcl](https://i.postimg.cc/Gp9L6rmc/Screenshot-2025-04-01-at-23-52-43.png)

![strctr](https://i.postimg.cc/rs2qdrCm/Js-webpack-config-js.png)

---

### Final Thoughts on Ant as an Alternative

This project explored **Apache Ant** as an alternative to **Gradle** for build automation. While **Gradle** offers a modern, efficient, and flexible approach with built-in dependency management and incremental builds, **Ant** provides a more manual but highly customizable solution, especially for simpler or legacy projects.

Ant was successfully implemented in this project, handling **dependency management (Ivy), backend compilation (Spring Boot), frontend automation (Webpack), and packaging (JAR creation)**. However, it required more explicit configurations compared to Gradle’s streamlined approach.

Ultimately, **Gradle is better suited for modern, large-scale applications**, offering superior performance and easier integration with CI/CD pipelines. **Ant remains a viable option for projects requiring full control or working within older systems**, but it comes at the cost of increased manual setup. The choice between the two depends on the project’s complexity, team expertise, and automation needs.

---

## Overall Conclusion of Part 3

In Part 3, the focus was on integrating Gradle into a Spring Boot project, managing both backend and frontend components. The project transitioned from Maven to Gradle, incorporating the `org.siouan.frontend-gradle-plugin` for frontend asset management. Custom Gradle tasks, like `copyJar` and `cleanWebpack`, were created to optimize the build process and maintain a clean environment. Additionally, an alternative build tool, **Ant**, was analyzed and implemented to achieve the same goals defined in this part of the assignment. By the end, the Spring Boot application was fully integrated with Gradle, demonstrating its effectiveness in managing complex workflows and automating builds. This part highlighted the power and flexibility of Gradle in modern software development, along with the versatility of alternative tools like Ant.

---

# Overall Conclusion of CA1 Assignment

This **CA1 assignment** has significantly broadened my understanding of essential tools for modern software development, covering **version control systems**, **build automation**, and **technology selection strategies**. Each component contributed to a deeper understanding of best practices for efficient and structured development workflows.

#### 1. Version Control: Git & Mercurial
We explored **Git** (with **GitHub**) as a powerful tool for **code versioning, collaboration, and branching strategies**, ensuring project stability and smooth feature integration. Additionally, examined **Mercurial** as an alternative, setting up a repository on **SourceForge** to understand different version control approaches. This comparison highlighted the strengths of both tools and their suitability for different team structures.

#### 2. Build Automation with Gradle
**Gradle** was implemented as a flexible build automation tool, streamlining **compilation, testing, and file management**. We explored custom tasks, such as `runServer`, `backup`, and `archive`, showcasing how Gradle can be tailored to meet specific project needs. The integration of unit tests further highlighted how Gradle facilitates the testing process, ensuring high-quality software delivery.

#### 3. Maven vs. Gradle vs. Ant: Choosing the Right Tool

We compared **Maven** and **Gradle** during a **Spring Boot** migration, analyzing their strengths:
- **Maven** follows a structured, convention-over-configuration model, making it suitable for standard projects.
- **Gradle** provides a more flexible, scriptable approach, allowing greater customization for complex builds.

Additionally, **Ant** was explored as a legacy alternative, offering low-level build control but requiring **more manual configuration** compared to Gradle. This reinforced the importance of choosing the right tool based on project complexity and team expertise.


#### Final Thoughts
This assignment enhanced my ability to evaluate and implement **version control, build automation, and software development best practices**. Whether managing code with **Git or Mercurial**, automating builds with **Gradle**, or selecting the best tool for the task, these lessons will inform my future projects. The key takeaway is the importance of **adaptability and well-informed tool selection** to ensure **efficient, maintainable, and high-quality software development**.

---

# Final Submission
To finalize the assignment, I created a tag **ca1-submission** in the **Git repository** to mark the completion of the project. After tagging the repository, I downloaded the generated zip file from GitHub, which included all the necessary project files and history. Additionally, I cloned the **Mercurial repository** and ensured that it was up to date. Both the **Git** and **Mercurial** repositories were then **compressed into a single zip file for submission**. This process ensured that both version control systems were accurately represented and included in the final submission, providing a comprehensive record of the project’s development.

