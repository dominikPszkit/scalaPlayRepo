-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Maj 2015, 09:22
-- Wersja serwera: 5.6.21
-- Wersja PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `diagnostyka`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dane`
--

CREATE TABLE IF NOT EXISTS `dane` (
`Id` int(11) NOT NULL,
  `pytania` varchar(60) COLLATE utf8_polish_ci NOT NULL,
  `ceny` int(11) NOT NULL,
  `diagnoza` varchar(100) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `dane`
--

INSERT INTO `dane` (`Id`, `pytania`, `ceny`, `diagnoza`) VALUES
(1, 'Witamy w programie!!', 0, '... ... ... Do wymiany: ... ... ...'),
(3, 'Czy rozrusznik pracuje prawidłowo?', 100, 'Rozrusznik'),
(4, 'Czy praca silnika jest regularna?', 100, 'Aparat zapłonowy'),
(8, 'Czy świecą się kontrolki?', 100, 'Akumulator'),
(10, 'Czy wskaźnik obrotów wskazuje jedynkę na biegu jałowym?', 50, 'Regulacja obrotów');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `dane`
--
ALTER TABLE `dane`
 ADD PRIMARY KEY (`Id`), ADD KEY `Id` (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `dane`
--
ALTER TABLE `dane`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
