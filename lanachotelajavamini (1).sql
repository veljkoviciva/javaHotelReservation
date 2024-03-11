-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2023 at 01:06 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lanachotelajavamini`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `IDHotela` int(11) NOT NULL,
  `NazivHotela` varchar(30) NOT NULL,
  `BrojSpratova` int(11) NOT NULL,
  `BrojSoba` int(11) NOT NULL,
  `Lokacija` varchar(30) NOT NULL,
  `DostupnostSoba` tinyint(1) NOT NULL,
  `DostupnostHotela` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`IDHotela`, `NazivHotela`, `BrojSpratova`, `BrojSoba`, `Lokacija`, `DostupnostSoba`, `DostupnostHotela`) VALUES
(3001, 'Tropical', 3, 9, 'Paralija', 1, 1),
(3002, 'StarPlus', 3, 12, 'Paralija', 1, 1),
(3003, 'Sunset', 4, 8, 'Pefkohori', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `IDKlijenta` int(11) NOT NULL,
  `ImeKlijenta` varchar(20) NOT NULL,
  `PrezimeKlijenta` varchar(25) NOT NULL,
  `DatumRodjenja` date NOT NULL,
  `KorisnickoIme` varchar(20) NOT NULL,
  `Lozinka` varchar(20) NOT NULL,
  `BrojPoena` int(11) DEFAULT NULL,
  `Uloga` enum('Klijent','Admin','Menadzer') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`IDKlijenta`, `ImeKlijenta`, `PrezimeKlijenta`, `DatumRodjenja`, `KorisnickoIme`, `Lozinka`, `BrojPoena`, `Uloga`) VALUES
(1, 'Stefan', 'Stefanovic', '2005-05-12', 'stefi', 'stefan', NULL, 'Klijent'),
(2, 'Marko', 'Markovic', '1987-06-30', 'markomare', 'mare', NULL, 'Klijent'),
(3, 'Todor', 'Todorovic', '1999-03-27', 'toki', 'todortoki', NULL, 'Klijent'),
(4, 'Iva', 'Veljkovic', '1998-08-08', 'admin', 'javaadmin', NULL, 'Admin'),
(5, 'Marina', 'Marinovic', '1989-04-20', 'menadzer1', 'javamenadzer1', NULL, 'Menadzer'),
(6, 'Luka', 'Mihajlovic', '2001-07-23', 'menadzer2', 'javamenadzer2', NULL, 'Menadzer'),
(7, 'Tatjana', 'Stamenkovic', '1983-01-19', 'menadzer3', 'javamenadzer3', NULL, 'Menadzer');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `IDRezervacije` int(11) NOT NULL,
  `IDKlijenta` int(11) NOT NULL,
  `IDSobe` int(11) NOT NULL,
  `DatumPocetka` date NOT NULL,
  `DatumKraja` date NOT NULL,
  `Ugovoreno` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`IDRezervacije`, `IDKlijenta`, `IDSobe`, `DatumPocetka`, `DatumKraja`, `Ugovoreno`) VALUES
(1, 3, 300102, '2023-06-30', '2023-07-08', 1);

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE `soba` (
  `IDSobe` int(11) NOT NULL,
  `BrojSobe` int(11) NOT NULL,
  `TipSobe` enum('Jednokrevetna','Dvokrevetna','Trokrevetna','Cetvorokrevetna','Petokrevetna') NOT NULL,
  `BrojSprata` int(11) NOT NULL,
  `IDHotela` int(11) NOT NULL,
  `Klima` tinyint(1) NOT NULL,
  `Sporet` tinyint(1) NOT NULL,
  `Terasa` tinyint(1) NOT NULL,
  `Sef` tinyint(1) NOT NULL,
  `Dostupnost` tinyint(1) NOT NULL,
  `Poeni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`IDSobe`, `BrojSobe`, `TipSobe`, `BrojSprata`, `IDHotela`, `Klima`, `Sporet`, `Terasa`, `Sef`, `Dostupnost`, `Poeni`) VALUES
(30011, 35, 'Cetvorokrevetna', 3, 3001, 1, 1, 1, 1, 0, 5),
(30016, 75, 'Petokrevetna', 1, 3001, 1, 0, 1, 0, 0, 5),
(30029, 172, 'Trokrevetna', 2, 3002, 1, 1, 0, 0, 0, 15),
(30034, 200, 'Jednokrevetna', 4, 3003, 1, 1, 0, 1, 0, 10),
(300101, 1, 'Cetvorokrevetna', 1, 3001, 0, 0, 0, 0, 0, 5),
(300102, 2, 'Trokrevetna', 1, 3001, 0, 0, 0, 0, 0, 5),
(300103, 3, 'Dvokrevetna', 1, 3001, 0, 0, 0, 0, 0, 5),
(300111, 11, 'Petokrevetna', 2, 3001, 0, 0, 0, 0, 0, 5),
(300112, 12, 'Dvokrevetna', 2, 3001, 0, 0, 0, 0, 0, 5),
(300113, 13, 'Jednokrevetna', 2, 3001, 0, 0, 0, 0, 0, 5),
(300121, 21, 'Cetvorokrevetna', 3, 3001, 0, 0, 0, 0, 0, 5),
(300122, 22, 'Trokrevetna', 3, 3001, 0, 0, 0, 0, 0, 5),
(300123, 23, 'Cetvorokrevetna', 3, 3001, 0, 0, 0, 0, 0, 5),
(300201, 10, 'Cetvorokrevetna', 1, 3002, 0, 0, 0, 0, 0, 15),
(300202, 20, 'Cetvorokrevetna', 1, 3002, 0, 0, 0, 0, 0, 15),
(300203, 30, 'Trokrevetna', 1, 3002, 0, 0, 0, 0, 0, 15),
(300204, 40, 'Trokrevetna', 1, 3002, 0, 0, 0, 0, 0, 15),
(300205, 50, 'Dvokrevetna', 2, 3002, 0, 0, 0, 0, 0, 15),
(300206, 60, 'Trokrevetna', 2, 3002, 0, 0, 0, 0, 0, 15),
(300207, 70, 'Cetvorokrevetna', 2, 3002, 0, 0, 0, 0, 0, 15),
(300208, 80, 'Jednokrevetna', 2, 3002, 0, 0, 0, 0, 0, 15),
(300209, 90, 'Dvokrevetna', 3, 3002, 0, 0, 0, 0, 0, 15),
(300210, 100, 'Dvokrevetna', 3, 3002, 0, 0, 0, 0, 0, 15),
(300211, 110, 'Cetvorokrevetna', 3, 3002, 0, 0, 0, 0, 0, 15),
(300212, 120, 'Trokrevetna', 3, 3002, 0, 0, 0, 0, 0, 15),
(300301, 101, 'Trokrevetna', 1, 3003, 0, 0, 0, 0, 0, 10),
(300303, 103, 'Petokrevetna', 1, 3003, 0, 0, 0, 0, 0, 10),
(300306, 106, 'Cetvorokrevetna', 2, 3003, 0, 0, 0, 0, 0, 10),
(300308, 108, 'Cetvorokrevetna', 2, 3003, 0, 0, 0, 0, 0, 10),
(300311, 111, 'Trokrevetna', 3, 3003, 0, 0, 0, 0, 0, 10),
(300313, 113, 'Petokrevetna', 3, 3003, 0, 0, 0, 0, 0, 10),
(300316, 116, 'Trokrevetna', 4, 3003, 0, 0, 0, 0, 0, 10),
(300318, 118, 'Cetvorokrevetna', 4, 3003, 0, 0, 0, 0, 0, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`IDHotela`);

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`IDKlijenta`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`IDRezervacije`),
  ADD KEY `IDKlijenta` (`IDKlijenta`,`IDSobe`),
  ADD KEY `IDSobe` (`IDSobe`);

--
-- Indexes for table `soba`
--
ALTER TABLE `soba`
  ADD PRIMARY KEY (`IDSobe`),
  ADD KEY `IDHotela` (`IDHotela`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `IDKlijenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `IDRezervacije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`IDSobe`) REFERENCES `soba` (`IDSobe`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`IDKlijenta`) REFERENCES `klijent` (`IDKlijenta`);

--
-- Constraints for table `soba`
--
ALTER TABLE `soba`
  ADD CONSTRAINT `soba_ibfk_1` FOREIGN KEY (`IDHotela`) REFERENCES `hotel` (`IDHotela`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
