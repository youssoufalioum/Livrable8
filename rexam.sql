/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 10.1.29-MariaDB : Database - rexam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rexam` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rexam`;

/*Table structure for table `abonnes` */

DROP TABLE IF EXISTS `abonnes`;

CREATE TABLE `abonnes` (
  `idAbonnes` int(8) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(25) NOT NULL,
  `telephone` int(9) NOT NULL,
  PRIMARY KEY (`idAbonnes`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `abonnes` */

insert  into `abonnes`(`idAbonnes`,`matricule`,`telephone`) values (1,'13D221EG',695415450),(2,'14C224EG',666876063),(3,'15E225EG',667988520),(4,'1236985EG',663254871),(5,'5236419',44885236),(6,'13D221EG',695415450);

/*Table structure for table `eleves` */

DROP TABLE IF EXISTS `eleves`;

CREATE TABLE `eleves` (
  `idEleves` int(8) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(25) NOT NULL,
  `nom_prenom` varchar(25) NOT NULL,
  `date_naissance` varchar(10) NOT NULL,
  `lieu_naissance` varchar(25) NOT NULL,
  `serie` varchar(25) NOT NULL,
  `decision_jury` varchar(5) NOT NULL,
  PRIMARY KEY (`idEleves`,`matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `eleves` */

insert  into `eleves`(`idEleves`,`matricule`,`nom_prenom`,`date_naissance`,`lieu_naissance`,`serie`,`decision_jury`) values (1,'13D221EG','Youssouf Alioum','19/05/1992','Maroua','BAC D','ADMIS'),(2,'','','','','',''),(3,'','','','','',''),(4,'12336955','alioum','19/04/1993','yaounde','Bac D','Admis'),(5,'5522','youoyo','15/96/1996','douala','Bac c','Admis');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
