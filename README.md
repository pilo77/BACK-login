# ReminderG app

# BACKEND:  JWT Authentication Project (Spring Boot)

This project demonstrates how to implement a JWT Authentication functionality in an Spring Boot application.

## Overview

This project showcases the implementation of a JWT Authentication feature in an Spring Boot application.

Technologies used:
  - Spring Boot 3
  - Spring Security 6
  - Java 17

## Autor

*Carlos Andres Villamil* - [LinkedIn](www.linkedin.com/in/pilo77)



# FRONTEND JWT Authentication Project (Ionic -Vue)

This project demonstrates how to implement a JWT Authentication functionality in an Ionic application.

## Overview

This project showcases the implementation of a login feature in an Angular application. It utilizes Angular's powerful features such as components, services, and routing to create a seamless login experience for users.

Technologies used:
  - Ionic
  - Vue
  - TypeScript
  - HTML 5/CSS 3


# Diagrama de Componentes

```mermaid
graph TD
    subgraph "Sistema de Gestión de Horarios"
        FrontEnd["Frontend"]
        API["API"]
        AdminController["Admin Controller"]
        SecurityComponent["Security Component"]
        ScheduleManagement["Schedule Management"]
        EmailService["Email Service"]
        WhatsAppService["WhatsApp Service"]
        PDFExport["PDF Export"]
    end

    subgraph "Sistemas Externos"
        ExternalEmailService["External Email Service"]
        ExternalWhatsAppService["External WhatsApp Service"]
    end

    FrontEnd -->|HTTP Requests| API
    API -->|Authentication| SecurityComponent
    SecurityComponent -->|Handles| AdminController
    AdminController -->|Manages| ScheduleManagement
    ScheduleManagement -->|Sends Notifications| EmailService
    ScheduleManagement -->|Sends Notifications| WhatsAppService
    EmailService -->|Uses| ExternalEmailService
    WhatsAppService -->|Uses| ExternalWhatsAppService
    ScheduleManagement -->|Exports| PDFExport

    style FrontEnd fill:#f9f,stroke:#333,stroke-width:2px;
    style API fill:#ccf,stroke:#333,stroke-width:2px;
    style AdminController fill:#cfc,stroke:#333,stroke-width:2px;
    style SecurityComponent fill:#fcf,stroke:#333,stroke-width:2px;
    style ScheduleManagement fill:#ff9,stroke:#333,stroke-width:2px;
    style EmailService fill:#9ff,stroke:#333,stroke-width:2px;
    style WhatsAppService fill:#f9f,stroke:#333,stroke-width:2px;
    style PDFExport fill:#cfc,stroke:#333,stroke-width:2px;
    style ExternalEmailService fill:#fdd,stroke:#333,stroke-width:2px;
    style ExternalWhatsAppService fill:#ddf,stroke:#333,stroke-width:2px;

