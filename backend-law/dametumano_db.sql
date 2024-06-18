-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2024 a las 16:14:03
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dametumano_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abogado`
--

CREATE TABLE `abogado` (
  `is_admin` bit(1) NOT NULL,
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `abogado`
--

INSERT INTO `abogado` (`is_admin`, `fk_staff_legal_id`, `id`) VALUES
(b'1', 2, 1),
(b'0', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actuado`
--

CREATE TABLE `actuado` (
  `fk_caso_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `creador` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `actuado`
--

INSERT INTO `actuado` (`fk_caso_id`, `id`, `contenido`, `creador`, `descripcion`, `fecha_creacion`, `tipo`) VALUES
(2, 1, 'Por la presente, se notifica que el pantano de Shrek ahora es propiedad del Reino de Duloc', 'Lord Farquaad', 'El Rey ha emitido un decreto oficial respecto al pantano de Shrek.', '2024-06-17T10:00:00', 'Notificación Real'),
(2, 2, 'Por la presente, se notifica que el pantano de Shrek ahora es propiedad del Reino de Duloc', 'Lord Farquaad', 'El Rey ha emitido un decreto oficial respecto al pantano de Shrek.', '2024-06-17T10:00:00', 'Notificación Real'),
(2, 3, 'Por la presente, se notifica que el pantano de Shrek ahora es propiedad del Reino de Duloc', 'Lord Farquaad', 'El Rey ha emitido un decreto oficial respecto al pantano de Shrek.', '2024-06-17T10:00:00', 'Notificación Real');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo_caso`
--

CREATE TABLE `archivo_caso` (
  `fk_caso_id` bigint(20) DEFAULT NULL,
  `fk_docu_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion_fisica` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `numero_caso` varchar(255) DEFAULT NULL,
  `responsable` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo_tramite`
--

CREATE TABLE `archivo_tramite` (
  `fk_docu_id` bigint(20) DEFAULT NULL,
  `fk_tramite_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion_fisica` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `numero_tramite` varchar(255) DEFAULT NULL,
  `responsable` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caso`
--

CREATE TABLE `caso` (
  `fk_abogado_id` bigint(20) DEFAULT NULL,
  `fk_cliente_id` bigint(20) DEFAULT NULL,
  `fk_honor_id` bigint(20) DEFAULT NULL,
  `fk_procurador_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_cierre` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `responsable` varchar(255) DEFAULT NULL,
  `tipo_caso` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caso`
--

INSERT INTO `caso` (`fk_abogado_id`, `fk_cliente_id`, `fk_honor_id`, `fk_procurador_id`, `id`, `descripcion`, `estado`, `fecha_cierre`, `fecha_inicio`, `observaciones`, `responsable`, `tipo_caso`, `titulo`) VALUES
(1, 4, 1, 1, 1, 'Caso \"Quien se comio todo el dulce de leche\"', 'En Progreso', '44444444', '22222222', 'ninguna', 'abogado, procurador, cliente', 'Judicial', 'Dulce de leche vacia'),
(2, 2, 1, 1, 2, 'Caso del zapato desaparecido', 'Pendiente', '11111111', '88888888', 'Solo encontramos uno', 'abogado, procurador, cliente', 'Civil', 'El zapato fantasma'),
(1, 3, 2, 1, 3, 'Caso de la lámpara que nunca se apagaba', 'Resuelto', '22222222', '99999999', 'Los vecinos no podían dormir', 'abogado, procurador, cliente', 'Vecinal', 'Luz eterna'),
(2, 4, 3, 1, 4, 'Caso de la nevera parlante', 'En Progreso', '33333333', '10101010', 'La nevera tiene muchas historias', 'abogado, procurador, cliente', 'Consumo', 'Cuentos fríos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caso_fiscalia`
--

CREATE TABLE `caso_fiscalia` (
  `fk_caso_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caso_fiscalia`
--

INSERT INTO `caso_fiscalia` (`fk_caso_id`, `id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caso_juzgado`
--

CREATE TABLE `caso_juzgado` (
  `fk_caso_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `duracion` int(11) NOT NULL,
  `fk_cliente_id` bigint(20) DEFAULT NULL,
  `fk_secre_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `creador` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_cita` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`duracion`, `fk_cliente_id`, `fk_secre_id`, `id`, `creador`, `estado`, `fecha_cita`, `fecha_creacion`, `motivo`, `notas`, `ubicacion`) VALUES
(60, 3, 1, 1, 'Abogado Mágico', 'En espera de que los planetas se alineen', '2024-06-17T10:00:00', '2024-06-17T09:00:00', 'Reunión para discutir la estrategia de defensa \'Abracadabra Legal\'', '¡Importante! Llevar sombrero de mago para entrar.', 'Despacho 404, Edificio Ilusión Jurídica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`fk_staff_legal_id`, `id`) VALUES
(3, 1),
(4, 2),
(5, 3),
(6, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuaderno`
--

CREATE TABLE `cuaderno` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `fecha_ultima_actualizacion` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `responsable` varchar(255) DEFAULT NULL,
  `tipo_cuaderno` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuaderno`
--

INSERT INTO `cuaderno` (`id`, `descripcion`, `estado`, `fecha_creacion`, `fecha_ultima_actualizacion`, `numero`, `observaciones`, `responsable`, `tipo_cuaderno`, `titulo`) VALUES
(2, 'cuaderno del juzgado', 'en progreso', '77777777', '8888888888', '5', 'Subsanar una cosa', 'Abgado, cliente, procurador', 'Penal', 'Caso Jabon en la olla'),
(3, 'cuaderno de la abuela', 'finalizado', '12345678', '87654321', '7', 'No perder la receta de las galletas', 'Abuela, nieto, gato', 'Civil', 'Disputa por la receta secreta'),
(4, 'cuaderno del procurador distraído', 'pendiente', '11111111', '22222222', '13', 'Encontrar el bolígrafo rojo perdido', 'Procurador, detective privado, perro rastreador', 'Penal', 'El bolígrafo desaparecido'),
(5, 'cuaderno del caso de la pizza', 'en progreso', '33333333', '44444444', '21', 'Averiguar quién se comió la última porción', 'Chef, repartidor, ratón', 'Comercial', 'El misterio de la pizza desaparecida'),
(6, 'cuaderno del abogado soñador', 'suspendido', '55555555', '66666666', '42', 'Resolver el caso del sueño misterioso', 'Abogado, psicoanalista, almohada', 'Laboral', 'El sueño del fumador misterioso'),
(7, 'cuaderno del gato detective', 'concluido', '99999999', '00000000', '9', 'Descubrir quién robó el pescado', 'Gato, ratón sospechoso, pez dorado', 'Penal', 'El gran robo del acuario'),
(8, 'Un cuaderno con notas tan intrigantes que podrían resolver cualquier caso judicial.', 'En espera de la firma del juez y un sello mágico', '17 de junio de 2024', 'Justo ahora, mientras la tinta se seca.', '42', '¡Atención! Contiene claves para descifrar el misterio de la justicia.', 'El abogado maestro de las palabras y los apuntes', 'Cuaderno judicial ultra secreto', 'El Caso del Cuaderno Misterioso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `is_active` bit(1) NOT NULL,
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `ci_usuario` varchar(255) DEFAULT NULL,
  `pass_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`is_active`, `fk_staff_legal_id`, `id`, `ci_usuario`, `pass_usuario`) VALUES
(b'1', 1, 1, '1234567', '123'),
(b'1', 2, 2, '1234567', '123'),
(b'1', 3, 3, '7654321', '123'),
(b'1', 4, 4, '7654321', '123'),
(b'1', 5, 5, '7654321', '123'),
(b'1', 6, 6, '7654321', '123'),
(b'1', 7, 7, '7654321', '123'),
(b'1', 8, 8, '7654321', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documentacion`
--

CREATE TABLE `documentacion` (
  `is_documento_inicial` bit(1) NOT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `fecha_ultima_actualizacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `responsable` varchar(255) DEFAULT NULL,
  `tipo_caso` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `documentacion`
--

INSERT INTO `documentacion` (`is_documento_inicial`, `id`, `descripcion`, `estado`, `fecha_creacion`, `fecha_ultima_actualizacion`, `nombre`, `observaciones`, `responsable`, `tipo_caso`) VALUES
(b'1', 1, 'Documentos para tramite', 'Sin copias', '888888888888888', '99999999999999999', 'Certificado nacimiento', 'Sin Observaciones', 'Abogado y cliente', 'Tramite'),
(b'0', 2, 'declaracion de impuestos', 'sin utilizar', '444444444', '5555555555', 'certificado de NIT de trabajo', 'ninguno', 'Procurador, abogado, cliente', 'Cambio de poseedor de bien inmueble');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `figuralegal`
--

CREATE TABLE `figuralegal` (
  `is_active` bit(1) NOT NULL,
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `ci` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` varchar(255) DEFAULT NULL,
  `fecha_registro` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `figuralegal`
--

INSERT INTO `figuralegal` (`is_active`, `id`, `apellidos`, `ci`, `direccion`, `email`, `fecha_nacimiento`, `fecha_registro`, `genero`, `nombres`, `rol`, `telefono`) VALUES
(b'1', 1, 'Pérez', '1234567', 'Calle Principal 123', 'perez@example.com', '1980-01-01', '2022-01-01', 'Masculino', 'Juan', 'Abogado', '555-1234'),
(b'1', 2, 'Pérez', '1234567', 'Calle Principal 123', 'perez@example.com', '1980-01-01', '2022-01-01', 'Femenino', 'Laura', 'Abogada', '555-1234'),
(b'1', 3, 'López', '7654321', 'Avenida Comercial 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Jose', 'Cliente', '555-5678'),
(b'1', 4, 'López', '7654321', 'Avenida Comercial 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Mocos', 'Cliente', '555-5678'),
(b'1', 5, 'López', '7654321', 'Avenida Comercial 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Joselo', 'Cliente', '555-5678'),
(b'1', 6, 'López', '7654321', 'Avenida Comercial 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Pancho', 'Cliente', '555-5678'),
(b'1', 7, 'López', '7654321', 'Avenida Norte 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Femenino', 'Ana', 'Secretaria', '555-5678'),
(b'1', 8, 'López', '7654321', 'Avenida Los Procuradores', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Roberto', 'Procurador', '555-5678'),
(b'1', 9, 'López', '7654321', 'Avenida cielo Mall 456', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Femenino', 'María', 'Juez', '555-5678'),
(b'1', 10, 'López', '7654321', 'Avenida Norte Calle', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Mario', 'Fiscal', '555-5678'),
(b'1', 11, 'López', '7654321', 'Avenida Medio Local', 'lopez@example.com', '1985-05-05', '2022-01-02', 'Masculino', 'Carlos', 'Investigador', '555-5678');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fiscal`
--

CREATE TABLE `fiscal` (
  `fk_fig_legal_id` bigint(20) DEFAULT NULL,
  `fk_fiscalia_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fiscal`
--

INSERT INTO `fiscal` (`fk_fig_legal_id`, `fk_fiscalia_id`, `id`) VALUES
(10, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fiscalia`
--

CREATE TABLE `fiscalia` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fiscalia`
--

INSERT INTO `fiscalia` (`id`, `ciudad`, `departamento`, `direccion`, `email`, `nombre`, `pais`, `telefono`, `tipo`) VALUES
(1, 'La Paz', 'La Paz', 'Esquina Juanito Calle', 'asdf@correo.com', 'Fiscalia primero del Estado Pluri', 'Bolivia', '12544121', 'Penal'),
(2, 'Santa Cruz', 'Santa Cruz', 'Avenida Principal 123', 'cruz@correo.com', 'Fiscalia Segunda del Estado', 'Bolivia', '11223344', 'Civil'),
(3, 'Cochabamba', 'Cochabamba', 'Calle Flores 456', 'flores@correo.com', 'Fiscalia Tercera de Justicia', 'Bolivia', '55667788', 'Laboral'),
(4, 'Sucre', 'Chuquisaca', 'Plaza Mayor 789', 'mayor@correo.com', 'Fiscalia Cuarta de Investigaciones', 'Bolivia', '99887766', 'Penal'),
(5, 'Potosi', 'Potosi', 'Zona Alta 101', 'alta@correo.com', 'Fiscalia Quinta de Protección', 'Bolivia', '44556677', 'Familia'),
(6, 'Tarija', 'Tarija', 'Bulevar Central 202', 'central@correo.com', 'Fiscalia Sexta de Derechos', 'Bolivia', '22334455', 'Comercial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `honorario`
--

CREATE TABLE `honorario` (
  `monto` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `moneda` varchar(255) DEFAULT NULL,
  `tipo_servicio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `honorario`
--

INSERT INTO `honorario` (`monto`, `id`, `descripcion`, `moneda`, `tipo_servicio`) VALUES
(23, 1, 'Tramite', 'Dolares', 'Tramite'),
(25, 2, 'Caso de Penales', 'Dolares', 'Caso Judicial'),
(50, 3, 'Investigaciones de quién dejó la tapa del inodoro levantada', 'Dolares', 'Caso Doméstico'),
(75, 4, 'Casos de conflictos por ronquidos nocturnos', 'Dolares', 'Caso Vecinal'),
(100, 5, 'Defensas de gatos acusado de robar pescado', 'Dolares', 'Caso Animal'),
(150, 6, 'Casos del vecinos que canta en la ducha a las 3 AM', 'Dolares', 'Caso Vecinal'),
(200, 7, 'Tramites para declarar a las plantas de oficinas como mascotas', 'Dolares', 'Tramite Especial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador`
--

CREATE TABLE `investigador` (
  `fk_fig_legal_id` bigint(20) DEFAULT NULL,
  `fk_fiscalia_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ito`
--

CREATE TABLE `ito` (
  `id` bigint(20) NOT NULL,
  `abogado_denunciado` varchar(255) DEFAULT NULL,
  `abogado_denunciante` varchar(255) DEFAULT NULL,
  `denunciado` varchar(255) DEFAULT NULL,
  `denunciante` varchar(255) DEFAULT NULL,
  `descripcion_hechos` varchar(255) DEFAULT NULL,
  `fecha_fin` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(255) DEFAULT NULL,
  `fiscal` varchar(255) DEFAULT NULL,
  `investigador` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juez`
--

CREATE TABLE `juez` (
  `fk_fig_legal_id` bigint(20) DEFAULT NULL,
  `fk_juzgado_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juzgado`
--

CREATE TABLE `juzgado` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `memorial`
--

CREATE TABLE `memorial` (
  `fk_caso_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `memorial`
--

INSERT INTO `memorial` (`fk_caso_id`, `id`, `contenido`, `fecha_creacion`, `titulo`) VALUES
(4, 1, 'Tiene muchos archivos', '77777777777', 'Memorial para el Caso nevera parlante'),
(4, 2, 'Tiene muchos archivos', '77777777777', 'Memorial para el Caso nevera parlante'),
(3, 3, 'El caso está congelado... literalmente', '55555555555', 'Memorial para el Caso del congelador que se rebela'),
(2, 4, 'Un caso lleno de agujeros... de donas', '66666666666', 'Memorial para el Caso de la invasión de donas'),
(1, 5, 'Está lleno de pelos de perro, cuidado', '88888888888', 'Memorial para el Caso del perro que se graduó de abogado'),
(4, 6, 'Cuidado: contiene documentos masticados', '99999999999', 'Memorial para el Caso del ratón de oficina'),
(3, 7, 'No abrir: contiene spoilers de la serie', '44444444444', 'Memorial para el Caso del vecino spoileador de series'),
(2, 8, 'Archivos en lenguaje alienígena', '33333333333', 'Memorial para el Caso del ovni en el jardín'),
(1, 9, 'Incluye receta secreta de la abuela', '22222222222', 'Memorial para el Caso del robo de galletas mágicas'),
(4, 10, 'Este caso es un chiste... literalmente', '11111111111', 'Memorial para el Caso del payaso en juicio'),
(3, 11, 'Muchos post-its involucrados', '10101010101', 'Memorial para el Caso del secuestro de post-its'),
(2, 12, 'Contiene archivos de las vacaciones del abogado', '20202020202', 'Memorial para el Caso de la oficina en la playa'),
(1, 13, 'Atención: contiene memes en los anexos', '30303030303', 'Memorial para el Caso de los memes virales'),
(4, 14, 'Incluye mapa del tesoro', '40404040404', 'Memorial para el Caso de los piratas urbanos'),
(3, 15, 'El archivo huele a pizza', '50505050505', 'Memorial para el Caso del pizzero misterioso'),
(2, 16, 'Cuidado con los spoilers de películas', '60606060606', 'Memorial para el Caso del cinéfilo indiscreto'),
(1, 17, 'Archivos con tinta invisible', '70707070707', 'Memorial para el Caso del espía amateur'),
(4, 18, 'Documentos empapados en café', '80808080808', 'Memorial para el Caso del adicto al café'),
(3, 19, 'Contiene archivos cantantes', '90909090909', 'Memorial para el Caso del coro en el juzgado'),
(2, 20, 'Archivos escritos en jeroglíficos', '11122233344', 'Memorial para el Caso del arqueólogo aficionado'),
(1, 21, 'Este caso tiene más giros que una novela', '22233344455', 'Memorial para el Caso del escritor creativo'),
(2, 22, 'Un memorial lleno de recuerdos de todas las cosas perdidas y olvidadas.', '17 de junio de 2024', 'El Memorial de las Cosas que Nunca Encontré');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minuta`
--

CREATE TABLE `minuta` (
  `costo_hora` double NOT NULL,
  `horas_facturadas` int(11) NOT NULL,
  `total` double NOT NULL,
  `fk_abogado_id` bigint(20) DEFAULT NULL,
  `fk_cliente_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `id` bigint(20) NOT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notificacion`
--

INSERT INTO `notificacion` (`id`, `contenido`, `fecha`, `tipo`) VALUES
(1, 'Notificacion para el caso legal penal TAL', '777777777', 'Penal'),
(2, 'Notificacion para el cambio de nombre', '8888888888888', 'Derechos Reales'),
(3, 'Estimado Cliente, usted a programado una cita con nuestra abogada de renombre', '2024-06-17T15:30:00', 'Notificación Urgente'),
(4, 'Sentencia Condenatoria para nuestro cliente Mr. Don Gato', '2024-06-17T15:30:00', 'Notificación Urgente'),
(5, 'Sentencia Condenatoria para nuestro cliente Mr. Don Gato', '2024-06-17T15:30:00', 'Notificación Urgente'),
(6, 'Sentencia Condenatoria para nuestro cliente Mr. Don Gato', '2024-06-17T15:30:00', 'Notificación Urgente'),
(7, 'Sentencia Condenatoria para nuestro cliente Mr. Don Gato', '2024-06-17T15:30:00', 'Notificación Urgente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proceso_fiscal`
--

CREATE TABLE `proceso_fiscal` (
  `fk_caso_fiscal_id` bigint(20) DEFAULT NULL,
  `fk_cuaderno_id` bigint(20) DEFAULT NULL,
  `fk_fiscal_id` bigint(20) DEFAULT NULL,
  `fk_investigador_id` bigint(20) DEFAULT NULL,
  `fk_ito_id` bigint(20) DEFAULT NULL,
  `fk_notificacion_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proceso_juzgado`
--

CREATE TABLE `proceso_juzgado` (
  `fk_caso_juzgado_id` bigint(20) DEFAULT NULL,
  `fk_juez_id` bigint(20) DEFAULT NULL,
  `fk_notificacion_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procurador`
--

CREATE TABLE `procurador` (
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `procurador`
--

INSERT INTO `procurador` (`fk_staff_legal_id`, `id`) VALUES
(8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretaria`
--

CREATE TABLE `secretaria` (
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `secretaria`
--

INSERT INTO `secretaria` (`fk_staff_legal_id`, `id`) VALUES
(7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `estado_sesion` bit(1) NOT NULL,
  `fk_staff_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `fecha_sesion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stafflegal`
--

CREATE TABLE `stafflegal` (
  `fk_fig_legal_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `stafflegal`
--

INSERT INTO `stafflegal` (`fk_fig_legal_id`, `id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subsanacion`
--

CREATE TABLE `subsanacion` (
  `plazo_en_dias` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(255) DEFAULT NULL,
  `fecha_limite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `subsanacion`
--

INSERT INTO `subsanacion` (`plazo_en_dias`, `id`, `descripcion`, `fecha_inicio`, `fecha_limite`) VALUES
(4, 1, 'Subsanar Memorial', '23232323', '45454545'),
(5, 2, 'Subsanar Memorial Del Cliente', '6666666', '0000000999999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramite`
--

CREATE TABLE `tramite` (
  `dura_meses` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `num_etapas` int(11) NOT NULL,
  `fk_abogado_id` bigint(20) DEFAULT NULL,
  `fk_cliente_id` bigint(20) DEFAULT NULL,
  `fk_honor_id` bigint(20) DEFAULT NULL,
  `fk_subsanacion_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `instancia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tramite`
--

INSERT INTO `tramite` (`dura_meses`, `estado`, `num_etapas`, `fk_abogado_id`, `fk_cliente_id`, `fk_honor_id`, `fk_subsanacion_id`, `id`, `instancia`) VALUES
(10, b'1', 3, 1, 2, 2, 2, 1, 'Fiscalia'),
(14, b'1', 5, 2, 3, 1, 1, 2, 'Derechos Reales');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abogado`
--
ALTER TABLE `abogado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKptguwtovt63y1wm6jkmhdjc7g` (`fk_staff_legal_id`);

--
-- Indices de la tabla `actuado`
--
ALTER TABLE `actuado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa5xfjpqqws2gi1pl411x8vvwg` (`fk_caso_id`);

--
-- Indices de la tabla `archivo_caso`
--
ALTER TABLE `archivo_caso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8tlhqhns1hp2tawf4gt5a3uc1` (`fk_caso_id`),
  ADD KEY `FKjp5kwkpupirncxdfw0tbb722s` (`fk_docu_id`);

--
-- Indices de la tabla `archivo_tramite`
--
ALTER TABLE `archivo_tramite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKotq4tcdvrj7fx3o3jta5m2kks` (`fk_docu_id`),
  ADD KEY `FK77ih7dquedsf731mot8ia5u7h` (`fk_tramite_id`);

--
-- Indices de la tabla `caso`
--
ALTER TABLE `caso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlro59n5ssky2awqmjpikribls` (`fk_abogado_id`),
  ADD KEY `FKcfwfk6aae0uo9kyhsf7xpkbu1` (`fk_cliente_id`),
  ADD KEY `FK61puwy9g9epwqn5xxx01q7hpa` (`fk_honor_id`),
  ADD KEY `FKp046qrveflkfust7ww8alqxuq` (`fk_procurador_id`);

--
-- Indices de la tabla `caso_fiscalia`
--
ALTER TABLE `caso_fiscalia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6tyynwvla42ghekqm16j684ud` (`fk_caso_id`);

--
-- Indices de la tabla `caso_juzgado`
--
ALTER TABLE `caso_juzgado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6ab0ljf8exo7maeowcrp8blu8` (`fk_caso_id`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3h80w5vsjgp1cgatnnbmb11q6` (`fk_cliente_id`),
  ADD KEY `FK87xpqw1dct51kmxxkgub24xds` (`fk_secre_id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh62vqshe4xs1in0p03brjl4s5` (`fk_staff_legal_id`);

--
-- Indices de la tabla `cuaderno`
--
ALTER TABLE `cuaderno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKagg49qkwl87dj8yjxhh5b9wj` (`fk_staff_legal_id`);

--
-- Indices de la tabla `documentacion`
--
ALTER TABLE `documentacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `figuralegal`
--
ALTER TABLE `figuralegal`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fiscal`
--
ALTER TABLE `fiscal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlh766lcxtah5uaumndowq5yus` (`fk_fig_legal_id`),
  ADD KEY `FKpibvxdm0vn1njj95p37px65mx` (`fk_fiscalia_id`);

--
-- Indices de la tabla `fiscalia`
--
ALTER TABLE `fiscalia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `honorario`
--
ALTER TABLE `honorario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `investigador`
--
ALTER TABLE `investigador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3x4id5dfcsss0vjgu5fh3op7h` (`fk_fig_legal_id`),
  ADD KEY `FKqdv5iqr69m8tugdqmiepgyrvh` (`fk_fiscalia_id`);

--
-- Indices de la tabla `ito`
--
ALTER TABLE `ito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `juez`
--
ALTER TABLE `juez`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcq2q6oq8d30ejb4yqnp5fbqb` (`fk_fig_legal_id`),
  ADD KEY `FKhl5rmfa8ctfixm13l82777w0j` (`fk_juzgado_id`);

--
-- Indices de la tabla `juzgado`
--
ALTER TABLE `juzgado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `memorial`
--
ALTER TABLE `memorial`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK93ilnlvex3vrif9gmvdywk261` (`fk_caso_id`);

--
-- Indices de la tabla `minuta`
--
ALTER TABLE `minuta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9ppsaccqyphftbi2xinw9lvgl` (`fk_abogado_id`),
  ADD KEY `FKlsdv6l8qn09buu02p6n397gss` (`fk_cliente_id`);

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proceso_fiscal`
--
ALTER TABLE `proceso_fiscal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg0i2ojqvn4a919ywkg9l3bxm9` (`fk_caso_fiscal_id`),
  ADD KEY `FK9t45arw5ibpym80s6e4iwpfvo` (`fk_cuaderno_id`),
  ADD KEY `FK599v6y0vnosj5lj6a428x1hl4` (`fk_fiscal_id`),
  ADD KEY `FKck3y05mb1b8xjtfpcrbdl2euh` (`fk_investigador_id`),
  ADD KEY `FKltq8opdnvv2584k7chttmnyg6` (`fk_ito_id`),
  ADD KEY `FKncu8qxyvio2du5360gtp91pxu` (`fk_notificacion_id`);

--
-- Indices de la tabla `proceso_juzgado`
--
ALTER TABLE `proceso_juzgado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKokru7c3h2rdmsu6m27g5xup6t` (`fk_caso_juzgado_id`),
  ADD KEY `FKbht2iw3vq695g1kyo8vgd30f0` (`fk_juez_id`),
  ADD KEY `FK6ycgpsnvsgcibwbqpmpg660cr` (`fk_notificacion_id`);

--
-- Indices de la tabla `procurador`
--
ALTER TABLE `procurador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqsf8wf3bp4u2fjvxef2mg11t1` (`fk_staff_legal_id`);

--
-- Indices de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtjwmfsi757igpca897vxcct4v` (`fk_staff_legal_id`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK47mncf8wreafb7yhv9hcn11yw` (`fk_staff_legal_id`);

--
-- Indices de la tabla `stafflegal`
--
ALTER TABLE `stafflegal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKegqm840bi5w37y4rdjifko1w8` (`fk_fig_legal_id`);

--
-- Indices de la tabla `subsanacion`
--
ALTER TABLE `subsanacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tramite`
--
ALTER TABLE `tramite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6cy8bs1xsa50kcgfhnp8dgjas` (`fk_abogado_id`),
  ADD KEY `FK4vmqhp86q1jijgsrusbhvoixg` (`fk_cliente_id`),
  ADD KEY `FKrfy967ftj1gu06m9makvifdff` (`fk_honor_id`),
  ADD KEY `FK5d876lma8y0dxouqb5lkqy6kc` (`fk_subsanacion_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abogado`
--
ALTER TABLE `abogado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `actuado`
--
ALTER TABLE `actuado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `archivo_caso`
--
ALTER TABLE `archivo_caso`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `archivo_tramite`
--
ALTER TABLE `archivo_tramite`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caso`
--
ALTER TABLE `caso`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `caso_fiscalia`
--
ALTER TABLE `caso_fiscalia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `caso_juzgado`
--
ALTER TABLE `caso_juzgado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `cuaderno`
--
ALTER TABLE `cuaderno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `documentacion`
--
ALTER TABLE `documentacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `figuralegal`
--
ALTER TABLE `figuralegal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `fiscal`
--
ALTER TABLE `fiscal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `fiscalia`
--
ALTER TABLE `fiscalia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `honorario`
--
ALTER TABLE `honorario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `investigador`
--
ALTER TABLE `investigador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ito`
--
ALTER TABLE `ito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `juez`
--
ALTER TABLE `juez`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `juzgado`
--
ALTER TABLE `juzgado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `memorial`
--
ALTER TABLE `memorial`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `minuta`
--
ALTER TABLE `minuta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proceso_fiscal`
--
ALTER TABLE `proceso_fiscal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proceso_juzgado`
--
ALTER TABLE `proceso_juzgado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `procurador`
--
ALTER TABLE `procurador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `stafflegal`
--
ALTER TABLE `stafflegal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `subsanacion`
--
ALTER TABLE `subsanacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tramite`
--
ALTER TABLE `tramite`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abogado`
--
ALTER TABLE `abogado`
  ADD CONSTRAINT `FKptguwtovt63y1wm6jkmhdjc7g` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `actuado`
--
ALTER TABLE `actuado`
  ADD CONSTRAINT `FKa5xfjpqqws2gi1pl411x8vvwg` FOREIGN KEY (`fk_caso_id`) REFERENCES `caso` (`id`);

--
-- Filtros para la tabla `archivo_caso`
--
ALTER TABLE `archivo_caso`
  ADD CONSTRAINT `FK8tlhqhns1hp2tawf4gt5a3uc1` FOREIGN KEY (`fk_caso_id`) REFERENCES `caso` (`id`),
  ADD CONSTRAINT `FKjp5kwkpupirncxdfw0tbb722s` FOREIGN KEY (`fk_docu_id`) REFERENCES `documentacion` (`id`);

--
-- Filtros para la tabla `archivo_tramite`
--
ALTER TABLE `archivo_tramite`
  ADD CONSTRAINT `FK77ih7dquedsf731mot8ia5u7h` FOREIGN KEY (`fk_tramite_id`) REFERENCES `tramite` (`id`),
  ADD CONSTRAINT `FKotq4tcdvrj7fx3o3jta5m2kks` FOREIGN KEY (`fk_docu_id`) REFERENCES `documentacion` (`id`);

--
-- Filtros para la tabla `caso`
--
ALTER TABLE `caso`
  ADD CONSTRAINT `FK61puwy9g9epwqn5xxx01q7hpa` FOREIGN KEY (`fk_honor_id`) REFERENCES `honorario` (`id`),
  ADD CONSTRAINT `FKcfwfk6aae0uo9kyhsf7xpkbu1` FOREIGN KEY (`fk_cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKlro59n5ssky2awqmjpikribls` FOREIGN KEY (`fk_abogado_id`) REFERENCES `abogado` (`id`),
  ADD CONSTRAINT `FKp046qrveflkfust7ww8alqxuq` FOREIGN KEY (`fk_procurador_id`) REFERENCES `procurador` (`id`);

--
-- Filtros para la tabla `caso_fiscalia`
--
ALTER TABLE `caso_fiscalia`
  ADD CONSTRAINT `FK6tyynwvla42ghekqm16j684ud` FOREIGN KEY (`fk_caso_id`) REFERENCES `caso` (`id`);

--
-- Filtros para la tabla `caso_juzgado`
--
ALTER TABLE `caso_juzgado`
  ADD CONSTRAINT `FK6ab0ljf8exo7maeowcrp8blu8` FOREIGN KEY (`fk_caso_id`) REFERENCES `caso` (`id`);

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `FK3h80w5vsjgp1cgatnnbmb11q6` FOREIGN KEY (`fk_cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK87xpqw1dct51kmxxkgub24xds` FOREIGN KEY (`fk_secre_id`) REFERENCES `secretaria` (`id`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKh62vqshe4xs1in0p03brjl4s5` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `FKagg49qkwl87dj8yjxhh5b9wj` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `fiscal`
--
ALTER TABLE `fiscal`
  ADD CONSTRAINT `FKlh766lcxtah5uaumndowq5yus` FOREIGN KEY (`fk_fig_legal_id`) REFERENCES `figuralegal` (`id`),
  ADD CONSTRAINT `FKpibvxdm0vn1njj95p37px65mx` FOREIGN KEY (`fk_fiscalia_id`) REFERENCES `fiscalia` (`id`);

--
-- Filtros para la tabla `investigador`
--
ALTER TABLE `investigador`
  ADD CONSTRAINT `FK3x4id5dfcsss0vjgu5fh3op7h` FOREIGN KEY (`fk_fig_legal_id`) REFERENCES `figuralegal` (`id`),
  ADD CONSTRAINT `FKqdv5iqr69m8tugdqmiepgyrvh` FOREIGN KEY (`fk_fiscalia_id`) REFERENCES `fiscalia` (`id`);

--
-- Filtros para la tabla `juez`
--
ALTER TABLE `juez`
  ADD CONSTRAINT `FKcq2q6oq8d30ejb4yqnp5fbqb` FOREIGN KEY (`fk_fig_legal_id`) REFERENCES `figuralegal` (`id`),
  ADD CONSTRAINT `FKhl5rmfa8ctfixm13l82777w0j` FOREIGN KEY (`fk_juzgado_id`) REFERENCES `juzgado` (`id`);

--
-- Filtros para la tabla `memorial`
--
ALTER TABLE `memorial`
  ADD CONSTRAINT `FK93ilnlvex3vrif9gmvdywk261` FOREIGN KEY (`fk_caso_id`) REFERENCES `caso` (`id`);

--
-- Filtros para la tabla `minuta`
--
ALTER TABLE `minuta`
  ADD CONSTRAINT `FK9ppsaccqyphftbi2xinw9lvgl` FOREIGN KEY (`fk_abogado_id`) REFERENCES `abogado` (`id`),
  ADD CONSTRAINT `FKlsdv6l8qn09buu02p6n397gss` FOREIGN KEY (`fk_cliente_id`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `proceso_fiscal`
--
ALTER TABLE `proceso_fiscal`
  ADD CONSTRAINT `FK599v6y0vnosj5lj6a428x1hl4` FOREIGN KEY (`fk_fiscal_id`) REFERENCES `fiscal` (`id`),
  ADD CONSTRAINT `FK9t45arw5ibpym80s6e4iwpfvo` FOREIGN KEY (`fk_cuaderno_id`) REFERENCES `cuaderno` (`id`),
  ADD CONSTRAINT `FKck3y05mb1b8xjtfpcrbdl2euh` FOREIGN KEY (`fk_investigador_id`) REFERENCES `investigador` (`id`),
  ADD CONSTRAINT `FKg0i2ojqvn4a919ywkg9l3bxm9` FOREIGN KEY (`fk_caso_fiscal_id`) REFERENCES `caso_fiscalia` (`id`),
  ADD CONSTRAINT `FKltq8opdnvv2584k7chttmnyg6` FOREIGN KEY (`fk_ito_id`) REFERENCES `ito` (`id`),
  ADD CONSTRAINT `FKncu8qxyvio2du5360gtp91pxu` FOREIGN KEY (`fk_notificacion_id`) REFERENCES `notificacion` (`id`);

--
-- Filtros para la tabla `proceso_juzgado`
--
ALTER TABLE `proceso_juzgado`
  ADD CONSTRAINT `FK6ycgpsnvsgcibwbqpmpg660cr` FOREIGN KEY (`fk_notificacion_id`) REFERENCES `notificacion` (`id`),
  ADD CONSTRAINT `FKbht2iw3vq695g1kyo8vgd30f0` FOREIGN KEY (`fk_juez_id`) REFERENCES `juez` (`id`),
  ADD CONSTRAINT `FKokru7c3h2rdmsu6m27g5xup6t` FOREIGN KEY (`fk_caso_juzgado_id`) REFERENCES `caso_juzgado` (`id`);

--
-- Filtros para la tabla `procurador`
--
ALTER TABLE `procurador`
  ADD CONSTRAINT `FKqsf8wf3bp4u2fjvxef2mg11t1` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD CONSTRAINT `FKtjwmfsi757igpca897vxcct4v` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `FK47mncf8wreafb7yhv9hcn11yw` FOREIGN KEY (`fk_staff_legal_id`) REFERENCES `stafflegal` (`id`);

--
-- Filtros para la tabla `stafflegal`
--
ALTER TABLE `stafflegal`
  ADD CONSTRAINT `FKegqm840bi5w37y4rdjifko1w8` FOREIGN KEY (`fk_fig_legal_id`) REFERENCES `figuralegal` (`id`);

--
-- Filtros para la tabla `tramite`
--
ALTER TABLE `tramite`
  ADD CONSTRAINT `FK4vmqhp86q1jijgsrusbhvoixg` FOREIGN KEY (`fk_cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK5d876lma8y0dxouqb5lkqy6kc` FOREIGN KEY (`fk_subsanacion_id`) REFERENCES `subsanacion` (`id`),
  ADD CONSTRAINT `FK6cy8bs1xsa50kcgfhnp8dgjas` FOREIGN KEY (`fk_abogado_id`) REFERENCES `abogado` (`id`),
  ADD CONSTRAINT `FKrfy967ftj1gu06m9makvifdff` FOREIGN KEY (`fk_honor_id`) REFERENCES `honorario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
