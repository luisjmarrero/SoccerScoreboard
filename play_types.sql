/*
This should set the play_types
 */

INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Gol', 'ha marcado gol!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Fuera de Lugar', 'se ha adelantado');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tiro Libre', '');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Pase', 'ha pasado el balon a');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Falta', ' a ');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tarjeta Roja', 'ha sido expulsado!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tarjeta Amarilla', 'ha recibido la amarilla!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tiro de esquina', 'patereara el corner');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Saque de mano', 'ha sacado de mano');
