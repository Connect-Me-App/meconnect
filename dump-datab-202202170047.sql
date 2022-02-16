-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: datab
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment_text` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `likes_count` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlcsdn3h1gj29dkju60rkjwbnp` (`post_id`),
  KEY `FKpjhbknta8xow2f8vvfvi4mgw6` (`user_name`),
  CONSTRAINT `FKlcsdn3h1gj29dkju60rkjwbnp` FOREIGN KEY (`post_id`) REFERENCES `user_post` (`id`),
  CONSTRAINT `FKpjhbknta8xow2f8vvfvi4mgw6` FOREIGN KEY (`user_name`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'this is my 1st comment','2022-02-16 22:59:51.982000','Aryan123',_binary '\0',0,'2022-02-16 22:59:51.982000',1,'Aryan123'),(2,'this is my 1st comment','2022-02-16 23:32:21.978000','Aryan123',_binary '',0,'2022-02-16 23:32:21.978000',1,'Aryan123'),(3,'this is my 2nd comment','2022-02-16 23:32:55.832000','Aryan123',_binary '\0',0,'2022-02-16 23:32:55.832000',1,'Aryan123'),(4,'this is my 3rd comment','2022-02-16 23:33:02.448000','Aryan123',_binary '\0',0,'2022-02-16 23:33:02.448000',1,'Aryan123'),(5,'this is my 4th comment','2022-02-17 00:30:58.098000','Aryan123',_binary '\0',0,'2022-02-17 00:30:58.098000',1,'Aryan123');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_post`
--

DROP TABLE IF EXISTS `user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `like_count` int DEFAULT NULL,
  `post_image_url` varchar(255) DEFAULT NULL,
  `post_text` varchar(255) DEFAULT NULL,
  `post_video_url` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKffmp2m6f2808du7ryjquxsywm` (`user_name`),
  CONSTRAINT `FKffmp2m6f2808du7ryjquxsywm` FOREIGN KEY (`user_name`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_post`
--

LOCK TABLES `user_post` WRITE;
/*!40000 ALTER TABLE `user_post` DISABLE KEYS */;
INSERT INTO `user_post` VALUES (1,'2022-02-16 20:23:13.126000','Aryan123',_binary '\0',0,'dummy url','This is my 1st post','www.google.com','2022-02-16 20:23:13.126000','Aryan123'),(2,'2022-02-16 20:23:41.395000','Aryan123',_binary '',0,'dummy url','This is my 2nd post','www.facebook.com','2022-02-16 20:23:41.395000','Aryan123'),(3,'2022-02-16 20:23:50.234000','Aryan123',_binary '\0',0,'dummy url','This is my 3rd post','www.youtube.com','2022-02-16 20:23:50.234000','Aryan123'),(4,'2022-02-17 00:40:04.589000','Aryan123',_binary '',0,'dummy url',NULL,'www.google.com','2022-02-17 00:40:04.589000','Aryan123'),(5,'2022-02-17 00:42:13.383000','Aryan123',_binary '\0',0,'dummy url','','www.google.com','2022-02-17 00:42:13.383000','Aryan123');
/*!40000 ALTER TABLE `user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_dt` datetime(6) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `registered_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_dt` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Delhi',NULL,'2022-02-16 20:18:08.352000','aryangupta@gmail.com','Aryan',_binary '','2022-02-16 20:18:08.352000','Gupta','','9873626201','Aryan123','2022-02-16 20:18:08.302000',NULL,'2022-02-16 20:18:08.352000','Aryan123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'datab'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-17  0:47:38
