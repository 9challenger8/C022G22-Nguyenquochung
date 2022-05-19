drop database demo;
create database demo;
use  demo;

create table products (
id int  ,
product_code int ,
product_name varchar(55),
product_price double,
product_amount int,
product_description varchar(55),
product_status varchar(55));

insert into products values
(1,223,'bap',60000,7,'ngon,bo,re','good'),
(2,224,'khoai',60000,9,'ngon,bo,re','good'),
(3,225,'san',40000,70,'ngon,bo,re','good'),
(4,226,'dau',90000,75,'ngon,bo,re','good'),
(5,227,'gao',70000,77,'ngon,bo,re','good'),
(6,228,'tao',670000,78,'ngon,bo,re','good');

-- index
EXPLAIN SELECT * FROM products WHERE product_name = 'khoai'; 

alter table products add index idx_product_code(product_code);

ALTER TABLE products DROP INDEX idx_product_code;

EXPLAIN SELECT * FROM products WHERE product_name = 'tao'; 

ALTER TABLE products ADD INDEX idx_full_name(product_name, product_price);

-- view
create view product_views as
select product_code,product_name,product_price,product_status
from products;

select * from product_views;

select product_name from product_views 
where product_name like 'bap';

drop view product_views;

-- store procedure 

DELIMITER //

CREATE PROCEDURE find_all_products()

BEGIN

  SELECT * FROM products;

END //

DELIMITER ;

call find_all_products();

delimiter //

create procedure create_new_products(inout `name` varchar(255), inout price int(55), inout amount int(55), inout `description` varchar(45))
begin
	insert into products(product_name, product_price, product_amount, product_description)
    values (`name`, price, amount, `description`);
end //

delimiter // 

set @`name` = 'chuoi';
set @price = 90000;
set @amount = 12;
set @`description` = 'ngon,bo,re';
call create_new_products(@`name`, @price, @amount, @`description`);

delimiter //
create procedure edit_products(id int(55), inout `name` varchar(255), inout price int(55), inout amount int(55), inout `description` varchar(45))
begin
	update products
    set product_name = `name`, product_price = price, product_amount = amount, product_description = `description`
    where product_code = id;
end //
delimiter ;

set @`name` = 'cam';
set @price = 98900;
set @amount = 2;
set @`description` = 'ngon,bo,re';
set @id = 33;
call edit_products(@id, @`name`, @price, @amount, @`description`);

delimiter //
create procedure delete_products(id int(11))
begin
	delete from products where product_code = id;
end //
delimiter ;

set @id = 183;
call delete_products(@id);



