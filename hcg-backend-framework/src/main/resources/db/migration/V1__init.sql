CREATE TABLE post
(
	id VARCHAR(40) NOT NULL  ,
	title VARCHAR(255) NULL,
	category VARCHAR(255) NULL,
	date VARCHAR(255) NULL,
	
	soft_delete BIT NOT NULL,
	created_by VARCHAR(255) NOT NULL,
	created_date DATETIME NOT NULL,
	updated_by VARCHAR(255) NULL,
	updated_date DATETIME NULL

)ENGINE=InnoDB
 DEFAULT CHARSET=utf8mb4
 COLLATE=utf8mb4_unicode_ci;




