-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: java
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vocabulary`
--

DROP TABLE IF EXISTS `vocabulary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vocabulary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(15) NOT NULL,
  `part_of_speech` varchar(5) NOT NULL,
  `interpretation` varchar(100) NOT NULL,
  `part_of_speech_nd` varchar(5) DEFAULT NULL,
  `interpretation_nd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vocabulary`
--

LOCK TABLES `vocabulary` WRITE;
/*!40000 ALTER TABLE `vocabulary` DISABLE KEYS */;
INSERT INTO `vocabulary` VALUES (1,'sincere','adj.','真诚的，真挚的',NULL,NULL),(2,'mood','n.','心情；情绪，（动词的）语气',NULL,NULL),(3,'static','adj.','静的，静态的；静止的，停滞的','n.','静电'),(4,'senator','n.','参议员',NULL,NULL),(5,'hobby','n.','业余爱好，癖好',NULL,NULL),(6,'lad','n.','男孩，小伙子',NULL,NULL),(7,'equip','vt.','装备，配备；（智力，体育上）使有准备',NULL,NULL),(8,'frown','vi.','皱眉，蹙额',NULL,NULL),(9,'fasten','vt.','扎劳，扣住',NULL,NULL),(10,'software','n.','软件',NULL,NULL),(11,'stir','v.','动，拨动；使微动；激动；（某种感情）产生','n.','搅拌，搅动；激动，骚乱'),(12,'distribution','n.','分发，分配；分布',NULL,NULL),(13,'flexible','adj.','易弯曲的；灵活的',NULL,NULL),(14,'solution','n.','解决；解决办法；溶液',NULL,NULL),(15,'panel','n.','专门小组；面板；控制版，仪表盘',NULL,NULL),(16,'ministry','n.','（政府的）部',NULL,NULL),(17,'describe','vt.','形容，描写；画出（图形等）',NULL,NULL),(18,'limb','n.','肢，臂，腿；树枝',NULL,NULL),(19,'circumstance','n.','情况，条件，境遇','pl.','境况，经济情况'),(20,'core','n.','果实的心；核心；要点',NULL,''),(21,'assistant','n.','助手，助理，助教','adj.','助理的，辅助的'),(22,'mess','n.','凌乱状态，脏乱状态；混乱的局面，困境','vt.','弄糟，弄脏，搞乱'),(23,'minus','n.','复数；减号','adj.','负的；减去'),(24,'statistic','n.','统计数值，统计资料','pl.','统计学');
/*!40000 ALTER TABLE `vocabulary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-31  0:02:24
