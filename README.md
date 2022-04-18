# Zip Code Validator Tsm

Validate zip code requests

---------------------------------------------------------------------------------------------------

# Application Integrity Identify

> MD5-File (jar): a710cc5ec735d4c62915cdc37d959c16

---------------------------------------------------------------------------------------------------

# RESOURCES AND DEPENDENCIES

* Java 8 (SDK - java-8-openjdk-amd64K)
* Spring Boot 2.6.2
* Maven Project 
* Lombok
* Spring Data JPA
* Mysql Driver
* Spring Rest Docs
* Spring Web
* Rest Repositories

<h4>Details</h4>
<pre>
JDK
$ javac -version 
javac 11.0.13

JRE
$ java -version
openjdk version "11.0.13" 2021-10-19
OpenJDK Runtime Environment (build 11.0.13+8-Ubuntu-0ubuntu1.20.04)
OpenJDK 64-Bit Server VM (build 11.0.13+8-Ubuntu-0ubuntu1.20.04, mixed mode, sharing)

</pre>

Please, for more details see the pom.xml

> More Details

Spring Initializr https://start.spring.io/

IntelliJ IDEA CE https://www.jetbrains.com/pt-br/idea/download/#section=linux

---------------------------------------------------------------------------------------------------

# HOW TO USE

> SETTINGS

Please, configure the environment before run the application as below instructions:

- Copy the application.properties to classpah (root path) on the application zipcodeBasil:
<pre>
   $ ls -ltr zip-code-validator-tsm-0.0.1-SNAPSHOT.jar application.properties
   -rw-rw-r-- 1 user user 48995169 jan 13 07:42 zip-code-validator-tsm-0.0.1-SNAPSHOT.jar
   -rw-rw-r-- 1 user user      540 jan 13 07:58 application.properties
</pre>

- Set environment vars in the machine (Please, give a look in the file application.properties to ensure that exists those variables):
<pre>
   $ JDBC_USER=devel
   $ JDBC_PASS=123mudar
   $ JDBC_URL="jdbc:mysql://localhost:3306/zipcode?useTimezone=true&serverTimezone=UTC"
</pre>

> DATABASE
   1. Create a database target into server (ex: zipcode)
   2. Import database structure file src/data/zipcode-0601-22.sql into database target created
   3. Create the view zipcode_view into database target created (the command is contained into file src/data/ConsultaCEP-MDB-Correios.sql)
   4. Finally, import data content from files into database target created

> APPLICATION
1. There is two-way to execute this application:
   1. Using artefact (jar) zip-code-validator-tsm, placed on src/data/ project path.
      1. java -jar zip-code-validator-tsm-0.0.1-SNAPSHOT.jar (md5-file: 41b2dc06549c5c66234d4998ca135d4c)
   2. Using project on IDE and run it with tomcat server inside spring boot native
      1. Open Project, and Shift+F10

---------------------------------------------------------------------------------------------------

# OpenAPI

> The openAPI(Swagger) is available to query and help understand the application ZipCode REST API

* http://localhost:8080/api-docs/
* http://localhost:8080/api-docs.yaml
* http://localhost:8080/swagger-ui.html

---------------------------------------------------------------------------------------------------

# Tests

TsmBrasilZipCodeValidatorApplicationTests.java
<pre>
   whenTryGetZipCodeDetailsCorrectly_RetrieveZipCodeDetailsAndStatusOK();
   whenTryGetZipCodeDetailsInvalid_RetrieveStatusNotFound();
   whenTryGetZipCodeDetailsIncorrectly_RetrieveStatusBadRequest();
   whenTryGetZipCodeByIncorrectUri_RetrieveStatusNotAcceptable();
</pre>


---------------------------------------------------------------------------------------------------
