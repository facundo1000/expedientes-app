-- personas
INSERT INTO personas (nombre, apellido, dni, telefono, email,asistencia,eliminado,fecha_nac,tipo_doc) VALUES ('maximiliano','lopez','78987654','2954265696','some_mail@hotmail.com',true,false,'27-09-1992','DNI');

-- expedientes
INSERT INTO expedientes (texto_nota,fecha_ingreso_facultad,iniciante_id,estado_expediente) VALUES ('algo descriptivo','2023-06-25',1,'ABIERTO');

-- acciones_realizadas
INSERT INTO acciones_realizadas (accion_realizada,fecha_accion,eliminado) VALUES ('aprobacion del expediente N°01123', '2023-06-12',false);

INSERT INTO persona_tipodepersona (persona_id,tipo_persona) VALUES (1,'INVOLUCRADO');