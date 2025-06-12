CREATE DATABASE parque_atracciones;

USE parque_atracciones;

CREATE TABLE Atracciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50)
);

CREATE TABLE Visitante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    edad INT
);

CREATE TABLE Tipos_Entrada (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_entrada VARCHAR(50),
    precio DECIMAL(5, 2)
);
