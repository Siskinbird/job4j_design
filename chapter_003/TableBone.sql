create table type(
	id serial primary key,
	name varchar(32)
);

create table product(
	id serial primary key,
	name varchar(32),
	type_id int references type(id),
	expired_date date,
	price float
);