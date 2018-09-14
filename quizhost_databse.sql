-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2017 at 05:22 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proglogic`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionNo` int(11) NOT NULL,
  `questionStatement` longtext COLLATE utf32_unicode_ci NOT NULL,
  `optionOne` longtext COLLATE utf32_unicode_ci NOT NULL,
  `optionTwo` longtext COLLATE utf32_unicode_ci NOT NULL,
  `optionThree` longtext COLLATE utf32_unicode_ci NOT NULL,
  `optionFour` longtext COLLATE utf32_unicode_ci NOT NULL,
  `quizId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `quizName` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `answer` longtext COLLATE utf32_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionNo`, `questionStatement`, `optionOne`, `optionTwo`, `optionThree`, `optionFour`, `quizId`, `quizName`, `answer`) VALUES
(1, 'Java was first developed in ?', '1990', '1991', '1993', '1996', 'JavaMahbub', 'Java', '1991'),
(2, 'The old name of Java was ?', 'J language', 'oak', 'oct', 'None of Above', 'JavaMahbub', 'Java', 'oak'),
(3, 'Which of the following feature is not supported by java ?', 'Multithreading', 'Reflection', 'perator Overloading', 'Garbage Collection', 'JavaMahbub', 'Java', 'Operator Overloading'),
(4, 'How many steps are in the systems development life cycle (SDLC)?', '4', '5', '6', '10', 'SADMahbub', 'SAD', '6'),
(5, 'The first step in the systems development life cycle (SDLC) is:', 'Analysis.', 'Design.', 'Problem/Opportunity Identification.', 'Development and Documentation.', 'SADMahbub', 'SAD', 'Problem/Opportunity Identification.'),
(6, 'The organized process or set of steps that needs to be followed to develop an information system is known as the:', 'analytical cycle', 'design cycle', 'program specification', 'system development life cycle', 'SADMahbub', 'SAD', 'system development life cycle'),
(7, '1', '1', '2', '3', '3', 'IQ Test747474', 'IQ Test', '1'),
(8, '2', '2', '3', '4', '5', 'IQ Test747474', 'IQ Test', '2');

-- --------------------------------------------------------

--
-- Table structure for table `questionanswer`
--

CREATE TABLE `questionanswer` (
  `studentId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `quizId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `questionNo` int(11) NOT NULL,
  `answer` longtext COLLATE utf32_unicode_ci NOT NULL,
  `studentAnswer` longtext COLLATE utf32_unicode_ci NOT NULL,
  `answerYet` varchar(100) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `questionanswer`
--

INSERT INTO `questionanswer` (`studentId`, `quizId`, `questionNo`, `answer`, `studentAnswer`, `answerYet`) VALUES
('Retu', 'SADMahbub', 4, '6', '5', 'Yes'),
('Retu', 'SADMahbub', 5, 'Problem/Opportunity Identification.', 'Problem/Opportunity Identification.', 'Yes'),
('Retu', 'SADMahbub', 6, 'system development life cycle', 'program specification', 'Yes'),
('Retu', 'JavaMahbub', 1, '1991', '1991', 'Yes'),
('Retu', 'JavaMahbub', 2, 'oak', 'oct', 'Yes'),
('Retu', 'JavaMahbub', 3, 'Operator Overloading', 'Garbage Collection', 'Yes'),
('151-15-4708', 'SADMahbub', 4, '6', '6', 'Yes'),
('151-15-4708', 'SADMahbub', 5, 'Problem/Opportunity Identification.', 'Problem/Opportunity Identification.', 'Yes'),
('151-15-4708', 'SADMahbub', 6, 'system development life cycle', 'program specification', 'Yes'),
('151-15-5001', 'SADMahbub', 4, '6', '6', 'Yes'),
('151-15-5001', 'SADMahbub', 5, 'Problem/Opportunity Identification.', 'Analysis.', 'Yes'),
('151-15-5001', 'SADMahbub', 6, 'system development life cycle', 'system development life cycle', 'Yes'),
('151-15-5001', 'JavaMahbub', 1, '1991', '1991', 'Yes'),
('151-15-5001', 'JavaMahbub', 2, 'oak', 'oak', 'Yes'),
('151-15-5001', 'JavaMahbub', 3, 'Operator Overloading', 'Reflection', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `quizNo` int(11) NOT NULL,
  `quizId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `quizName` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `noOfQuestions` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `accessPass` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `addByUser` varchar(100) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`quizNo`, `quizId`, `quizName`, `noOfQuestions`, `time`, `accessPass`, `addByUser`) VALUES
(9, 'SADMahbub', 'SAD', 3, 10, '12345', 'Mahbub'),
(7, 'JavaMahbub', 'Java', 3, 10, '54321', 'Mahbub'),
(10, 'IQ Test747474', 'IQ Test', 2, 10, '123', '747474');

-- --------------------------------------------------------

--
-- Table structure for table `quizresult`
--

CREATE TABLE `quizresult` (
  `studentId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `quizId` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `quizName` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `noOfQuestions` int(11) NOT NULL,
  `correctAnswer` int(11) NOT NULL,
  `scoreInPercent` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `quizresult`
--

INSERT INTO `quizresult` (`studentId`, `quizId`, `quizName`, `noOfQuestions`, `correctAnswer`, `scoreInPercent`) VALUES
('Retu', 'SADMahbub', 'SAD', 3, 1, 33.33),
('Retu', 'JavaMahbub', 'Java', 3, 1, 33.33),
('151-15-4708', 'SADMahbub', 'SAD', 3, 2, 66.67),
('151-15-5001', 'SADMahbub', 'SAD', 3, 2, 66.67),
('151-15-5001', 'JavaMahbub', 'Java', 3, 2, 66.67);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`name`, `username`, `password`, `role`) VALUES
('Shajjad', 'Shajjad', '1', 'admin'),
('Mahbubur Rahman', 'Mahbub', 'q', 'Teacher'),
('Rejwana Retu', 'Retu', '1', 'Student'),
('Fahad', '151-15-4708', '4708', 'Student'),
('salman', '151-15-5001', '123456', 'Student'),
('Arinuddha Rakshit', '747474', '74', 'Teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionNo`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`quizNo`,`quizId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quizNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
