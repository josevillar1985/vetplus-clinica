# 🐾 VetPlus  
## Sistema de gestión de citas para clínica veterinaria

Aplicación **full-stack** para la gestión de citas de una clínica veterinaria, con **doble flujo de uso**:

- **Clientes** → reserva de citas online  
- **Administración / recepción** → gestión completa de citas  

El proyecto está pensado como un **caso real**, priorizando la lógica de negocio, la usabilidad y la robustez por encima de funcionalidades innecesarias.

---

## 🚀 Funcionalidades principales

### 👤 Cliente (web pública)
- Selección de fecha mediante calendario
- Visualización de horas disponibles en tiempo real
- Bloqueo automático de horas ya ocupadas
- Reserva de cita con:
  - Nombre del cliente  
  - DNI  
  - Nombre de la mascota  
- Feedback visual claro (confirmación y errores)

---

### 🛠 Administración
- Vista de gestión de citas
- Listado completo con buscador
- Edición de citas existentes
- Eliminación de citas con confirmación
- Reserva manual de citas (por llamadas telefónicas) usando el mismo calendario que el cliente
- Prevención de solapamiento de citas (misma fecha y hora)

---

## 🧠 Reglas de negocio implementadas
- No pueden existir dos citas en la misma fecha y hora
- Validación de DNI en backend
- Backend centralizado para ambos flujos (cliente y admin)
- Manejo correcto de errores y mensajes claros al usuario
- Separación clara entre lógica de presentación y lógica de negocio

---

## 🛠️ Tecnologías utilizadas

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Arquitectura con Entity, DTO, Mapper, Repository y Service
- Base de datos relacional

### Frontend
- Vue.js (Vue 2)
- Vuetify
- Axios
- SweetAlert2

---

## 🧩 Arquitectura
- Frontend y backend desacoplados
- Uso de DTOs para evitar exponer entidades
- Mapper dedicado para conversión DTO ↔ Entity
- Servicios con validaciones de negocio
- Reutilización del mismo backend para cliente y administración

---

## 📌 Estado del proyecto
El sistema es **funcional y estable**, pensado como un **producto mínimo viable real** para una clínica veterinaria pequeña o mediana.

### Posibles mejoras futuras:
- Teléfono del cliente
- Notas internas de la cita
- Tipos de cita (vacuna, revisión, urgencia)
- Bloqueo de días festivos
- Autenticación para administración

Estas mejoras no se incluyeron para priorizar un sistema completo y bien cerrado.

---

## 🎯 Objetivo del proyecto
Este proyecto forma parte de mi **portfolio profesional** y busca demostrar:

- Capacidad para diseñar soluciones reales
- Implementación de reglas de negocio
- Buenas prácticas de backend y frontend
- Enfoque en usabilidad y experiencia de usuario
- Finalización completa de un producto funcional
