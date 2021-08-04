create table person(
	id serial primary key,
	name varchar(255)
);

create table emails(
	id serial primary key,
	name varchar(255),
	person_id int references person(id)
);