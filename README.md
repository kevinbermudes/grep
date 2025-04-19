# 🧩 Mini Proyecto ZKoss + SQLite

Este es un mini proyecto desarrollado con **ZKoss** y **SQLite**, ideal como ejemplo básico de aplicación web Java con una interfaz basada en componentes y una base de datos liviana. El propósito es demostrar cómo integrar ZK con una base de datos SQLite de forma simple y funcional.

---

## 🛠️ Tecnologías Utilizadas

- **Java** 11+
- **ZKoss Framework**
- **SQLite** (base de datos embebida)
- **Maven**
- **Jetty** / **Tomcat** (para despliegue local)

---

## ⚙️ Funcionalidades

- Interfaz dinámica con componentes ZK (MVVM)
- Conexión a base de datos SQLite
- Operaciones CRUD básicas
- Validación de formularios
- Diseño limpio y responsive con ZK

---

## 🚀 Instalación y ejecución

### Clonar el repositorio
```bash
git clone https://github.com/tuusuario/zkoss-mini-proyecto.git
cd zkoss-mini-proyecto
```

### Ejecutar con Maven (Jetty)
```bash
mvn clean install
mvn jetty:run
```

### Acceder a la aplicación
Abre tu navegador y entra a:  
[http://localhost:8080](http://localhost:8080)

---

## 🧪 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com.kevin.zkoss/
│   │       ├── controller/
│   │       ├── model/
│   │       └── dao/
│   ├── resources/
│   └── webapp/
│       └── index.zul
```

---

## 📌 Notas

- La base de datos SQLite se crea automáticamente si no existe.
- Ideal para aprender integración rápida de Java con ZK y SQLite.
- Puede ser el punto de partida para proyectos más complejos.

---

## 🤝 Autor

**Kevin Bermúdez**  
_Técnico Superior en Desarrollo de Aplicaciones Web_  
💡 Explorando soluciones simples pero funcionales con tecnologías Java.

---

## 📄 Licencia

Este proyecto es de código abierto y puedes modificarlo libremente para fines educativos o personales.
