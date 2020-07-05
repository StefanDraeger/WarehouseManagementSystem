-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 05. Jul 2020 um 11:46
-- Server-Version: 10.1.37-MariaDB
-- PHP-Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `wmsdb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `halle`
--

CREATE TABLE `halle` (
  `id` bigint(20) NOT NULL,
  `bezeichnung` varchar(255) DEFAULT NULL,
  `hasRegal` bit(1) DEFAULT NULL,
  `hasStellplatz` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `halle`
--

INSERT INTO `halle` (`id`, `bezeichnung`, `hasRegal`, `hasStellplatz`) VALUES
(0, 'Test123', b'1', b'1');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `produkte`
--

CREATE TABLE `produkte` (
  `id` int(20) NOT NULL,
  `anzahl` int(11) DEFAULT NULL,
  `warn_anzahl` double NOT NULL,
  `menge` double DEFAULT NULL,
  `mengeneinheit` varchar(255) DEFAULT NULL,
  `laenge` double DEFAULT NULL,
  `breite` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `packmaterial` int(11) DEFAULT NULL,
  `gesperrt` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `produkte`
--

INSERT INTO `produkte` (`id`, `anzahl`, `warn_anzahl`, `menge`, `mengeneinheit`, `laenge`, `breite`, `name`, `packmaterial`, `gesperrt`) VALUES
(1, 1, 300, 45, 'kg', 5, 1, 'V60S4 blank', 1, b'1'),
(2, 1, 56, 34, 'kg', 6, 3, 'V60S4 blank', 1, b'0'),
(3, 29, 25, 34, 'l', 4, 8, 'Test123', NULL, b'0'),
(4, 56, 5, 455, 'kg', 56, 678, 'Lorem ipsum cdfgdf fdgdg frgdgdgf', NULL, b'0');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `passwort` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `passwort`, `username`) VALUES
(1, 'draeger', 'stefand');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `halle`
--
ALTER TABLE `halle`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `produkte`
--
ALTER TABLE `produkte`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `produkte`
--
ALTER TABLE `produkte`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
