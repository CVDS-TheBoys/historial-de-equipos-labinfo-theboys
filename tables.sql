-- -----------------------------------------------------
-- Tabla LABORATORIOS
-- -----------------------------------------------------
CREATE TABLE LABORATORIOS (
    id					NUMBER(5) NOT NULL,
    nombre				VARCHAR2(50) NOT NULL,
	cantidad_equipos	NUMBER(5) NOT NULL,
	estado				BOOLEAN NOT NULL,
	fecha_creacion		DATE NOT NULL,
	fecha_cierre		DATE
);

-- -----------------------------------------------------
-- Table EQUIPOS
-- -----------------------------------------------------
CREATE TABLE EQUIPOS (
    id					NUMBER(5) NOT NULL,
	estado				BOOLEAN NOT NULL,
    LABORATORIO_id		NUMBER(5) NOT NULL,
	nombre				VARCHAR2(50) NOT NULL
);

-- -----------------------------------------------------
-- Table ELEMENTOS
-- -----------------------------------------------------
CREATE TABLE ELEMENTOS (
    id				NUMBER(5) NOT NULL,
	nombre			VARCHAR2(50) NOT NULL,
    tipo			VARCHAR2(10) NOT NULL,
	funcional		BOOLEAN NOT NULL,
	EQUIPO_id		NUMBER(5)
);

-- -----------------------------------------------------
-- Table NOVEDADES
-- -----------------------------------------------------
CREATE TABLE NOVEDADES (
    id				NUMBER(5) NOT NULL,
    titulo			VARCHAR2(20) NOT NULL,
	detalle			VARCHAR2(250) NOT NULL,
	fecha			DATE NOT NULL,
	EQUIPO_id		NUMBER(5),
	ELEMENTO_id		NUMBER(5) NOT NULL
);