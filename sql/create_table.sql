CREATE DATABASE `haochidb` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `doctorinfo` (
  `docid` int(11) NOT NULL,
  `docuserid` int(11) NOT NULL COMMENT 'docuserid corresponding with the user id, its logon password is stored in the userinfo table',
  `docname` varchar(45) NOT NULL,
  `docintro` longtext,
  `docability` varchar(45) NOT NULL,
  PRIMARY KEY (`docid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `leaveapplication` (
  `leavedocid` int(11) NOT NULL,
  `leavedate` varchar(45) NOT NULL,
  `leavestarttime` varchar(45) NOT NULL,
  `leaveendtime` varchar(45) NOT NULL,
  PRIMARY KEY (`leavedocid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `orderuserid` int(11) DEFAULT NULL,
  `orderdocid` int(11) NOT NULL,
  `orderdate` date NOT NULL,
  `orderstartblock` int(11) NOT NULL,
  `ordertreatmentid` varchar(45) NOT NULL,
  `orderinfo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `schedule` (
  `scheduledocid` int(11) NOT NULL,
  `schedulerestdayindex` int(11) NOT NULL,
  PRIMARY KEY (`scheduledocid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `treathistory` (
  `treatid` int(11) NOT NULL,
  `treatuserid` int(11) NOT NULL,
  `treatdocid` int(11) NOT NULL,
  `treatcontent` longtext,
  `treatdate` varchar(45) NOT NULL,
  PRIMARY KEY (`treatid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `userpass` varchar(45) NOT NULL,
  `useraddress` varchar(100) DEFAULT NULL,
  `userphone` varchar(45) DEFAULT NULL,
  `usertype` int(11) NOT NULL DEFAULT '0',
  `usergenda` int(11) NOT NULL,
  `usermailbox` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
