-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema airline
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airline
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airline` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
USE `airline` ;

-- -----------------------------------------------------
-- Table `airline`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airline`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `latitude` VARCHAR(45) NOT NULL,
  `longitude` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airline`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airline`.`flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flight_number` VARCHAR(45) NOT NULL,
  `airplane_type` VARCHAR(45) NOT NULL,
  `departure_city_id` INT NOT NULL,
  `departure_time` DATETIME NOT NULL,
  `arrival_city_id` INT NOT NULL,
  `arrival_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `flight_number_UNIQUE` (`flight_number` ASC),
  INDEX `FK_1_flight_city_idx` (`departure_city_id` ASC),
  INDEX `FK_2_flight_city_idx` (`arrival_city_id` ASC),
  CONSTRAINT `FK_1_flight_city`
    FOREIGN KEY (`departure_city_id`)
    REFERENCES `airline`.`city` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_2_flight_city`
    FOREIGN KEY (`arrival_city_id`)
    REFERENCES `airline`.`city` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airline`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airline`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
