# Blogging API

## Technologies Used

### Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL / PostgreSQL (choose your DB)
- Lombok

## API Endpoints

### Blog Controller (`/api/v1/posts`)

| Method | Endpoint            | Description                     |
|--------|---------------------|---------------------------------|
| GET    | `/posts`            | Get all blogs or search by term |
| GET    | `/posts?term=query` | search blogs  by term           |
| POST   | `/posts`            | Create a new blog post          |
| PUT    | `/posts/{id}`       | Update an existing blog         |
|DELETE  | `/posts/{id}`       | Delete an existing blog         |

---

## Sample Request Body for Blog

```json
{
  "title": "Spring Boot Guide",
  "content": "This blog covers Spring Boot basics.",
  "category": "Tech",
  "tags": ["spring", "java", "backend"]
}

```

## Sample Response Body for Blog

```json
{
  "id": 10,
  "title": "Getting Started with Spring Boot",
  "content": "This is a beginner guide for Spring Boot.",
  "category": "Programming",
  "tags": [
    "spring boot",
    "java",
    "backend"
  ],
  "createdAt": "2025-06-24T11:17:21.146191",
  "updatedAt": "2025-06-24T11:17:21.146191"
}
```

---

Project URL: [Blogging Platform API](https://roadmap.sh/projects/blogging-platform-api)
