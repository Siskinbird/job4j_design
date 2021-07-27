--Devices
insert into devices(name, price)
values('Samsung', 3.33);
insert into devices(name, price)
values('Philips', 4.44);
insert into devices(name, price)
values('Iphone', 5.55);
insert into devices(name, price)
values('Nokia', 6.66);

--People
insert into people(name)
values('Vasa');
insert into people(name)
values('Peta');
insert into people(name)
values('Nina');
insert into people(name)
values('Viktor');

--Devices_people
insert into devices_people(device_id, people_id)
values(5, 1);
insert into devices_people(device_id, people_id)
values(6, 1);
insert into devices_people(device_id, people_id)
values(7, 1);
insert into devices_people(device_id, people_id)
values(5, 2);
insert into devices_people(device_id, people_id)
values(6, 2);
insert into devices_people(device_id, people_id)
values(6, 3);
insert into devices_people(device_id, people_id)
values(7, 4);
insert into devices_people(device_id, people_id)
values(8, 4);

