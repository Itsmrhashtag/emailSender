# HR Mail Sender
This project is a web application designed to simplify the process of sending emails to HR departments of various companies. By entering the HR's name, company name, HR email, and the hiring position, users can easily send emails directly from the application.

## Technologies Used
### Backend: Spring Boot
### Frontend: HTML, CSS, JavaScript
## Features
User-friendly interface for entering HR details and the hiring position.
Sends email directly to the specified HR email address.
Streamlined process for job seekers to contact HR departments.
## Setup and Installation
### Prerequisites
Java Development Kit (JDK) 11 or higher
Maven
Node.js and npm
## Backend Setup
### Clone the repository:

```bash
git clone https://github.com/yourusername/hr-mail-sender.git
cd hr-mail-sender
```
### Navigate to the backend directory:

```bash
cd backend
```
### Install dependencies and run the Spring Boot application:

```bash
mvn clean install
mvn spring-boot:run
```
## Frontend Setup
### Navigate to the frontend directory:

```bash
cd ../frontend
```
###Install dependencies:

```bash
npm install
```
###Run the frontend application:

```bash
npm start
```
## Configuration
Configure the email service in the Spring Boot application by updating the application.properties file with your email service credentials:
properties
```bash
spring.mail.host=smtp.your-email-provider.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
## Usage
Open the frontend application in your browser (typically running on http://localhost:3000).
Enter the HR's name, company name, HR email, and the hiring position.
Click the "Send Email" button to send the email.
