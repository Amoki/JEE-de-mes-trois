-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (i686)
--
-- Host: db-tp.cpe.fr    Database: binome19
-- ------------------------------------------------------
-- Server version	5.5.46-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `binome19`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `binome19` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `binome19`;

--
-- Table structure for table `DB_PM`
--

DROP TABLE IF EXISTS `DB_PM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DB_PM` (
  `Login` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DB_PM`
--

LOCK TABLES `DB_PM` WRITE;
/*!40000 ALTER TABLE `DB_PM` DISABLE KEYS */;
/*!40000 ALTER TABLE `DB_PM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DB_Recipe`
--

DROP TABLE IF EXISTS `DB_Recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DB_Recipe` (
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `expertise` mediumint(9) DEFAULT NULL,
  `duration` mediumint(9) DEFAULT NULL,
  `nbpeople` mediumint(9) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DB_Recipe`
--

LOCK TABLES `DB_Recipe` WRITE;
/*!40000 ALTER TABLE `DB_Recipe` DISABLE KEYS */;
INSERT INTO `DB_Recipe` VALUES ('Fish Salad','bla bla bal bla',5,180,10,'salad'),('Fresh Meat','bla bla bal bla',1,20,1,'meat'),('Fish Salad','bla bla bal bla',5,180,10,'salad'),('Fresh Meat','bla bla bal bla',1,20,1,'meat'),('Fish Salad','bla bla bal bla',5,180,10,'salad'),('Fresh Meat','bla bla bal bla',1,20,1,'meat'),('Fish Salad','bla bla bal bla',5,180,10,'salad'),('Fresh Meat','bla bla bal bla',1,20,1,'meat'),('Fish Salad','bla bla bal bla',5,180,10,'salad'),('Fresh Meat','bla bla bal bla',1,20,1,'meat'),('kjhkhk','lkojm',45,32,65,'fiuhgjd'),('kjhkhk','lkojm',45,32,65,'fiuhgjd'),('kjhkhk','lkojm',45,32,65,'fiuhgjd'),('kjhkhk','lkojm',45,32,65,'fiuhgjd'),('olivier','lkojm',45,32,65,'fiuhgjd'),('loic','lkojm',45,32,65,'fiuhgjd'),('bebe','sais',2,2,2,'je '),('bebe','sais',2,2,2,'je '),('bnbnbn','ghjkl',14,14,14,'gigigi'),('xcxcxc','xcxc',4,6,5,'xcxcxc'),('gfgffg','gffgf',4,4,4,'fgfgf'),('gfgffg','gffgf',4,4,4,'fgfgf'),('gfgffg','gffgf',4,4,4,'fgfgf');
/*!40000 ALTER TABLE `DB_Recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DB_WEBDYN`
--

DROP TABLE IF EXISTS `DB_WEBDYN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DB_WEBDYN` (
  `surname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `login` varchar(20) CHARACTER SET latin1 NOT NULL,
  `pwd` varchar(8) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DB_WEBDYN`
--

LOCK TABLES `DB_WEBDYN` WRITE;
/*!40000 ALTER TABLE `DB_WEBDYN` DISABLE KEYS */;
INSERT INTO `DB_WEBDYN` VALUES ('lolo','gogo',25,'lili','3535'),('olol','thithi',24,'oyéoyé','pdpd'),('chien','chatte',2,'Olivier','lap'),('pipi','caca',1,'coco','ococ'),('Olivier','mange',1,'fruit','parjour'),('mange','Olivier',1,'fruit','parjour'),('mange','Olivier',1,'fruit','parjour'),('mange','Olivier',1,'bite','parjour'),('fdfddf','fdfdffdf',5,'dfdf','dfdffdfd'),('gtrg','rgtr',23,'gfdgdhg','fgfduj'),('John','Doe',55,'jdoe','pwd'),('John','Doe',55,'jdoe','pwd'),('John','Doe',55,'jdoe','pwd'),('John','Doe',55,'jdoe','pwd'),('John','Doe',55,'jdoe','pwd'),('John','Doe',55,'jdoe','pwd'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna'),('titi','jojo',23,'titidu73','hanouna');
/*!40000 ALTER TABLE `DB_WEBDYN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `recipeId` int(11) NOT NULL,
  `userLogin` varchar(100) NOT NULL,
  `date` char(50) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (0,'thebg','24 mai 2016 17:49:36','ssss',5),(80,'liarick','25 mai 2016 10:27:53','mouhahahahaha',4),(80,'jordan','25 mai 2016 11:18:41','toto',4);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `title` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `expertise` int(11) NOT NULL,
  `nbpeople` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `idRecipe` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idRecipe`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES ('Tartiflette','Du rebloch des patates et des lardons',5,6,30,'Reblochon',79),('Cochon de lait','Un bon dieu de cochon à la broche',5,56,480,'Meat',80),('Tarte au pommes','Des pommes de la compote et de la pate feuilleté',5,6,30,'Dessert',81);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `lastname` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('chase','jordan',23,'chase','chase','jordanchase@gmail.com',1),('verdez','gilles2',70,'gilles','fatou','a@g.d',0),('raton','julien',56,'liarick','liarick','jijilamorose@truc.machin',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-25 11:53:50
