# TDSE_parcial
- Jeimy Alejandra Yaya Martínez

## Overview

El proyecto implementa una función de fibonacci desplegado en dos instacias EC2.
El video del funcionamiento se llama video-parcial.

---

## Architecture
El sistema esta compuesto de 

* **EC2 (fibonacci 1 y 2)**

  * Expone REST API endpoint (`/fibwin)
 

### 🔁 Communication Flow

Browser → Proxy → Math Services

---

## Technologies Used

* Java 17 / 21
* Spring Boot
* AWS EC2
* HTML + JavaScript

---

## Deployment Steps

### 1. Parcial

```bash
mvn clean package
java -jar target/parcial0.0.1-SNAPSHOT.jar
```

### 2. Ec2

* Instalar java 

```bash
sudo yum install java-17-amazon-corretto
```
* Subir el jar

```bash
scp -i "parcialkey.pem" parcial-0.0.1-SNAPSHOT.jar ec2-user@ec2-3-83-3-125.compute-1.amazonaws.com:/home/ec2-user
```
* Correr la aplicación
```
java -jar parcial-0.0.1-SNAPSHOT.jar
```
---

## API Endpoints


### GET /fibwin

Returns:

```
{
  "operation": "Fibonacci con ventana K=3",
  "input": 10,
  "output": "serie: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 | ventana: 2, 4, 6, 10, 16, 26, 42, 68, 110"
}
```


---

## Evidence

* Instancias
<img width="1659" height="74" alt="image" src="https://github.com/user-attachments/assets/aebc1a10-7a39-4963-aa84-1b1c66cb44cb" />

* Primer instacia corriendo
<img width="582" height="368" alt="image" src="https://github.com/user-attachments/assets/0117f155-77c3-484f-9700-ae238c45f9bb" />

<img width="876" height="182" alt="image" src="https://github.com/user-attachments/assets/c2f6006e-5858-4038-ae15-f638c481cb97" />

* Segunda instacia corriendo
<img width="577" height="325" alt="image" src="https://github.com/user-attachments/assets/0c0c966d-48b4-4cd8-b01f-0ee4f7a6b60c" />

<img width="696" height="213" alt="image" src="https://github.com/user-attachments/assets/27d9baee-57e4-4505-a27b-5448378c4bb5" />

---

## Repository Structure

```
Parcial/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── parcial/
│   │   │               ├── MathController.java
│   │   │               └── RestServiceApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```
