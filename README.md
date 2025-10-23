# lx-auth-center

## Overview

This project is a minimal OAuth 2.1 Authorization Server and Resource Server built with Spring Boot and Spring Authorization Server. It demonstrates how to issue JWT access tokens and protect REST API endpoints.

### Features

- Minimal OAuth 2.1 Authorization Server configured with the Spring Authorization Server library.
- Registered test client using the client credentials grant.
- Protected resource with JWT-based authentication.
- Public endpoint that is accessible without authentication.
- Maven-based project with Java 21.

## Getting Started

### Prerequisites

- Java 21 or later installed.
- Maven 3.6+ installed.

### Building and Running

Clone the repository and navigate into it:

```bash
git clone https://github.com/cxlet/lx-auth-center.git
cd lx-auth-center
```

Build and run the application using Maven:

```bash
mvn spring-boot:run
```

The authorization server will start on port 9000 (configured in `application.yml`).

### Obtaining an Access Token

This project registers a single test client with the following credentials:

- Client ID: `messaging-client`
- Client Secret: `secret`

To obtain a JWT access token using the client credentials grant, send a POST request to the `/oauth2/token` endpoint:

```bash
curl -X POST \
  -u "messaging-client:secret" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "grant_type=client_credentials&scope=message.read" \
  http://localhost:9000/oauth2/token
```

The response will contain a JSON object with an `access_token`.

### Calling the Protected Resource

Once you have obtained a token, you can call the protected endpoint `/api/hello` by including the token in the `Authorization` header:

```bash
TOKEN=<access_token>
curl -H "Authorization: Bearer $TOKEN" http://localhost:9000/api/hello
```

This should return a greeting from the secure endpoint.

The public endpoint `/api/public` can be accessed without a token:

```bash
curl http://localhost:9000/api/public
```

### Notes

The resource server is configured to validate JWTs using the issuer URI property defined in `application.yml`. Spring Security automatically configures a resource server when a JWT issuer URI is provided.
