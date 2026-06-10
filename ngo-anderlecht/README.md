

#  NGO Anderlecht – Enterprise Applications

**Auteur:** Ali Asaad  
**Academiejaar:** 2025–2026  
**Opleiding:** Enterprise Applications  

**Repository:**  
[GitHub Repository](https://github.com/aliasaad22/Enterprise-Apps-ali.asaad.git)
---

##  Over dit project

Dit project is een prototype van een vernieuwde website voor een Anderlechtse NGO die zich inzet voor gemeenschapsopbouw en ondersteuning van kwetsbare gezinnen.  
De applicatie is gebouwd met **Spring Boot (Java)** en demonstreert een functionele webapplicatie met basisfunctionaliteiten rond evenementenbeheer en communicatie.

De focus van het prototype ligt op:

- duidelijke navigatie  
- correcte validatie  
- eenvoudige data‑flow  
- professionele layout via TailwindCSS  
- veilige e-mailverwerking via Mailtrap  

---

##  Functionaliteiten

###  **Indexpagina (Events overzicht)**
- Toont de **10 meest recente** evenementen  
- Weergave van **titel** en **organisatie**  
- Link naar **detailpagina** per event  
- Knop om een **nieuw event** toe te voegen  

---

###  **Nieuw Event**
- Formulier om een nieuw event aan te maken  
- Validatie via `jakarta.validation`  
- Verplichte velden:
  - Titel  
  - Beschrijving  
  - Organisatie  
  - Contact e‑mail  
  - Datum & tijd  
  - Locatie  
- Foutmeldingen worden automatisch weergegeven  
- Bij succes → redirect naar indexpagina  

---

###  **Event Details**
- Volledige weergave van één specifiek event  
- Niet bereikbaar via menu (enkel via index)  

---

###  **About pagina**
- Adres van de NGO (Campus Kaai, Anderlecht)  
- Contactgegevens  
- Beschrijving van de organisatie (Lorem Ipsum placeholder)  

---

###  **Contact pagina**
- Formulier met validatie  
- Versturen van e-mails via **Mailtrap SMTP**  
- Succesmelding na verzending  

---

###  **Layout**
- Gedeelde navigatiebalk op alle pagina’s  
- Footer op elke pagina  
- Styling via **TailwindCSS (CDN)**  

---

##  Technologieën

### Backend
- Java 17  
- Spring Boot  
  - Spring Web  
  - Spring MVC  
  - Spring Validation  
  - Spring Mail  

### Frontend
- Thymeleaf  
- TailwindCSS (via CDN)  

### Tools
- Maven  
- Mailtrap.io  
- IntelliJ IDEA  

---

##  Architectuur

De applicatie volgt het **Spring MVC pattern**:

- Controller → behandelt requests
- Service → business logic + data opslag
- Model → Event & Location data
- View → Thymeleaf templates

Dit project gebruikt een **in-memory data structuur** (geen database).

##  Projectstructuur

```
src/
└── main/
    ├── java/be/ali/enterprise/ngo_anderlecht/
    │   ├── Event.java
    │   ├── Location.java
    │   ├── EventService.java
    │   ├── EventController.java
    │   ├── ContactController.java
    │   ├── ContactForm.java
    │   ├── MailService.java
    │   └── PageController.java
    │
    └── resources/
        ├── templates/
        │   ├── about.html
        │   ├── contact.html
        │   └── events/
        │       ├── index.html
        │       ├── new.html
        │       └── details.html
        │
        └── application.properties
```

---

##  Hoe het project starten

### 1. Project builden
```bash
mvn clean install
```

### 2. Applicatie starten
```bash
mvn spring-boot:run
```

### 3. Open in browser
```
http://localhost:8080
```

---

##  Mailtrap configuratie

De contactpagina verstuurt e-mails via **Mailtrap**.

### 1. Maak een gratis Mailtrap-account  
[https://mailtrap.io]

### 2. Ga naar **Email Testing → Inboxes**  
Kopieer de SMTP‑gegevens.

### 3. Voeg deze toe aan `application.properties`:

```properties
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username="username"
spring.mail.password="password"
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---




