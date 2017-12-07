-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment9
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `idea`
--

DROP TABLE IF EXISTS `idea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idea` (
  `idea_id` int(11) NOT NULL AUTO_INCREMENT,
  `idea_name` varchar(45) NOT NULL,
  `idea_desc` varchar(1000) NOT NULL,
  `idea_start_date` date NOT NULL,
  `idea_end_date` date NOT NULL,
  `idea_fund_expectation` int(11) NOT NULL,
  `idea_fund_current` int(11) NOT NULL DEFAULT '0',
  `idea_creator_id` int(11) NOT NULL,
  `catagory_id` int(11) NOT NULL,
  `idea_completion` int(11) NOT NULL DEFAULT '0',
  `idea_status` varchar(45) NOT NULL DEFAULT 'HEALTH',
  `idea_photo_url` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `operation_reason` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idea_id`),
  KEY `idea_fk01_idx` (`idea_creator_id`),
  KEY `idea_fk02_idx` (`catagory_id`),
  CONSTRAINT `idea_fk01` FOREIGN KEY (`idea_creator_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idea_fk02` FOREIGN KEY (`catagory_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idea`
--

LOCK TABLES `idea` WRITE;
/*!40000 ALTER TABLE `idea` DISABLE KEYS */;
INSERT INTO `idea` VALUES (2,'New Idea','This is the first idea','2017-04-22','2018-04-22',1000000,0,9,1,0,'Available','http://baidu.com',NULL,NULL);
/*!40000 ALTER TABLE `idea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-07 13:35:47
