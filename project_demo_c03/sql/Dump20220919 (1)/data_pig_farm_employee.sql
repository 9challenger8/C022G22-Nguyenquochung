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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `birth_day` date DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `id_card` varchar(15) DEFAULT NULL,
  `image` text,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(30) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa25uapm8xok6gcovm4sf6fyru` (`user_id`),
  CONSTRAINT `FKa25uapm8xok6gcovm4sf6fyru` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'1994-02-17','NV-123','Nam','205465852226','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A37%3A29IMG_2214.jpg?alt=media&token=d248f7ce-37a3-44e6-bc9b-52c83a822f02',_binary '\0','Lê Thuận Đạt',1),(2,'1996-08-09','NV-124','Nam','205666685888','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A35%3A12IMG_2223.jpg?alt=media&token=a8f044f5-104c-455d-a9de-762ada3a0689',_binary '\0','Trần Thuận',2),(3,'1998-10-10','NV-125','Nam','250252525251','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A32%3A28Quoc%20hung.jpg?alt=media&token=ae00891d-a4ed-4cc3-8e04-3a32584d1e21',_binary '\0','Nguyễn Quốc Hùng',3),(4,'1991-06-09','NV-126','Nữ','123456789111','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A30%3A14t%C6%B0%E1%BB%9Fng.jpg?alt=media&token=34a8795f-2e96-4b36-9b90-937b91dc97e8',_binary '\0','Trần Kim Tưởng',4),(5,'1995-10-07','NV-127','Nữ','205666666666','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A25%3A24huyen.jpg?alt=media&token=5dff8aad-dcd4-4d08-9708-46ddaf7d2556',_binary '\0','Trương Ngọc Huyền',5),(6,'1993-03-06','NV-128','Nam','205498888456','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A13%3A08IMG_2211.jpg?alt=media&token=c32c2feb-f713-4c76-8e24-4b0e17ea9fae',_binary '\0','Trần Văn Hoàn',6),(7,'1993-01-09','NV-129','Khác','273283728378','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A10%3A26IMG_2224.jpg?alt=media&token=cfd10b4f-127f-425a-ab91-d270bcdb86aa',_binary '\0','Lê Thị Đức',7),(8,'1998-06-09','NV-130','Nam','212121212122','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A38%3A34IMG_2228.jpg?alt=media&token=025d7e0c-c180-4d6b-b82d-9b4e02745702',_binary '\0','Lê Thanh Tâm',8),(9,'1994-09-06','NV-666','Nam','252525252525','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A05%3A21IMG_2216.jpg?alt=media&token=4a835e75-6356-4774-abac-dd2d4e29b8de',_binary '\0','Nguyễn Văn Chung',9),(10,'1998-06-26','NV-015','Nam','205456985252','https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/employee%2F2022-09-18%2002%3A39%3A51IMG_2227.jpg?alt=media&token=9641d9b5-7e19-4d33-ad2d-eb3560170e60',_binary '\0','Lê Hữu Phương Đông',10);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
