# Password Security Validator

A Java-based password security validation project that checks password strength, policy compliance, and estimated entropy.

## Features
- Validates password length
- Checks uppercase and lowercase letters
- Detects digits and special characters
- Calculates estimated password entropy
- Identifies passwords from a small common-password list
- Classifies strength as Weak, Moderate, Strong, or Exceptional
- Provides suggestions for improving password security

## Technologies Used
- Java
- VS Code
- Git and GitHub

## How to Run

1. Clone the repository.
2. Open the project folder.
3. Compile the Java program:

   `javac PasswordValidator.java`

4. Run the program:

   `java PasswordValidator`

## Future Improvements
- Integrate the Have I Been Pwned API for breached-password detection
- Add a graphical user interface
- Improve strength estimation using pattern detection

## Note
The current version uses a basic entropy estimate and a small common-password list. It does not yet perform a live breach database check.