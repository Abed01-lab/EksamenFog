-- MySQL Workbench Forward Engineering
-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

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
  `brugerId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `kodeord` VARCHAR(45) NOT NULL,
  `rolle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`brugerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`carport` (
  `carportId` INT NOT NULL AUTO_INCREMENT,
  `højde` INT NOT NULL,
  `bredde` INT NOT NULL,
  `længde` INT NOT NULL,
  `materiale` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`carportId`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`skur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`skur` (
  `skurId` INT NOT NULL AUTO_INCREMENT,
  `skurbredde` INT NOT NULL,
  `skurlængde` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`skurId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`tag` (
  `tagId` INT NOT NULL AUTO_INCREMENT,
  `tagtype` VARCHAR(45) NOT NULL,
  `taghældning` INT NOT NULL,
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
  `ordreId` INT NOT NULL AUTO_INCREMENT,
  `brugerId` INT NOT NULL,
  `carportId` INT NOT NULL,
  `skurId` INT NULL,
  `tagId` INT NOT NULL,
  `dato` VARCHAR(45) NOT NULL,
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
