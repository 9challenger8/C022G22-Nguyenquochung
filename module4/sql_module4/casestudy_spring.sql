SELECT * FROM case_study_module4.customer;

use case_study_module4;
insert into customer(name,date_of_birth,gender,id_card,phone_number,email,address,customer_id) values
('Nguyễn Thị Hào','1970-11-07','Male','643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',2),
('Phạm Xuân Diệu','1992-08-08','Male','865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',2),
('Trương Đình Nghệ','1990-02-27','Male','488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',3),
('Dương Văn Quan','1981-07-08','Male','543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',3),
('Hoàng Trần Nhi Nhi','1995-12-09','Male','795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',1),
('Tôn Nữ Mộc Châu','2005-12-06','Male','732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',1),
('Nguyễn Mỹ Kim','1984-04-08','Male','856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
('Nguyễn Thị Hào','1999-04-08','Male','965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',1),
('Trần Đại Danh','1994-07-01','Male','432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
('Nguyễn Tâm Đắc','1989-07-01','Male','344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

insert into employee(name,date_of_birth,id_card,salary,phone_number,email,address,position_id,education_degree_id,division_id) values
('Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
('Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
('Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);

insert into attach_facility(name,cost,unit,status) values
('Karaoke',10000,'giờ','tiện nghi, hiện tại'),
('Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
('Thuê xe đạp',20000,'chiếc','tốt'),
('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');


delete from employee;

truncate table employee;