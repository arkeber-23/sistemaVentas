-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemaventas
-- ------------------------------------------------------
-- Server version	5.6.49-log

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
-- Table structure for table `tab_categorias`
--

DROP TABLE IF EXISTS `tab_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_categorias` (
  `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_CAT` varchar(20) DEFAULT NULL,
  `DESCRIPCION_CAT` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_CATEGORIA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_categorias`
--

LOCK TABLES `tab_categorias` WRITE;
/*!40000 ALTER TABLE `tab_categorias` DISABLE KEYS */;
INSERT INTO `tab_categorias` VALUES (1,'ZAPATILLAS','SUAVE'),(2,'CAMISETAS','COMODAS PARA EL SOL');
/*!40000 ALTER TABLE `tab_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_facturas`
--

DROP TABLE IF EXISTS `tab_facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_facturas` (
  `ID_FACTURA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRDUCTO` int(11) DEFAULT NULL,
  `PRECIO_PRO` decimal(10,0) DEFAULT NULL,
  `CANTIDAD_PRO` decimal(10,0) DEFAULT NULL,
  `SUBTOTAL` decimal(10,0) DEFAULT NULL,
  `IVA` decimal(10,0) DEFAULT NULL,
  `TOTAL_PAGAR` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_FACTURA`),
  KEY `FK_REFERENCE_4` (`ID_PRDUCTO`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ID_PRDUCTO`) REFERENCES `tab_productos` (`ID_PRDUCTO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_facturas`
--

LOCK TABLES `tab_facturas` WRITE;
/*!40000 ALTER TABLE `tab_facturas` DISABLE KEYS */;
INSERT INTO `tab_facturas` VALUES (1,1,350,1,350,42,392);
/*!40000 ALTER TABLE `tab_facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_marcas`
--

DROP TABLE IF EXISTS `tab_marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_marcas` (
  `ID_MARCA` int(11) NOT NULL AUTO_INCREMENT,
  `MARCA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_marcas`
--

LOCK TABLES `tab_marcas` WRITE;
/*!40000 ALTER TABLE `tab_marcas` DISABLE KEYS */;
INSERT INTO `tab_marcas` VALUES (1,'NIKE'),(2,'ADIDAS'),(3,'PUMA'),(4,'REEBOK');
/*!40000 ALTER TABLE `tab_marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_productos`
--

DROP TABLE IF EXISTS `tab_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_productos` (
  `ID_PRDUCTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROVEEDOR` int(11) DEFAULT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  `ID_MARCA` int(11) DEFAULT NULL,
  `NOMBRE_PR` varchar(30) DEFAULT NULL,
  `TALLA_PR` varchar(2) DEFAULT NULL,
  `COLOR_PR` varchar(30) DEFAULT NULL,
  `PRECIO_PR` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_PRDUCTO`),
  KEY `FK_REFERENCE_1` (`ID_PROVEEDOR`),
  KEY `FK_REFERENCE_2` (`ID_CATEGORIA`),
  KEY `FK_REFERENCE_3` (`ID_MARCA`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `tab_proveedores` (`ID_PROVEEDOR`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `tab_categorias` (`ID_CATEGORIA`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`ID_MARCA`) REFERENCES `tab_marcas` (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_productos`
--

LOCK TABLES `tab_productos` WRITE;
/*!40000 ALTER TABLE `tab_productos` DISABLE KEYS */;
INSERT INTO `tab_productos` VALUES (1,1,1,1,'Vapor MAx','41','Rojo',350),(2,1,1,2,'Predator','40','Negro',450),(3,1,1,3,'Puma One','39','Verdes',120);
/*!40000 ALTER TABLE `tab_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_proveedores`
--

DROP TABLE IF EXISTS `tab_proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_proveedores` (
  `ID_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `APELLIDO` varchar(30) DEFAULT NULL,
  `DIRECCION` varchar(100) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_PROVEEDOR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_proveedores`
--

LOCK TABLES `tab_proveedores` WRITE;
/*!40000 ALTER TABLE `tab_proveedores` DISABLE KEYS */;
INSERT INTO `tab_proveedores` VALUES (1,'Stalin','Castillo','San Lorenzo','0987654321','staCastillo@gmail.com');
/*!40000 ALTER TABLE `tab_proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_usuarios`
--

DROP TABLE IF EXISTS `tab_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_usuarios` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `APELLIDO` varchar(30) DEFAULT NULL,
  `CORREO` varchar(40) DEFAULT NULL,
  `USER` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_usuarios`
--

LOCK TABLES `tab_usuarios` WRITE;
/*!40000 ALTER TABLE `tab_usuarios` DISABLE KEYS */;
INSERT INTO `tab_usuarios` VALUES (1,'Eber','Cabezas','cabezasev@gmail.com','root','root');
/*!40000 ALTER TABLE `tab_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-05  3:34:43
