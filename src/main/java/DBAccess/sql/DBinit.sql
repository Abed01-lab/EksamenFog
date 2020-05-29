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
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`skur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`skur` (
                                                   `skurId` INT NOT NULL AUTO_INCREMENT,
                                                   `bredde` INT NOT NULL,
                                                   `længde` INT NOT NULL,
                                                   PRIMARY KEY (`skurId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`tag` (
                                                  `tagId` INT NOT NULL AUTO_INCREMENT,
                                                  `type` VARCHAR(45) NOT NULL,
                                                  `hældning` INT NOT NULL,
                                                  `materiale` VARCHAR(45) NOT NULL,
                                                  PRIMARY KEY (`tagId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`forespørgsel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`forespørgsel` (
                                                           `forespørgselsId` INT NOT NULL AUTO_INCREMENT,
                                                           `fornavn` VARCHAR(45) NOT NULL,
                                                           `efternavn` VARCHAR(45) NOT NULL,
                                                           `adresse` VARCHAR(45) NOT NULL,
                                                           `email` VARCHAR(45) NOT NULL,
                                                           `telefonnummer` VARCHAR(45) NOT NULL,
                                                           `carportId` INT NOT NULL,
                                                           `tagId` INT NOT NULL,
                                                           `skurId` INT NULL DEFAULT NULL,
                                                           `status` INT NOT NULL DEFAULT '0',
                                                           PRIMARY KEY (`forespørgselsId`),
                                                           INDEX `forespørgsel_carport_FK_idx` (`carportId` ASC) VISIBLE,
                                                           INDEX `forespørgsel_tag_FK_idx` (`tagId` ASC) VISIBLE,
                                                           INDEX `forespørgsel_skur_FK_idx` (`skurId` ASC) VISIBLE,
                                                           CONSTRAINT `forespørgsel_carport_FK`
                                                               FOREIGN KEY (`carportId`)
                                                                   REFERENCES `fogprojekt`.`carport` (`carportId`),
                                                           CONSTRAINT `forespørgsel_skur_FK`
                                                               FOREIGN KEY (`skurId`)
                                                                   REFERENCES `fogprojekt`.`skur` (`skurId`),
                                                           CONSTRAINT `forespørgsel_tag_FK`
                                                               FOREIGN KEY (`tagId`)
                                                                   REFERENCES `fogprojekt`.`tag` (`tagId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`ordre` (
                                                    `ordreId` INT NOT NULL AUTO_INCREMENT,
                                                    `dato` VARCHAR(45) NOT NULL,
                                                    `forespørgselsId` INT NOT NULL,
                                                    PRIMARY KEY (`ordreId`),
                                                    INDEX `Forespørgsel_Ordre_FK_idx` (`forespørgselsId` ASC) VISIBLE,
                                                    CONSTRAINT `Forespørgsel_Ordre_FK`
                                                        FOREIGN KEY (`forespørgselsId`)
                                                            REFERENCES `fogprojekt`.`forespørgsel` (`forespørgselsId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`styklisteitems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`styklisteitems` (
                                                             `itemId` INT NOT NULL AUTO_INCREMENT,
                                                             `beskrivelse` VARCHAR(95) NOT NULL,
                                                             `enhed` VARCHAR(45) NOT NULL,
                                                             `pris` DOUBLE NOT NULL,
                                                             PRIMARY KEY (`itemId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`stykliste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`stykliste` (
                                                        `styklisteId` INT NOT NULL AUTO_INCREMENT,
                                                        `forespørgselsId` INT NOT NULL,
                                                        `serienummer` INT NOT NULL,
                                                        `antal` INT NOT NULL,
                                                        `længde` INT NOT NULL,
                                                        PRIMARY KEY (`styklisteId`),
                                                        INDEX `stykliste_ibfk_2` (`serienummer` ASC) VISIBLE,
                                                        INDEX `stykliste_Forespørgsel_FK_idx` (`forespørgselsId` ASC) VISIBLE,
                                                        CONSTRAINT `stykliste_Forespørgsel_FK`
                                                            FOREIGN KEY (`forespørgselsId`)
                                                                REFERENCES `fogprojekt`.`forespørgsel` (`forespørgselsId`),
                                                        CONSTRAINT `stykliste_ibfk_2`
                                                            FOREIGN KEY (`serienummer`)
                                                                REFERENCES `fogprojekt`.`styklisteitems` (`itemId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`styklistedefault`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`styklistedefault` (
                                                               `styklistedefaultId` INT NOT NULL AUTO_INCREMENT,
                                                               `item` VARCHAR(90) NULL DEFAULT NULL,
                                                               `styklisteitemId` INT NOT NULL,
                                                               PRIMARY KEY (`styklistedefaultId`),
                                                               INDEX `styklisteitemId` (`styklisteitemId` ASC) VISIBLE,
                                                               CONSTRAINT `styklistedefault_ibfk_1`
                                                                   FOREIGN KEY (`styklisteitemId`)
                                                                       REFERENCES `fogprojekt`.`styklisteitems` (`itemId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;