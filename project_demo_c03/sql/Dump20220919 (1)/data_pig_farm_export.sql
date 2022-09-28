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
-- Table structure for table `export`
--

DROP TABLE IF EXISTS `export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `code_export` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `kilogram` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  `type_pigs` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `pigsty_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjgbjcd3ks706qvawp0noitddh` (`employee_id`),
  KEY `FKcx26w7wsu5cs6d6l97osopj6m` (`pigsty_id`),
  CONSTRAINT `FKcx26w7wsu5cs6d6l97osopj6m` FOREIGN KEY (`pigsty_id`) REFERENCES `pigsty` (`id`),
  CONSTRAINT `FKjgbjcd3ks706qvawp0noitddh` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export`
--

LOCK TABLES `export` WRITE;
/*!40000 ALTER TABLE `export` DISABLE KEYS */;
INSERT INTO `export` VALUES (1,18,'MC-01','CTy CP SGFood',_binary '\0',1021,140000,'2021-01-15',1,1,1),(2,20,'MC-02','Cty FujiFoods',_binary '\0',987,120000,'2021-02-25',0,2,1),(3,19,'MC-03','Cty Ace-Foods',_binary '\0',1002,130000,'2021-03-10',1,3,1),(4,15,'MC-04','CTy SGFood',_binary '\0',1120,110000,'2021-01-01',1,4,1),(5,20,'MC-05','TP Hoàng Đông',_binary '\0',1020,120000,'2021-02-09',1,4,1),(6,18,'MC-06','Cty Ace-Foods',_binary '\0',1202,100000,'2021-03-05',0,5,1),(7,19,'MC-07','CTy CP Food',_binary '\0',990,120000,'2021-01-11',0,6,1),(8,16,'MC-08','Meat Deli',_binary '\0',980,130000,'2021-02-20',1,7,1),(9,15,'MC-09','CTy SGFood',_binary '\0',920,140000,'2021-03-22',1,8,1),(10,20,'MC-10','Cty Ace-Foods',_binary '\0',980,110000,'2022-02-19',1,9,1),(11,20,'MC-11','CTy CP Food',_binary '\0',1021,120000,'2022-04-13',1,10,1),(12,18,'MC-12','CTy CP Food',_binary '\0',1022,130000,'2022-05-12',0,1,1),(13,18,'MC-13','TP Hoàng Đông',_binary '\0',1232,140000,'2022-02-11',1,5,1),(14,15,'MC-14','Cty FujiFoods',_binary '\0',1123,100000,'2022-05-16',1,6,1),(15,18,'MC-15','Meat Deli',_binary '\0',1322,110000,'2022-05-17',0,7,1),(16,16,'MC-16','Cty Ace-Foods',_binary '\0',1132,120000,'2022-02-22',1,8,1),(17,17,'MC-17','CTy CP Food',_binary '\0',1232,130000,'2022-06-20',0,9,1),(18,20,'MC-18','Cty FujiFoods',_binary '\0',1213,140000,'2021-05-15',0,10,1),(19,19,'MC-19','CTy SGFood',_binary '\0',1223,140000,'2019-12-25',0,2,1),(20,19,'MC-20','TP Hoàng Đông',_binary '\0',1112,120000,'2019-12-25',1,3,1);
/*!40000 ALTER TABLE `export` ENABLE KEYS */;
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
