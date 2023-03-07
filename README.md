# Getting Started

## How To

* Start the app
* Open [GraphiQL web interface](localhost:8080/graphiql)
* Issue request
* Examine response

## Request and response examples

* all posts
```graphql
query {
  posts {
    id,
    title,
    comments {
      id,
      comment
    }
  }
}
```

```json
{
  "data": {
    "posts": [
      {
        "id": "1",
        "title": "Russia attacks Ukraine",
        "comments": [
          {
            "id": "1",
            "comment": "+1"
          },
          {
            "id": "1",
            "comment": "+11"
          }
        ]
      },
      {
        "id": "2",
        "title": "Putin must d i e",
        "comments": [
          {
            "id": "2",
            "comment": "+2"
          },
          {
            "id": "2",
            "comment": "+22"
          }
        ]
      }
    ]
  }
}
```

* get one by id

```graphql
query {
  postById(id:1) {
    id,
    title
  }
}
```

```json
{
  "data": {
    "postById": {
      "id": "1",
      "title": "Russia attacks Ukraine"
    }
  }
}
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/#build-image)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/web.html#web.graphql)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

