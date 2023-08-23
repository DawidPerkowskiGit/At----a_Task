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

```
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
}
```

### Provided value "application/xml" for the "Accept" header
```
{
    "status": 406,
    "message": "XML format is unavailable"
}
```

### User does not exist
```
{
    "status": 404,
    "message": "User could not be found"
}
```


### Provided other values for the "Accept" header
```
{
    "status": 400,
    "message": "Unrecognizable request, header value is invalid"
}
```


## Installation

### Prerequisites

- Docker

### Clone the repository
```
git clone https://github.com/DawidPerkowskiGit/At----a_Task
```

### Build docker image 
```
docker build --tag dp_github_service .
```

### Run the docker container
```
docker run -it -p 8080:8080 dp_github_service
```
