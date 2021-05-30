CREATE TABLE ALUMNO (ID BIGINT NOT NULL, APELLIDO1 VARCHAR NOT NULL, APELLIDO2 VARCHAR, CP_NOTIFICACION VARCHAR, DNI VARCHAR NOT NULL UNIQUE, DIRECCION_NOTIFICACION VARCHAR, EMAIL_INSTITUCIONAL VARCHAR NOT NULL, EMAIL_PERSONAL VARCHAR, LOCALIDAD_NOTIFICACION VARCHAR, MOVIL VARCHAR, NOMBRE VARCHAR NOT NULL, PROVINCIA_NOTIFICACION VARCHAR, TELEFONO VARCHAR, PDF LONGVARBINARY, PRIMARY KEY (ID))
CREATE TABLE ASIGNATURA (REFERENCIA VARCHAR NOT NULL, OPTATIVA VARCHAR(31), CARACTER VARCHAR, CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, CURSO VARCHAR, DURACION INTEGER, IDIOMA_DE_IMPARTICION BOOLEAN NOT NULL, NOMBRE VARCHAR NOT NULL, OFERTADA BOOLEAN NOT NULL, UNIDAD_TEMPORAL INTEGER, TITULACION_CODIGO INTEGER, MENCION VARCHAR, PRIMARY KEY (REFERENCIA))
CREATE TABLE CENTRO (ID BIGINT NOT NULL, DIRECCION VARCHAR NOT NULL, NOMBRE VARCHAR NOT NULL UNIQUE, TLF_CONSERJERIA VARCHAR, PRIMARY KEY (ID))
CREATE TABLE ENCUESTA (FECHA_ENVIO DATE NOT NULL, DOCUMENTOS LONGVARBINARY, TURNO_PREFERENTE VARCHAR, CURSOACAMBIAR VARCHAR, RAZONES VARCHAR, EXPEDIENTE_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (FECHA_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE EXPEDIENTE (NUM_EXPEDIENTE BIGINT NOT NULL, ACTIVO BOOLEAN, NOTA_MEDIA_PROVISIONAL DOUBLE, ALUMNO_ID BIGINT NOT NULL, TITULACION_CODIGO INTEGER, PRIMARY KEY (NUM_EXPEDIENTE))
CREATE TABLE CLASE (HORAINICIO TIMESTAMP NOT NULL, DIA TIMESTAMP NOT NULL, HORAFIN TIME, ASIGNATURA_REFERENCIA VARCHAR, GRUPO_ID BIGINT NOT NULL, PRIMARY KEY (HORAINICIO, DIA, GRUPO_ID))
CREATE TABLE GRUPO (ID BIGINT NOT NULL, ASIGNAR VARCHAR, CURSO VARCHAR NOT NULL, INGLES VARCHAR, LETRA VARCHAR NOT NULL, PLAZAS BIGINT, PLAZASNUEVOINGRESO BIGINT, PLAZASREPETIDORES BIGINT, TURNO_MANYANA_TARDE VARCHAR NOT NULL, VISIBLE VARCHAR, IDIOMAINGLES BOOLEAN, GRUPO_ID BIGINT, TITULACION_CODIGO INTEGER, PRIMARY KEY (ID))
CREATE TABLE MATRICULA (CURSO_ACADEMICO VARCHAR NOT NULL, ESTADO CHAR NOT NULL, FECHA_MATRICULA DATE NOT NULL, LISTADO_ASIGNATURAS VARCHAR, NUEVO_INGRESO CHAR, NUM_ARCHIVO INTEGER, TURNO_PREFERENTE CHAR, EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE))
CREATE TABLE TITULACION (CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, NOMBRE VARCHAR NOT NULL, PRIMARY KEY (CODIGO))
CREATE TABLE GRUPOS_POR_ASIGNATURA (CURSO_ACADEMICO VARCHAR NOT NULL, OFERTA BOOLEAN, ASIGNATURA_REFERENCIA VARCHAR NOT NULL, GRUPO_ID BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID))
CREATE TABLE ASIGNATURAS_MATRICULAS (AM LONGVARBINARY NOT NULL, ASIGNATURA_REFERENCIA VARCHAR NOT NULL, GRUPO_ID BIGINT, CURSO_ACADEMICO VARCHAR, EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE BIGINT, PRIMARY KEY (AM, ASIGNATURA_REFERENCIA))
CREATE TABLE ALUMNO_GRUPO (Alumno_ID BIGINT NOT NULL, grupos_ID BIGINT NOT NULL, PRIMARY KEY (Alumno_ID, grupos_ID))
CREATE TABLE TITULACION_CENTRO (centros_ID BIGINT NOT NULL, titulaciones_CODIGO INTEGER NOT NULL, PRIMARY KEY (centros_ID, titulaciones_CODIGO))
CREATE TABLE ENCUESTA_GRUPOS_POR_ASIGNATURA (FECHA_ENVIO DATE NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE BIGINT NOT NULL, CURSO_ACADEMICO VARCHAR NOT NULL, ASIGNATURA_REFERENCIA VARCHAR NOT NULL, GRUPO_ID BIGINT NOT NULL, PRIMARY KEY (FECHA_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE, CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID))
CREATE TABLE GRUPO_ALUMNO (Grupo_ID BIGINT NOT NULL, alumno_ID BIGINT NOT NULL, PRIMARY KEY (Grupo_ID, alumno_ID))
ALTER TABLE ASIGNATURA ADD CONSTRAINT FK_ASIGNATURA_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULAEXPEDIENTESNUM_EXPEDIENTES_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPOS_POR_ASIGNATURA_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE ASIGNATURAS_MATRICULAS ADD CONSTRAINT FK_ASIGNATURAS_MATRICULAS_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTES_NUM_EXPEDIENTES_NUM_EXPEDIENTE)
ALTER TABLE ASIGNATURAS_MATRICULAS ADD CONSTRAINT FK_ASIGNATURAS_MATRICULAS_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE ASIGNATURAS_MATRICULAS ADD CONSTRAINT FK_ASIGNATURAS_MATRICULAS_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE ALUMNO_GRUPO ADD CONSTRAINT FK_ALUMNO_GRUPO_grupos_ID FOREIGN KEY (grupos_ID) REFERENCES GRUPO (ID)
ALTER TABLE ALUMNO_GRUPO ADD CONSTRAINT FK_ALUMNO_GRUPO_Alumno_ID FOREIGN KEY (Alumno_ID) REFERENCES ALUMNO (ID)
ALTER TABLE TITULACION_CENTRO ADD CONSTRAINT FK_TITULACION_CENTRO_titulaciones_CODIGO FOREIGN KEY (titulaciones_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE TITULACION_CENTRO ADD CONSTRAINT FK_TITULACION_CENTRO_centros_ID FOREIGN KEY (centros_ID) REFERENCES CENTRO (ID)
ALTER TABLE ENCUESTA_GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_ENCUESTA_GRUPOS_POR_ASIGNATURA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID) REFERENCES GRUPOS_POR_ASIGNATURA (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID)
ALTER TABLE ENCUESTA_GRUPOS_POR_ASIGNATURA ADD CONSTRAINT FK_ENCUESTA_GRUPOS_POR_ASIGNATURA_FECHA_ENVIO FOREIGN KEY (FECHA_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES ENCUESTA (FECHA_ENVIO, EXPEDIENTE_NUM_EXPEDIENTE)
ALTER TABLE GRUPO_ALUMNO ADD CONSTRAINT FK_GRUPO_ALUMNO_Grupo_ID FOREIGN KEY (Grupo_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO_ALUMNO ADD CONSTRAINT FK_GRUPO_ALUMNO_alumno_ID FOREIGN KEY (alumno_ID) REFERENCES ALUMNO (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
