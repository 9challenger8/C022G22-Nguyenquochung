INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (1, '2019-09-09', 'NV-123', 'Nam', '123456789', 'abc', 0, 'Nguyễn Văn Hùng', 1);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (2, '1996-08-09', 'NV-124', 'Nữ', '123456789', 'abc', 0, 'Trần Thị Bưởi', 2);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (3, '1995-07-09', 'NV-125', 'Nam', '123456789', 'abc', 0, 'Nguyễn Thái Công', 3);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (4, '1993-06-09', 'NV-126', 'Nam', '123456789', 'abc', 0, 'Nguyễn Văn Chung', 4);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (5, '1895-05-09', 'NV-127', 'Nữ', '123456789', 'abc', 0, 'Trần Thị Đức', 5);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (6, '1889-03-09', 'NV-128', 'Nữ', '123456789', 'abc', 0, 'Trần Thị Dần', 6);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (7, '1993-01-09', 'NV-129', 'Nữ', '123456789', 'abc', 0, 'THái Thị Long', 7);
INSERT INTO `pig_farm_database`.`employee` (`id`, `birth_day`, `code`, `gender`, `id_card`, `image`, `is_deleted`, `name`, `user_id`) VALUES (8, '1998-06-09', 'NV-130', 'Nữ', '123456789', 'abc', 0, 'Tạ Thị Nặng', 8);


INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (1, 0, 1, 1);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (2, 0, 2, 2);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (3, 0, 1, 3);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (4, 0, 2, 4);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (5, 0, 1, 5);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (6, 0, 2, 6);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (7, 0, 1, 7);
INSERT INTO `pig_farm_database`.`user_role` (`id`, `is_deleted`, `role_id`, `user_id`) VALUES (8, 0, 2, 8);

INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (1, '2019-12-12', 'abc1@gmail.com', 0, '123456', 'abc1');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (2, '2019-12-12', 'abc2@gmail.com', 0, '123456', 'abc2');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (3, '2019-12-12', 'abc3@gmail.com', 0, '123456', 'abc3');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (4, '2019-12-12', 'abc4@gmail.com',0, '123456', 'abc4');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (5, '2019-12-12', 'abc5@gmail.com', 0, '123456', 'abc5');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (6, '2019-12-12', 'abc6@gmail.com', 0, '123456', 'abc6');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (7, '2019-12-12', 'abc7@gmail.com', 0, '123456', 'abc7');
INSERT INTO `pig_farm_database`.`app_user` (`id`, `creation_date`, `email`, `is_deleted`, `password`, `username`) VALUES (8, '2019-12-12', 'abc8@gmail.com', 0, '123456', 'abc8');

INSERT INTO `pig_farm_database`.`app_role` (`id`, `is_deleted`, `role_name`) VALUES (1, 0, 'Admin');
INSERT INTO `pig_farm_database`.`app_role` (`id`, `is_deleted`, `role_name`) VALUES (2, 0, 'User');