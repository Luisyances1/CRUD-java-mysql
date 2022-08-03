-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2022 at 03:05 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `almacen`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `tipo_c` varchar(20) NOT NULL,
  `clase_c` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `tipo_c`, `clase_c`) VALUES
(1001, 'detergente', 'multi usos'),
(1002, 'aceites', 'cocina'),
(1003, 'concentrado', 'mascotas'),
(1004, 'cerveza', 'alcohol'),
(1005, 'carne molida', 'carnes'),
(1006, 'confites', 'dulces');

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `id_p` int(11) NOT NULL,
  `id_c` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `cantidad`, `descripcion`, `id_p`, `id_c`) VALUES
(3001, 'costeñita', 50, 'producto con alcohol', 2003, 1004),
(3002, 'higado de res', 120, 'producto de la canasta familiar', 2002, 1005),
(3003, 'bombom bum', 50, 'producto para niños', 2006, 1006),
(3004, 'fab total', 30, 'productos para el baño', 2001, 1001),
(3005, 'frita frita', 70, 'productos para la cocina', 2004, 1002),
(3006, 'dogourmet', 100, 'productos para mascotas premium', 2005, 1003),
(3007, 'ringo premium', 10, 'productos para mascotas', 2003, 1003),
(3008, 'poker', 120, 'productos con alcohol', 2001, 1004),
(3009, 'girasol ', 45, 'productos para la cocina', 2001, 1002);

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre`, `direccion`, `telefono`) VALUES
(2001, 'productos de la costa ltda', 'barranquilla calle 57 #6-45', 7804576),
(2002, 'distribuidores del caribe', 'cartagena mz 20 lt 35 ', 7963456),
(2003, 'multientregas s.a', 'sincelejo calle 70 #45-60', 7849056),
(2004, 'grupo unido del caribe', 'barranquilla calle 39 #56-19', 7890432),
(2005, 'disproductos s.a esp', 'monteria calle circunvalar #8-17', 7347895),
(2006, 'mercatiendas del sinu', 'calle 43 #3-40', 7564839);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_p` (`id_p`),
  ADD KEY `id_c` (`id_c`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_p`) REFERENCES `proveedor` (`id_proveedor`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`id_c`) REFERENCES `categoria` (`id_categoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
