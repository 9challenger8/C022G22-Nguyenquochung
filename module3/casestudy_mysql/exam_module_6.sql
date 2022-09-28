INSERT INTO `final_exam_module6`.`customer` (`id`, `card_id`, `code`, `date_of_birth`, `end_date`, `gender`, `name_customer`, `start_date`, `facility_id`) VALUES ('1', '123456789', 'NV-123', '1998-12-12', '2000-01-01', 'Male', 'Putin', '1998-10-10', '1');


INSERT INTO `final_exam_module6`.`pt` (`id`, `code_pt`, `date_of_birth`, `gender`, `name_pt`, `facility_id`) VALUES ('1', 'PT-123', '1998-12-12', 'Male', 'Nguyen Cuong', '1');
INSERT INTO `final_exam_module6`.`pt` (`id`, `code_pt`, `date_of_birth`, `gender`, `name_pt`, `facility_id`) VALUES ('2', 'PT-444', '1998-12-12', 'Male', 'Nguyen Quoc Hai', '1');
INSERT INTO `final_exam_module6`.`pt` (`id`, `code_pt`, `date_of_birth`, `gender`, `name_pt`, `facility_id`) VALUES ('3', 'PT-565', '1998-12-12', 'Female', 'Tran Thi Nga', '1');

INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES (1, 'MN-123', '1998-12-12', 'Male', 'Nguyen Tom');
INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES (2, 'MN-333', '1998-12-12', 'Male', 'Tran Dat');
INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES ('3', 'MN-444', '2000-12-12', 'Male', 'Tran Thai');
INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES ('4', 'MN-444', '2000-12-12', 'Male', 'Tran Tom');
INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES ('5', 'MN-444', '2000-12-12', 'Male', 'Tran Cu');
INSERT INTO `final_exam_module6`.`manager` (`id`, `code_manager`, `date_of_birth`, `gender`, `name_manager`) VALUES ('6', 'MN-444', '2000-12-12', 'Male', 'Tran Thaaaaai');

UPDATE `final_exam_module6`.`facility` SET `is_deleted` = 0 WHERE (`id` = '1');
UPDATE `final_exam_module6`.`facility` SET `is_deleted` = 0 WHERE (`id` = '2');