-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2021 at 08:56 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `activite`
--

CREATE TABLE `activite` (
                            `id` bigint(20) NOT NULL,
                            `created_at` datetime DEFAULT NULL,
                            `ref` varchar(255) DEFAULT NULL,
                            `updated_at` datetime DEFAULT NULL,
                            `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `annex_administrative`
--

CREATE TABLE `annex_administrative` (
                                        `id` bigint(20) NOT NULL,
                                        `nom` varchar(255) DEFAULT NULL,
                                        `numero` varchar(255) DEFAULT NULL,
                                        `secteur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `commune`
--

CREATE TABLE `commune` (
                           `id` bigint(20) NOT NULL,
                           `nom` varchar(255) DEFAULT NULL,
                           `ville_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `declaration`
--

CREATE TABLE `declaration` (
                               `id` bigint(20) NOT NULL,
                               `created_at` datetime DEFAULT NULL,
                               `ref` varchar(255) DEFAULT NULL,
                               `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `declaration_piece_jointe`
--

CREATE TABLE `declaration_piece_jointe` (
                                            `id` bigint(20) NOT NULL,
                                            `created_at` datetime DEFAULT NULL,
                                            `ref` varchar(255) DEFAULT NULL,
                                            `updated_at` datetime DEFAULT NULL,
                                            `description` varchar(255) DEFAULT NULL,
                                            `nom` varchar(255) DEFAULT NULL,
                                            `url` varchar(255) DEFAULT NULL,
                                            `declaration_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
                                         `installed_rank` int(11) NOT NULL,
                                         `version` varchar(50) DEFAULT NULL,
                                         `description` varchar(200) NOT NULL,
                                         `type` varchar(20) NOT NULL,
                                         `script` varchar(1000) NOT NULL,
                                         `checksum` int(11) DEFAULT NULL,
                                         `installed_by` varchar(100) NOT NULL,
                                         `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
                                         `execution_time` int(11) NOT NULL,
                                         `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `local`
--

CREATE TABLE `local` (
                         `id` bigint(20) NOT NULL,
                         `dernier_annee_payer` int(11) NOT NULL,
                         `dernier_trim_payer` int(11) NOT NULL,
                         `nom` varchar(255) DEFAULT NULL,
                         `nom_commercial` varchar(255) DEFAULT NULL,
                         `numero_caissier` varchar(255) DEFAULT NULL,
                         `ref` varchar(255) DEFAULT NULL,
                         `activite_id` bigint(20) DEFAULT NULL,
                         `declaration_id` bigint(20) DEFAULT NULL,
                         `redevable_id` bigint(20) DEFAULT NULL,
                         `rue_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `quartier`
--

CREATE TABLE `quartier` (
                            `id` bigint(20) NOT NULL,
                            `nom` varchar(255) DEFAULT NULL,
                            `numero` varchar(255) DEFAULT NULL,
                            `annex_administrative_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `redevable`
--

CREATE TABLE `redevable` (
                             `id` bigint(20) NOT NULL,
                             `created_at` datetime DEFAULT NULL,
                             `ref` varchar(255) DEFAULT NULL,
                             `updated_at` datetime DEFAULT NULL,
                             `adresse` varchar(255) DEFAULT NULL,
                             `email` varchar(255) DEFAULT NULL,
                             `nom` varchar(255) DEFAULT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rue`
--

CREATE TABLE `rue` (
                       `id` bigint(20) NOT NULL,
                       `created_at` datetime DEFAULT NULL,
                       `ref` varchar(255) DEFAULT NULL,
                       `updated_at` datetime DEFAULT NULL,
                       `nom` varchar(255) DEFAULT NULL,
                       `numero` varchar(255) DEFAULT NULL,
                       `quartier_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `secteur`
--

CREATE TABLE `secteur` (
                           `id` bigint(20) NOT NULL,
                           `nom` varchar(255) DEFAULT NULL,
                           `commune_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

CREATE TABLE `ville` (
                         `id` bigint(20) NOT NULL,
                         `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `zone`
--

CREATE TABLE `zone` (
                        `id` bigint(20) NOT NULL,
                        `nom` varchar(255) DEFAULT NULL,
                        `secteur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activite`
--
ALTER TABLE `activite`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_dwqqn6wta68xnjbuoo1bxsxna` (`ref`);

--
-- Indexes for table `annex_administrative`
--
ALTER TABLE `annex_administrative`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK78nfpl3qv2dpp328lbn5eloow` (`secteur_id`);

--
-- Indexes for table `commune`
--
ALTER TABLE `commune`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKarnjhko728y26cr9xmw1q6twu` (`ville_id`);

--
-- Indexes for table `declaration`
--
ALTER TABLE `declaration`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_28mkjxhl8vntqwyppufp8vl50` (`ref`);

--
-- Indexes for table `declaration_piece_jointe`
--
ALTER TABLE `declaration_piece_jointe`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_d43i9gx8v791254rdhvtsbork` (`ref`),
  ADD KEY `FKnjttpqs77ahqk4imnw1r4ytwc` (`declaration_id`);

--
-- Indexes for table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
    ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Indexes for table `local`
--
ALTER TABLE `local`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ik34gpeuwkrnr45rwldpp0cfw` (`ref`),
  ADD KEY `FKjktlqbaw513kj6a6f3i7aitv1` (`activite_id`),
  ADD KEY `FK3oychlvohae3ilr4dfimv8k2m` (`declaration_id`),
  ADD KEY `FKof61fdeqhbtpkyvn8fwl6jvj` (`redevable_id`),
  ADD KEY `FKg14gvsndnbcpryhi6ndx6fuwo` (`rue_id`);

--
-- Indexes for table `quartier`
--
ALTER TABLE `quartier`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKhaq2ko28bgln5xgue2mioitv0` (`annex_administrative_id`);

--
-- Indexes for table `redevable`
--
ALTER TABLE `redevable`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_7yf1aywj4lt2vrc28ug0i0g2b` (`ref`);

--
-- Indexes for table `rue`
--
ALTER TABLE `rue`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jc8bc9xol92fuylo9st9v6j33` (`ref`),
  ADD KEY `FKdw0cx674acqg4e3jcfoeit6i9` (`quartier_id`);

--
-- Indexes for table `secteur`
--
ALTER TABLE `secteur`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK3t3uvy51o5phydx3n8oj01nhn` (`commune_id`);

--
-- Indexes for table `ville`
--
ALTER TABLE `ville`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zone`
--
ALTER TABLE `zone`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKnmam5guofi5wfkurfuaxpl5qt` (`secteur_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `annex_administrative`
--
ALTER TABLE `annex_administrative`
    ADD CONSTRAINT `FK78nfpl3qv2dpp328lbn5eloow` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`id`);

--
-- Constraints for table `commune`
--
ALTER TABLE `commune`
    ADD CONSTRAINT `FKarnjhko728y26cr9xmw1q6twu` FOREIGN KEY (`ville_id`) REFERENCES `ville` (`id`);

--
-- Constraints for table `declaration_piece_jointe`
--
ALTER TABLE `declaration_piece_jointe`
    ADD CONSTRAINT `FKnjttpqs77ahqk4imnw1r4ytwc` FOREIGN KEY (`declaration_id`) REFERENCES `declaration` (`id`);

--
-- Constraints for table `local`
--
ALTER TABLE `local`
    ADD CONSTRAINT `FK3oychlvohae3ilr4dfimv8k2m` FOREIGN KEY (`declaration_id`) REFERENCES `declaration` (`id`),
  ADD CONSTRAINT `FKg14gvsndnbcpryhi6ndx6fuwo` FOREIGN KEY (`rue_id`) REFERENCES `rue` (`id`),
  ADD CONSTRAINT `FKjktlqbaw513kj6a6f3i7aitv1` FOREIGN KEY (`activite_id`) REFERENCES `activite` (`id`),
  ADD CONSTRAINT `FKof61fdeqhbtpkyvn8fwl6jvj` FOREIGN KEY (`redevable_id`) REFERENCES `redevable` (`id`);

--
-- Constraints for table `quartier`
--
ALTER TABLE `quartier`
    ADD CONSTRAINT `FKhaq2ko28bgln5xgue2mioitv0` FOREIGN KEY (`annex_administrative_id`) REFERENCES `annex_administrative` (`id`);

--
-- Constraints for table `rue`
--
ALTER TABLE `rue`
    ADD CONSTRAINT `FKdw0cx674acqg4e3jcfoeit6i9` FOREIGN KEY (`quartier_id`) REFERENCES `quartier` (`id`);

--
-- Constraints for table `secteur`
--
ALTER TABLE `secteur`
    ADD CONSTRAINT `FK3t3uvy51o5phydx3n8oj01nhn` FOREIGN KEY (`commune_id`) REFERENCES `commune` (`id`);

--
-- Constraints for table `zone`
--
ALTER TABLE `zone`
    ADD CONSTRAINT `FKnmam5guofi5wfkurfuaxpl5qt` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
