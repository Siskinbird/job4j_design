create table person_names(
	id serial primary key,
	name varchar(255)
);

create table phobies(
	id serial primary key,
	name varchar(255)
);

create table persons_phobies(
	id serial primary key,
	person_name_id int references person_names(id),
	phobia_id int references phobies(id)
);
	