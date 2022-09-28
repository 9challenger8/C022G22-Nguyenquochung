-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: data_pig_farm
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `unit` varchar(15) DEFAULT NULL,
  `pigsty_id` int DEFAULT NULL,
  `storage_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ow2280x7444no3gx28txsvr2` (`pigsty_id`),
  KEY `FK4fs1rp3sgbwa6v85ng701vni7` (`storage_id`),
  CONSTRAINT `FK4fs1rp3sgbwa6v85ng701vni7` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`id`),
  CONSTRAINT `FK4ow2280x7444no3gx28txsvr2` FOREIGN KEY (`pigsty_id`) REFERENCES `pigsty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,30000,_binary '\0','kg/năm',4,15),(2,2000,_binary '\0','kg/tháng',15,12),(3,31000,_binary '\0','kg/năm',13,14),(4,10,_binary '\0','kg/ngày',12,13),(5,15,_binary '\0','kg/ngày',11,11),(6,12,_binary '\0','kg/ngày',1,10),(7,9,_binary '\0','kg/ngày',3,9),(8,16,_binary '\0','kg/ngày',2,7),(9,17,_binary '\0','kg/ngày',4,8),(10,290,_binary '\0','kg/tháng',6,6),(11,300,_binary '\0','kg/tháng',5,4),(12,310,_binary '\0','kg/tháng',7,5),(13,301,_binary '\0','kg/tháng',8,3),(14,31000,_binary '\0','kg/năm',9,2),(15,32000,_binary '\0','kg/năm',10,1),(16,32000,_binary '\0','kg/năm',12,4);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19 17:21:19
