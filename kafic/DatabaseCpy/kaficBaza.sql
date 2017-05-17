-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2017 at 06:19 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kafic`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Admin` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`Username`, `Password`, `Admin`) VALUES
('Mare', '123', 'false '),
('Ad', '111', 'true '),
('admin', 'admin', 'true '),
('Steva', '123', 'false '),
('Zeljko', '123', 'false ');

-- --------------------------------------------------------

--
-- Table structure for table `prihod`
--

CREATE TABLE `prihod` (
  `kljuc` int(11) NOT NULL,
  `smena` varchar(8) CHARACTER SET utf16 NOT NULL,
  `dan` date NOT NULL,
  `proizvod` varchar(30) NOT NULL,
  `sifra` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prihod`
--

INSERT INTO `prihod` (`kljuc`, `smena`, `dan`, `proizvod`, `sifra`) VALUES
(24, 'prva', '2017-04-28', 'viski', 5),
(25, 'prva', '2017-04-28', 'viski', 5),
(26, 'prva', '2017-04-28', 'stok', 5),
(27, 'druga', '2017-05-16', 'Fanta', 12),
(28, 'druga', '2017-05-16', 'Fanta', 12),
(29, 'druga', '2017-05-16', 'Fanta', 12),
(30, 'druga', '2017-05-16', 'Fanta', 12),
(31, 'druga', '2017-05-16', 'Fanta', 12),
(32, 'druga', '2017-05-16', 'Fanta', 12),
(33, 'druga', '2017-05-16', 'Fanta', 12),
(34, 'druga', '2017-05-16', 'Fanta', 12),
(35, 'druga', '2017-05-16', 'Fanta', 12),
(36, 'druga', '2017-05-16', 'Fanta', 12),
(37, 'druga', '2017-05-16', 'Fanta', 12),
(38, 'druga', '2017-05-16', 'Visiki', 11),
(39, 'druga', '2017-05-16', 'Fanta', 12),
(40, 'druga', '2017-05-16', 'Viski', 11),
(41, 'druga', '2017-05-16', 'Fanta', 12),
(42, 'druga', '2017-05-16', 'Viski', 11),
(43, 'druga', '2017-05-16', 'Visiki', 11),
(44, 'druga', '2017-05-16', 'Fanta', 12),
(45, 'druga', '2017-05-16', 'Visiki', 11),
(46, 'druga', '2017-05-16', 'Visiki', 11),
(47, 'druga', '2017-05-16', 'Fanta', 12),
(48, 'druga', '2017-05-16', 'Visiki', 11),
(49, 'druga', '2017-05-16', 'Fanta', 12),
(50, 'druga', '2017-05-16', 'kapucino', 2),
(51, 'druga', '2017-05-16', 'espresso', 1),
(52, 'druga', '2017-05-16', 'kapucino', 2),
(53, 'druga', '2017-05-16', 'Fanta', 12),
(54, 'druga', '2017-05-16', 'Fanta', 12),
(55, 'druga', '2017-05-16', 'espresso', 1),
(56, 'druga', '2017-05-16', 'espresso', 1),
(57, 'druga', '2017-05-16', 'espresso', 1),
(58, 'druga', '2017-05-16', 'espresso', 1),
(59, 'druga', '2017-05-16', 'Fanta', 12),
(60, 'druga', '2017-05-16', 'espresso', 1),
(61, 'druga', '2017-05-16', 'espresso', 1),
(62, 'druga', '2017-05-16', 'Visiki', 11),
(63, 'druga', '2017-05-16', 'Fanta', 12),
(64, 'druga', '2017-05-16', 'kapucino', 2),
(65, 'druga', '2017-05-16', 'espresso', 1),
(66, 'druga', '2017-05-16', 'espresso', 1),
(67, 'druga', '2017-05-16', 'kapucino', 2),
(68, 'druga', '2017-05-16', 'Visiki', 11),
(69, 'druga', '2017-05-16', 'Fanta', 12),
(70, 'druga', '2017-05-16', 'Fanta', 12),
(71, 'druga', '2017-05-16', 'kapucino', 2),
(72, 'druga', '2017-05-16', 'Fanta', 12),
(73, 'druga', '2017-05-16', 'espresso', 1),
(74, 'druga', '2017-05-16', 'Fanta', 12),
(75, 'druga', '2017-05-16', 'kapucino', 2),
(76, 'druga', '2017-05-16', 'Visiki', 11),
(77, 'druga', '2017-05-16', 'Fanta', 12),
(78, 'druga', '2017-05-16', 'kapucino', 2),
(79, 'druga', '2017-05-16', 'kapucino', 2),
(80, 'druga', '2017-05-16', 'Fanta', 12),
(81, 'druga', '2017-05-17', 'Erdinger0.4', 103),
(82, 'druga', '2017-05-17', 'Niksicko0.5', 3),
(83, 'druga', '2017-05-17', 'Visiki', 11),
(84, 'druga', '2017-05-17', 'Fanta', 12),
(85, 'druga', '2017-05-17', 'Niksicko0.5', 3);

-- --------------------------------------------------------

--
-- Table structure for table `stanje_pica`
--

CREATE TABLE `stanje_pica` (
  `sifra` int(4) NOT NULL,
  `ime` varchar(18) NOT NULL,
  `tip` varchar(15) NOT NULL,
  `cena` int(10) NOT NULL,
  `stanje` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stanje_pica`
--

INSERT INTO `stanje_pica` (`sifra`, `ime`, `tip`, `cena`, `stanje`) VALUES
(12, 'Fanta', 'bezalkoholno', 120, 70),
(11, 'Visiki', 'alkoholno', 250, 12),
(1, 'espresso', 'topliNapitak', 110, 191),
(2, 'kapucino', 'topliNapitak', 130, 192),
(3, 'Niksicko0.5', 'pivo', 140, 98),
(101, 'Zajecarsko0.3', 'bezalkoholno', 120, 100),
(103, 'Erdinger0.4', 'pivo', 220, 49);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `prihod`
--
ALTER TABLE `prihod`
  ADD PRIMARY KEY (`kljuc`);

--
-- Indexes for table `stanje_pica`
--
ALTER TABLE `stanje_pica`
  ADD PRIMARY KEY (`sifra`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prihod`
--
ALTER TABLE `prihod`
  MODIFY `kljuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
