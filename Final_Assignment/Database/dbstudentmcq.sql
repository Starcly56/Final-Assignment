-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2020 at 08:28 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbstudentmcq`
--

-- --------------------------------------------------------

--
-- Table structure for table `question_answer`
--

CREATE TABLE `question_answer` (
  `Question_ID` int(4) NOT NULL,
  `Subject_ID` int(4) NOT NULL,
  `Question` varchar(500) NOT NULL,
  `Answer1` varchar(100) NOT NULL,
  `Answer2` varchar(100) NOT NULL,
  `Answer3` varchar(100) NOT NULL,
  `Answer4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question_answer`
--

INSERT INTO `question_answer` (`Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4`) VALUES
(1, 201, 'What is meant by Johari Window?', 'Personality Test', 'Dietary Test', 'Expression Test', 'None'),
(2, 210, 'Which is the Interpreter from following?', 'Python', 'Java', 'C#', 'C++'),
(3, 205, 'What is meant by CSS?', 'Cascading Style Sheet', 'Creating Style Sheet', 'Customizable Style Sheet', 'Cascading Styling Sheet'),
(4, 290, 'When was Muluki Ain Introduced in Nepal?', '1910 B.S.', '2026 B.S.', '2045 B.S.', '1990 B.S.'),
(5, 201, 'What is the full form of CV?', 'Curriculum Vitae', 'Course Vitae', 'Credential Vitae', 'None'),
(6, 210, 'What is meant by OOP?', 'Object Oriented Programming', 'Only Oriented Programming', 'Object Only Programming', 'Object Oriented Pseudocode'),
(7, 205, 'What is meant by XML?', 'Extensible Markup Language', 'Entity Modelling Language', 'Entity Markup Language', 'Extensible Modelling Language'),
(8, 290, 'What is meant by Freedom of Speech?', 'Free to Expression', 'Free to Shout', 'Free to Gossip', 'Free to make Noise'),
(9, 201, 'Which of the following is correct?', 'If I were bird, I would fly.', 'If I was bird, I will fly.', 'If I would have been bird, I could fly.', 'If I was bird, I could fly.'),
(10, 210, 'What is the datatype of \"String\"?', 'Object ', 'String ', 'Integer', 'Float'),
(11, 205, 'What is the full form of JS?', 'JavaScript', 'JavaSceen', 'JuniperScript', 'JuniperScreen'),
(12, 290, 'Which day is regarded as Constitution day in Nepal?', '3rd Ashoj', '3rd Baisakh', '3rd Mangsir', '3rd Magh'),
(13, 201, 'What does EQ stand for ?', 'Emotional Intelligence', 'Emotional Quotient', 'Empathy', 'Emotional Quantile'),
(14, 210, 'Which of the following sorting algorithm is used to sort random linked list with minimum time?', 'Merge Sort', 'Insertion Sort', 'Quick Sort', 'Heap Sort'),
(15, 205, 'Which is the first Internet search engine?', 'Archie', 'Google ', 'Altavista', 'WAIS'),
(16, 290, 'Where is the Cyber Bureau of Nepal Police located?', 'Bhotahity', 'Dillibazar', 'Koteshwor', 'Maitighar'),
(17, 201, 'Which of these element is not involved in the process of communication?', 'Pipe', 'Sender', 'Message', 'Channel'),
(18, 210, 'Which one of the following is an application of Stack Data Structure?', 'All', 'Managing function calls', 'The stock span problem', 'Arithmetic expression evaluation'),
(19, 205, 'Who is making the Web Standards?', 'Mozilla', 'Microsoft', 'The Word Wide Web Consortium', 'NVIDIA'),
(20, 290, 'Where is the capital city of Iraq?', 'Bhagdadh', 'Tehran', 'Petra', 'Doha'),
(21, 201, 'Which of these is not an information based system?', 'SDS', 'MIS', 'DSS', 'SIS'),
(22, 210, 'To evaluate an expression without any embedded function calls:', 'One stack is enough', 'Two stacks are needed', 'As many as the height of the binary tree', 'Turing machine '),
(23, 205, 'Which tag is correct?', '<input/>', '<input>', '<input></input>', 'All'),
(24, 290, 'Which country was colonizing Macau in early 90s?', 'Portugal', 'France', 'Germany', 'Russia'),
(25, 201, 'Which of these does not come under behavioural sciences?', 'Globalization', 'Psychology', 'Sociology', 'Transactional Analysis'),
(26, 210, 'Which of the follwing is sorting algorithm?', 'Bubble', 'Linear', 'Binary', 'All'),
(27, 205, 'Which is the correct tag?', '<select></select>', '<input type=\"dropdown\"/>', '<dropdown/>', 'All'),
(28, 290, 'Where is the Interpol headquarter located?', 'France ', 'Germany', 'USA', 'Italy'),
(29, 201, 'For effective communication, which of these commandments should one not follow?', 'Inadequate medium', 'Clarity', 'Objective of Communication', 'Adequate medium'),
(30, 210, 'Which of the language is used for data analysis?', 'Python', 'Java', 'C#', 'C'),
(31, 205, 'What is the full form of HTML?', 'Hyper Text Markup Language', 'High Text Modelling Language', 'Hyper Text Modelling Language', 'High Text Markup Language'),
(32, 290, 'When did Rana Regime end in Nepal?', '2007 B.S.', '2000 B.S.', '1990 B.S.', '2010 B.S.'),
(33, 201, 'Which of these does not come under the four S’s?', 'Shock', 'Simplicity', 'Strength', 'Sincerity'),
(34, 210, 'Which one of the following is an application of Queue Data Structure?', 'All', 'Load Balancing', 'When a resource is shared among multiple consumers', 'When data is transferred asynchronously'),
(35, 205, 'Which tag is deprecated in HTML 5?', '<applet>', '<select></select>', '<tbody>', '<u></u>'),
(36, 290, 'Who is the current President of Russia?', 'Vladimir Putin', 'Donald Trumph', 'Frank-Walter Steinmeier', 'Narendra Damodardas Modi'),
(37, 201, 'Communication is a part of _________ skills.', 'soft ', 'hard', 'rough', 'short'),
(38, 210, 'The smallest element of an array\'s index is called its ', 'lower bound', 'upper bound', 'range', 'extraction'),
(39, 205, 'HTML is a _____ language.', 'markup', 'procedural', 'object oriented', 'object based'),
(40, 205, 'Who is the Mahatma Ghandi of RSA?', 'Nelson Mandela', 'K.P. Oli', 'Quni Shi Hungadi', 'Abraham Lincoln');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `Result_ID` int(4) NOT NULL,
  `Student_ID` int(4) NOT NULL,
  `Student_Email` varchar(50) NOT NULL,
  `Subject` int(4) NOT NULL,
  `Marks_Obtained` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(4) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `batch` enum('24 A','24 B','25 A','25 B','25 C','25 D') NOT NULL,
  `Gender` varchar(40) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Mobile` varchar(15) NOT NULL,
  `Token` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `student_name`, `batch`, `Gender`, `Email`, `Password`, `Address`, `Mobile`, `Token`) VALUES
(1, 'Ujjwal Humagain', '25 A', 'Male', 'humagainuzjwol@gmail.com', 'asdfgh', 'Kalanki', '9840452872', 'hq6ccpr');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Subject_Code` int(4) NOT NULL,
  `Subject_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Subject_Code`, `Subject_Name`) VALUES
(201, 'Communication Skills'),
(205, 'Developing the Modern Web'),
(290, 'Ethics'),
(210, 'Programming, Data Structures and Algorithms');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question_answer`
--
ALTER TABLE `question_answer`
  ADD PRIMARY KEY (`Question_ID`),
  ADD KEY `Subject_ID` (`Subject_ID`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`Result_ID`),
  ADD KEY `Student_ID` (`Student_ID`),
  ADD KEY `Student_Email` (`Student_Email`),
  ADD KEY `Subject` (`Subject`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Subject_Code`),
  ADD UNIQUE KEY `Subject_Name` (`Subject_Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question_answer`
--
ALTER TABLE `question_answer`
  MODIFY `Question_ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `Result_ID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `Subject_Code` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=291;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `question_answer`
--
ALTER TABLE `question_answer`
  ADD CONSTRAINT `question_answer_ibfk_1` FOREIGN KEY (`Subject_ID`) REFERENCES `subject` (`Subject_Code`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`ID`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`Student_Email`) REFERENCES `student` (`Email`),
  ADD CONSTRAINT `result_ibfk_3` FOREIGN KEY (`Subject`) REFERENCES `subject` (`Subject_Code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
