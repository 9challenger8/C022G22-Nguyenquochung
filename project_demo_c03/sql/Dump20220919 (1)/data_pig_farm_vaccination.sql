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
-- Table structure for table `vaccination`
--

DROP TABLE IF EXISTS `vaccination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `note` varchar(255) DEFAULT NULL,
  `vaccinated_person` varchar(45) DEFAULT NULL,
  `vaccine_type` varchar(45) DEFAULT NULL,
  `pigsty_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjdeultvabdu1tbfj6ivcb4l3w` (`pigsty_id`),
  CONSTRAINT `FKjdeultvabdu1tbfj6ivcb4l3w` FOREIGN KEY (`pigsty_id`) REFERENCES `pigsty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination`
--

LOCK TABLES `vaccination` WRITE;
/*!40000 ALTER TABLE `vaccination` DISABLE KEYS */;
INSERT INTO `vaccination` VALUES (1,12,'09/09/2022',_binary '\0','','Huỳnh Khôi','CFS',1),(2,9,'08/09/2022',_binary '\0','ML004 không tiêm','Tuấn Dũng','Mycoplasma',3),(3,19,'09/12/2022',_binary '\0','','Liên Liên','CFS',1),(4,20,'08/25/2022',_binary '\0','','Huỳnh Khôi','APP',4),(5,15,'09/14/2022',_binary '\0','ML009 không tiêm','Hình Học','Mycoplasma',1),(6,12,'09/01/2022',_binary '\0','ML011 không tiêm','Lam Linh','APP',1),(7,18,'09/14/2022',_binary '\0','','Huỳnh Khôi','CFS',4),(8,16,'08/09/2022',_binary '\0','ML004 không tiêm','Huỳnh Khôi','FMD',3),(9,12,'09/14/2022',_binary '\0','','Gia Hùng','APP',1),(10,19,'08/26/2022',_binary '\0','ML015 không tiêm','Nam Ninh','FMD',2);
/*!40000 ALTER TABLE `vaccination` ENABLE KEYS */;
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
