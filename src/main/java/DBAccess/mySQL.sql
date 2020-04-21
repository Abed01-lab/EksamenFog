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
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`ordrer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`ordrer` (
  `ordrerId` INT(11) NOT NULL,
  `carportId` INT(11) NOT NULL,
  `brugerId` INT(11) NOT NULL,
  `dato` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ordrerId`),
  INDEX `carportId` (`carportId` ASC) VISIBLE,
  INDEX `brugerId` (`brugerId` ASC) VISIBLE,
  CONSTRAINT `ordrer_ibfk_1`
    FOREIGN KEY (`carportId`)
    REFERENCES `fogprojekt`.`carport` (`carportId`),
  CONSTRAINT `ordrer_ibfk_2`
    FOREIGN KEY (`brugerId`)
    REFERENCES `fogprojekt`.`bruger` (`brugerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
