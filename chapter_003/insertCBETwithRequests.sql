/* Insert into BODY
insert into body(name)
values ('Hatchback');
insert into body(name)
values ('Sedan');
insert into body(name)
values ('Wagon');
insert into body(name)
values ('Minivan');
insert into body(name)
values ('Coupe');
insert into body(name)
values ('Cabriolet');
insert into body(name)
values ('Limousine');
insert into body(name)
values ('Roadster');
insert into body(name)
values ('Pickup');
insert into body(name)
values ('Crossover');
insert into body(name)
values ('SUV');
*/

/* Insert into TRANSMISSION
insert into transmission(name) values('Mechanical');
insert into transmission(name) values('Automatic');
insert into transmission(name) values('Robotic');
*/

/* Insert into ENGINE
insert into engine(name) values('Diesel');
insert into engine(name) values('Atmospheric');
insert into engine(name) values('Rotary');
*/

/* Insert into CAR
insert into car(name, body_id, engine_id, transmission_id)
values('Suzuki Grand Vitara', 11, 2, 1);
insert into car(name, body_id, engine_id, transmission_id)
values('BMW ZX7', 8, 2, 2);
insert into car(name, body_id, engine_id, transmission_id)
values('Subaru', 1, 2, 2);
*/

/* Select all components of car
select * from car c left join engine e on e.id = c.engine_id
left join body b on b.id = c.body_id
left join transmission t on t.id = c.transmission_id;
*/

/* Select car without engine
select * from car c
right join engine e
on c.engine_id = e.id
where c.engine_id is null;
*/

/* Select car without body
select * from car c
right join body b
on c.body_id = b.id
where c.body_id is null;
*/

/* Select car without transmission
select * from car c
right join transmission t
on c.transmission_id = t.id
where c.transmission_id is null;
*/