# Content of project
* [About application](#about-application)
* [Technologies](#technologies)
* [Endpoint information](#endpoint-information)
* [Example response](#example-response)
* [Installation](#installation)

## About application

Backend application which calls "GitHub Apps" (https://docs.github.com/en/apps) REST API and fetches specified user, non-forked repository list with every branch name and latest commit SHA value.


## Technologies
Java 17, Spring Boot 3, Docker, Jackson, REST API


## Endpoint information

List of requirements to correctly call the API and retrieve data

### URL

```
/{username}
```

Where {username} is GitHub's existing username 

### Header

```
Accept:application/json
```

Available data will be presented in JSON format


## Example response

Example data which can be fetched by calling the API.

### Valid input data response

This is example data fetched by calling exposed endpoint in locally deployed application on port 8080.
```
localhost:8080/dawidperkowskigit
```
Also provided header "Accept" with value
```
Accept: application/json
```

Response body:
```json
{
    "username": "Dawid Perkowski",
    "repositories": [
        {
            "name": "At----a_Task",
            "owner": "DawidPerkowskiGit",
            "branches": [
                {
                    "name": "master",
                    "commit": {
                        "sha": "784ed05d81d9c82ccf791bef06ec8eb70143e5fc"
                    }
                }
            ]
        },
        {
(...)
        },
(...)
    ]
}
```

### Provided value "application/xml" for the "Accept" header
```json
{
    "status": 406,
    "message": "XML format is unavailable"
}
```

### User does not exist
```json
{
    "status": 404,
    "message": "User could not be found"
}
```


### Provided other values for the "Accept" header
```json
{
    "status": 400,
    "message": "Unrecognizable request, header value is invalid"
}
```


## Installation

### Option #1 - Docker

#### Prerequisites

- Docker

#### 1. Clone the repository
```
git clone https://github.com/DawidPerkowskiGit/At----a_Task
```

#### 2. Go to the application catalogue
```
cd At----a_Task
```

#### 3. Build docker image 
```
docker build --tag dp_github_service .
```

#### 4. Run the docker container
```
docker run -it -p 8080:8080 dp_github_service
```

### Option #2 - Maven and Java

#### Prerequisites

- Maven
- Java 17

#### 1. Clone the repository  
```
git clone https://github.com/DawidPerkowskiGit/At----a_Task
```
#### 2. Go to the application catalogue
```
cd At----a_Task
```
#### 3. Compile the project using Maven  
```
mvn compile
```
#### 4. Package the project using Maven  
```
mvn clean package
```
#### 5. Run the Jar file  
```
java -jar .\target\At----a_Task-0.0.1-SNAPSHOT.jar
```

