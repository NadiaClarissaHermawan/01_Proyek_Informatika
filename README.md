# 01_Proyek_Informatika

## Anggota Kelompok B :

- @NadiaClarissaHermawan        6181901013
- @ReynaldiLukasYudawinata      6181901038
- @ThomasChristianHaerynoo      2016730027


## Project Details :
This is a Spring-boot REST API project for a train management application as explained by a challenge from [Topcoder](https://www.topcoder.com/challenges/a840efcb-eaf4-435f-92d8-0fbde7dfa018) website.

In this [Topcoder](https://www.topcoder.com/challenges/a840efcb-eaf4-435f-92d8-0fbde7dfa018) page, there are 3 types of difficulty for this challenge. The difficulties are as following: 
- Childhood Dream (easy) -  http://www.topcoder.com/challenges/30168991
- Bullet Train (medium) - http://www.topcoder.com/challenges/30168980 
- Old Train (hard) - http://www.topcoder.com/challenges/30168986

The reference that is being used to work on this project comes from this [link](https://www.bezkoder.com/spring-boot-postgresql-example/)


## Software & Environment Requirement :
- JDK 8
- Spring Boot 2 (with Spring Web MVC, Spring Data JPA)
- PostgreSQL
- Maven

## How To Run the Project:
### 1. Preconditions:
1. make sure udah ada semua requirement di system environment
2. execute command yang ada di db di psql
3. app.properties harus di custom

### 2. How To Activate the API :

1. Open the project directory in cmd
2. type mvn spring-boot:run 
3. enter & wait 


## How to Kill Task :

### Method 1
1. Open cmd, type : netstat -ano | findstr 8080
2. type : taskkill /F /PID "task_id"

### Method 2
1. Open cmd, type: ctrl+c