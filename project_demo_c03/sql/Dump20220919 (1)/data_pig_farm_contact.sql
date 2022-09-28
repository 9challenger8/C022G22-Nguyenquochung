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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(45) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'Quảng Trị','Cần mua 1 con lợn','2022-10-08','nguyenvana@gamil.com',_binary '\0','Nguyễn Văn A','0988888888'),(2,'Huế','Lợn giống là gì vậy ạ?','2022-09-09','levanbay@gamil.com',_binary '\0','Lê Văn Bảy','0988888889'),(3,'Quảng Nam','Xuất 1 chuồng giá bao nhiêu vậy ạ','2022-11-10','tranthitong@gmail.com',_binary '\0','Trần Thị Tống','0988888890'),(4,'Gia Lai','Cần mua 2 con lợn','2022-12-11','phamthanhtri@gmail.com',_binary '\0','Phạm Thành Tri','0988888891'),(5,'Dak Lak','Giá mua heo như thế nào?','2022-12-21','thuan@gmail.com',_binary '\0','Trần Thuận','0999923323'),(6,'Quy Nhơn','Cần mua heo','2022-12-22','hieu@gmail.com',_binary '\0','Hoàng Hiếu','0923244354'),(7,'Quãng Nam','Lợn thịt giá thế nào','2022-12-23','tuyen@gmail.com',_binary '\0','Thanh Tuyền','0392372834'),(8,'Komtum','Cần mua heo giống','2022-12-23','tiendat@gmail.com',_binary '\0','Tiến Đạt','0972124545'),(9,'Bình Dương','Thông tin về đàn heo','2022-12-23','duyphuc@gmail.com',_binary '\0','Duy Phúc','0983435432'),(10,'Bình Phước','Giá heo thịt','2022-12-26','hoangsang@gmail.com',_binary '\0','Hoàng Sang','0938234554'),(11,'Lâm Đồng','Đàn heo thịt','2022-09-01','vanhai@gmail.com',_binary '\0','Văn Hải','0344545455'),(12,'Đà Lạt','Cần mua thịt heo','2022-09-06','phuongdong@gmail.com',_binary '\0','Phương Đông','0932454545'),(13,'Huế','Xuất chuồng heo giống không ạ','2022-09-09','kimtuong@gmail.com',_binary '\0','Kim Tưởng','0934354545'),(14,'Quảng Trị','Giá heo giống','2022-09-22','ngochuyen@gmail.com',_binary '\0','Ngọc Huyền','0932454555'),(15,'Nghệ An','Giá thịt heo mua số lượng lớn','2022-09-12','tunglam@gmail.com',_binary '\0','Tùng Lâm','0923242435');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
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
