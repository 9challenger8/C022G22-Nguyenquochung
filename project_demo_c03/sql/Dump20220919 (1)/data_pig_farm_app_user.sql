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
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,'2019-12-12','sangnguyenjp97@gmail.com',_binary '\0','$2a$10$3Vke14hdeWGh25HEPhpD.uncnmsUmGKstrOueJ98iHLZFfOv0oLnW','admin'),(2,'2019-12-12','abc2@gmail.com',_binary '\0','123456','abc2'),(3,'2019-12-12','abc3@gmail.com',_binary '\0','123456','abc3'),(4,'2019-12-12','abc4@gmail.com',_binary '\0','123456','abc4'),(5,'2019-12-12','abc5@gmail.com',_binary '\0','123456','abc5'),(6,'2019-12-12','abc6@gmail.com',_binary '\0','123456','abc6'),(7,'2019-12-12','abc7@gmail.com',_binary '\0','123456','abc7'),(8,'2019-12-12','abc8@gmail.com',_binary '\0','123456','abc8'),(9,'2022-09-18','tranvai591989@gmail.com',_binary '\0','$2a$10$RGvXEGBo5i0deq.wnsrpbucq/vIYs0OlWvoKWyUeAzimqmhMQK6Om','admin12'),(10,'2022-09-18','dong@gmail.com',_binary '\0','$2a$10$01ddvjJB4P2gegonQtbK2e4d5jYu8oc.bcVpDgprEn9WlXfCgYpKi','phuongdong');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
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
