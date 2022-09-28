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
-- Table structure for table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advertisement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `submitted_date` date DEFAULT NULL,
  `time_existence` varchar(50) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `placement_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK545tn2fpu0apqmnr9x5wv7gi8` (`placement_id`),
  CONSTRAINT `FK545tn2fpu0apqmnr9x5wv7gi8` FOREIGN KEY (`placement_id`) REFERENCES `placement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES (1,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A07%3A39b%C3%B2.jpg?alt=media&token=5f7d3e28-b7f1-48d5-b3e5-4f2bd0fa73a7',_binary '\0','2022-09-19','2','Bò giống',1),(2,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A10%3A11c%C3%A1m%20g%C3%A0%201.jpg?alt=media&token=ee167685-4731-4f4d-bd54-5aff1781d324',_binary '\0','2022-09-20','2','Cám gà',2),(3,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A10%3A40c%C3%A1m%20heo%201.jpg?alt=media&token=cf3495ca-5b22-4b38-9dc7-85fee2afe310',_binary '\0','2022-09-21','1','Cám heo',3),(4,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A11%3A20heo%20gi%E1%BB%91ng.jpg?alt=media&token=0e35c282-0264-4639-b602-0e7de9642d30',_binary '\0','2022-09-22','3','Heo giống',4),(5,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A11%3A52heo-giong-th%C6%B0%C6%A1ng-ph%E1%BA%A9m.jpg?alt=media&token=8d5b1fae-c758-4a22-919f-0e5d7e40c85d',_binary '\0','2022-09-23','3','Heo thương phẩm',3),(6,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A12%3A21qu%E1%BA%A3ng%20c%C3%A1o%20c%C3%A1m%20v%E1%BB%8Bt.jpg?alt=media&token=9cb7fe26-e6c8-4bd0-b290-100e6efc574b',_binary '\0','2022-09-24','4','Cám vịt',2),(7,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A12%3A55qu%E1%BA%A3ng%20c%C3%A1o%20g%C3%A0.jpg?alt=media&token=0e5a2acf-1f49-47e5-abad-77d8cf4ca35e',_binary '\0','2022-09-26','2','Gà giống',2),(8,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A13%3A37qu%E1%BA%A3ng%20c%C3%A1o%20th%E1%BB%A9c%20%C4%83n%20m%C3%A0u%20m%C6%B0a.jpg?alt=media&token=f3d73661-90ba-4c4d-9001-27b474a5c818',_binary '\0','2022-09-27','1','Vi sinh ',2),(9,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A14%3A06qu%E1%BA%A3ng%20c%C3%A1o%20tr%C3%A2u%20gi%E1%BB%91ng.jpg?alt=media&token=d1ff0559-9022-4267-b75a-a9cf3890521e',_binary '\0','2022-09-28','2','Trâu giống',2),(10,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A14%3A39thu%E1%BB%91c%20b%C3%B2%201.jpg?alt=media&token=b98e7f00-6a2c-42ea-a97e-9e9ed2b67ee3',_binary '\0','2022-09-30','1','Thuốc cho bò',2),(11,'https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/advertisement%2F2022-09-18%2010%3A15%3A04thu%E1%BB%91c%20cho%20heo.jpg?alt=media&token=34236801-fa35-4154-ae27-b86884f58e17',_binary '\0','2022-09-29','2','Thuốc cho heo',3);
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
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
