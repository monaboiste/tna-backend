# TNA System (Time and Attendance)
TNA System is a working time management Web Application. The solution can 
function as a stand-alone system, which features:
- keeping records of employees' working hours,
- calculating working time on a monthly basis.  

# Demo
<p align="center">
  <img src="https://i.ibb.co/gP1z341/demo-employee-dashboard.png">
    Employee management dashboard
    <br><br>
  <img src="https://i.ibb.co/pzX0h3R/demo-employee-edit.png">
    Work hours - manual edit
</p>

Demo is deployed at: [https://tna-system-backend.herokuapp.com](https://tna-system-backend.herokuapp.com). 
You can view Application which uses tna-backend [here](https://tna-system.herokuapp.com).  
Credentials to test admin account:
```
username: ttest001
password: test
```
Actually, you can log in using any account listed in _Pracownicy_ page. Default password is _test_ for every account. 
___
### Project's functional requirements
##### User accounts related
| Req ID| Req Description | Priority |
|:-----:|:---------------:|:--------:|
| FR101 | The system shall provide an administrative panel for Manager (Superuser) | Highest |
| FR102 | The system shall provide administrative rights to Manager at least: create/remove user account, deactivate/activate | Highest |
| FR103 | Employee shall be able to log in to the system with given credentials | Highest |
| FR104 | User shall be able to reset password | Normal |
| FR105 | The system shall validate password strength and require combination of upper and lower case letters, special characters and digits | Low |
##### Employee time tracking system related
| Req ID| Req Description | Priority |
|:-----:|:---------------:|:--------:|
| FR201 | The system shall register Employee's clock-ins and clock-outs (e.g. using NFC proximity badages at terminals) and store in database | High |
| FR202 | The system shall record the working hours of employees on a daily/mothly basis for each Employee | High |
| FR203 | Manager shall be able manually change Employees' working hours | High |

#### Backend Technology stack:
* JDK 11
* Gradle
* Spring Boot
* Spring Data JPA
* Spring Security
* JUnit
* Mockito
* PostgreSQL
* Liquibase

## Getting started
### Prerequisites
These of following must be installed on your local machine:  
 * JDK 11  
 * Docker and Docker-Compose  
 * Git  

### Clone
Clone repository:
```sh
git clone https://github.com/monaboiste/tna-system-backend.git
```  

### Set up environment variables
The variables listed in  the example below must be specified. 
The easiest way is set up ``.env`` file (supported by bootRun task): 
```sh
# Application
TNA_ADMIN_LOGIN=admin
TNA_ADMIN_PASSWORD=admin

# Database
POSTGRES_HOST=localhost
POSTGRES_PORT=5432
POSTGRES_DB=tna
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
```
If you prefer to build and run the application using IntelliJ IDE, 
you might consider installing [EnvFile plugin](https://plugins.jetbrains.com/plugin/7861-envfile).

### Run
Start PostgreSQL:
```sh
docker-compose up -d
```

Execute:  
```sh
./gradlew bootRun
```
System provides default in-memory ``$TNA_ADMIN_LOGIN`` user with password ``$TNA_ADMIN_PASSWORD``.

Gradle will build project and start Tomcat Server on your localhost. Base URL of Web Api: [http://localhost:8080/api](http://localhost:8080/api).

Generate sample data:  
To auto-generate sample data, run Spring Boot application as follows:
```sh
./gradlew bootRun -Dspring.jpa.hibernate.ddl-auto=update
```

You can also use bash scripts provided in ``scripts/`` directory:
```sh
./generate-employees.sh -u <username>:<password> -h <host_addr> # Generate some employee data
./generate-attendance-records.sh -u <username>:<password> -h <host_addr> # Generate attendance data
```

#### Tests
Run unit tests:
```sh
./gradlew test
```  
Run integration tests:
```sh
./gradlew integrationTest
```  
### Available Endpoints
🚧 WIP 🚧
