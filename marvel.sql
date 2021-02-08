-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2021 a las 17:21:22
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `marvel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `characters`
--

CREATE TABLE `characters` (
  `ID_CHARACTER` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `LAST_SYNC` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `characters`
--

INSERT INTO `characters` (`ID_CHARACTER`, `NAME`, `LAST_SYNC`) VALUES
(1009220, 'Captain America', '2021-02-07 20:12:57'),
(1009368, 'iron Man', '2021-02-07 20:12:52');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `characterxrolxcollaborator`
--

CREATE TABLE `characterxrolxcollaborator` (
  `ID_CHARACTER` int(11) NOT NULL,
  `ID_ROL` int(11) NOT NULL,
  `ID_COLLABORATOR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `characterxrolxcollaborator`
--

INSERT INTO `characterxrolxcollaborator` (`ID_CHARACTER`, `ID_ROL`, `ID_COLLABORATOR`) VALUES
(1009220, 1, 2133),
(1009220, 1, 4300),
(1009220, 1, 4430),
(1009220, 1, 12313),
(1009220, 1, 13027),
(1009220, 1, 13647),
(1009220, 2, 18),
(1009220, 2, 30),
(1009220, 2, 96),
(1009220, 2, 259),
(1009220, 2, 367),
(1009220, 2, 1340),
(1009220, 2, 4858),
(1009220, 2, 5178),
(1009220, 2, 5237),
(1009220, 2, 10363),
(1009220, 2, 12516),
(1009220, 2, 12854),
(1009220, 2, 13081),
(1009220, 2, 13100),
(1009220, 2, 13262),
(1009220, 2, 13625),
(1009220, 2, 13750),
(1009220, 2, 13989),
(1009220, 2, 14151),
(1009220, 3, 586),
(1009220, 3, 1004),
(1009220, 3, 1405),
(1009220, 3, 4267),
(1009220, 3, 9329),
(1009220, 3, 12991),
(1009220, 3, 13021),
(1009220, 3, 13449),
(1009368, 1, 2133),
(1009368, 1, 4300),
(1009368, 1, 4430),
(1009368, 1, 4600),
(1009368, 1, 8822),
(1009368, 1, 12376),
(1009368, 1, 12457),
(1009368, 2, 536),
(1009368, 2, 1231),
(1009368, 2, 2784),
(1009368, 2, 11743),
(1009368, 2, 11765),
(1009368, 2, 12447),
(1009368, 2, 12494),
(1009368, 2, 12712),
(1009368, 2, 12798),
(1009368, 2, 12838),
(1009368, 2, 12983),
(1009368, 2, 13471),
(1009368, 2, 13861),
(1009368, 2, 13917),
(1009368, 2, 13940),
(1009368, 3, 582),
(1009368, 3, 586),
(1009368, 3, 8504),
(1009368, 3, 9937),
(1009368, 3, 10279),
(1009368, 3, 13180),
(1009368, 3, 13676);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `charxrelatedxcomic`
--

CREATE TABLE `charxrelatedxcomic` (
  `ID_CHARACTER` int(11) NOT NULL,
  `ID_RELATED` int(11) NOT NULL,
  `ID_COMIC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `charxrelatedxcomic`
--

INSERT INTO `charxrelatedxcomic` (`ID_CHARACTER`, `ID_RELATED`, `ID_COMIC`) VALUES
(1009220, 1009220, 77163),
(1009220, 1009220, 77230),
(1009220, 1009220, 77236),
(1009220, 1009220, 77237),
(1009220, 1009220, 77238),
(1009220, 1009220, 77239),
(1009220, 1009220, 77240),
(1009220, 1009220, 77241),
(1009220, 1009220, 77242),
(1009220, 1009220, 78072),
(1009220, 1009220, 78361),
(1009220, 1009220, 78621),
(1009220, 1009220, 81260),
(1009220, 1009220, 82285),
(1009220, 1009220, 82368),
(1009220, 1009220, 82601),
(1009220, 1009220, 88628),
(1009220, 1009220, 88629),
(1009220, 1009220, 90048),
(1009220, 1009220, 91232),
(1009220, 1009228, 77236),
(1009220, 1009228, 77238),
(1009220, 1009228, 77239),
(1009220, 1009228, 77240),
(1009220, 1009282, 82368),
(1009220, 1009610, 82368),
(1009220, 1009718, 82368),
(1009220, 1009726, 82368),
(1009220, 1010682, 77238),
(1009220, 1010740, 77238),
(1009220, 1010740, 78072),
(1009220, 1011335, 78361),
(1009220, 1016181, 77163),
(1009220, 1017575, 77238),
(1009368, 1009180, 78633),
(1009368, 1009185, 76162),
(1009368, 1009185, 76163),
(1009368, 1009262, 77132),
(1009368, 1009281, 91755),
(1009368, 1009368, 27238),
(1009368, 1009368, 76162),
(1009368, 1009368, 76163),
(1009368, 1009368, 76359),
(1009368, 1009368, 76360),
(1009368, 1009368, 77132),
(1009368, 1009368, 78359),
(1009368, 1009368, 78633),
(1009368, 1009368, 78634),
(1009368, 1009368, 80464),
(1009368, 1009368, 84567),
(1009368, 1009368, 85577),
(1009368, 1009368, 85578),
(1009368, 1009368, 85579),
(1009368, 1009368, 85580),
(1009368, 1009368, 85581),
(1009368, 1009368, 85662),
(1009368, 1009368, 90052),
(1009368, 1009368, 91755),
(1009368, 1009368, 93469),
(1009368, 1009415, 85662),
(1009368, 1009472, 85662),
(1009368, 1009546, 85662),
(1009368, 1009629, 85662),
(1009368, 1009664, 78633),
(1009368, 1009664, 78634),
(1009368, 1009718, 27238),
(1009368, 1009718, 85662),
(1009368, 1009726, 85662),
(1009368, 1010351, 85577),
(1009368, 1010351, 85578),
(1009368, 1010351, 85580),
(1009368, 1010351, 85581);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `collaborators`
--

CREATE TABLE `collaborators` (
  `ID_COLLABORATOR` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `collaborators`
--

INSERT INTO `collaborators` (`ID_COLLABORATOR`, `NAME`) VALUES
(18, 'Jeph Loeb'),
(30, 'Stan Lee'),
(96, 'Jim Lee'),
(259, 'Mark Gruenwald'),
(367, 'Ed Brubaker'),
(536, 'Greg Pak'),
(582, 'Brian Reber'),
(586, 'Michael Kelleher'),
(1004, 'Daniel Acuna'),
(1231, 'Kurt Busiek'),
(1340, 'James Robinson'),
(1405, 'Matt Milla'),
(2133, 'Tom Brevoort'),
(2784, 'David Michelinie'),
(4267, 'Andy Troy'),
(4300, 'Nick Lowe'),
(4430, 'Jeff Youngquist'),
(4600, 'Mark Paniccia'),
(4858, 'Margaret Clark'),
(5178, 'Mike Baron'),
(5237, 'Gregory Wright'),
(8504, 'Frank D\'ARMATA'),
(8822, 'Jordan White'),
(9329, 'Rico Renzi'),
(9937, 'Jim Charalampidis'),
(10279, 'Matthew Wilson'),
(10363, 'John Rhett Thomas'),
(11743, 'Jonathan Hickman'),
(11765, 'Christos Gage'),
(12313, 'Mark Basso'),
(12376, 'Wilson Moss'),
(12447, 'Tom Taylor'),
(12457, 'Edward Devin Lewis'),
(12494, 'Chip Zdarsky'),
(12516, 'Walt Simonson'),
(12712, 'Donny Cates'),
(12798, 'Amy Chu'),
(12838, 'Jeremy Whitley'),
(12854, 'Paul Allor'),
(12983, 'Dan Slott'),
(12991, 'Rachelle Rosenberg'),
(13021, 'David Curiel'),
(13027, 'Darren Shan'),
(13081, 'Saladin Ahmed'),
(13100, 'Jeph York'),
(13180, 'Federico Blee'),
(13262, 'Dan Chichester'),
(13449, 'Chris Sotomayor'),
(13471, 'Jed Mackay'),
(13625, 'Ta-Nehisi Coates'),
(13647, 'Lauren Amaro'),
(13676, 'Mattia Iacono'),
(13750, 'Phillip Kennedy Johnson'),
(13861, 'Christopher Cantwell'),
(13917, 'Alyssa Wong'),
(13940, 'Barbara Kesel'),
(13989, 'Mark Russell'),
(14151, 'Anthony Falcone');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comic`
--

CREATE TABLE `comic` (
  `ID_COMIC` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comic`
--

INSERT INTO `comic` (`ID_COMIC`, `NAME`) VALUES
(27238, 'Wolverine Saga (2009) #7'),
(76162, 'Black Cat (2019) #11'),
(76163, 'Black Cat (2019) #12'),
(76359, 'Aero (2019) #11'),
(76360, 'Aero (2019) #12'),
(77132, 'Daredevil (2019) #22'),
(77163, 'Miles Morales: Spider-Man (2018) #20'),
(77230, 'Captain America by Ta-Nehisi Coates Vol. 4: All Die Young (Trade Paperback)'),
(77236, 'Captain America (2018) #20'),
(77237, 'Captain America (2018) #21'),
(77238, 'Captain America (2018) #22'),
(77239, 'Captain America (2018) #23'),
(77240, 'Captain America (2018) #24'),
(77241, 'Captain America (2018) #25'),
(77242, 'Captain America (2018) #26'),
(78072, 'Captain America: Winter Soldier Marvel Select (Hardcover)'),
(78359, 'Avengers: Marvels Snapshots (2020) #1'),
(78361, 'Civil War: Marvels Snapshots (2020) #1'),
(78621, 'Marvel\'s Avengers: Captain America (2020) #1'),
(78633, 'Thor (2020) #7'),
(78634, 'Thor (2020) #8'),
(80464, 'Iron Man 2020 (2020) #5'),
(81260, 'Captain America Epic Collection: Blood And Glory (Trade Paperback)'),
(82285, 'Heroes Reborn: Captain America (Trade Paperback)'),
(82368, 'Marvel Monograph: The Art Of Chris Bachalo (Trade Paperback)'),
(82601, 'Captain America: Marvels Snapshots (2020) #1'),
(84567, 'True Believers: Iron Man 2020 - War Machine (2020) #1'),
(85577, 'Iron Man (2020) #1'),
(85578, 'Iron Man (2020) #2'),
(85579, 'Iron Man (2020) #3'),
(85580, 'Iron Man (2020) #4'),
(85581, 'Iron Man (2020) #5'),
(85662, 'Free Comic Book Day: X-Men (2020) #1'),
(88628, 'Empyre: Captain America (2020) #1'),
(88629, 'Empyre: Captain America (2020) #2'),
(90048, 'Captain America #117: Facsimile Edition (2021)'),
(90052, 'Tales of Suspense Facsimile Edition (2020) #39'),
(91232, 'Captain America: Von Strucker Gambit (2020)'),
(91755, 'King In Black: Iron Man/Doom (2020) #1'),
(93469, 'Marvel Action Chillers (2020) #1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `related_character`
--

CREATE TABLE `related_character` (
  `ID_RELATED` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `related_character`
--

INSERT INTO `related_character` (`ID_RELATED`, `NAME`) VALUES
(1009180, 'Beta-Ray Bill'),
(1009185, 'Black Cat'),
(1009220, 'Captain America'),
(1009228, 'Sharon Carter'),
(1009262, 'Daredevil'),
(1009281, 'Doctor Doom'),
(1009282, 'Doctor Strange'),
(1009368, 'Iron Man'),
(1009415, 'Magik (Illyana Rasputin)'),
(1009472, 'Nightcrawler'),
(1009546, 'Rogue'),
(1009610, 'Spider-Man'),
(1009629, 'Storm'),
(1009664, 'Thor'),
(1009718, 'Wolverine'),
(1009726, 'X-Men'),
(1010351, 'Hellcat (Patsy Walker)'),
(1010682, 'Misty Knight'),
(1010740, 'Winter Soldier'),
(1011335, 'Maria Hill'),
(1016181, 'Spider-Man (Miles Morales)'),
(1017575, 'Captain America (Sam Wilson)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `ID_ROL` int(11) NOT NULL,
  `NAME` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID_ROL`, `NAME`) VALUES
(3, 'colorist'),
(1, 'editor'),
(2, 'writer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `ID_CHARACTER` int(11) NOT NULL,
  `ID_ROL` int(11) NOT NULL,
  `ID_COLLABORATOR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`ID_CHARACTER`);

--
-- Indices de la tabla `characterxrolxcollaborator`
--
ALTER TABLE `characterxrolxcollaborator`
  ADD PRIMARY KEY (`ID_CHARACTER`,`ID_ROL`,`ID_COLLABORATOR`),
  ADD KEY `FKp68kh5w85egf7wv9u07mx0jwy` (`ID_COLLABORATOR`),
  ADD KEY `FK7chr7cvddix0epjn72m6kknjc` (`ID_ROL`);

--
-- Indices de la tabla `charxrelatedxcomic`
--
ALTER TABLE `charxrelatedxcomic`
  ADD PRIMARY KEY (`ID_CHARACTER`,`ID_RELATED`,`ID_COMIC`),
  ADD KEY `FK9f0vlx5xjrv2hgiuipbo3y0v9` (`ID_COMIC`),
  ADD KEY `FKixsvc1cphulrlqam85lx2ewin` (`ID_RELATED`);

--
-- Indices de la tabla `collaborators`
--
ALTER TABLE `collaborators`
  ADD PRIMARY KEY (`ID_COLLABORATOR`);

--
-- Indices de la tabla `comic`
--
ALTER TABLE `comic`
  ADD PRIMARY KEY (`ID_COMIC`);

--
-- Indices de la tabla `related_character`
--
ALTER TABLE `related_character`
  ADD PRIMARY KEY (`ID_RELATED`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID_ROL`),
  ADD UNIQUE KEY `NAME` (`NAME`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`ID_CHARACTER`,`ID_ROL`,`ID_COLLABORATOR`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID_ROL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `characterxrolxcollaborator`
--
ALTER TABLE `characterxrolxcollaborator`
  ADD CONSTRAINT `FK7chr7cvddix0epjn72m6kknjc` FOREIGN KEY (`ID_ROL`) REFERENCES `roles` (`ID_ROL`),
  ADD CONSTRAINT `FK984c45ph61mxfvbqvldaypo2e` FOREIGN KEY (`ID_CHARACTER`) REFERENCES `characters` (`ID_CHARACTER`),
  ADD CONSTRAINT `FKp68kh5w85egf7wv9u07mx0jwy` FOREIGN KEY (`ID_COLLABORATOR`) REFERENCES `collaborators` (`ID_COLLABORATOR`);

--
-- Filtros para la tabla `charxrelatedxcomic`
--
ALTER TABLE `charxrelatedxcomic`
  ADD CONSTRAINT `FK9f0vlx5xjrv2hgiuipbo3y0v9` FOREIGN KEY (`ID_COMIC`) REFERENCES `comic` (`ID_COMIC`),
  ADD CONSTRAINT `FKfhevlrrq0qhnbxo3n1x47f0jn` FOREIGN KEY (`ID_CHARACTER`) REFERENCES `characters` (`ID_CHARACTER`),
  ADD CONSTRAINT `FKixsvc1cphulrlqam85lx2ewin` FOREIGN KEY (`ID_RELATED`) REFERENCES `related_character` (`ID_RELATED`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
