# AI E-Commerce Customer Support Agent

A beginner-friendly Spring Boot + HTML/CSS/JavaScript project.

## Run backend
1. Install Java 17 and Maven.
2. Open a terminal in `backend`.
3. Run `mvn spring-boot:run`.
4. Backend URL: http://localhost:8080

## Run frontend
Open `frontend/index.html` using VS Code Live Server.

## API
- GET `/api/products`
- GET `/api/products/search?keyword=phone`
- POST `/api/chat`

Example POST body:
`{"message":"How can I track my order?"}`
