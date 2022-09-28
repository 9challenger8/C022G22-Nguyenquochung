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
-- Table structure for table `pigsty`
--

DROP TABLE IF EXISTS `pigsty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pigsty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `build_date` date DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `max_number` int DEFAULT NULL,
  `type_pigs` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj0ts6wh92nkkwe6ki4kymbis0` (`employee_id`),
  CONSTRAINT `FKj0ts6wh92nkkwe6ki4kymbis0` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pigsty`
--

LOCK TABLES `pigsty` WRITE;
/*!40000 ALTER TABLE `pigsty` DISABLE KEYS */;
INSERT INTO `pigsty` VALUES (1,'2022-09-19','C001','2022-09-14',_binary '\0',15,1,1),(2,'1970-01-08','C002','2022-09-21',_binary '\0',16,1,2),(3,'1970-01-08','C003','2022-09-14',_binary '\0',18,1,3),(4,'1970-01-08','C004','2022-09-14',_binary '\0',20,1,4),(5,'1970-01-20','C005','2022-09-14',_binary '\0',20,1,5),(6,'1970-01-08','C006','2022-09-14',_binary '\0',16,1,6),(7,'1970-01-08','C007','2022-09-14',_binary '\0',19,1,7),(8,'1970-01-20','C008','2022-09-21',_binary '\0',20,2,2),(9,'1970-01-08','C009','2022-09-21',_binary '\0',15,2,1),(10,'1970-01-08','C010','2022-09-21',_binary '\0',18,2,8),(11,'1970-01-08','C011','2022-09-21',_binary '\0',19,2,1),(12,'1970-01-08','C012','2022-09-21',_binary '\0',20,2,1),(13,'1970-01-08','C013','2022-09-21',_binary '\0',16,1,3),(14,'1970-01-08','C014','2022-09-21',_binary '\0',15,1,4),(15,'1970-01-08','C015','2022-09-21',_binary '\0',15,1,7),(16,'1970-01-08','C016','2022-09-21',_binary '\0',20,1,2);
/*!40000 ALTER TABLE `pigsty` ENABLE KEYS */;
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
