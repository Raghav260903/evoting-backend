🗳️ E-Voting System (Backend)

A secure E-Voting system built using Spring Boot and PostgreSQL.

🚀 Features
- OTP-based voter authentication
- One vote per voter
- Real-time vote counting
- Admin dashboard support

🛠️ Tech Stack
- Java
- Spring Boot
- PostgreSQL (Supabase)
- REST APIs

📦 API Endpoints
- POST /api/votes → Cast vote
- GET /api/votes/check/{voterId} → Check if voted
- GET /api/votes/results → View results

▶️ Run Locally
```bash
mvn spring-boot:run
