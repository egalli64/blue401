use blue;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `blue` DEFAULT CHARACTER SET utf8 ;
USE `blue` ;

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
  `vehicle_id` INT NOT NULL,
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
  `password` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `vehicle_id`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `blue`.`vehicles` (`vehicle_id`)
);

CREATE TABLE IF NOT EXISTS `blue`.`superusers` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL UNIQUE,
  `email` VARCHAR(45) NULL UNIQUE,
  `zone_id` INT NOT NULL,
  `telefono` VARCHAR(45) NULL UNIQUE,
   PRIMARY KEY (`user_id`),
     CONSTRAINT `zone_id`
    FOREIGN KEY (`zone_id`)
    REFERENCES `blue`.`zone` (`zone_id`)
);



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
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `blue`.`users` (`user_id`),
  CONSTRAINT `parking_id`
    FOREIGN KEY (`parking_id`)
    REFERENCES `blue`.`parkings` (`parking_id`),
  CONSTRAINT `zone_id`
    FOREIGN KEY (`zone_id`)
    REFERENCES `blue`.`zone` (`zone_id`));

CREATE TABLE IF NOT EXISTS `blue`.`zone` (
  `zone_id` INT NOT NULL AUTO_INCREMENT,
  `zone_name` VARCHAR(45) NULL,
   PRIMARY KEY (`zone_id`));
