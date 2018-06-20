-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: natale
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Current Database: `natale`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `natale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `natale`;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `ACT_ID` int(20) NOT NULL AUTO_INCREMENT,
  `ACT_NOMBRE` varchar(16) DEFAULT NULL,
  `ACT_DESCRIPCION` varchar(200) DEFAULT NULL,
  `ACT_FECHA_DESDE` date DEFAULT NULL,
  `ACT_FECHA_HASTA` date DEFAULT NULL,
  `ACT_HORA_DESDE` time DEFAULT NULL,
  `ACT_HORA_HASTA` time DEFAULT NULL,
  `ACT_TIPO_ACT_ID` int(11) DEFAULT NULL,
  `ACT_SUBTIPO_ACT_ID` int(11) DEFAULT NULL,
  `ACT_BORRADA` int(11) DEFAULT NULL,
  `ACT_PRECIO` decimal(10,2) DEFAULT NULL,
  `ACT_PRO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ACT_ID`),
  KEY `ACT_TIPO_ACT_FK_idx` (`ACT_TIPO_ACT_ID`),
  KEY `ACT_SUBTIPO_ACT_FK_idx` (`ACT_SUBTIPO_ACT_ID`),
  KEY `ACT_PRO_FK_idx` (`ACT_PRO_ID`),
  CONSTRAINT `ACT_PROF_ID_FK` FOREIGN KEY (`ACT_PRO_ID`) REFERENCES `profesor` (`PRO_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ACT_SUBTIPO_ACT_FK` FOREIGN KEY (`ACT_SUBTIPO_ACT_ID`) REFERENCES `subtipo_actividad` (`STACT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ACT_TIPO_ACT_FK` FOREIGN KEY (`ACT_TIPO_ACT_ID`) REFERENCES `tipo_actividad` (`TACT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'CursoPrePartoNov','Grupo de preparto Noviembre','2016-11-09','2016-12-14','20:00:00','22:30:00',1,1,0,1960.00,1),(2,'BabyFitness','Gimnasia con bebé x dos','2017-01-01','2017-12-31','17:00:00','19:00:00',3,1,0,730.00,1),(3,'PrepartoEnero','Curso Preparto Enero','2017-01-18','2017-02-22','20:30:00','23:00:00',1,1,0,2250.00,1),(4,'CursoPrePartoNov','Grupo Preparto Noviembre ','2016-11-16','2016-12-07','20:00:00','22:30:00',1,1,1,1400.00,1),(5,'Gym','Gimnasia embarazadas','2017-01-01','2017-12-31','18:30:00','20:00:00',3,1,0,530.00,1),(6,'Gym','Gimnasia embarazadas x dos','2017-01-01','2017-12-31','18:30:00','20:00:00',3,1,0,840.00,1),(7,'Gym','Gimnasia embarazadas x tres','2017-01-01','2017-12-31','18:30:00','20:00:00',3,1,0,880.00,1),(8,'BabyFitness','Gimnasia con bebé','2017-01-01','2017-12-31','17:00:00','19:00:00',3,1,0,430.00,1),(9,'BabyFitness','Gimnasia con bebé x tres','2017-01-01','2017-12-31','17:00:00','19:00:00',3,1,0,770.00,1),(10,'Preparto','Curso Preparto Diciembre','2016-12-06','2017-01-24','20:00:00','22:30:00',1,1,0,1960.00,1),(11,'PrepartoEnero','Curso Preparto Enero','2017-01-18','2017-02-22','20:00:00','22:30:00',1,1,0,1960.00,1);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `CLI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLI_DNI` int(11) DEFAULT NULL,
  `CLI_NOMBRE` varchar(200) DEFAULT NULL,
  `CLI_TEL` varchar(50) DEFAULT NULL,
  `CLI_EMAIL` varchar(37) DEFAULT NULL,
  `CLI_BORRADO` int(11) DEFAULT NULL,
  `CLI_CERTIFICADO` blob,
  `CLI_FUM` date DEFAULT NULL,
  `CLI_FPP` date DEFAULT NULL,
  `CLI_OBRASOCIAL` int(11) DEFAULT NULL,
  `CLI_FECHA_REGISTRO` date DEFAULT NULL,
  `CLI_FECHA_MOD` date DEFAULT NULL,
  `CLI_FECHA_BAJA` date DEFAULT NULL,
  PRIMARY KEY (`CLI_ID`),
  KEY `CLI_OS_FK_idx` (`CLI_OBRASOCIAL`),
  CONSTRAINT `CLI_OS_FK` FOREIGN KEY (`CLI_OBRASOCIAL`) REFERENCES `obra_social` (`OS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,13175901,'Montserrat Dominguez','2147483647','montse_dm@live.com.mx',0,'0',NULL,'2016-09-14',NULL,NULL,NULL,NULL),(2,25864823,'Helga Gaysert','156818558','helgagaysert@hotmail.com',0,'1',NULL,'2017-03-13',NULL,NULL,NULL,NULL),(3,26964727,'Virginia Hirschfeld','156572132','virginiahirsh@gmail.com',0,'1',NULL,'2017-01-20',NULL,NULL,NULL,NULL),(4,27246420,'Maria Laura Cuestas','153453089','laurascuestas@hotmail.com',0,'0',NULL,'2017-07-21',NULL,NULL,NULL,NULL),(5,28269438,'Claudia Morales','153122918','caly80@hotmail.com',0,'1',NULL,'2017-08-04',NULL,NULL,NULL,NULL),(6,28272116,'Maria Eugenia Ingaramo','153041655','eugenia.ingaramo@gmail.com',0,'0',NULL,'2017-04-13',NULL,NULL,NULL,NULL),(7,28368186,'Laura Brizuela','2147483647','laurabrizuela03@gmail.com',0,'1',NULL,'2017-02-05',NULL,NULL,NULL,NULL),(8,28425945,'Eliana Lopez','156576815','elilopezmaldonado@hotmail.com',0,'0',NULL,'2017-04-11',NULL,NULL,NULL,NULL),(9,28429542,'Sabrina Escalante','2147483647','sabri.escalante@gmail.com',0,'1',NULL,'2017-01-14',NULL,NULL,NULL,NULL),(10,28731279,'debora Rey','156488133','deborarey31@hotmail.com',0,'0',NULL,'2017-03-26',NULL,NULL,NULL,NULL),(11,28759554,'Evangelina Soria','152281864','evassoria@gmail.com',0,'0',NULL,'2017-07-23',NULL,NULL,NULL,NULL),(12,28850110,'Ines Robertson','2147483647','inerobertson@hotmail.com',0,'0',NULL,'2017-04-14',NULL,NULL,NULL,NULL),(13,28853338,'Natalia Medrano','153337982','medrano_natalia@hotmail.com',0,'0',NULL,'2017-03-30',NULL,NULL,NULL,NULL),(14,29203076,'Cristina Ussher','2147483647','crisussher@hotmail.com',0,'1',NULL,'2017-02-05',NULL,NULL,NULL,NULL),(15,29252501,'Ana Sol Giorgis','152583399','ana.giorgis24@gmail.com',0,'1',NULL,'2017-05-25',NULL,NULL,NULL,NULL),(16,29253786,'Mariana Oliveros','2147483647','mariana_oliveros@hotmail.com',0,'1',NULL,'2016-12-17',NULL,NULL,NULL,NULL),(17,29254482,'Evangelina Ledesma','2147483647','eveledesma@hotmail.com',0,'1',NULL,'2017-07-10',NULL,NULL,NULL,NULL),(18,29606295,'Maria Eugenia Valentinuzzi','2147483647','evalentinuzziestudio@gmail.com',0,'0',NULL,'2017-05-07',NULL,NULL,NULL,NULL),(19,30656581,'Evangelino Sotelo','2147483647','eva_aguirresotelo@hotmail.com',0,'1',NULL,'2016-11-15',NULL,NULL,NULL,NULL),(20,30656787,'Gabriela Carrasco','2147483647','gabilucaf07@hotmail.com',1,'0','2016-03-14','2017-01-27',NULL,NULL,NULL,NULL),(21,30901060,'Vanina Eiben','157523380','vanieiben@hotmail.com',0,'1',NULL,'2016-12-04',NULL,NULL,NULL,NULL),(22,30971549,'Agustina Conquin','153495318','agus02@hotmail.com',0,'1',NULL,'2017-03-28',NULL,NULL,NULL,NULL),(23,30971857,'Noelia Peralta','152266874','noeliaperalta.nutricion@hotmail.com',0,'1','2016-07-09','2017-04-14',NULL,NULL,NULL,NULL),(24,31054656,'Carolina Peralta','2147483647','caroperaltaestudio@gmail.com',0,'1',NULL,'2017-01-20',NULL,NULL,NULL,NULL),(25,31087232,'Ma Victoria Orallo','2147483647','victoriaorallo@gmail.com',0,'1',NULL,'2017-02-16',NULL,NULL,NULL,NULL),(26,31218151,'Valeria Dippolito','153885804','valedippolito@live.com',0,'0',NULL,'2017-02-15',NULL,NULL,NULL,NULL),(27,31221633,'Maria Visconti','2147483647','maria.visconti@marcasymercados.com.ar',0,'1',NULL,'2017-06-10',NULL,NULL,NULL,NULL),(28,31245079,'Ayelen Tamara Nagel','153412119','ayelen.nagel@hotmail.com',0,'0',NULL,'2017-03-07',NULL,NULL,NULL,NULL),(29,31355739,'Natalia Ferrando','2147483647','ferrando.natalia@gmail.com',0,'0',NULL,'2017-03-11',NULL,NULL,NULL,NULL),(30,31647176,'Maria Belen Marenchino','152300446','belumarenchino@hotmail.com',0,'0',NULL,'2017-04-08',NULL,NULL,NULL,NULL),(31,31868423,'Oriana Grahovac','2147483647','origrao@hotmail.com',0,'1',NULL,'2017-02-07',NULL,NULL,NULL,NULL),(32,32189787,'Marlen Londero','2147483647','londeromarlen@gmail.com',0,'1',NULL,'2017-04-10',NULL,NULL,NULL,NULL),(33,32491897,'Pilar Martinez','2147483647','pilar.martinezmurphy@hotmail.com',0,'0','2016-05-17','2017-02-26',NULL,NULL,NULL,NULL),(34,32540544,'Julieta Castiñeira','153141203','julietacastineira@gmail.com',0,'0',NULL,'2017-07-11',NULL,NULL,NULL,NULL),(35,32848296,'Dolores Sarmiento','2147483647','loli_sar@hotmail.com',0,'1',NULL,'2017-03-01',NULL,NULL,NULL,NULL),(36,32907831,'Pilar Asselle','2147483647','pilarasselle@gmail.com',0,'1',NULL,'2017-03-15',NULL,NULL,NULL,NULL),(37,33201283,'Maria Pia Martinez Quintanaq','155140145','mpiamq@hotmail.com',0,'0',NULL,'2017-06-29',NULL,NULL,NULL,NULL),(38,33333310,'Candelaria deAllende','2147483647','candedeallende@hotmail.com',0,'0','2016-04-06','2017-01-11',NULL,NULL,NULL,NULL),(39,33333311,'Carolina Pogostking','2147483647','mcaropkg@hotmail.com',0,'0','2016-04-26','2017-01-31',NULL,NULL,NULL,NULL),(40,33333312,'Rocio Tavella','2147483647','rociotavella6@gmail.com',0,'0','2016-04-23','2017-01-28',NULL,NULL,NULL,NULL),(41,33333313,'Carolina Peralta','2147483647','caroperaltaestudio@gmail.com',1,'0','2016-04-15','2017-01-20',NULL,NULL,NULL,NULL),(42,33333314,'Ingrid Castineira','2147483647','ingrid_castineira@hotmail.com',0,'0','2016-04-04','2017-01-09',NULL,NULL,NULL,NULL),(43,33333315,'Paola Monti','2147483647','femaconsultorios@gmail.com',0,'0','2016-04-27','2017-02-10',NULL,NULL,NULL,NULL),(44,33333322,'Belen Urqueta','2147483647','belenurqueta@gmail.com',0,'0','2016-04-20','2017-01-25',NULL,NULL,NULL,NULL),(45,33333333,'Gabriela Carrasco','2147483647','gabilucaf07@hotmail.com',0,'0','2016-04-22','2017-01-27',NULL,NULL,NULL,NULL),(46,33333334,'MicaelaAilin Retamal','2147483647','micaelaretamal@hotmail.com',1,'0','2016-04-06','2017-01-11',NULL,NULL,NULL,NULL),(47,33333335,'OrianaCarolina Grahovac','2147483647','origrao@hotmail.com',1,'0','2016-04-30','2017-02-05',NULL,NULL,NULL,NULL),(48,33333336,'Daniela Mizzau','2147483647','dani_mizzau@hotmail.com',0,'0','2016-04-30','2017-02-05',NULL,NULL,NULL,NULL),(49,33333337,'Amira Koussa','2147483647','amira.koussa@hotmail.com',0,'0','2016-04-22','2017-01-27',NULL,NULL,NULL,NULL),(50,33333338,'Carolina Saldivar','2147483647','saldivar.carolina@gmail.com',0,'0','2016-04-07','2017-01-12',NULL,NULL,NULL,NULL),(51,33333339,'Silvina Pedraza','2147483647','silpedraza@gmail.com',1,'0','2016-03-27','2017-01-02',NULL,NULL,NULL,NULL),(52,33333344,'Pilar Martinez','2147483647','pilar.martinezmurphy@hotmail.com',1,'0','2016-05-17','2017-02-26',NULL,NULL,NULL,NULL),(53,33333355,'Silvana Marquez','2147483647','silvanamarquez2@hotmail.com',0,'0','2016-04-05','2017-01-10',NULL,NULL,NULL,NULL),(54,33333366,'Sabrina Escalante','2147483647','sabri.escalante@gmail.com',1,'0','2016-04-10','2017-01-14',NULL,NULL,NULL,NULL),(55,33750204,'Josefina  Contreras','155290712','joccontreras@hotmail.com',0,'0',NULL,'2017-04-01',NULL,NULL,NULL,NULL),(56,34131735,'Eliana Belen Bantin','156568740','elianabantin@hotmail.com',0,'0',NULL,'2017-04-12',NULL,NULL,NULL,NULL),(57,38645530,'Catalina Gil Montero','2147483647','catalinagmb@gmail.com',0,'0',NULL,'2017-07-07',NULL,NULL,NULL,NULL),(65,22051946,'Natalia Diaz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_actividad`
--

DROP TABLE IF EXISTS `cliente_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_actividad` (
  `idCliente` int(11) DEFAULT NULL,
  `idActividad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_actividad`
--

LOCK TABLES `cliente_actividad` WRITE;
/*!40000 ALTER TABLE `cliente_actividad` DISABLE KEYS */;
INSERT INTO `cliente_actividad` VALUES (27246420,2147483647),(28269438,2147483647),(28272116,2147483647),(28368186,2147483647),(28425945,2147483647),(28731279,2147483647),(28759554,2147483647),(28850110,2147483647),(28853338,2147483647),(29252501,2147483647),(29254482,2147483647),(29606295,2147483647),(30971857,2147483647),(31054656,2147483647),(31218151,2147483647),(31221633,2147483647),(31245079,2147483647),(31245079,2147483647),(31355739,2147483647),(31647176,2147483647),(31647176,2147483647),(32189787,2147483647),(32189787,2147483647),(32540544,2147483647),(32848296,2147483647),(33201283,2147483647),(33333310,2147483647),(33333311,2147483647),(33333312,2147483647),(33333313,2147483647),(33333314,2147483647),(33333315,2147483647),(33333322,2147483647),(33333322,2147483647),(33333333,2147483647),(33333334,2147483647),(33333335,2147483647),(33333336,2147483647),(33333337,2147483647),(33333338,2147483647),(33333339,2147483647),(33333355,2147483647),(33333366,2147483647),(33750204,2147483647),(34131735,2147483647),(38645530,2147483647);
/*!40000 ALTER TABLE `cliente_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_actividad`
--

DROP TABLE IF EXISTS `factura_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_actividad` (
  `idFacturaActividad` int(11) DEFAULT NULL,
  `fecha` int(11) DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `montoTotal` int(11) DEFAULT NULL,
  `IdCliente` int(11) DEFAULT NULL,
  `idFormaPago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_actividad`
--

LOCK TABLES `factura_actividad` WRITE;
/*!40000 ALTER TABLE `factura_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_detalle_actividad`
--

DROP TABLE IF EXISTS `factura_detalle_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_detalle_actividad` (
  `idFacturaActividad` int(11) DEFAULT NULL,
  `idActividad` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_detalle_actividad`
--

LOCK TABLES `factura_detalle_actividad` WRITE;
/*!40000 ALTER TABLE `factura_detalle_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_detalle_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_detalle_indumentaria`
--

DROP TABLE IF EXISTS `factura_detalle_indumentaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_detalle_indumentaria` (
  `idFacturaIndumentaria` int(11) DEFAULT NULL,
  `idndumentaria` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subTotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_detalle_indumentaria`
--

LOCK TABLES `factura_detalle_indumentaria` WRITE;
/*!40000 ALTER TABLE `factura_detalle_indumentaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_detalle_indumentaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_indumentaria`
--

DROP TABLE IF EXISTS `factura_indumentaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_indumentaria` (
  `idFacturaIndumentaria` int(11) DEFAULT NULL,
  `fecha` int(11) DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `montoTotal` int(11) DEFAULT NULL,
  `idFormaPago` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_indumentaria`
--

LOCK TABLES `factura_indumentaria` WRITE;
/*!40000 ALTER TABLE `factura_indumentaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_indumentaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago`
--

DROP TABLE IF EXISTS `forma_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pago` (
  `idFormaPago` int(11) DEFAULT NULL,
  `nombre` int(11) DEFAULT NULL,
  `nroCuotas` int(11) DEFAULT NULL,
  `idTarjeta` int(11) DEFAULT NULL,
  `borradoLogico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago`
--

LOCK TABLES `forma_pago` WRITE;
/*!40000 ALTER TABLE `forma_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indumentaria`
--

DROP TABLE IF EXISTS `indumentaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indumentaria` (
  `codigo` int(11) DEFAULT NULL,
  `nombreIndumentaria` varchar(8) DEFAULT NULL,
  `descripcion` varchar(26) DEFAULT NULL,
  `precio` decimal(4,1) DEFAULT NULL,
  `borradoLogicoIndumentaria` int(11) DEFAULT NULL,
  `enConsignacion` int(11) DEFAULT NULL,
  `precioCosto` decimal(4,1) DEFAULT NULL,
  `talle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indumentaria`
--

LOCK TABLES `indumentaria` WRITE;
/*!40000 ALTER TABLE `indumentaria` DISABLE KEYS */;
INSERT INTO `indumentaria` VALUES (1910,'Gorrito','Gorro con nudo',46.0,0,0,23.0,0),(5052,'Batita','Batita cruzada adelante',120.0,0,0,60.0,0),(5702,'Osito','Medio osito blanco',115.0,0,0,58.0,0),(6141,'Bombacha','Tiro corto Top control',105.0,0,0,53.0,0),(6142,'Bombacha','Universal Top control',110.0,0,0,56.0,0),(6531,'Corpiño','Corpiño maternal s/costura',430.0,0,0,215.0,0),(7704,'Gorrito','Gorrito bebé jean',115.0,0,0,58.0,0),(63031,'Camisola','camisola juvenil basic',430.0,0,0,219.0,0);
/*!40000 ALTER TABLE `indumentaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripcion` (
  `idInscripcion` int(11) DEFAULT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `hora` varchar(16) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idActividad` int(11) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `ultimaAsistencia` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (2147483647,'2017-01-04','19:03:00.0000000',32189787,2147483647,0,'2017-01-26'),(2147483647,'2017-02-01','18:07:00.0000000',28853338,2147483647,7,'2017-02-01'),(2147483647,'2017-02-07','19:01:00.0000000',29254482,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333313,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333335,2147483647,8,''),(2147483647,'2017-01-10','18:59:00.0000000',28272116,2147483647,3,'2017-02-07'),(2147483647,'2017-01-19','19:19:00.0000000',31245079,2147483647,4,'2017-02-01'),(2147483647,'2017-01-19','19:19:00.0000000',31218151,2147483647,7,'2017-01-19'),(2147483647,'2017-01-19','19:19:00.0000000',31355739,2147483647,6,'2017-02-01'),(2147483647,'2017-01-02','19:45:00.0000000',33333322,2147483647,7,'2017-01-02'),(2147483647,'2017-01-23','19:31:00.0000000',31245079,2147483647,8,'2017-02-08'),(2147483647,'2017-01-04','18:54:00.0000000',31054656,2147483647,8,''),(2147483647,'2017-01-04','19:18:00.0000000',28425945,2147483647,3,'2017-01-04'),(2147483647,'2017-01-09','19:32:00.0000000',34131735,2147483647,2,'2017-01-30'),(2147483647,'2017-01-09','19:32:00.0000000',33201283,2147483647,4,'2017-02-01'),(2147483647,'2017-02-01','17:54:00.0000000',28759554,2147483647,7,'2017-02-07'),(2147483647,'2017-02-02','10:44:00.0000000',28731279,2147483647,7,'2017-02-02'),(2147483647,'2017-02-07','19:14:00.0000000',28368186,2147483647,7,'2017-02-07'),(2147483647,'2017-02-08','19:12:00.0000000',28269438,2147483647,7,'2017-02-08'),(2147483647,'2017-02-08','19:12:00.0000000',38645530,2147483647,11,'2017-02-08'),(2147483647,'2016-11-21','19:19:00.0000000',33333366,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333310,2147483647,7,'2016-11-21'),(2147483647,'2016-11-21','19:07:00.0000000',33333311,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333312,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333314,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333315,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333333,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333334,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333336,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333337,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333338,2147483647,8,''),(2147483647,'2016-11-21','19:07:00.0000000',33333339,2147483647,8,''),(2147483647,'2017-01-11','19:19:00.0000000',28850110,2147483647,7,'2017-01-11'),(2147483647,'2017-01-17','19:45:00.0000000',32848296,2147483647,1,'2017-02-08'),(2147483647,'2017-01-19','19:19:00.0000000',32189787,2147483647,5,'2017-02-01'),(2147483647,'2017-01-19','19:19:00.0000000',31647176,2147483647,6,'2017-02-01'),(2147483647,'2017-01-19','19:19:00.0000000',33750204,2147483647,6,'2017-02-01'),(2147483647,'2017-01-23','19:27:00.0000000',27246420,2147483647,4,'2017-02-08'),(2147483647,'2017-01-23','19:28:00.0000000',31221633,2147483647,4,'2017-02-08'),(2147483647,'2017-01-23','19:40:00.0000000',31647176,2147483647,3,'2017-02-07'),(2147483647,'2017-01-26','18:48:00.0000000',29606295,2147483647,4,'2017-02-08'),(2147483647,'2017-01-26','18:50:00.0000000',32540544,2147483647,4,'2017-02-07'),(2147483647,'2016-11-21','19:19:00.0000000',33333322,2147483647,8,''),(2147483647,'2016-11-21','19:31:00.0000000',33333355,2147483647,8,''),(2147483647,'2016-11-29','19:13:00.0000000',30971857,2147483647,6,'2016-12-13'),(2147483647,'2016-11-30','18:11:00.0000000',29252501,2147483647,3,'2017-02-08');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra_social`
--

DROP TABLE IF EXISTS `obra_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra_social` (
  `OS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OS_NOMBRE` varchar(45) DEFAULT NULL,
  `OS_CENTRO_ATENCION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra_social`
--

LOCK TABLES `obra_social` WRITE;
/*!40000 ALTER TABLE `obra_social` DISABLE KEYS */;
/*!40000 ALTER TABLE `obra_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_DNI` int(11) DEFAULT NULL,
  `PRO_NOMBRE` varchar(35) DEFAULT NULL,
  `PRO_TEL` varchar(25) DEFAULT NULL,
  `PRO_EMAIL` varchar(35) DEFAULT NULL,
  `PRO_BORRADO` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,18304900,'Natalia Diaz','6714437','natalegym@gmail.com',NULL);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtipo_actividad`
--

DROP TABLE IF EXISTS `subtipo_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subtipo_actividad` (
  `STACT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STACT_NOMBRE` varchar(37) DEFAULT NULL,
  `STACT_BORRADA` int(11) DEFAULT NULL,
  `STACT_CREDITOS` int(11) DEFAULT NULL,
  PRIMARY KEY (`STACT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtipo_actividad`
--

LOCK TABLES `subtipo_actividad` WRITE;
/*!40000 ALTER TABLE `subtipo_actividad` DISABLE KEYS */;
INSERT INTO `subtipo_actividad` VALUES (1,'Primigestas',0,8),(2,'Secundigestas',0,8),(3,'Recién Nacidos',0,1),(4,'Primeros Auxilios y Reanimación',0,1),(5,'Masaje Infantil',0,1),(6,'Lactancia',0,1),(7,'Gimnasia para embarazadas (1xSem)',0,4),(8,'Baby Fitness (1xSem)',0,4),(9,'Pilates MAT (1xSem)',0,4),(10,'Gimnasia para embarazadas (2xSem)',0,8),(11,'Baby Fitness (2xSem)',0,8),(12,'Pilates MAT (2xSem)',0,8),(13,'Gimnasia para embarazadas (3xSem)',0,12),(14,'Baby Fitness (3xSem)',0,12),(15,'Pilates MAT (3xSem)',0,12),(16,'Gimnasia para embarazadas (PaseLibre)',0,20),(17,'Baby Fitness (PaseLibre)',0,20),(18,'Pilates MAT (PaseLibre)',0,20),(19,'Zumba',0,12);
/*!40000 ALTER TABLE `subtipo_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `idTarjeta` int(11) DEFAULT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `borradoLogico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (0,'NINGUNA',0),(2147483647,'MasterCard',0),(2147483647,'Visa Credito',0),(2147483647,'Tarjeta Naranja',0),(2147483647,'Visa Debito',0);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_actividad`
--

DROP TABLE IF EXISTS `tipo_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_actividad` (
  `TACT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TACT_NOMBRE` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`TACT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_actividad`
--

LOCK TABLES `tipo_actividad` WRITE;
/*!40000 ALTER TABLE `tipo_actividad` DISABLE KEYS */;
INSERT INTO `tipo_actividad` VALUES (1,'Curso'),(2,'Taller'),(3,'Actividad Física');
/*!40000 ALTER TABLE `tipo_actividad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 18:17:01
