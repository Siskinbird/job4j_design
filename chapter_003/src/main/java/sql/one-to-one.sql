create table crypto_wallet(
	id serial primary key,
	serial int,
	name varchar(255)
);

create table people(
	id serial primary key,
	name varchar(255),
	crypto_wallet_id int references crypto_wallet(id) unique
);
	