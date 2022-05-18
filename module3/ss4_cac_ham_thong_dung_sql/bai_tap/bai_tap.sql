use quanlysinhvien;

select subid,subname,max(credit) from subject;

select subname,max(mark) from subject
inner join mark on subject.SubId = mark.SubId;

select studentname , avg(mark) as diem_trung_binh from student 
inner join mark on student.studentId = mark.studentid
group by studentname;
