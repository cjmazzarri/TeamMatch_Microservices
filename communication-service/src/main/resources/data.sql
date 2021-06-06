CREATE TABLE IF NOT EXISTS `players` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT,`username` VARCHAR(250) NOT NULL,`password` VARCHAR(250) NOT NULL,`hours` INT NOT NULL,`last_connection` VARCHAR(250) NOT NULL, `filter_id` INT NOT NULL);

INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`,`filter_id`) VALUES (1,'Calixto21','password', 21,'2021-06-05 23:04', 1);
INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`,`filter_id`) VALUES (2,'EmpePayasito','password', 48,'2021-06-05 15:34', 2);
INSERT INTO players (`id`,`username`,`password`,`hours`,`last_connection`,`filter_id`) VALUES (3,'8rb','password', 80,'2021-06-05 04:34', 3);

CREATE TABLE IF NOT EXISTS `chats` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT);

INSERT INTO chats (`id`) VALUES (1);
INSERT INTO chats (`id`) VALUES (2);
INSERT INTO chats (`id`) VALUES (3);

CREATE  TABLE IF NOT EXISTS `messages` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT, `message` VARCHAR(250) NOT NULL, `sent_date` VARCHAR(250) NOT NULL, `is_hyper_link` BIT,  `chat_id` INT NOT NULL);


