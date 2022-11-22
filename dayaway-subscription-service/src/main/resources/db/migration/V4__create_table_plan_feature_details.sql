CREATE TABLE `plan_feature_details` (
  `id` varchar(40) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `soft_delete` tinyint(1) DEFAULT 0,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `plan_feature_id` varchar(40) DEFAULT NULL,
  `plan_id` varchar(40) DEFAULT NULL,
  `value` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

