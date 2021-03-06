-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: emart
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `buyer_profile_tbl`
--

DROP TABLE IF EXISTS `buyer_profile_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyer_profile_tbl` (
  `buyer_id` varchar(15) NOT NULL,
  `buyer_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `postal_address` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer_profile_tbl`
--

LOCK TABLES `buyer_profile_tbl` WRITE;
/*!40000 ALTER TABLE `buyer_profile_tbl` DISABLE KEYS */;
INSERT INTO `buyer_profile_tbl` VALUES ('11111','buyer001','001','111@wew_dummy.com','100-000340','Dlian, Liaoning','2020-05-04 12:29:46','2020-05-04 12:29:46');
/*!40000 ALTER TABLE `buyer_profile_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_tbl`
--

DROP TABLE IF EXISTS `cart_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_tbl` (
  `buyer_id` varchar(15) NOT NULL,
  `product_id` varchar(15) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `seller_id` varchar(15) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_num` int NOT NULL,
  `purchase_amount` double NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  PRIMARY KEY (`buyer_id`,`product_id`,`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_tbl`
--

LOCK TABLES `cart_tbl` WRITE;
/*!40000 ALTER TABLE `cart_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_tbl`
--

DROP TABLE IF EXISTS `category_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_tbl` (
  `category_id` char(3) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  `brief_intro` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tbl`
--

LOCK TABLES `category_tbl` WRITE;
/*!40000 ALTER TABLE `category_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_history_tbl`
--

DROP TABLE IF EXISTS `order_history_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_history_tbl` (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `buyer_id` varchar(15) NOT NULL,
  `buyer_name` varchar(30) NOT NULL,
  `seller_id` varchar(15) NOT NULL,
  `transaction_id` char(8) NOT NULL,
  `product_id` varchar(15) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_num` int NOT NULL,
  `purchase_amount` double NOT NULL,
  `purchase_date` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`order_no`),
  UNIQUE KEY `order_no_UNIQUE` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_history_tbl`
--

LOCK TABLES `order_history_tbl` WRITE;
/*!40000 ALTER TABLE `order_history_tbl` DISABLE KEYS */;
INSERT INTO `order_history_tbl` VALUES (1,'b11','b11','s11','TRA-001','p001','p001',1,10,10,'2020-03-01 10:11:20',NULL,'2020-03-01 10:11:20','2020-03-01 10:11:20'),(2,'b11','b11','s11','TRA-001','p002','p002',2,20,40,'2020-03-02 10:11:20',NULL,'2020-03-02 10:11:20','2020-03-01 10:11:20'),(3,'b11','b11','s13','TRA-001','p003','p003',3,30,90,'2020-03-10 10:11:20',NULL,'2020-03-10 10:11:20','2020-03-01 10:11:20'),(4,'b11','b11','s14','TRA-002','p004','p004',4,40,160,'2020-03-11 00:00:00',NULL,'2020-03-11 00:00:00','2020-03-11 00:00:00');
/*!40000 ALTER TABLE `order_history_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tbl`
--

DROP TABLE IF EXISTS `product_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_tbl` (
  `product_id` varchar(15) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `category_id` char(3) DEFAULT NULL,
  `category_name` varchar(30) DEFAULT NULL,
  `subcategory_id` char(4) DEFAULT NULL,
  `subcategory_name` varchar(30) DEFAULT NULL,
  `seller_id` varchar(15) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `description` varchar(100) NOT NULL,
  `current_price` float NOT NULL DEFAULT '0',
  `current_stock` int NOT NULL DEFAULT '0',
  `remarks` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tbl`
--

LOCK TABLES `product_tbl` WRITE;
/*!40000 ALTER TABLE `product_tbl` DISABLE KEYS */;
INSERT INTO `product_tbl` VALUES ('11111','鍟嗗搧66','c11',NULL,'瀛愬垎绫?',NULL,NULL,'涓?,'鍟嗗搧鎻忚堪11',139.9,200,'For test','2020-05-06 10:54:57','2020-05-06 10:54:57'),('22222','鍟嗗搧33','c11',NULL,'瀛愬垎绫?',NULL,NULL,'鍖?,'鍟嗗搧鎻忚堪2',23,500,'For test','2020-05-06 10:54:57','2020-05-06 10:54:57'),('33333','鍟嗗搧11','鍒嗙被1',NULL,'瀛愬垎绫?',NULL,NULL,'鍖?,'鍟嗗搧鎻忚堪33',36,300,'For test','2020-05-07 11:54:57','2020-05-07 11:54:57'),('44444','鍟嗗搧22','鍒嗙被1',NULL,'瀛愬垎绫?',NULL,NULL,'鍖?,'鍟嗗搧鎻忚堪4',69,400,'For test','2020-05-07 12:54:57','2020-05-07 12:54:57');
/*!40000 ALTER TABLE `product_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_profile_tbl`
--

DROP TABLE IF EXISTS `seller_profile_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_profile_tbl` (
  `seller_id` varchar(15) NOT NULL,
  `seller_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `company_name` varchar(60) NOT NULL,
  `GSTIN` varchar(30) DEFAULT NULL,
  `company_brief` varchar(100) DEFAULT NULL,
  `postal_address` varchar(100) NOT NULL,
  `website` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(20) NOT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`seller_id`),
  UNIQUE KEY `seller_id_UNIQUE` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_profile_tbl`
--

LOCK TABLES `seller_profile_tbl` WRITE;
/*!40000 ALTER TABLE `seller_profile_tbl` DISABLE KEYS */;
INSERT INTO `seller_profile_tbl` VALUES ('11111','seller001','001','Dingdao Tech.','','','Dlian, Liaoning','www.dingdao.com','111@wew_dummy.com','100-005-0360','2020-05-04 13:02:11','2020-05-04 13:02:11');
/*!40000 ALTER TABLE `seller_profile_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory_tbl`
--

DROP TABLE IF EXISTS `subcategory_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategory_tbl` (
  `category_id` char(3) NOT NULL,
  `subcategory_id` char(4) NOT NULL,
  `subcategory_name` varchar(30) NOT NULL,
  `brief_intro` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`,`subcategory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory_tbl`
--

LOCK TABLES `subcategory_tbl` WRITE;
/*!40000 ALTER TABLE `subcategory_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `subcategory_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_tbl`
--

DROP TABLE IF EXISTS `transaction_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_tbl` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `transaction_type` varchar(20) DEFAULT 'Credit card',
  `buyer_id` varchar(15) NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_date` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_tbl`
--

LOCK TABLES `transaction_tbl` WRITE;
/*!40000 ALTER TABLE `transaction_tbl` DISABLE KEYS */;
INSERT INTO `transaction_tbl` VALUES (1,'Credit card','b11',340,'2020-05-16 20:55:04',NULL,NULL,NULL),(2,'Credit card','b11',50,'2020-05-16 20:55:04',NULL,NULL,NULL),(3,'Credit card','b12',199,'2020-05-16 20:55:04',NULL,NULL,NULL),(4,'Credit card','b11',340,'2020-05-16 20:55:20',NULL,NULL,NULL),(5,'Credit card','b11',50,'2020-05-16 20:55:20',NULL,NULL,NULL),(6,'Credit card','b12',199,'2020-05-16 20:55:20',NULL,NULL,NULL);
/*!40000 ALTER TABLE `transaction_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-17 14:47:11
