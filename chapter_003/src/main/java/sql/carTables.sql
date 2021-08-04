create table engine(
	id serial primary key,
	name varchar(32)
);

create table transmission(
	id serial primary key,
	name varchar(32)
);

create table body(
	id serial primary key,
	name varchar(32)
);

create table car(
	id serial primary key,
	name varchar(32),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);