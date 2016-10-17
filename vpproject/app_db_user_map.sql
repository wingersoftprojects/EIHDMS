CREATE TABLE `app_db_user_map` (
  `app_db_user_map_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_detail_id` int(11) NOT NULL,
  `db_user` varchar(50) NOT NULL,
  `db_password` varchar(255) NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `is_active` int(1) NOT NULL,
  `add_date` datetime NOT NULL,
  `add_by` int(11) NOT NULL,
  `last_edit_date` datetime DEFAULT NULL,
  `last_edit_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`app_db_user_map_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
