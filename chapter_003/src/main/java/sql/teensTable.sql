/* Create
create table gender(
	id serial primary key,
	gender varchar(6)
);

create table teens(
	id serial primary key,
	name varchar(12),
	gender_id int references gender(id)
);
*/

/* Insert
insert into gender(gender) values('male');
insert into gender(gender) values('female');

insert into teens(name, gender_id)
values('Masha', 2);
insert into teens(name, gender_id)
values('Misha', 1);
insert into teens(name, gender_id)
values('Dasha', 2);
insert into teens(name, gender_id)
values('Sasha', 1);
*/

/* Select
select n1.name as Имена, n2.name as Именя, 
concat(n1.gender_id, ' ', n2.gender_id) as Пары 
from teens n1 
cross join teens as n2
where concat(n1.gender_id, ' ', n2.gender_id) = '1 2' 
or concat(n1.gender_id, ' ', n2.gender_id) = '2 1';
*/
select n1.name as Имена, n2.name as Именя, 
concat(n1.gender_id, ' ', n2.gender_id) as Пары 
from teens n1 
cross join teens as n2
where n1.gender_id != n2.gender_id;