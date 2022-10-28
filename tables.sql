-- -----------------------------------------------------
-- Tabla LABORATORIOS
-- -----------------------------------------------------
CREATE TABLE LABORATORIOS (
    id			NUMBER(5) NOT NULL,
    nombre		VARCHAR2(50) NOT NULL
);

-- -----------------------------------------------------
-- Table EQUIPOS
-- -----------------------------------------------------
CREATE TABLE EQUIPOS (
    id					NUMBER(5) NOT NULL,
    LABORATORIO_id		NUMBER(5) NOT NULL
);

-- -----------------------------------------------------
-- Table ELEMENTOS
-- -----------------------------------------------------
CREATE TABLE ELEMENTOS (
    id				NUMBER(5) NOT NULL,
    tipo			VARCHAR2(50) NOT NULL,
	funcional		BOOLEAN NOT NULL,
	EQUIPO_id		NUMBER(5) NOT NULL
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