## 🌦️ Weather & Air Quality Monitoring Application

A full-stack Spring Boot application that provides **real-time weather data**, **air quality index (AQI)**, and personalized **health advice** by integrating OpenWeatherMap and IQAir APIs. Built using modular design and best practices to demonstrate professional-level backend development.

## 🚀 Features
- 🌡️ **Live Weather Info** – Temperature, humidity, "feels like", and conditions by city.
- 🏭 **Air Quality Insights** – Real-time AQI with health-based recommendations.
- 📍 **Coordinates Detection** – Automatically fetches latitude and longitude from city names.
- 📅 **5-Day Weather Forecast** – Future weather support using OpenWeatherMap forecast API.
- ❗ **Error Handling** – Clean exceptions with meaningful HTTP responses.
- ✅ **Validation + Unit Testing** – Ensures reliable and safe input/output handling.
- ⚙️ **Scalable Architecture** – Service, DTO, and Utility layers for industry readiness.

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Web (REST APIs)**
- **Lombok**
- **Maven**
- **OpenWeatherMap API**
- **IQAir AirVisual API**
- **Postman (for testing)**

📁 Project Folder Structure
src/
 └── main/
     ├── java/com/example/weather/
     │   ├── controller/        # REST API endpoints
     │   ├── service/           # Business logic and integrations
     │   ├── model/             # DTOs and response objects
     │   ├── util/              # Utility classes and helpers
     └── resources/
         ├── application.properties  # API keys and configs

🌐 API Endpoints
Method	Endpoint	Description
GET	localhost:8080/api/weather >> Fetch current weather and AQI 
{
 "city":"Delhi"
}

GET	localhost:8080/api/weather/forecast >> Fetch 5-day forecast

📸 Sample API Output
json
{
  "city": "Delhi",
  "temperature": 34.2,
  "feelsLike": 36.1,
  "humidity": 50,
  "condition": "clear sky",
  "latitude": 28.61,
  "longitude": 77.2,
  "airQuality": "Moderate (AQI: 55)",
  "healthAdvice": "Sensitive groups should reduce outdoor exertion."
}

## 🙋‍♂️ Author

**Kartik Sharma**  
Java Developer | Spring Boot Enthusiast

[🔗 LinkedIn]([https://www.linkedin.com/in/your-profile](https://www.linkedin.com/in/kartiksharma-tech-enthusiast/))
