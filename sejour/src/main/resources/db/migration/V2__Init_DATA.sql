-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2021 at 11:23 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET
FOREIGN_KEY_CHECKS=0;
SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET
time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taxe_sejour_db`
--

--
-- Dumping data for table `taxe_sejour_annuele`
--

INSERT INTO `taxe_sejour_annuele` (`id`, `created_at`, `updated_at`, `anneee`, `date_presentation`, `date_validation`,
                                   `montant_retard`, `nombre_clients`, `nombre_nuit`, `ref_local`,
                                   `ref_taxe_sejour_annuele`)
VALUES (0, '2021-10-18 11:19:54', '2021-10-18 11:19:54', 2021, '2021-10-18', '2021-10-18', '1500.00', '20.00', '2.00',
        'Local_ref_1', 'Taxe_sejour_ref_1');

--
-- Dumping data for table `taxe_sejour_trim`
--

INSERT INTO `taxe_sejour_trim` (`id`, `created_at`, `updated_at`, `annee`, `date_presentation`, `date_validation`,
                                `montant`, `montant_retard`, `nombre_nuit`, `num_trim`, `ref_taxe_sejour_trim`,
                                `taxe_sejour_annuele_id`)
VALUES (0, '2021-10-18 11:21:08', '2021-10-18 11:21:08', 2021, '2021-10-19', '2021-10-20', '300.00', '200.00', '10.00',
        1, 'Taxe_Sejour_Trim_Ref1', 0);
SET
FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
