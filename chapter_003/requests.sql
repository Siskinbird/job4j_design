-- Написать запрос получение всех продуктов с типом "СЫР"

select p.name as Имя_продукта, tn.name as Тип_продукта
from product as p 
join type tn
on tn.id = p.type_id
where tn.name like '%Сыр%';

-- Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"

select p.name as Имя_продукта, tn.name as Тип_продукта 
from product as p 
join type tn
on tn.id = p.type_id
where tn.name like '%Мороженное%';

--Написать запрос, который выводит все продукты, срок годности которых уже истек

select name as Имя_продукта, expired_date as Просрочены
from product
where (expired_date < current_date);

--Написать запрос, который выводит самый дорогой продукт.

select name, price
from product
where price = (select max(price) from product);

--Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество

select tn.name, count(tn.name) 
FROM product
join type tn
on tn.id = product.type_id
group by tn.name;

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

select p.name as Имя_продукта, tn.name as Тип_продукта
from product as p 
join type tn
on tn.id = p.type_id
where tn.name like '%Сыр%' OR tn.name like '%Молоко%';

--Написать запрос, который выводит тип 
--продуктов, которых осталось меньше 10 штук. 
--Под количеством подразумевается количество 
--продуктов определенного типа. 
--Например, если есть тип "СЫР" и 
--продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, 
--то количество продуктов типа "СЫР" будет 2. 

SELECT tn.name, count(tn.name) 
FROM product
join type tn
on tn.id = product.type_id
GROUP BY tn.name 
HAVING count(tn.name) < 10;

--Вывести все продукты и их тип.

select p.name as Имя_продукта, tn.name as Тип_продукта
from product as p 
join type tn
on tn.id = p.type_id;
