CREATE SEQUENCE chosen_rosters_id;
CREATE SEQUENCE chosen_item_sets_id;

CREATE TABLE users (
	username 		varchar(50) ,
	password 		varchar(50) ,
	is_admin 		boolean DEFAULT false ,
	points			integer DEFAULT 0 NOT NULL ,
	CONSTRAINT pk_users_username PRIMARY KEY ( username )
);

CREATE TABLE teams (
	team_name		varchar(50) ,
	team_shortname		varchar(50) ,
	CONSTRAINT pk_teams_team_name PRIMARY KEY ( team_name )
);

CREATE TABLE players (
	nickname		varchar(50) ,
	team			varchar(50) ,
	position		varchar(50) ,
	CONSTRAINT pk_players_nickname PRIMARY KEY ( nickname ) ,
	CONSTRAINT fk_players_teams FOREIGN KEY ( team ) REFERENCES teams( team_name )
);

ALTER TABLE players ADD CONSTRAINT ck_players_position CHECK ( (position = 'top' OR position = 'jungle' OR position = 'middle' OR position = 'bottom' OR position = 'support') );

CREATE TABLE items (
	item_name		varchar(50) ,
	item_description	varchar(99) ,
	type			varchar(50) ,
	cost			integer NOT NULL ,
	CONSTRAINT pk_items_item_name PRIMARY KEY ( item_name )
);

ALTER TABLE items ADD CONSTRAINT ck_items_type CHECK ( (type = 'common' OR type = 'rare' OR type = 'epic' OR type = 'legendary') );

CREATE TABLE chosen_rosters (
	roster_id		integer DEFAULT nextval('chosen_rosters_id') NOT NULL ,
	username		varchar(50) ,
	top			varchar(50) ,
	jungle			varchar(50) ,
	middle			varchar(50) ,
	bottom			varchar(50) ,
	support			varchar(50) ,
	CONSTRAINT pk_chosen_rosters_roster_id PRIMARY KEY ( roster_id )
);

CREATE TABLE chosen_item_sets (
	item_set_id		integer DEFAULT nextval('chosen_item_sets_id') NOT NULL ,
	roster_id		integer NOT NULL ,
	top_item_1		varchar(50) ,
	top_item_2		varchar(50) ,
	top_item_3		varchar(50) ,
	jungle_item_1		varchar(50) ,
	jungle_item_2		varchar(50) ,
	jungle_item_3		varchar(50) ,
	middle_item_1		varchar(50) ,
	middle_item_2		varchar(50) ,
	middle_item_3		varchar(50) ,
	bottom_item_1		varchar(50) ,
	bottom_item_2		varchar(50) ,
	bottom_item_3		varchar(50) ,
	support_item_1		varchar(50) ,
	support_item_2		varchar(50) ,
	support_item_3		varchar(50) ,
	CONSTRAINT pk_chosen_item_sets_item_set_id PRIMARY KEY ( item_set_id ) ,
	CONSTRAINT fk_chosen_item_sets_chosen_rosters FOREIGN KEY ( roster_id ) REFERENCES chosen_rosters( roster_id ) ,
	CONSTRAINT fk_chosen_item_sets_items_top_1 FOREIGN KEY ( top_item_1 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_top_2 FOREIGN KEY ( top_item_2 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_top_3 FOREIGN KEY ( top_item_3 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_jungle_1 FOREIGN KEY ( jungle_item_1 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_jungle_2 FOREIGN KEY ( jungle_item_2 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_jungle_3 FOREIGN KEY ( jungle_item_3 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_middle_1 FOREIGN KEY ( middle_item_1 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_middle_2 FOREIGN KEY ( middle_item_2 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_middle_3 FOREIGN KEY ( middle_item_3 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_bottom_1 FOREIGN KEY ( bottom_item_1 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_bottom_2 FOREIGN KEY ( bottom_item_2 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_bottom_3 FOREIGN KEY ( bottom_item_3 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_support_1 FOREIGN KEY ( support_item_1 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_support_2 FOREIGN KEY ( support_item_2 ) REFERENCES items( item_name ) ,
	CONSTRAINT fk_chosen_item_sets_items_support_3 FOREIGN KEY ( support_item_3 ) REFERENCES items( item_name )
);

CREATE TABLE settings (
	max_roster_cost		integer NOT NULL ,
	max_same_team_players 	integer NOT NULL ,
	max_player_item_copies 	integer NOT NULL ,
	min_players_chosen     	integer DEFAULT 5 NOT NULL
);

--NECESSARY DATA INSERT--

INSERT INTO users (username, password, is_admin) VALUES ('ADMIN', 'password', TRUE);

INSERT INTO teams (team_name, team_shortname) VALUES ('G2 Esports', 'G2');
INSERT INTO teams (team_name, team_shortname) VALUES ('Astralis', 'AST');
INSERT INTO teams (team_name, team_shortname) VALUES ('Rogue', 'RGE');
INSERT INTO teams (team_name, team_shortname) VALUES ('Fnatic', 'FNC');

INSERT INTO players (nickname, team, position) VALUES ('Broken Blade', 'G2 Esports', 'top');
INSERT INTO players (nickname, team, position) VALUES ('Jankos', 'G2 Esports', 'jungle');
INSERT INTO players (nickname, team, position) VALUES ('caPs', 'G2 Esports', 'middle');
INSERT INTO players (nickname, team, position) VALUES ('Flakked', 'G2 Esports', 'bottom');
INSERT INTO players (nickname, team, position) VALUES ('Targamas', 'G2 Esports', 'support');
INSERT INTO players (nickname, team, position) VALUES ('Vizicsacsi', 'Astralis', 'top');
INSERT INTO players (nickname, team, position) VALUES ('Xerxe', 'Astralis', 'jungle');
INSERT INTO players (nickname, team, position) VALUES ('Dajor', 'Astralis', 'middle');
INSERT INTO players (nickname, team, position) VALUES ('Kobbe', 'Astralis', 'bottom');
INSERT INTO players (nickname, team, position) VALUES ('JeongHoon', 'Astralis', 'support');
INSERT INTO players (nickname, team, position) VALUES ('Odoamne', 'Rogue', 'top');
INSERT INTO players (nickname, team, position) VALUES ('Malrang', 'Rogue', 'jungle');
INSERT INTO players (nickname, team, position) VALUES ('Larssen', 'Rogue', 'middle');
INSERT INTO players (nickname, team, position) VALUES ('Comp', 'Rogue', 'bottom');
INSERT INTO players (nickname, team, position) VALUES ('Trymbi', 'Rogue', 'support');
INSERT INTO players (nickname, team, position) VALUES ('Wunder', 'Fnatic', 'top');
INSERT INTO players (nickname, team, position) VALUES ('Razork', 'Fnatic', 'jungle');
INSERT INTO players (nickname, team, position) VALUES ('Humanoid', 'Fnatic', 'middle');
INSERT INTO players (nickname, team, position) VALUES ('Upset', 'Fnatic', 'bottom');
INSERT INTO players (nickname, team, position) VALUES ('Hylissang', 'Fnatic', 'support');

INSERT INTO items (item_name, item_description, type, cost) VALUES ('Colossal Mace', '11 points if the player makes the highest damage to enemy towers of the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Crown Of The Dwarf King', '13 points if the player makes the highest gold number in the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Divine Impetu', '11 points if the player gets the best KDA of the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Dual Spear', '8 points if the player makes the highest number of doublekills of the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Earthly Staff', '15 points if the player destroys the first tower of the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Evasive Protection', '15 points if the player does not die during the game', 'common', 0);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Accurate Sword', '16 points if the player makes the biggest critical hit of the game', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Arcane Adrenaline', '16 points if the player deals the highest magic damage in the game', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Arcane Explosive', '12 points if the player deals 4500 damage to enemy towers or more', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Being Of Light', '18 points if the player makes the highest healing number of the game', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Dance Of Death', '8 points if the player performs 4 kills or more', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Death Helper', '10 points if the player makes 8 assists or more', 'rare', 1);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Beast Hunter', '18 points if the player kills the highest number of neutral minions of the game', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Berseker Ax', '14 points if the player deals more than 14500 damage to enemy champions', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Bloody Instinct', '15 points if the player assists in the first blood kill', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Conquering Staff', '24 points if the player destroys 15 wards or more', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Fast Furious Blade', '16 points if the player kills 9 or more minions per minute', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Heavenly Vision', '22 points if the player gets the highest vision score of the game', 'epic', 2);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Divine Ascent', '25 points if the player reaches level 18', 'legendary', 3);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Guardian Totem', '1 point for every 3 wards placed by the player', 'legendary', 3);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Incapacitor', '3 points for every 2 wards destroyed by the player', 'legendary', 3);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Legend Aura', '40 points if the player makes a killing spree of 7 or more', 'legendary', 3);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Scythe', '1 point for every 18 minions killed by the player', 'legendary', 3);
INSERT INTO items (item_name, item_description, type, cost) VALUES ('Sharp Blade', '3 points for each kill done by the player', 'legendary', 3);

INSERT INTO settings (max_roster_cost, max_same_team_players, max_player_item_copies) VALUES (15, 2, 1);
