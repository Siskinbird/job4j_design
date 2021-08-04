create table covidstatus(
	id serial primary key,
	covstatus bool
);

create table vaccination(
	id serial primary key,
	vaccina varchar(32)
);

create table peoples(
	id serial primary key,
	name varchar(14),
	covidstatus_id int references covidstatus(id),
	vaccination_id int references vaccination(id)
);

insert into vaccination(vaccina) values ('Astra');
insert into vaccination(vaccina) values ('Zenica');
insert into vaccination(vaccina) values ('Vector');
insert into vaccination(vaccina) values ('Sputnik');

insert into covidstatus(covstatus) values(true);
insert into covidstatus(covstatus) values(false);

insert into peoples(name, covidstatus_id, vaccination_id) values('Igor', 1, 1);
insert into peoples(name, covidstatus_id, vaccination_id) values('Sam', 2, 4);
insert into peoples(name, covidstatus_id, vaccination_id) values('Jhon', 2, 2);
insert into peoples(name, covidstatus_id, vaccination_id) values('Ivan', 2, 3);
insert into peoples(name, covidstatus_id, vaccination_id) values('Oleg', 1, 2);
insert into peoples(name) values('Gleb');
insert into peoples(name) values('Vovan');

//Запрос объединения с Альяс//

select name as Имя, covidstatus_id as Статус, vaccination_id as Вакцинация, vaccina as Вакцина from peoples join vaccination vac on peoples.vaccination_id = vac.id;
