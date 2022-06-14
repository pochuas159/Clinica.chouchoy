-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-03-2022 a las 22:29:09
-- Versión del servidor: 10.3.15-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_clinica`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_horarios_disponibles` (`_turno` INT, `_medico` VARCHAR(6), `_fecha` DATE)  BEGIN
   IF (current_date() = _fecha) THEN
		 SELECT *
         FROM HORA 
         where id_turno = _turno AND Hora_Inicio>=curTime() 
		       AND id_hora NOT IN (SELECT ID_HORA
                                   FROM CITA
                                   WHERE ID_Med = _medico);
   ELSE IF(current_date()<_fecha) THEN
     
	     SELECT *
         FROM HORA 
         where id_turno = _turno 
		       AND id_hora NOT IN (SELECT ID_HORA
                                   FROM CITA
                                   WHERE ID_Med = _medico AND FECHA_CITA = _fecha);
     END IF;
   END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id_Cita` int(11) NOT NULL,
  `id_usu` int(11) DEFAULT NULL,
  `id_med` varchar(6) DEFAULT NULL,
  `id_Hora` int(11) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `fecha_cita` date DEFAULT NULL,
  `estado` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id_Cita`, `id_usu`, `id_med`, `id_Hora`, `fecha_registro`, `fecha_cita`, `estado`) VALUES
(1, 1, 'M002', 9, '2022-03-09 11:54:28', '2021-03-09', 'PENDIENTE'),
(2, 3, 'M002', 11, '2022-03-09 11:54:42', '2021-03-09', 'PENDIENTE'),
(3, 2, 'M008', 12, '2022-03-09 11:58:30', '2021-03-09', 'PENDIENTE'),
(4, 3, 'M008', 10, '2022-03-09 11:58:37', '2021-03-09', 'PENDIENTE'),
(5, 5, 'M008', 11, '2022-03-09 11:58:42', '2022-03-09', 'PENDIENTE'),
(6, 6, 'M009', 23, '2022-03-09 11:58:46', '2022-03-09', 'PENDIENTE'),
(7, 1, 'M005', 10, '2022-03-09 11:58:52', '2022-03-09', 'PENDIENTE'),
(8, 3, 'M005', 11, '2022-03-09 11:58:58', '2022-03-09', 'PENDIENTE'),
(9, 3, 'M002', 18, '2022-03-09 11:59:03', '2022-03-09', 'PENDIENTE'),
(10, 3, 'M004', 23, '2022-03-09 11:59:09', '2022-03-09', 'PENDIENTE'),
(11, 3, 'M001', 2, '2022-03-09 11:59:47', '2022-03-19', 'PENDIENTE'),
(12, 3, 'M002', 1, '2022-03-09 16:16:16', '2022-03-10', 'PENDIENTE'),
(13, 3, 'M002', 21, '2022-03-09 16:16:27', '2022-03-09', 'PENDIENTE'),
(14, 6, 'M002', 1, '2022-03-09 16:17:05', '2022-03-17', 'PENDIENTE'),
(15, 3, 'M001', 1, '2022-03-09 16:17:19', '2022-03-11', 'PENDIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_esp` varchar(3) NOT NULL,
  `nom_esp` varchar(30) NOT NULL,
  `prec_esp` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_esp`, `nom_esp`, `prec_esp`) VALUES
('E01', 'Cirugia', 45),
('E02', 'Fisioterapia', 45),
('E03', 'Rehabilitación', 65),
('E04', 'Imagenología', 45),
('E05', 'Fauna Silvestre', 45),
('E06', 'Oftalmologia', 45),
('E07', 'Odontologia', 45),
('E08', 'Rayos X', 50),
('E10', 'Oncología', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hora`
--

CREATE TABLE `hora` (
  `id_Hora` int(11) NOT NULL,
  `id_Turno` int(11) DEFAULT NULL,
  `hora_Inicio` time DEFAULT NULL,
  `hora_Fin` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hora`
--

INSERT INTO `hora` (`id_Hora`, `id_Turno`, `hora_Inicio`, `hora_Fin`) VALUES
(1, 1, '08:00:00', '08:30:00'),
(2, 1, '08:30:00', '09:00:00'),
(3, 1, '09:00:00', '09:30:00'),
(4, 1, '09:30:00', '10:00:00'),
(5, 1, '10:00:00', '10:30:00'),
(6, 1, '10:30:00', '11:00:00'),
(7, 1, '11:00:00', '11:30:00'),
(8, 1, '11:30:00', '12:00:00'),
(9, 2, '12:00:00', '12:30:00'),
(10, 2, '12:30:00', '13:00:00'),
(11, 2, '13:00:00', '13:30:00'),
(12, 2, '13:30:00', '14:00:00'),
(13, 2, '14:00:00', '14:30:00'),
(14, 2, '14:30:00', '15:00:00'),
(15, 2, '15:00:00', '15:30:00'),
(16, 2, '15:30:00', '16:00:00'),
(17, 2, '16:00:00', '16:30:00'),
(18, 2, '16:30:00', '17:00:00'),
(19, 2, '17:00:00', '17:30:00'),
(20, 2, '17:30:00', '18:00:00'),
(21, 3, '18:00:00', '18:30:00'),
(22, 3, '18:30:00', '19:00:00'),
(23, 3, '19:00:00', '19:30:00'),
(24, 3, '19:30:00', '20:00:00'),
(25, 3, '20:00:00', '20:30:00'),
(26, 3, '20:30:00', '21:00:00'),
(27, 3, '21:00:00', '21:30:00'),
(28, 3, '21:30:00', '22:00:00'),
(29, 3, '22:00:00', '22:30:00'),
(30, 3, '22:30:00', '23:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario_medico`
--

CREATE TABLE `horario_medico` (
  `id_Horario` int(11) NOT NULL,
  `id_med` varchar(6) DEFAULT NULL,
  `id_Turno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `horario_medico`
--

INSERT INTO `horario_medico` (`id_Horario`, `id_med`, `id_Turno`) VALUES
(1, 'M001', 1),
(2, 'M002', 1),
(3, 'M002', 2),
(4, 'M002', 3),
(5, 'M003', 1),
(6, 'M004', 3),
(7, 'M005', 3),
(8, 'M005', 2),
(9, 'M006', 3),
(10, 'M007', 1),
(11, 'M008', 2),
(12, 'M009', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_med` varchar(6) NOT NULL,
  `id_esp` varchar(3) NOT NULL,
  `nom_med` varchar(30) NOT NULL,
  `ape_med` varchar(30) NOT NULL,
  `tele_med` varchar(9) NOT NULL,
  `email_med` varchar(30) NOT NULL,
  `cmp_med` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`id_med`, `id_esp`, `nom_med`, `ape_med`, `tele_med`, `email_med`, `cmp_med`) VALUES
('M001', 'E01', 'Jack', 'Jackson', '5555555', 'M@gmail.com', 784578),
('M002', 'E02', 'Jackson', 'Tavara Sheen', '5555555', 'g@gmail.com', 784578),
('M003', 'E07', 'Percy Ignacio', 'Mesa Prado', '988569856', 'percy@gmail.com', 568426),
('M004', 'E07', 'Victor', 'Puentes', '988569856', 'vicp@gmail.com', 563926),
('M005', 'E05', 'Patricia A', 'Juares', '485758625', 'patjua@yahoo.com', 125896),
('M006', 'E04', 'Miguel', 'Lujan', '988569856', 'migl@gmail.com', 567926),
('M007', 'E05', 'Alberto', 'Mendez', '988987556', 'albm@gmail.com', 598926),
('M008', 'E07', 'Gian Carlos', 'Bustamante', '988596856', 'giab@gmail.com', 588926),
('M009', 'E03', 'Javier', 'Mesa Chirinos', '984589856', 'javm@gmail.com', 268926),
('M010', 'E01', 'Jack', 'Sparrow', '985658745', 'aaaaaa@gmail.com', 568926),
('M011', 'E02', 'Vilma ', 'Pantoja', '985658745', 'vilp@hotmail.com', 123654);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `id_Turno` int(11) NOT NULL,
  `nombre_Turno` varchar(50) NOT NULL,
  `hora_Inicio` time NOT NULL,
  `hora_Fin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`id_Turno`, `nombre_Turno`, `hora_Inicio`, `hora_Fin`) VALUES
(1, 'Mañana', '08:00:00', '12:00:00'),
(2, 'Tarde', '12:00:00', '18:00:00'),
(3, 'Noche', '18:00:00', '23:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usu` int(11) NOT NULL,
  `nom_usu` varchar(30) NOT NULL,
  `ape_usu` varchar(30) NOT NULL,
  `dni_usu` varchar(8) NOT NULL,
  `pass_usu` varchar(30) NOT NULL,
  `tele_usu` varchar(9) NOT NULL,
  `email_usu` varchar(30) NOT NULL,
  `edad_usu` int(11) NOT NULL,
  `tipo_usu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usu`, `nom_usu`, `ape_usu`, `dni_usu`, `pass_usu`, `tele_usu`, `email_usu`, `edad_usu`, `tipo_usu`) VALUES
(1, 'Gimena', 'Sanchez', '92837483', '123', '912121211', 'gims@hotmail.com', 60, 'PACIENTE'),
(2, 'Zenaida', 'Manrique Suarez', '70446411', '70446411', '984141471', 'zenaida_manrique@hotmail.com', 32, 'PACIENTE'),
(3, 'Luis', 'Revilla G', '12345678', '123', '5555555', 'user@gmail.com', 25, 'PACIENTE'),
(4, 'Joaquin', 'Perez', '72316242', '72316242', '5555555', 'admin@gmail.com', 25, 'ADMINISTRADOR'),
(5, 'Kalvin', 'Fuentes', '98765432', '98765432', '5555555', 'user78@gmail.com', 25, 'ADMINISTRADOR'),
(6, 'Victor', 'Carranza Lopez', '01856926', '123', '988569856', 'victor@gmail.com', 28, 'PACIENTE'),
(7, 'Percy Albert', 'Arbisu Correa', '01856932', '123', '988569856', 'percy.arbisu@gmail.com', 29, 'PACIENTE'),
(8, 'Victor', 'Cubas Naquiche', '01856932', '454165413521', '985658745', 'victor_ysuhdsajd@gmail.com', 42, 'PACIENTE');


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id_Cita`),
  ADD KEY `id_usu` (`id_usu`),
  ADD KEY `id_Hora` (`id_Hora`),
  ADD KEY `id_med` (`id_med`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_esp`);

--
-- Indices de la tabla `hora`
--
ALTER TABLE `hora`
  ADD PRIMARY KEY (`id_Hora`),
  ADD KEY `id_Turno` (`id_Turno`);

--
-- Indices de la tabla `horario_medico`
--
ALTER TABLE `horario_medico`
  ADD PRIMARY KEY (`id_Horario`),
  ADD KEY `id_Turno` (`id_Turno`),
  ADD KEY `id_med` (`id_med`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_med`),
  ADD KEY `id_esp` (`id_esp`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id_Turno`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id_Cita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `hora`
--
ALTER TABLE `hora`
  MODIFY `id_Hora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `horario_medico`
--
ALTER TABLE `horario_medico`
  MODIFY `id_Horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `id_Turno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`id_usu`) REFERENCES `usuario` (`id_usu`),
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`id_Hora`) REFERENCES `hora` (`id_Hora`),
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`id_med`) REFERENCES `medico` (`id_med`);

--
-- Filtros para la tabla `hora`
--
ALTER TABLE `hora`
  ADD CONSTRAINT `hora_ibfk_1` FOREIGN KEY (`id_Turno`) REFERENCES `turno` (`id_Turno`);

--
-- Filtros para la tabla `horario_medico`
--
ALTER TABLE `horario_medico`
  ADD CONSTRAINT `horario_medico_ibfk_1` FOREIGN KEY (`id_Turno`) REFERENCES `turno` (`id_Turno`),
  ADD CONSTRAINT `horario_medico_ibfk_2` FOREIGN KEY (`id_med`) REFERENCES `medico` (`id_med`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`id_esp`) REFERENCES `especialidad` (`id_esp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
