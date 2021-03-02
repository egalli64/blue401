use blue; 
drop table if exists parking_history;
drop table if exists superusers;
drop table if exists zone;
drop table if exists parkings;
drop table if exists users;
drop table if exists vehicles;

-- SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
-- SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- CREATE SCHEMA IF NOT EXISTS `blue` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `blue`.`parkings`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `blue`.`parkings` (
  `parking_id` INT NOT NULL AUTO_INCREMENT,
  `parking_name` VARCHAR(45) NULL,
  `capacity_bike` INT NULL,
  `capacity_car` INT NULL,
  `capacity_camper` INT NULL,
  `zone_id` INT NOT NULL,
  `cost_bike` DECIMAL(6,2) NOT NULL,
  `cost_car` DECIMAL(6,2) NOT NULL,
  `cost_camper` DECIMAL(6,2) NOT NULL,
  `capacity_electric_vehicle` INT NULL,
  `cost_electric_vehicle` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`parking_id`));


-- -----------------------------------------------------
-- Table `blue`.`vehicles`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `blue`.`vehicles` (
  `vehicle_id` INT NOT NULL auto_increment,
  `vehicle_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`vehicle_id`));


-- -----------------------------------------------------
-- Table `blue`.`users`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `blue`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `credit` DECIMAL(6,2) NOT NULL,
  `vehicle_id` INT NULL,
  `license_plate` VARCHAR(45) NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `vehicle_id`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `blue`.`vehicles` (`vehicle_id`)
);

CREATE TABLE IF NOT EXISTS `blue`.`zone` (
  `zone_id` INT NOT NULL AUTO_INCREMENT,
  `zone_name` VARCHAR(45) NULL,
   PRIMARY KEY (`zone_id`));


-- -----------------------------------------------------
-- Table `blue`.`parking_history`	.
-- -----------------------------------------------------


   CREATE TABLE IF NOT EXISTS `blue`.`parking_history` (
  `parking_history_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `parking_id` INT NULL,
  `zone_id` INT NOT NULL,
  PRIMARY KEY (`parking_history_id`),
  CONSTRAINT `parkhist_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `blue`.`users` (`user_id`),
  CONSTRAINT `parkhist_parking_fk`
    FOREIGN KEY (`parking_id`)
    REFERENCES `blue`.`parkings` (`parking_id`),
  CONSTRAINT `parkhist_zone_fk`
    FOREIGN KEY (`zone_id`)
    REFERENCES `blue`.`zone` (`zone_id`));
   
   CREATE TABLE IF NOT EXISTS `blue`.`superusers` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL UNIQUE,
  `email` VARCHAR(45) NULL UNIQUE,
  `zone_id` INT NOT NULL,
  `telefono` VARCHAR(45) NULL UNIQUE,
   PRIMARY KEY (`user_id`),
	CONSTRAINT `superuser_zone_fk`
    FOREIGN KEY (`zone_id`)
    REFERENCES `blue`.`zone` (`zone_id`)
);
   
INSERT INTO `blue`.`vehicles` (`vehicle_id`, `vehicle_type`) VALUES ('1', 'Car');
INSERT INTO `blue`.`vehicles` (`vehicle_id`, `vehicle_type`) VALUES ('2', 'Bike');
INSERT INTO `blue`.`vehicles` (`vehicle_id`, `vehicle_type`) VALUES ('3', 'Camper');
INSERT INTO `blue`.`vehicles` (`vehicle_id`, `vehicle_type`) VALUES ('4', 'Electric_vehicle');

INSERT INTO `blue`.`users` (`first_name`, `last_name`, `password`,`date_of_birth`, `email`, `credit`, `vehicle_id`, `license_plate`) VALUES ('Silvio', 'Berlusconi', 'pwd', '1936-05-05', 'silvio.berlusca@figa.it', '1000', '1', 'FI365GA');
INSERT INTO `blue`.`users` (`first_name`, `last_name`, `password`,`date_of_birth`, `email`, `credit`, `vehicle_id`, `license_plate`) VALUES ('Roberto', 'Speranza','root', '1973-03-03', 'robby.spera@gov.it', '500', '2', 'GO324VER');
INSERT INTO `blue`.`users` (`first_name`, `last_name`, `password`,`date_of_birth`, `email`, `credit`, `vehicle_id`, `license_plate`) VALUES ('Emanuele', 'Galli', 'roop', '1970-04-02', 'ema.gally@java.it', '300', '3', 'EGA64');

INSERT INTO `blue`.`zone` (`zone_name`) VALUES ('San Paolo');
INSERT INTO `blue`.`zone` (`zone_name`) VALUES ('Crocetta');
INSERT INTO `blue`.`zone` (`zone_name`) VALUES ('Santa Rita');
INSERT INTO `blue`.`zone` (`zone_name`) VALUES ('Centro');

INSERT INTO parkings (`parking_name`, `capacity_bike`, `capacity_car`, `capacity_camper`, `zone_id`, `cost_bike`, `cost_car`, `cost_camper`, `capacity_electric_vehicle`, `cost_electric_vehicle`) VALUES ('Crocetta_Parking', '50', '100', '20', '2' ,'3.50', '5.50', '10.00', '100', '2.50');
INSERT INTO parkings (`parking_name`, `capacity_bike`, `capacity_car`, `capacity_camper`, `zone_id`, `cost_bike`, `cost_car`, `cost_camper`, `capacity_electric_vehicle`, `cost_electric_vehicle`) VALUES ('San_Paolo_Parking', '100', '50', '20','1', '4.00', '6.50', '12.50', '90', '2.00');

INSERT INTO `blue`.`superusers` (`first_name`, `last_name`, `password`, `email`, `zone_id`, `telefono`) VALUES ('Daniele', 'Quaglione', 'Dany', 'daniele.q@libero.it', '1', '34556454');

commit;
