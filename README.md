DISCLAIMER: This is a small project that is part of a Job selection process.

## ARCHITECTURE

<sub>MVC Models -> Client, Car, Supplier Controllers -> ClientController, CarController, SupplierController Views -> src/main/resources/templates -> All HTML pages</sub>

## FRAMEWORKS AND TOOLS USED ?

<sub>Frameworks: Spring Boot, Spring Data, JUnit, Thymeleaf, Bootstrap</sub>

<sub>Tools: Maven ** Please, see POM.XML file. This file is all commented explaining each dependency.</sub>

## HOW TO RUN THE APPLICATION ?

<sub>To run just CLONE this repository and open as Maven Project, then run class SpringBootConfigAndInitializer.java OR You can run the application using FAT/UBER Jar, see below how to do it:</sub>

<sub>1  Go to the project directory</sub>
<sub>2. Execute command "mvn clean install"</sub>
<sub>3. Go to the TARGET folder, and run the command: "java -jar APPLICATION_0.1.1.jar"</sub>

<sub>*** IMPORTANT *** IT IS IMPORTANT TO REMEMBER THAT TO RUN THIS APPLICATION IS MANDATORY TO HAVE AT LEAST ONE RELATIONAL DATABASE AND CREATE THE SCHEME USING "CREATE DATABASE xyinc". DEFAULT IS POSTGRESQL, BUT IT CAN BE CHANGED BY ADDING THE DRIVER DEPENDENCY AND CHANGING SOME PARAMETERS AT "application.properties" file.</sub>

## HOW TO TEST ?

<sub>Just go to src/test/java folder, on br.com.xy.inc.test package you'll find UNIT TESTS, just execute and see the results.</sub>

<sub>(Not able to do this due to short deadline)</sub>

## HOW TO TEST """REMOTELLY""" ?

<sub>Download some REST test tool, copy and past the URI replacing the parameters. You can use SOAP UI or POSTMAN, these tools are very large accepted by the community.</sub>

## The endpoins are:

## Clients
<sub>Client by ID -> localhost:{port}/getclientservice/{id}
All Clients -> localhost:{port}/allclientsservice
Insert a Client -> localhost:{port}/createclientservice/{name}/{email}/{telephone}
Update a Client -> localhost:{port}/updateclientservice/{id}/{name}/{email}/{telephone}
Remove a Client -> localhost:{port}/removeclientservice/{id}</sub>

## Suppliers
<sub>Supplier by ID -> localhost:{port}/getsupplierservice/{id} 
All Suppliers -> localhost:{port}/allsuppliersservice 
Insert a Supplier -> localhost:{port}/createsupplierservice/{name}/{lineOfBusiness}/{telephone} 
Update a Supplier -> localhost:{port}/updatesupplierservice/{id}/{name}/{lineOfBusiness}/{telephone} 
Remove a Supplier -> localhost:{port}/removesupplierservice/{id}</sub>

## Fleet
<sub>Car by ID -> localhost:{port}/getcarservice/{id} 
Fleet -> localhost:{port}/fleet 
Insert a Car -> localhost:{port}/createcarservice/{modelName}/{price}/{patrimonyTag} 
Update a Car -> localhost:{port}/updatecarservice/{id}/{modelName}/{price}/{patrimonyTag} 
Remove a Car -> localhost:{port}/removecarservice/{id}</sub>
