create table roles(
	id serial primary key,
	name varchar(255)
);

create table categoryes(
	id serial primary key,
	name varchar(255)
);

create table states(
	id serial primary key,
	name varchar(255)
);

create table rules(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	role_id int references roles(id)
);

create table role_rules(
	id serial primary key,
	name varchar(255),
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table items(
	id serial primary key,
	name varchar(255),
	user_id int references users(id),
	state_id int references states(id),
	category_id int references categoryes(id)
);
	
create table comments(
	id serial primary key,
	name varchar(255),
	item_id int references items(id)
);
	
create table attaches(
	id serial primary key,
	name varchar(255),
	item_id int references items(id)
);

