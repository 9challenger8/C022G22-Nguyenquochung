create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
cID int primary key,
cName varchar(20),
cAge int);

create table orders(
oID int primary key,
cID int,
foreign key (cID)  references customer(cID),
oDate date,
oTotalPrice double);
create table product(
pID int primary key,
pName varchar(20),
pPrice double);
create table order_detail(
oID int,
foreign key (oID) references orders(oID),
pID int,
foreign key (pID) references product(pID),
odQTY int);


