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

    ## Diagrama de Componentes

### Componentes

#### Front-End
- **Descripción**: Interfaz de usuario donde los administradores interactúan con el sistema para gestionar profesores, horarios y salones.
- **Tecnologías**: React, Angular, Vue.js

#### API
- **Descripción**: Punto de entrada para todas las solicitudes del cliente. Proporciona endpoints para gestionar profesores, horarios y salones.
- **Tecnologías**: Node.js, Express, Django, Flask

#### Controlador de Autenticación
- **Descripción**: Maneja la autenticación de los administradores. Verifica las credenciales y emite tokens de sesión.
- **Tecnologías**: JWT, OAuth

#### Componente de Gestión de Profesores
- **Descripción**: Gestiona la información de los profesores, incluyendo la carga académica y los contratos.
- **Tecnologías**: Servicios REST, base de datos relacional

#### Componente de Gestión de Horarios
- **Descripción**: Administra la asignación de horarios a los profesores y evita solapamientos.
- **Tecnologías**: Servicios REST, algoritmos de planificación

#### Componente de Gestión de Salones
- **Descripción**: Administra la disponibilidad y asignación de salones.
- **Tecnologías**: Servicios REST, base de datos relacional

#### Sistema de Notificaciones
- **Descripción**: Envía notificaciones por correo electrónico y WhatsApp a los profesores con sus horarios.
- **Tecnologías**: Servicios de correo electrónico, APIs de WhatsApp

### Relaciones

- **Front-End** interactúa con **API** para realizar operaciones.
- **API** se comunica con **Controlador de Autenticación** para manejar la autenticación.
- **API** delega a los componentes **Gestión de Profesores**, **Gestión de Horarios** y **Gestión de Salones** las operaciones correspondientes.
- **Componente de Gestión de Profesores** interactúa con **Base de Datos** para almacenar y recuperar información sobre los profesores.
- **Componente de Gestión de Horarios** usa **Base de Datos** para gestionar los horarios.
- **Componente de Gestión de Salones** usa **Base de Datos** para gestionar los salones.
- **Sistema de Notificaciones** es utilizado por **API** para enviar notificaciones a los profesores.

### Diagrama

```plaintext
+------------------+       +-------------+       +---------------------------+
|   Front-End      | ----> |     API      | ----> |   Controlador de Autenticación |
+------------------+       +-------------+       +---------------------------+
                                    |
                                    v
                        +----------------------------+
                        | Componente de Gestión de Profesores |
                        +----------------------------+
                                    |
                                    v
                        +----------------------------+
                        | Componente de Gestión de Horarios |
                        +----------------------------+
                                    |
                                    v
                        +----------------------------+
                        | Componente de Gestión de Salones |
                        +----------------------------+
                                    |
                                    v
                        +----------------------------+
                        |   Sistema de Notificaciones   |
                        +----------------------------+

