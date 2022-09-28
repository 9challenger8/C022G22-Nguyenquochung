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
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `diseases` varchar(255) DEFAULT NULL,
  `doctor` varchar(50) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `medicine` varchar(50) DEFAULT NULL,
  `pig_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg40adgo0ce77hwyx5fim1gvs8` (`pig_id`),
  CONSTRAINT `FKg40adgo0ce77hwyx5fim1gvs8` FOREIGN KEY (`pig_id`) REFERENCES `pig` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (1,20,'2022-09-01','tiêu chảy','BS.Nguyễn Thanh Bình',_binary '\0','kháng sinh',2),(2,13,'2022-09-02','cầu trùng','BS.Nguyễn Thanh Bình',_binary '\0','muối sinh lý NACl',4),(3,5,'2022-09-04','tụ huyết','BS.Nguyễn Thanh Bình',_binary '\0','kháng sinh',7),(4,10,'2022-09-09','xoắn khuẩn','Trung tâm Thú y vùng',_binary '\0','kháng sinh',12),(5,10,'2022-09-10','cúm','BS.Nguyễn Thanh Bình',_binary '\0','NOVA-COLISPEC',9),(6,12,'2022-09-13','tiêu chảy','Trung tâm Thú y vùng',_binary '\0','kháng sinh',5),(7,13,'2022-09-15','cầu trùng','BS.Nguyễn Thị Tú',_binary '\0','muối sinh lý NACl',8),(8,5,'2022-09-16','tụ huyết','BS.Nguyễn Văn Minh',_binary '\0','kháng sinh',10),(9,10,'2022-09-18','xoắn khuẩn','Trung tâm Thú y vùng',_binary '\0','kháng sinh',11),(10,10,'2022-09-18','cúm','BS.Nguyễn Thanh Bình',_binary '\0','NOVA-COLISPEC',3);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
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
