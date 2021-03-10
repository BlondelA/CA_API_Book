-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bpt5ojvktgy4qlphelk2-mysql.services.clever-cloud.com:3306
-- Generation Time: Mar 10, 2021 at 01:56 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bpt5ojvktgy4qlphelk2`
--

-- --------------------------------------------------------

--
-- Table structure for table `autor`
--

CREATE TABLE `autor` (
  `ID` int NOT NULL,
  `UUID` varchar(256) NOT NULL,
  `FIRSTNAME` varchar(256) NOT NULL,
  `NAME` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autor`
--

INSERT INTO `autor` (`ID`, `UUID`, `FIRSTNAME`, `NAME`) VALUES
(1, '04627558-89ff-4460-9434-b7800cec7ff0', 'Tolkien', 'J.R.R'),
(2, '8e674408-0df4-4815-8b4e-9dae96b58966', 'Christopher', 'Paolini');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` int NOT NULL,
  `UUID` varchar(256) NOT NULL,
  `TITLE` varchar(256) NOT NULL,
  `PRICE` bigint NOT NULL,
  `AUTOR_UUID` varchar(256) NOT NULL,
  `STOCK` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `UUID`, `TITLE`, `PRICE`, `AUTOR_UUID`, `STOCK`) VALUES
(1, '74278090-bf56-4fb1-8b71-98039683c382', 'Le Seigneur des anneaux : La Communauté de l\'anneau', 10, '04627558-89ff-4460-9434-b7800cec7ff0', 45),
(2, '8121dbfb-41ad-47c5-adc2-56febb442ada', 'Le Seigneur des anneaux : Les Deux Tours', 10, '04627558-89ff-4460-9434-b7800cec7ff0', 0),
(3, 'c4e1714a-cd58-462d-8b57-7957e2433e93', 'Le Seigneur des anneaux : Le Retour du roi', 10, '04627558-89ff-4460-9434-b7800cec7ff0', 12),
(4, '24568466-d218-4377-a252-b27df1d11950', 'Eragon', 6, '8e674408-0df4-4815-8b4e-9dae96b58966', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UUID` (`UUID`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UUID` (`UUID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autor`
--
ALTER TABLE `autor`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
