/* Left join
select * from emploees e
left join departments d
on e.department_id = d.id;
*/

/* Right join
select * from departments d
right join emploees e
on d.id = e.department_id;
*/

/* Full join
select * from emploees e
full join departments d
on e.department_id = d.id;
*/

/* Cross join
select * from departments d
cross join emploees e;
*/

/* Is null
select * from emploees e
left join departments d
on e.department_id = d.id
where d.id is null;
*/

/* Left/Right одинаковый результат
select * from departments d left join emploees e on e.department_id = d.id;
select * from emploees e right join departments d on d.id = e.department_id;

select * from emploees e left join departments d on d.id = e.department_id;
select * from departments d right join emploees e on e.department_id = d.id;
*/
