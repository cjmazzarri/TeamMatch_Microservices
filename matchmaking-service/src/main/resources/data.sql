CREATE TABLE IF NOT EXISTS `players` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT,`username` VARCHAR(250) NOT NULL,`password` VARCHAR(250) NOT NULL,`hours` INT NOT NULL,`last_connection` VARCHAR(250) NOT NULL);

CREATE TABLE IF NOT EXISTS `filters` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT,`account_level` INT NOT NULL,`age` INT NOT NULL,`game` VARCHAR(250) NOT NULL,`game_style` VARCHAR(250) NOT NULL,`rating` FLOAT NOT NULL,`region` VARCHAR(250) NOT NULL);

CREATE TABLE IF NOT EXISTS `games` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT,`game_team_size` INT NOT NULL,`name` VARCHAR(250) NOT NULL);

CREATE TABLE IF NOT EXISTS `teams` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT,`team_name` VARCHAR(250) NOT NULL,`team_size` INT NOT NULL,`average` FLOAT NOT NULL, `hours_played` FLOAT NOT NULL);

INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`) VALUES (1,'8rb','password', 30,'2021-06-05 12:34');
INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`) VALUES (2,'sadaakisz','reymarselo', 40,'2021-06-04 11:12');
INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`) VALUES (3,'oserigez','maduro', 56,'2021-06-06 09:55');

INSERT INTO filters (`id`,`account_level`,`age`,`game`,`game_style`,`rating`,`region`) VALUES (1,10,20,'Chess','Casual',1084,'Peru');
INSERT INTO filters (`id`,`account_level`,`age`,`game`,`game_style`,`rating`,`region`) VALUES (2,55,24,'APEX Legends','Competitive',55,'Brasil');
INSERT INTO filters (`id`,`account_level`,`age`,`game`,`game_style`,`rating`,`region`) VALUES (3,34,19,'Valorant','Competitive',89,'Venezuela');

INSERT INTO games (`id`,`game_team_size`,`name`) VALUES (1,4,'Chess');
INSERT INTO games (`id`,`game_team_size`,`name`) VALUES (2,4,'APEX Legends');
INSERT INTO games (`id`,`game_team_size`,`name`) VALUES (3,10,'Valorant');

INSERT INTO teams (`id`,`team_name`,`team_size`,`average`, `hours_played`) VALUES (1,'Chess Pros',4, 950, 452);
INSERT INTO teams (`id`,`team_name`,`team_size`,`average`, `hours_played`) VALUES (2,'Apex Team',4, 55, 777);
INSERT INTO teams (`id`,`team_name`,`team_size`,`average`, `hours_played`) VALUES (3,'TeamMatch Valorant',10, 7.3, 214);
