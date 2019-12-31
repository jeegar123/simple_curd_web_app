-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2019 at 08:20 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarymangement`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `bookName` text NOT NULL,
  `bookAuthor` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `bookName`, `bookAuthor`) VALUES
(1, 'Android', 'Legend'),
(2, 'Java', 'Legend2'),
(3, 'Php', 'Legend3'),
(4, 'Ajax', 'Legend');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `username` text NOT NULL,
  `enrollment` text NOT NULL,
  `password` text NOT NULL,
  `semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `enrollment`, `password`, `semester`) VALUES
(1, 'jeegar', 'j.272@rku.ac.in', '17soece11001', '123', 1),
(2, 'Jeegar Vinodkuma5r', 'j.272@rku.ac.in', '17soece11001', 'aa', 5),
(3, '', '', '', '', 1),
(4, 'dsd', 'dsd@gmail.com', 'sds', 's', 3),
(5, 'fdsf', 'fdf@gmail.com', 'dsfdfd', 'fd', 5),
(6, 'dsa', 'ss@gmail.com', 'ss@gmail.com', 'ew', 3),
(7, 'ewfd', 'df@gmaiil.com', 'fdf', 'dfd', 4),
(8, 'fgs', 'fg@gmail.com', 'gfg', 'dfd', 1),
(9, 'fdf', 'fd@gmail.com', 'dfdfd', 'sdf', 1),
(10, '', '', '', '', 1),
(11, '', '', '', '', 1),
(12, '', '', '', '', 1),
(13, '', '', '', '', 1),
(14, 'Maulik', 'jeegar@gmail.com', '17soece11001', '123', 1),
(15, 'Jee', 'j@gmail.com', '17soece11003', '123', 1),
(16, 'He', 'k@gmail.com', '1800d', 'dsds', 1),
(17, 'J', 'j@gmail.com', 'j', 'kk', 1),
(18, 'Jeegar', 'w@gmail.com', 'ww', '1', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
