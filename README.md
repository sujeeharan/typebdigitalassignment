# Simple Hello World API

## Overview
This is a simple HTTP API built using Spring Boot.  
It responds differently based on the first letter of the `name` parameter.

### Endpoint
**GET /hello-world?name={name}**

### Responses
| Condition | Status | Response |
|------------|---------|-----------|
| Name starts with A–M | 200 OK | `{ "message": "Hello Alice" }` |
| Name starts with N–Z | 400 Bad Request | `{ "error": "Invalid Input" }` |
| Name missing/empty | 400 Bad Request | `{ "error": "Invalid Input" }` |

---

## Run the Application
```bash
mvn spring-boot:run