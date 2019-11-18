-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2019 a las 23:43:43
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
(3, 'Explosive', 'img/Ab/explosive.jpg');

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
(3, 'David Garrett', 'img/A/davidgarrett.jpg');

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
(30, 'Thinking of Loud', 223, 3, 3);

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
(11, 2);

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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `artista`
--
ALTER TABLE `artista`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cancion`
--
ALTER TABLE `cancion`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

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
