CREATE SCHEMA IF NOT EXISTS Biblioteca;

CREATE TABLE IF NOT EXISTS Biblioteca.Archivo (
    Id INT PRIMARY KEY,  -- Identificador único del archivo, clave primaria
    Extension_archivo VARCHAR,  -- Extensión del archivo (por ejemplo, pdf, docx)
    Tamano_archivo DOUBLE PRECISION,  -- Tamaño del archivo en formato double
    Link VARCHAR  -- Link al archivo
);


CREATE TABLE IF NOT EXISTS Biblioteca.Libro (
    Autores VARCHAR[] NOT NULL,  -- Array de VARCHAR para los autores, parte de la PK
    Titulo VARCHAR NOT NULL,  -- Título del libro, parte de la PK
    Editorial VARCHAR,  -- Editorial del libro
    Numero_edicion VARCHAR,  -- Número de edición en formato string
    Ano_publicacion INT,  -- Año de publicación en formato entero
    Formato_archivo VARCHAR,  -- Formato del archivo (escaneado o digital)
    Idioma VARCHAR,  -- Idioma del libro
    Resena TEXT,  -- Reseña o sinopsis o resumen (se mantiene TEXT por su longitud potencialmente larga)
    isFiccion BOOLEAN,  -- Indicador si es ficción o no ficción
    Clasificacion VARCHAR,  -- Clasificación del género o temática
    Datos_archivo INT UNIQUE,  -- Clave foránea referenciando a la tabla Archivo
    PRIMARY KEY (Autores, Titulo),  -- Llave primaria compuesta por Autores y Titulo
    FOREIGN KEY (Datos_archivo) REFERENCES Biblioteca.Archivo (id)  -- Clave foránea
);


CREATE INDEX idx_editorial ON Biblioteca.Libro (Editorial);

-- Índice para buscar por Año de Publicación
CREATE INDEX idx_ano_publicacion ON Biblioteca.Libro (Ano_publicacion);

-- Índice para buscar por Formato de Archivo
CREATE INDEX idx_formato_archivo ON Biblioteca.Libro (Formato_archivo);

-- Índice para buscar por Idioma
CREATE INDEX idx_idioma ON Biblioteca.Libro (Idioma);

-- Índice para buscar por Clasificación del género o temática
CREATE INDEX idx_clasificacion ON Biblioteca.Libro (Clasificacion);

-- Índice para la columna isFiccion (boolean)
CREATE INDEX idx_isficcion ON Biblioteca.Libro (isFiccion);



CREATE INDEX idx_extension_archivo ON Biblioteca.Archivo (Extension_archivo);

CREATE INDEX idx_link_archivo ON Biblioteca.Archivo (Link);

CREATE TABLE IF NOT EXISTS Biblioteca.Usuario (
    IDUsuario INT PRIMARY KEY,  -- Identificador único del usuario, clave primaria
    Nombre VARCHAR,  -- Nombre del usuario
    Apellidos VARCHAR,  -- Apellidos del usuario
    Username VARCHAR,  -- Nombre de usuario (único para el login)
    Password VARCHAR,  -- Contraseña del usuario
    Email VARCHAR,  -- Correo electrónico del usuario
    Rol VARCHAR  -- Rol del usuario (admin, lector, etc.)
);


-- Crear índices esenciales para mejorar las consultas

-- Índice único para garantizar que no haya duplicados en los nombres de usuario (Username)
CREATE UNIQUE INDEX idx_username ON Biblioteca.Usuario (Username);

-- Índice único para garantizar la unicidad de los correos electrónicos (Email)
CREATE UNIQUE INDEX idx_email ON Biblioteca.Usuario (Email);

GRANT INSERT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON ALL TABLES IN SCHEMA Biblioteca TO Bibliotecario;

  