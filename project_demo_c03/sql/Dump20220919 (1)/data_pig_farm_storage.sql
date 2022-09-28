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
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `food_type` varchar(30) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `unit` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,500,'2022-10-02','Porcy 00-09',_binary '\0','Kg'),(2,650,'2022-10-03','Porcy 09-20',_binary '\0','Kg'),(3,50,'2022-10-05','Porcy 20-50',_binary '\0','Tấn'),(4,700,'2022-10-07','Porcy 20-50S',_binary '\0','Kg'),(5,35,'2022-10-10','Porcy 50-99',_binary '\0','Tấn'),(6,10,'2022-11-11','Hỗn hợp Porcy 15',_binary '\0','Tấn'),(7,240,'2022-11-12','Hỗn hợp Porcy 16',_binary '\0','Kg'),(8,200,'2022-11-13','Bio-zeem Mama 00-01',_binary '\0','Kg'),(9,620,'2022-11-14','Porcy 18A',_binary '\0','Kg'),(10,550,'2022-11-15','Porcy 18B',_binary '\0','Kg'),(11,900,'2022-12-01','Porcy Mới S00+',_binary '\0','Kg'),(12,450,'2022-12-02','Porcy Mới S09+',_binary '\0','Kg'),(13,50,'2022-12-03','Porcy Mới S20+',_binary '\0','Tấn'),(14,780,'2022-12-10','Porcy Mới S20S+',_binary '\0','Kg'),(15,30,'2022-12-11','Porcy Mới S50+',_binary '\0','Tấn'),(16,15,'2022-12-12','Porcy Mới S02+',_binary '\0','Tấn'),(17,440,'2022-12-13','Porcy Mới S03+',_binary '\0','Kg'),(18,320,'2022-12-14','Big One 1',_binary '\0','Kg'),(19,50,'2022-12-15','Big One 2',_binary '\0','Tấn'),(20,350,'2022-12-16','Big One 3',_binary '\0','Kg'),(21,250,'2022-12-17','Big One 4',_binary '\0','Kg');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
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
