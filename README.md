# Travel Attraction REST API
REST API application which allows users to manage travel attraction records.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Contact](#contact)

## General info
Travel Attraction REST API is an application written in Java programming language, based on HTTP protocol and JSON format. It cooperates with H2 database and permits users to add/remove/update/get travel attraction records.
Application has been created for educational purpose, in order to develop my porgramming skills.


## Technologies
* Java
* Spring
* Spring Boot
* H2 database as a data source
* JPA - Hibernate implementation
* Hibernate validator
* Swagger

## Features
* **Getting travel attracions(GET method)** - Application allows users to get list of all records from database, or one specific record according to provided id in JSON format.

  * Instruction:<br>
  **Endpoint:** http://localhost:8080/api/attractions <br>
    *   Get list of all records: In order to get list of all record please send GET request to above endpoint<br>
    *   Get one record accorgind to provided id: In order to get record according to provided id, please send GET request to above endpoint and provide id.<br>
    Example : To get record with id = 2, send GET requste under follwing endpoint: http://localhost:8080/api/attractions/2
    
* **Adding new travel attraction(POST method)** - Application allows users to add new record to database.

  * Instruction:<br>
  **Endpoint:** http://localhost:8080/api/attractions <br>
    In order to add new travel attraction record to database please send POST request to above andpoint with JSON parameter in following format:
    
    ```json
    {
      "name" : "name of travel attraction",
      "description" : "description of travel attraction",
      "location" : {
          "city" : "city of travel attraction",
          "street" : "street of travel attraction",
          "country" : "country of travel attraction",
          "postalCode" : "postal code of travel attraction"
      },
      "attractionTypeString" : "type of travel attraction",
      "stars" : 5
    }
    ```
    
    Please be informed that:<br>
    - type of travel attraction is an enum value and must complies with one of the following : CASTLE/NATIONAL_PARK(so far).<br>
    - max. no. of stars is 5.
                                                             
* **Updating travel attraction(PUT method)** - Application allows users to update record from databae according to provided id.
  
  * Instruction:<br>
  **Endpoint:** http://localhost:8080/api/attractions <br>



* **Removing travel attraction(DELETE method)** - Application allows users to remove record from database accoording to provided id.

  * Instruction:<br>
  **Endpoint:** http://localhost:8080/api/attractions <br>





## Contact
Created by : Martin Skuthan. Please feel free to contact me :
* By mail: martin.skuthan95@gmail.com
* Linkedin : www.linkedin.com/in/martin-skuthan-630553190
