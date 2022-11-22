CREATE TABLE `subscription_history` (
  `id` varchar(40) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `soft_delete` tinyint(1) DEFAULT 0,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `payment_amount` decimal(19,4) DEFAULT NULL,
  `payment_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `payment_status` varchar(40) DEFAULT NULL,
  `period_start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `subscription_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
   DEFAULT CHARSET=utf8mb4
   COLLATE=utf8mb4_unicode_ci;