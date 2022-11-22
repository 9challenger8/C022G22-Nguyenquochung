CREATE TABLE `subscription` (
  `id` varchar(40) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `soft_delete` tinyint(1) DEFAULT 0,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `auto_renew_enabled` bit(1) DEFAULT NULL,
  `end_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `plan_id` varchar(40) DEFAULT NULL,
  `related_id` varchar(40) DEFAULT NULL,
  `related_type` varchar(40) DEFAULT NULL,
  `start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
     DEFAULT CHARSET=utf8mb4
     COLLATE=utf8mb4_unicode_ci;