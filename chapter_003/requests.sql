-- Avg device prise
select avg(price) as Средняя_цена_устройств from devices;

-- Avg price for each person
select p.name as Имя, avg(dev.price) as Средняя_цена 
from people as p 
join devices_people dp
on p.id = dp.people_id
join devices as dev
on dp.device_id = dev.id
group by p.name

-- Avg price for each person is more than five
having avg(dev.price) > 5;