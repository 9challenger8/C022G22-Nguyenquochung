CREATE TABLE `plan` (
                        `id` varchar(40) NOT NULL,
                        `created_by` varchar(255) NOT NULL,
                        `created_date` datetime(6) NOT NULL,
                        `soft_delete` tinyint(1) DEFAULT 0,
                        `updated_by` varchar(255) DEFAULT NULL,
                        `updated_date` datetime(6) DEFAULT NULL,
                        `code` varchar(40) DEFAULT NULL,
                        `description` varchar(40) DEFAULT NULL,
                        `months_per_interval` varchar(40) DEFAULT NULL,
                        `name` varchar(40) DEFAULT NULL,
                        `price` decimal(19,4) DEFAULT NULL,
                        `role_code` varchar(40) DEFAULT NULL,
                        `status` varchar(40) DEFAULT NULL,
                        `type` varchar(40) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB
     DEFAULT CHARSET=utf8mb4
     COLLATE=utf8mb4_unicode_ci;

