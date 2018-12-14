--liquibase formatted sql

--changeset andrey:1
DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (
  `USER_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` VARCHAR(20) NOT NULL,
  `EMAIL` VARCHAR(30) NOT NULL,
  `PASSWORD` VARCHAR(100) NOT NULL,
  UNIQUE (`LOGIN`),
  UNIQUE (`EMAIL`),
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--rollback drop table USERS;

--changeset andrey:2
DROP TABLE IF EXISTS `PATIENTS`;
CREATE TABLE `PATIENTS` (
  `PATIENT_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `PHONE` VARCHAR(50) NOT NULL,
  `STATEID` INT(11) NOT NULL,
  `CREATEDBY` INT(11),
  `UPDATEDBY` INT(11),
  `CREATEDDATE` TIMESTAMP,
  `UPDATEDDATE` TIMESTAMP NULL,
  UNIQUE (`PHONE`),
  CONSTRAINT FK_PAT_USER_CREATEDBY FOREIGN KEY (`CREATEDBY`) REFERENCES USERS (`USER_ID`),
  CONSTRAINT FK_PAT_USER_UPDATEDBY FOREIGN KEY (`UPDATEDBY`) REFERENCES USERS (`USER_ID`),
  PRIMARY KEY (`PATIENT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
--rollback drop table PATIENTS;

--changeset andrey:3
DROP TABLE IF EXISTS `STATES`;
CREATE TABLE `STATES` (
  `STATE_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CODE` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(50) NOT NULL,
  `CREATEDBY` INT(11),
  `UPDATEDBY` INT(11),
  `CREATEDDATE` TIMESTAMP,
  `UPDATEDDATE` TIMESTAMP NULL,
  UNIQUE (`CODE`),
  UNIQUE (`NAME`),
  CONSTRAINT FK_STATE_USER_CREATEDBY FOREIGN KEY (`CREATEDBY`) REFERENCES USERS (`USER_ID`),
  CONSTRAINT FK_STATE_USER_UPDATEDBY FOREIGN KEY (`UPDATEDBY`) REFERENCES USERS (`USER_ID`),
  PRIMARY KEY (`STATE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--rollback drop table STATES;

--changeset andrey:4
DROP TABLE IF EXISTS `PRODUCTS`;
CREATE TABLE `PRODUCTS` (
  `PRODUCT_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NOT NULL,
  `STATEID` INT(11) NOT NULL,
  `CREATEDBY` INT(11),
  `UPDATEDBY` INT(11),
  `CREATEDDATE` TIMESTAMP,
  `UPDATEDDATE` TIMESTAMP NULL,
  UNIQUE (`NAME`),
  CONSTRAINT FK_PRODUCT_STATE FOREIGN KEY (`STATEID`) REFERENCES STATES (`STATE_ID`),
  CONSTRAINT FK_PROD_USER_CREATEDBY FOREIGN KEY (`CREATEDBY`) REFERENCES USERS (`USER_ID`),
  CONSTRAINT FK_PROD_USER_UPDATEDBY FOREIGN KEY (`UPDATEDBY`) REFERENCES USERS (`USER_ID`),
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--rollback drop table PRODUCTS;

--changeset andrey:5
DROP TABLE IF EXISTS `TRANSACTIONS`;
CREATE TABLE `TRANSACTIONS` (
  `TRANSACTION_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `PATIENTID` INT(11) NOT NULL,
  `PRODUCTID` INT(11) NOT NULL,
  `DATE_TRANSACTION` DATE NOT NULL,
  `CREATEDBY` INT(11),
  `UPDATEDBY` INT(11),
  `CREATEDDATE` TIMESTAMP,
  `UPDATEDDATE` TIMESTAMP NULL,
  CONSTRAINT FK_TRANSACTION_PATIENT FOREIGN KEY (`PATIENTID`) REFERENCES PATIENTS (`PATIENT_ID`),
  CONSTRAINT FK_TRANSACTION_PRODUCT FOREIGN KEY (`PRODUCTID`) REFERENCES PRODUCTS (`PRODUCT_ID`),
  CONSTRAINT FK_TRANS_USER_CREATEDBY FOREIGN KEY (`CREATEDBY`) REFERENCES USERS (`USER_ID`),
  CONSTRAINT FK_TRANS_USER_UPDATEDBY FOREIGN KEY (`UPDATEDBY`) REFERENCES USERS (`USER_ID`),
  PRIMARY KEY (`TRANSACTION_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--rollback drop table TRANSACTIONS;

--changeset andrey:6
DROP TABLE IF EXISTS `AUDITOPERATIONS`;
CREATE TABLE `AUDITOPERATIONS` (
  `AUDIT_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE_AUDIT` DATE NOT NULL,
  `STATUS` BIT NOT NULL,
  `ACTION` VARCHAR(2000) NOT NULL,
  PRIMARY KEY (`AUDIT_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--rollback drop table AUDITOPERATIONS;

--changeset andrey:7
ALTER TABLE `PATIENTS` ADD CONSTRAINT FK_PATIENT_STATE FOREIGN KEY (`STATEID`) REFERENCES STATES (`STATE_ID`);