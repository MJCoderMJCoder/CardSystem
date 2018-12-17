-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2018 �?06 �?03 �?06:47
-- 服务器版本: 5.6.11
-- PHP 版本: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `cardmanager`
--
CREATE DATABASE IF NOT EXISTS `cardmanager` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cardmanager`;

-- --------------------------------------------------------

--
-- 表的结构 `card_table`
--

CREATE TABLE IF NOT EXISTS `card_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` text NOT NULL,
  `password` text NOT NULL,
  `name` text NOT NULL,
  `sex` text NOT NULL,
  `identity` text NOT NULL,
  `phone` text NOT NULL,
  `college` text NOT NULL,
  `money` double NOT NULL,
  `islock` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `card_table`
--

INSERT INTO `card_table` (`id`, `number`, `password`, `name`, `sex`, `identity`, `phone`, `college`, `money`, `islock`) VALUES
(1, '11', '123456', '11', '111', '111', '1111', '1111', 2200, 'false');

-- --------------------------------------------------------

--
-- 表的结构 `history_table`
--

CREATE TABLE IF NOT EXISTS `history_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` text NOT NULL,
  `operation` text NOT NULL,
  `money` double NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `history_table`
--

INSERT INTO `history_table` (`id`, `number`, `operation`, `money`, `date`) VALUES
(1, '11', '??', 1000, '2018-06-03 04:42:00'),
(2, '11', '??', 200, '2018-06-03 04:43:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
