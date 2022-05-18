
use quan_ly_ban_hang;

insert into customer values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into orders values
(1,1,3/21/2006,Null),
(2,2,3/23/2006,Null),
(3,1,3/16/2006,Null);

insert into product values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select oID,oDate from orders; 

select cName,pName from customer
join orders on customer.cId=orders.oID
join order_detail on orders.oID= order_detail.oID
join product on order_detail.pID=product.pID;

select c.cName, p.pName from orders ob
inner join customer c on ob.cID = c.cID
inner join order_detail od on od.oID = ob.oID
inner join product p on od.pID = p.pID;

select c.cName from customer c where not exists (select cName from orders where c.cID = orders.cID);

select ob.oID, ob.oDate, (p.pPrice * od.odQTY) as gia_tien from orders ob
inner join order_detail od on od.oID = ob.oID
inner join product p on p.pID = od.pID;





