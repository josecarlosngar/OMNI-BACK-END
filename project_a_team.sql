-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-05-2018 a las 12:01:37
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `project_a_team`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creationDate` datetime NOT NULL,
  `editionDate` datetime NOT NULL,
  `text` varchar(1000) NOT NULL,
  `likes` int(11) NOT NULL DEFAULT '0',
  `dislikes` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `post`
--

INSERT INTO `post` (`id`, `creationDate`, `editionDate`, `text`, `likes`, `dislikes`, `userId`) VALUES
(2, '2018-05-01 00:00:00', '2018-05-02 00:00:00', 'En las últimas horas se ha producido el anuncio oficial de uno de los videojuegos más esperados del año. Nos estamos refiriendo a la nueva entrega de la saga Battlefield, que tendrá como título Battlefield V y nos llevará a la Segunda Guerra Mundial.', 0, 0, 4),
(3, '2018-05-24 00:00:00', '0000-00-00 00:00:00', 'Los jet-packs ya han llegado a Fortnite. Mochilas propulsoras con las que volar (mientras haya combustible) y ser el terror de los cielos. Sin embargo, este podría ser el comienzo de los objetos que nos colgamos a la espalda, ya que la minería de datos de nuevo ha encontrado en los archivos del juego lo que podría significar el futuro del título de Epic Games.', 0, 0, 3),
(4, '2018-05-11 00:00:00', '2018-05-12 00:00:00', 'Tras varios años en el mundo del PC, el videojuego de supervivencia y género Battle Royale H1Z1 al fin ha aterrizado en PlayStation 4 a través de una fase beta abierta que permite a todo aquel interesado en la propuesta descargarla sin tener que pagar ni un solo céntimo. El título de acción en el que se inspiraron obras como Fortnite o PlayerUnknown’s Battlegrounds llegó a la consola de Sony el 22 de mayo y ya se puede considerar un auténtico éxito.', 0, 0, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post-tag`
--

CREATE TABLE IF NOT EXISTS `post-tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL,
  `tagId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `postId` (`postId`),
  KEY `tagId` (`tagId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `post-tag`
--

INSERT INTO `post-tag` (`id`, `postId`, `tagId`) VALUES
(2, 2, 4),
(3, 3, 6),
(4, 3, 2),
(5, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tag`
--

INSERT INTO `tag` (`id`, `name`) VALUES
(2, 'MMO'),
(4, 'FPS'),
(5, 'RPG'),
(6, 'F2P'),
(7, 'Indie');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(250) NOT NULL,
  `role` varchar(45) NOT NULL,
  `image` varchar(250) NOT NULL,
  `registrationMoment` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `name`, `surname`, `email`, `role`, `image`, `registrationMoment`) VALUES
(3, 'vegeta', 'vegeta', 'Vegeta', 'Saiyan', 'Vegeta@gmail.com', 'USER', 'https://vignette.wikia.nocookie.net/dragonball/images/e/e2/Vegeta_Universo7.png/revision/latest?cb=20170706191743&path-prefix=es', '2018-05-25 09:43:38'),
(4, 'goku', 'goku', 'Goku', 'Super saiyan', 'Goku@dragonball.com', 'USER', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHd2re4mbg5WbA0jonDffG3D_JAZWdGWoXesBEVxfGz8tlXW4Z', '2018-05-08 00:00:00'),
(5, 'dragon', 'dragon', 'Shenlong', 'Targaryen', 'Shenlong@dragonball.com', 'ADMIN', 'https://vignette.wikia.nocookie.net/dbxenoverse/images/a/ac/Shenron.jpg/revision/latest?cb=20150507125859', '2018-05-14 00:00:00');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `post-tag`
--
ALTER TABLE `post-tag`
  ADD CONSTRAINT `post@002dtag_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `post@002dtag_ibfk_2` FOREIGN KEY (`tagId`) REFERENCES `tag` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
