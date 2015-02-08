-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 07, 2015 at 04:07 AM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `insuranceSystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `security_question`
--

CREATE TABLE `security_question` (
`question_id` int(11) unsigned NOT NULL,
  `question` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `security_question`
--

INSERT INTO `security_question` (`question_id`, `question`) VALUES
(1, 'What was the name of your elementary / primary school?'),
(2, 'In what city or town does your nearest sibling live?'),
(3, 'What is your pet’s name?'),
(4, 'What is the last name of the teacher who gave you your first failing grade?'),
(5, 'What was your childhood nickname?'),
(6, 'What is the name of your favorite childhood friend?'),
(7, 'In what city or town did your mother and father meet?'),
(8, 'What is your favorite movie?'),
(9, 'What was your favorite food as a child?'),
(10, 'Who is your childhood sports hero?');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `security_question`
--
ALTER TABLE `security_question`
 ADD PRIMARY KEY (`question_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `security_question`
--
ALTER TABLE `security_question`
MODIFY `question_id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;