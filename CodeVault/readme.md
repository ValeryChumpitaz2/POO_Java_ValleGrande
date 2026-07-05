# 📦 CodeVault

CodeVault es una aplicación de escritorio desarrollada en **Java Swing** utilizando el patrón **MVC (Modelo–Vista–Controlador)**. Permite gestionar proyectos de software organizados por categorías, con autenticación de usuarios y conexión a base de datos MySQL.

---

## 🚀 Tecnologías utilizadas

- Java 8+
- Java Swing
- MySQL 8.0
- JDBC
- Docker
- Arquitectura MVC

---

## 📁 Estructura del proyecto

```

CodeVault
│
├── controller
│   ├── CategoriaController.java
│   ├── DashboardController.java
│   ├── LoginController.java
│   └── ProyectoController.java
│
├── model
│   ├── Categoria.java
│   ├── CategoriaDAO.java
│   ├── Conexion.java
│   ├── Proyecto.java
│   ├── ProyectoDAO.java
│   ├── Usuario.java
│   └── UsuarioDAO.java
│
├── view
│   ├── CategoriaPanel.java
│   ├── DashboardView.java
│   ├── LoginView.java
│   ├── ProyectoPanel.java
│   └── Main.java

```
## 🧠 Arquitectura MVC

```

```
            ┌───────────────┐
            │     VIEW      │
            │  (Swing UI)   │
            │ LoginView     │
            │ DashboardView │
            │ Paneles       │
            └──────┬────────┘
                   │ eventos
                   ▼
            ┌───────────────┐
            │ CONTROLLER    │
            │ LoginCtrl     │
            │ ProyectoCtrl  │
            │ CategoriaCtrl │
            └──────┬────────┘
                   │ lógica
                   ▼
            ┌───────────────┐
            │    MODEL      │
            │ DAO + Entity  │
            │ Conexion DB   │
            └──────┬────────┘
                   │ JDBC
                   ▼
            ┌───────────────┐
            │   MySQL DB    │
            │  CodeVault    │
            └───────────────┘
```

````

---

## 🐳 Paso 1: Levantar MySQL con Docker

Ejecuta el siguiente comando:

```bash
docker run --name mysql-codevault \
  -e MYSQL_ROOT_PASSWORD=123456 \
  -e MYSQL_DATABASE=CodeVault \
  -p 3306:3306 \
  -d mysql:8.0
````

---

## 🗄️ Paso 2: Crear la base de datos

Ingresa al contenedor o usa un cliente MySQL (Workbench, DBeaver, etc.) y ejecuta:

```sql
CREATE DATABASE IF NOT EXISTS CodeVault;
USE CodeVault;

CREATE TABLE IF NOT EXISTS categoria (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS proyecto (
    idProyecto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    categoria INT NOT NULL,
    lenguaje VARCHAR(30) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    baseDatos BOOLEAN DEFAULT FALSE,
    loginSistema BOOLEAN DEFAULT FALSE,
    reportes BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_categoria
    FOREIGN KEY (categoria)
    REFERENCES categoria(idCategoria)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

INSERT INTO usuario(username, password)
VALUES ('admin', '1234');

INSERT INTO categoria(nombre) VALUES
('Sistema de Ventas'),
('Sistema Académico'),
('Inventario'),
('Biblioteca'),
('Clínica');

INSERT INTO proyecto
(nombre, descripcion, categoria, lenguaje, estado, baseDatos, loginSistema, reportes)
VALUES
('Sistema Ventas Básico', 'CRUD de ventas y productos', 1, 'Java', 'Completo', TRUE, TRUE, TRUE),
('Gestor Académico', 'Control de alumnos y notas', 2, 'Java', 'En desarrollo', TRUE, TRUE, FALSE),
('Inventario Simple', 'Control de stock de productos', 3, 'Java', 'Completo', TRUE, FALSE, TRUE);
```

---

## 🔌 Paso 3: Configurar conexión MySQL

Archivo: `Conexion.java`

```java
String url = "jdbc:mysql://localhost:3306/CodeVault";
String user = "root";
String password = "123456";
```

---

## ▶️ Paso 4: Ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA o NetBeans
2. Esperar que Maven cargue dependencias
3. Ejecutar `Main.java`
4. Iniciar sesión con:

```
Usuario: admin
Password: 1234
```

---

## 📌 Funcionalidades

* 🔐 Login de usuario
* 📊 Dashboard principal
* 📁 Gestión de proyectos (CRUD)
* 🗂️ Gestión de categorías
* 🧾 Conexión a MySQL con JDBC
* 🖥️ Interfaz gráfica con Java Swing

---

## 🧠 Patrón de diseño

El sistema está basado en **MVC (Modelo–Vista–Controlador)**:

* **Model:** entidades + DAO + conexión BD
* **View:** interfaces Swing
* **Controller:** lógica de aplicación y eventos

---

## 📄 Notas importantes

* La base de datos debe estar activa antes de ejecutar la aplicación
* El puerto 3306 debe estar libre
* Usuario por defecto: `admin / 1234`

---

## 📜 Licencia

Proyecto académico - uso educativo libre.
