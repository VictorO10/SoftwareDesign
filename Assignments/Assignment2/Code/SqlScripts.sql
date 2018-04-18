CREATE TABLE `moodle`.`users` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(65) NOT NULL,
  `password` VARCHAR(55) NULL,
  `group` VARCHAR(45) NULL,
  `hobby` VARCHAR(45) NULL,
  `is_teacher` BIT NULL,
  `token` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`));

  
  