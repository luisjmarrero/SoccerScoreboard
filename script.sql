-- Truncate all tables
TRUNCATE TABLE teams CASCADE;
TRUNCATE TABLE players CASCADE;
TRUNCATE TABLE games CASCADE;
TRUNCATE TABLE statistics CASCADE;
TRUNCATE TABLE plays CASCADE;
TRUNCATE TABLE play_types CASCADE ;
COMMIT ;

-- Insert Play Types
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Gol', 'ha marcado gol!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Fuera de Lugar', 'se ha adelantado');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tiro Libre', 'pateara el tiro libre');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tiro de esquina', 'pateara el corner');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Pase', 'ha pasado el balon');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Falta', 'ha dado una falta');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tarjeta Roja', 'ha sido expulsado!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Tarjeta Amarilla', 'ha recibido tarjeta amarilla amarilla!');
INSERT INTO play_types (play_type_id, type, message) VALUES (nextval('hibernate_sequence'), 'Saque de mano', 'ha sacado de mano');
COMMIT ;

-- Insert Teams
INSERT INTO public.teams (team_id, name) VALUES (nextval('hibernate_sequence'), 'Real Madrid');
INSERT INTO public.teams (team_id, name) VALUES (nextval('hibernate_sequence'), 'FC Barcelona');
COMMIT ;

SELECT * FROM teams;
/*
141	Real Madrid
142	FC Barcelona
 */
-- Insert FC Barcelona
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Messi', 'Lionel', 10, 'Delantero', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Suarez', 'Luis', 9, 'Delantero', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'da Silva', 'Neymar', 11, 'Delantero', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Stegen', 'Ter', 1, 'Portero', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Rakitic', 'Ivan', 4, 'Centrocampista', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Busquets', 'Sergio', 5, 'Centrocampista', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Gomes', 'Andres', 21, 'Centrocampista', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Piqué', 'Gerard', 3, 'Defensa', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Alba', 'Jordi', 18, 'Defensa', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Macherano', 'Javier', 14, 'Defensa', 142);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Roberto', 'Sergi', 20, 'Defensa', 142);
COMMIT ;

-- Insert Real Madrid
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Navas', 'Keylor', 1, 'Portero', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Carvajal', 'Daniel', 2, 'Defensa', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Ramos', 'Sergio', 4, 'Defensa', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Varane', 'Raphael', 5, 'Defensa', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Ronaldo', 'Cristiano', 7, 'Delantero', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Benzema', 'Karin', 9, 'Delantero', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Vieira', 'Marcelo', 12, 'Defensa', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Kovacic', 'Mateo', 16, 'Centrocampista', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Vazquez', 'Lucas', 17, 'Delantero', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Modric', 'Luka', 19, 'Centrocampista', 141);
INSERT INTO players (player_id, last_name, name, number, position, team_id) VALUES (nextval('hibernate_sequence'), 'Isco', 'Alarcón', 22, 'Centrocampista', 141);
COMMIT ;

-- Create Statistics
INSERT INTO statistics (statistic_id, corner_away, corner_local, fouls_away, fouls_local, offside_away, offside_local, posesion_away, posesion_local, red_away, red_local, yellow_away, yellow_local, game_id)
    VALUES (nextval('hibernate_sequence'),1 ,3,6,9,0,
                                          0,0,0,0,0,3,0,168);;
COMMIT ;

-- Create Game
SELECT * FROM statistics;

INSERT INTO games (game_id, stadio, team_a_id, team_b_id, score_a, score_b, statistic_id, date)
VALUES (nextval('hibernate_sequence'), 'Camp Nou',142,141,1,1,null,to_date('12 03 2016 02:15:00', 'DD MM YYYY HH:MI:SS'));

UPDATE games SET statistic_id = 219 WHERE game_id = 168;
-- UPDATE statistics SET game_id = 168 WHERE statistic_id = ;

-- Insert Plays
SELECT * FROM play_types;
SELECT * FROM games; -- 168
SELECT * FROM players;
SELECT * FROM plays;

INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 1,168,150,136,true);
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 4,168,155,135,true);
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 10,168,149,134,true);
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 12,168,166,138,FALSE);
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 16,168,165,136,FALSE);
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 26,168,145,136,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 28,168,147,138,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 30,168,155,136,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 34,168,157,136,FALSE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 39,168,149,134,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 42,168,150,136,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 47,168,146,136,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 51,168,159,136,FALSE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 52,168,146,131,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 54,168,162,134,FALSE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 68,168,149,134,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 74,168,146,138,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 79,168,146,138,FALSE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 83,168,150,138,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 89,168,154,138,TRUE );
INSERT INTO plays (play_id, commentary, minute, game_id, player_id, play_type_id, local) VALUES (nextval('hibernate_sequence'),'', 90,168,158,138,FALSE );
COMMIT ;

/*
Referencias

131	Gol	ha marcado gol!
132	Fuera de Lugar	se ha adelantado
133	Tiro Libre	pateara el tiro libre
134	Tiro de esquina	pateara el corner
135	Pase	ha pasado el balon
136	Falta	ha dado una falta
137	Tarjeta Roja	ha sido expulsado!
138	Tarjeta Amarilla	ha recibido tarjeta amarilla amarilla!
140	Saque de mano	ha sacado de mano

141	Real Madrid
142	FC Barcelona

id -statistics
219	1	3	6	9	0	0	0	0	0	0	3	0	168

145	Messi	Lionel	10	Delantero	142
146	Suarez	Luis	9	Delantero	142
147	da Silva	Neymar	11	Delantero	142
148	Stegen	Ter	1	Portero	142
149	Rakitic	Ivan	4	Centrocampista	142
150	Busquets	Sergio	5	Centrocampista	142
151	Gomes	Andres	21	Centrocampista	142
152	Piqué	Gerard	3	Defensa	142
153	Alba	Jordi	18	Defensa	142
154	Macherano	Javier	14	Defensa	142
155	Roberto	Sergi	20	Defensa	142
156	Navas	Keylor	1	Portero	141
157	Carvajal	Daniel	2	Defensa	141
158	Ramos	Sergio	4	Defensa	141
159	Varane	Raphael	5	Defensa	141
160	Ronaldo	Cristiano	7	Delantero	141
161	Benzema	Karin	9	Delantero	141
162	Vieira	Marcelo	12	Defensa	141
163	Kovacic	Mateo	16	Centrocampista	141
164	Vazquez	Lucas	17	Delantero	141
165	Modric	Luka	19	Centrocampista	141
166	Isco	Alarcón	22	Centrocampista	141

 */