# CampusAI - AI Student Support Assistant

## Stack
- Frontend: React + Vite
- Backend: Spring Boot 3 + Java 17
- REST API
- Current knowledge base: sample college rules/notices in Java

## Run Backend

Open terminal 1:

```bash
cd backend
mvn spring-boot:run
```

Backend runs at:
http://localhost:8080

## Run Frontend

Open terminal 2:

```bash
cd frontend
npm install
npm run dev
```

Frontend runs at:
http://localhost:5173

## API

POST /api/chat

Example:
```json
{
  "question": "What is the attendance requirement?",
  "studentId": "student001"
}
```

GET /api/notices

## Important
The sample answers are placeholders. For the final project, replace them with your actual college PDFs/FAQs/notices and connect an LLM + RAG/vector database.
