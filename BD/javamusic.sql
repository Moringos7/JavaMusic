-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2019 a las 08:04:22
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `javamusic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album`
--

CREATE TABLE `album` (
  `Id` int(11) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `album`
--

INSERT INTO `album` (`Id`, `Titulo`, `Img`) VALUES
(1, 'Bad', 'img/Ab/bad.jpg'),
(2, 'Back in Black', 'img/Ab/backinblack.jpg'),
(3, 'Explosive', 'img/Ab/explosive.jpg'),
(4, 'Lover', 'img/Ab/lover.jpg'),
(5, 'Mozart Album', 'img/Ab/mozart.jpg'),
(6, 'Beethoven Album', 'img/Ab/beethoven.jpg'),
(7, 'Appetite for Destruction', 'img/Ab/appetite.jpg'),
(8, 'Joytime III', 'img/Ab/joytime.jpg'),
(9, 'Piece Of Mind', 'img/Ab/pieceofmind.jpg'),
(10, 'Metallica', 'img/Ab/metallica.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`Id`, `Nombre`, `Img`) VALUES
(1, 'Michael Jackson', 'img/A/michaeljackson.jpg'),
(2, 'ACDC', 'img/A/acdc.jpg'),
(3, 'David Garrett', 'img/A/davidgarrett.jpg'),
(4, 'Taylor Swift', 'img/A/taylor.jpg'),
(5, 'Mozart', 'img/A/mozart.jpg'),
(6, 'Beethoven', 'img/A/beethoven.jpg'),
(7, 'Guns and Roses', 'img/A/gunsnroses.jpg'),
(8, 'Marshmello', 'img/A/marsh.jpg'),
(9, 'Iron Maiden', 'img/A/ironmaiden.jpg'),
(10, 'Metallica', 'img/A/metallica.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `Id` int(11) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Duracion` int(11) NOT NULL,
  `FkAlbum` int(11) NOT NULL,
  `FkGenero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cancion`
--

INSERT INTO `cancion` (`Id`, `Titulo`, `Duracion`, `FkAlbum`, `FkGenero`) VALUES
(1, 'Bad', 248, 1, 1),
(2, 'The Way You Make Me Feel', 299, 1, 1),
(3, 'Speed Demon', 243, 1, 1),
(4, 'Liberian Girl', 235, 1, 1),
(5, 'Just Good Friends', 249, 1, 1),
(6, 'Another Part of Me', 235, 1, 1),
(7, 'Man in the Mirror', 321, 1, 1),
(8, 'I Just Cant Stop Loving You', 267, 1, 1),
(9, 'Dirty Diana', 282, 1, 1),
(10, 'Smooth Criminal', 260, 1, 1),
(11, 'Hells Bells', 312, 2, 2),
(12, 'Shoot to Thrill', 314, 2, 2),
(13, 'What Do You Do for Money Honey', 215, 2, 2),
(14, 'Givin The Dog A Bone', 211, 2, 2),
(15, 'Let Me Put My Love Into You', 211, 2, 2),
(16, 'Back in Black', 252, 2, 2),
(17, 'You Shook Me All Night Long', 212, 2, 2),
(18, 'Have a Drink On Me', 238, 2, 2),
(19, 'Shake a Leg', 245, 2, 2),
(20, 'Rock and Roll Aint Noise Pollution', 266, 2, 2),
(21, 'Dangerous', 234, 3, 3),
(22, 'Explosive', 213, 3, 3),
(23, 'Serenity', 223, 3, 3),
(24, 'Lose Yourself', 186, 3, 3),
(25, 'Adventure Island', 165, 3, 3),
(26, 'Midnight Waltz', 188, 3, 3),
(27, 'How Many Times', 202, 3, 3),
(28, 'Unlimited Symphony', 193, 3, 3),
(29, 'They Dont Care About Us', 221, 3, 3),
(30, 'Thinking of Loud', 223, 3, 3),
(31, 'I Forgot That You Existed', 171, 4, 1),
(32, 'Cruel Summer', 171, 4, 1),
(33, 'Lover', 179, 4, 1),
(34, 'The Man', 221, 4, 1),
(35, 'The Archer', 190, 4, 1),
(36, 'I Think He Knows', 173, 4, 1),
(37, 'Miss Americana & The Heartbr..', 234, 4, 1),
(38, 'Paper Rings', 223, 4, 1),
(39, 'Cornelia Street', 287, 4, 1),
(40, 'Death By A Thousand Cuts', 199, 4, 1),
(41, 'La Flauta Magica', 396, 5, 5),
(42, 'Eine kleine Nachtmusik', 347, 5, 5),
(43, 'Sonata para piano n 11', 226, 5, 5),
(44, 'Sinfonía n 40', 495, 5, 5),
(45, 'Don Giovanni', 369, 5, 5),
(46, 'Concierto para clarinete', 419, 5, 5),
(47, 'Las bodas de Figaro', 265, 5, 5),
(48, 'Sonata Piano n16', 553, 5, 5),
(49, 'Concierto para piano n 21 ', 351, 5, 5),
(50, 'Ave verum corpusg', 182, 5, 5),
(51, 'Sinfonía n9', 942, 6, 5),
(52, 'Sinfonía n5', 623, 6, 5),
(53, 'Sonata para piano n 14', 900, 6, 5),
(54, 'Para Elisa', 456, 6, 5),
(55, 'Sinfonía n7', 506, 6, 5),
(56, 'Sinfonía n3', 396, 6, 5),
(57, 'Sonata para piano n8', 400, 6, 5),
(58, 'Sinfonía n6', 630, 6, 5),
(59, 'Concierto para piano n5', 586, 6, 5),
(60, 'Concierto para violin', 586, 6, 5),
(61, 'Welcome to the Jungle', 280, 7, 2),
(62, 'Its So Easy', 204, 7, 2),
(63, 'Nightrain', 267, 7, 2),
(64, 'Out Ta Get Me', 263, 7, 2),
(65, 'Mr. Brownstonee', 229, 7, 2),
(66, 'Paradise City', 406, 7, 2),
(67, 'My Michelle', 280, 7, 2),
(68, 'Think About You', 292, 7, 2),
(69, 'Sweet Child O Mine', 303, 7, 2),
(70, 'You are Crazy', 198, 7, 2),
(71, 'Down', 153, 8, 3),
(72, 'Run it Up', 143, 8, 3),
(73, 'Put Yo Hands Up', 196, 8, 3),
(74, 'Let\'s Get Down', 163, 8, 3),
(75, 'Sad Songs', 195, 8, 3),
(76, 'Set Me Free', 183, 8, 3),
(77, 'Room to Fall', 181, 8, 3),
(78, 'Angklung Life', 189, 8, 3),
(79, 'Earthquake', 148, 8, 3),
(80, 'Falling To Pieces', 166, 8, 3),
(81, 'Where Eagles Dare', 370, 9, 4),
(82, 'Revelations', 410, 9, 4),
(83, 'Flight of Icarus', 234, 9, 4),
(84, 'Die With Your Boots On', 328, 9, 4),
(85, 'The Trooper', 253, 9, 4),
(86, 'Still Life', 298, 9, 4),
(87, 'Quest for Fire', 223, 9, 4),
(88, 'Sun and Steel', 208, 9, 4),
(89, 'To Tame a Land', 449, 9, 4),
(90, 'Enter Sandman', 331, 10, 4),
(91, 'Sad But True', 326, 10, 4),
(92, 'Hoiler Than Thou', 228, 10, 4),
(93, 'The Unforgiven', 268, 10, 4),
(94, 'Wherever I May Roam', 369, 10, 4),
(95, 'Don\'t Tread On Me', 241, 10, 4),
(96, 'Through The Never', 245, 10, 4),
(97, 'Nothing Else Matters ', 386, 10, 4),
(98, 'Of Wolf And Man', 257, 10, 4),
(99, 'The God That Failed', 309, 10, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancionartista`
--

CREATE TABLE `cancionartista` (
  `FkCancion` int(11) NOT NULL,
  `FkArtista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cancionartista`
--

INSERT INTO `cancionartista` (`FkCancion`, `FkArtista`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 3),
(22, 3),
(23, 3),
(24, 3),
(25, 3),
(26, 3),
(27, 3),
(28, 3),
(29, 3),
(30, 3),
(11, 2),
(30, 4),
(31, 4),
(32, 4),
(33, 4),
(34, 4),
(35, 4),
(36, 4),
(37, 4),
(38, 4),
(39, 4),
(40, 4),
(41, 5),
(42, 5),
(43, 5),
(44, 5),
(45, 5),
(46, 5),
(47, 5),
(48, 5),
(49, 5),
(50, 5),
(51, 6),
(52, 6),
(53, 6),
(54, 6),
(55, 6),
(56, 6),
(57, 6),
(58, 6),
(59, 6),
(60, 6),
(61, 7),
(62, 7),
(63, 7),
(64, 7),
(65, 7),
(66, 7),
(67, 7),
(68, 7),
(69, 7),
(70, 7),
(71, 8),
(72, 8),
(73, 8),
(74, 8),
(75, 8),
(76, 8),
(77, 8),
(78, 8),
(79, 8),
(80, 8),
(81, 9),
(82, 9),
(83, 9),
(84, 9),
(85, 9),
(86, 9),
(87, 9),
(88, 9),
(89, 9),
(90, 10),
(91, 10),
(92, 10),
(93, 10),
(94, 10),
(95, 10),
(96, 10),
(97, 10),
(98, 10),
(99, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`Id`, `Nombre`, `Img`) VALUES
(1, 'Pop', 'img/G/pop.jpg'),
(2, 'Rock', 'img/G/rock.jpg'),
(3, 'Electronica', 'img/G/electronica.jpg'),
(4, 'Metal', 'img/G/metal.jpg'),
(5, 'Clasica', 'img/G/clasica.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Fk_Album` (`FkAlbum`),
  ADD KEY `Fk_Genero` (`FkGenero`);

--
-- Indices de la tabla `cancionartista`
--
ALTER TABLE `cancionartista`
  ADD KEY `FkCancion_Artista` (`FkCancion`),
  ADD KEY `FkArtista_Cancion` (`FkArtista`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `album`
--
ALTER TABLE `album`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `artista`
--
ALTER TABLE `artista`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cancion`
--
ALTER TABLE `cancion`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD CONSTRAINT `Fk_Album` FOREIGN KEY (`FkAlbum`) REFERENCES `album` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Genero` FOREIGN KEY (`FkGenero`) REFERENCES `genero` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cancionartista`
--
ALTER TABLE `cancionartista`
  ADD CONSTRAINT `FkArtista_Cancion` FOREIGN KEY (`FkArtista`) REFERENCES `artista` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FkCancion_Artista` FOREIGN KEY (`FkCancion`) REFERENCES `cancion` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
