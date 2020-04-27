-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- MySQL Workbench Forward Engineering


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fogprojekt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fogprojekt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fogprojekt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fogprojekt` ;

-- -----------------------------------------------------
-- Table `fogprojekt`.`bruger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`bruger` (
  `brugerId` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `kodeord` VARCHAR(45) NULL DEFAULT NULL,
  `rolle` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`brugerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`carport` (
  `carportId` INT(11) NOT NULL AUTO_INCREMENT,
  `højde` INT(11) NULL DEFAULT NULL,
  `bredde` INT(11) NULL DEFAULT NULL,
  `længde` INT(11) NULL DEFAULT NULL,
  `materiale` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`carportId`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`skur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`skur` (
  `skurId` INT(11) NOT NULL AUTO_INCREMENT,
  `skurbredde` INT(11) NULL DEFAULT NULL,
  `skurlængde` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`skurId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`tag` (
  `tagId` INT(11) NOT NULL AUTO_INCREMENT,
  `tagtype` VARCHAR(45) NULL DEFAULT NULL,
  `taghældning` INT(11) NOT NULL,
  `tagmateriale` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tagId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`ordre` (
  `ordreId` INT(11) NOT NULL AUTO_INCREMENT,
  `brugerId` INT(11) NOT NULL,
  `carportId` INT(11) NULL DEFAULT NULL,
  `skurId` INT(11) NULL DEFAULT NULL,
  `tagId` INT(11) NULL DEFAULT NULL,
  `dato` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ordreId`),
  INDEX `brugerId` (`brugerId` ASC) VISIBLE,
  INDEX `ordre_ibfk_2` (`carportId` ASC) VISIBLE,
  INDEX `ordre_ibfk_3` (`skurId` ASC) VISIBLE,
  INDEX `ordre_ibfk_4` (`tagId` ASC) VISIBLE,
  CONSTRAINT `ordre_ibfk_1`
    FOREIGN KEY (`brugerId`)
    REFERENCES `fogprojekt`.`bruger` (`brugerId`),
  CONSTRAINT `ordre_ibfk_2`
    FOREIGN KEY (`carportId`)
    REFERENCES `fogprojekt`.`carport` (`carportId`),
  CONSTRAINT `ordre_ibfk_3`
    FOREIGN KEY (`skurId`)
    REFERENCES `fogprojekt`.`skur` (`skurId`),
  CONSTRAINT `ordre_ibfk_4`
    FOREIGN KEY (`tagId`)
    REFERENCES `fogprojekt`.`tag` (`tagId`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
