# API Restful Test
API Restful Test is a Java Spring Boot application that allows you to create and manage user information, including name, email, password, and a list of phone numbers with number, city code, and country code.

## Table of Contents
- Technologies Used
- Getting Started
- API Endpoints
- User Object
- Phone Number Object
- Error Handling

## Technologies Used
- Java 17
- Spring Boot
- Hibernate
- HSQLDB (in-memory database)
- Maven
- 
## Getting Started
1) Make sure you have Java 17 and Maven installed on your system.
2) Clone this repository to your local machine.
3) Open a terminal or command prompt and navigate to the project directory.
4) Build the project using Maven: ```mvn clean install```
5) Run the application:```mvn spring-boot:run```

The application will start, and you can access the API endpoints described below.

## API Endpoints
The API exposes the following endpoints:

- POST /users: Create a new user.
- GET /users: Retrieve a list of all users.

## User Object
A User object has the following attributes:

- id (UUID): The unique identifier for the user.
- name (String): The name of the user.
- email (String): The email address of the user.
- password (String): The encrypted password of the user.
- phoneNumbers (List of PhoneNumber): A list of phone numbers associated with the user.

## Phone Number Object
A PhoneNumber object has the following attributes:

- number (String): The phone number.
- cityCode (String): The city code of the phone number.
- countryCode (String): The country code of the phone number.

## Token Object
A Token object represents the authentication token obtained during the login process. It includes the following attributes:

- token (String): The authentication token.
- userId (UUID): The user ID associated with the token.
- dateCreated (Date): The date when the token was created.
- dateExpire (Date): The date when the token will expire.
- modified (Date): The date of the last modification.
- lastLogin (Date): The date of the last login.
- isActive (boolean): Indicates if the token is still active.

## Error Handling
The API handles various error scenarios and returns appropriate error messages in JSON format. For example, if you try to create a user with an invalid email or password, you will receive an error message indicating the specific validation errors.

## SQL User Table
```
CREATE TABLE "user" (
  "UserId" VARCHAR(60),
  "Name" VARCHAR(100),
  "Email" VARCHAR(100),
  "Password" VARCHAR(100),
  PRIMARY KEY ("UserId")
);
```
## SQL Phone Table
```
CREATE TABLE "phone" (
  "PhoneId" VARCHAR(60),
  "Number" VARCHAR(100),
  "CityCode" VARCHAR(100),
  "CountryCode" VARCHAR(100),
  PRIMARY KEY ("PhoneId")
);
```
## SQL Token Table
```
CREATE TABLE "token" (
  "TokenId" BIGINT(255),
  "Token" VARCHAR(100),
  "DateCreate" DATETIME,
  "DateExpire" DATETIME,
  "modified" DATETIME,
  "LastLogin" DATETIME,
  "IsActive" BOOLEAN,
  "user" VARCHAR(60),
  PRIMARY KEY ("TokenId")
);
```
