-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2021 at 08:57 AM
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
-- Database: `localdb`
--

--
-- Dumping data for table `activite`
--

INSERT INTO `activite` (`id`, `created_at`, `ref`, `updated_at`, `nom`) VALUES
(1, '2021-11-15 08:44:55', 'acitiviter-1', '2021-11-15 08:44:55', 'nom Activiter');

--
-- Dumping data for table `annex_administrative`
--

INSERT INTO `annex_administrative` (`id`, `nom`, `numero`, `secteur_id`)
VALUES (1, 'Annex-admin-1', '215445', NULL);

--
-- Dumping data for table `commune`
--
INSERT INTO `ville` (`id`, `nom`)
VALUES (1, 'Marrakech');

INSERT INTO `commune` (`id`, `nom`, `ville_id`)
VALUES (1, 'Commune', 1);

--
-- Dumping data for table `declaration`
--

INSERT INTO `declaration` (`id`, `created_at`, `ref`, `updated_at`)
VALUES (1, '2021-11-15 08:46:59', 'declaration-ref-1', '2021-11-15 08:46:59');

--
-- Dumping data for table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'root', '2021-11-09 16:18:43', 0, 1),
(2, '2', 'init-data', 'SQL', 'V2__init-data.sql', -324963627, 'root', '2021-11-09 16:18:43', 31, 0);

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

--
-- Dumping data for table `local`
--

-- INSERT INTO `local` (`id`, `dernier_annee_payer`, `dernier_trim_payer`, `nom`, `nom_commercial`, `numero_caissier`, `ref`, `activite_id`, `declaration_id`, `redevable_id`, `rue_id`) VALUES
-- (1, 2020, 2, 'Cristal', 'Cristal', '74411', 'ref-local-1', 1, 1, 1, 1),
-- (2, 2021, 2, 'Amarillo', 'Amarillo', '874445', 'ref-local-2', 1, 1, 1, 1);

--
-- Dumping data for table `quartier`
--

INSERT INTO `quartier` (`id`, `nom`, `numero`, `annex_administrative_id`) VALUES
(1, 'rue-chabab', '45454', 1);

--
-- Dumping data for table `redevable`
--

INSERT INTO `redevable` (`id`, `created_at`, `ref`, `updated_at`, `adresse`, `email`, `nom`, `password`, `prenom`) VALUES
(1, '2021-11-15 08:50:02', 'ref-redevable-1', '2021-11-15 08:50:02', 'Test Addresse', 'yassin@gmail.com', 'abidar', '123456789', 'yassine');

--
-- Dumping data for table `rue`
--

INSERT INTO `rue` (`id`, `created_at`, `ref`, `updated_at`, `nom`, `numero`, `quartier_id`) VALUES
(1, '2021-11-15 08:49:25', 'ref-rue-1', '2021-11-15 08:49:25', 'rue-nom', '74', 1);

--
-- Dumping data for table `secteur`
--

INSERT INTO `secteur` (`id`, `nom`, `commune_id`) VALUES
(1, 'Massira', 1);

--
-- Dumping data for table `ville`
--


--
-- Dumping data for table `zone`
--

INSERT INTO `zone` (`id`, `nom`, `secteur_id`) VALUES
(1, 'zone-1', 1);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
