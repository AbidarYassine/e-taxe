-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2021 at 11:23 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taxe_sejour_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
                              `id` bigint(20) NOT NULL,
                              `created_at` datetime DEFAULT NULL,
                              `updated_at` datetime DEFAULT NULL,
                              `categorie` varchar(255) DEFAULT NULL,
                              `ref_categorie_sejour` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `taxe_sejour_annuele`
--

CREATE TABLE `taxe_sejour_annuele` (
                                       `id` bigint(20) NOT NULL,
                                       `created_at` datetime DEFAULT NULL,
                                       `updated_at` datetime DEFAULT NULL,
                                       `anneee` int(11) NOT NULL,
                                       `date_presentation` date DEFAULT NULL,
                                       `date_validation` date DEFAULT NULL,
                                       `montant_retard` decimal(19,2) DEFAULT NULL,
                                       `nombre_clients` decimal(19,2) DEFAULT NULL,
                                       `nombre_nuit` decimal(19,2) DEFAULT NULL,
                                       `ref_local` varchar(255) DEFAULT NULL,
                                       `ref_taxe_sejour_annuele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `taxe_sejour_trim`
--

CREATE TABLE `taxe_sejour_trim` (
                                    `id` bigint(20) NOT NULL,
                                    `created_at` datetime DEFAULT NULL,
                                    `updated_at` datetime DEFAULT NULL,
                                    `annee` int(11) NOT NULL,
                                    `date_presentation` date DEFAULT NULL,
                                    `date_validation` date DEFAULT NULL,
                                    `montant` decimal(19,2) DEFAULT NULL,
                                    `montant_retard` decimal(19,2) DEFAULT NULL,
                                    `nombre_nuit` decimal(19,2) DEFAULT NULL,
                                    `num_trim` int(11) NOT NULL,
                                    `ref_taxe_sejour_trim` varchar(255) DEFAULT NULL,
                                    `taxe_sejour_annuele_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `taxe_sejour_annuele`
--
ALTER TABLE `taxe_sejour_annuele`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `taxe_sejour_trim`
--
ALTER TABLE `taxe_sejour_trim`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK7051757ugo0ir3l06bbsh3ewi` (`taxe_sejour_annuele_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `taxe_sejour_trim`
--
ALTER TABLE `taxe_sejour_trim`
    ADD CONSTRAINT `FK7051757ugo0ir3l06bbsh3ewi` FOREIGN KEY (`taxe_sejour_annuele_id`) REFERENCES `taxe_sejour_annuele` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
