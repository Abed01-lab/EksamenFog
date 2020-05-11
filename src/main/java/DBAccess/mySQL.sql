-- MySQL Workbench Forward Engineering
-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- MySQL Workbench Forward Engineering
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fogprojekt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fogprojekt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fogprojekt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `fogprojekt`;

-- -----------------------------------------------------
-- Table `fogprojekt`.`bruger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`bruger`
(
    `brugerId` INT         NOT NULL AUTO_INCREMENT,
    `email`    VARCHAR(45) NOT NULL,
    `kodeord`  VARCHAR(45) NOT NULL,
    `rolle`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`brugerId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`carport`
(
    `carportId` INT         NOT NULL AUTO_INCREMENT,
    `højde`     INT         NOT NULL,
    `bredde`    INT         NOT NULL,
    `længde`    INT         NOT NULL,
    `materiale` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`carportId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 23
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`fladttagstyklister`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`fladttagstyklister`
(
    `idFladtTagStyklister` INT          NOT NULL AUTO_INCREMENT,
    `deminsion`            VARCHAR(45)  NULL DEFAULT NULL,
    `længde`               FLOAT        NULL DEFAULT NULL,
    `antal`                FLOAT        NULL DEFAULT NULL,
    `enhed`                VARCHAR(45)  NULL DEFAULT NULL,
    `beskrivelse`          VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`idFladtTagStyklister`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 59
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`skur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`skur`
(
    `skurId`     INT         NOT NULL AUTO_INCREMENT,
    `skurbredde` INT         NOT NULL,
    `skurlængde` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`skurId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`tag`
(
    `tagId`        INT         NOT NULL AUTO_INCREMENT,
    `tagtype`      VARCHAR(45) NOT NULL,
    `taghældning`  INT         NOT NULL,
    `tagmateriale` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`tagId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`ordre`
(
    `ordreId`   INT         NOT NULL AUTO_INCREMENT,
    `brugerId`  INT         NOT NULL,
    `carportId` INT         NOT NULL,
    `skurId`    INT         NULL DEFAULT NULL,
    `tagId`     INT         NOT NULL,
    `dato`      VARCHAR(45) NOT NULL,
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
            REFERENCES `fogprojekt`.`tag` (`tagId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 23
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`skråtagstyklister`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`skråtagstyklister`
(
    `idskråtagstyklister` INT          NOT NULL AUTO_INCREMENT,
    `deminsion`           VARCHAR(45)  NULL DEFAULT NULL,
    `længde`              FLOAT        NULL DEFAULT NULL,
    `antal`               FLOAT        NULL DEFAULT NULL,
    `enhed`               VARCHAR(45)  NULL DEFAULT NULL,
    `beskrivelse`         VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`idskråtagstyklister`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 69
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`styklisteitems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`styklisteitems`
(
    `itemId`      INT         NOT NULL AUTO_INCREMENT,
    `beskrivelse` VARCHAR(95) NULL DEFAULT NULL,
    `enhed`       VARCHAR(45) NULL DEFAULT NULL,
    `pris`        INT         NULL DEFAULT NULL,
    PRIMARY KEY (`itemId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 16
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogprojekt`.`stykliste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogprojekt`.`stykliste`
(
    `styklisteId` INT         NOT NULL AUTO_INCREMENT,
    `ordreId`     INT         NOT NULL,
    `serienummer` INT         NOT NULL,
    `antal`       INT         NULL DEFAULT NULL,
    `længde`      INT         NULL DEFAULT NULL,
    `beskrivelse` VARCHAR(90) NULL DEFAULT NULL,
    PRIMARY KEY (`styklisteId`),
    INDEX `ordreId` (`ordreId` ASC) VISIBLE,
    INDEX `stykliste_ibfk_2` (`serienummer` ASC) VISIBLE,
    CONSTRAINT `stykliste_ibfk_1`
        FOREIGN KEY (`ordreId`)
            REFERENCES `fogprojekt`.`ordre` (`ordreId`),
    CONSTRAINT `stykliste_ibfk_2`
        FOREIGN KEY (`serienummer`)
            REFERENCES `fogprojekt`.`styklisteitems` (`itemId`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 10
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
