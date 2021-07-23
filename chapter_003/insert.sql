insert into roles(name) values('TestRole');
insert into categoryes(name) values('TestCategory');
insert into states(name) values('TestStat');
insert into rules(name) values('TestRule');
insert into users(name, role_id) values('TestUser', 1);
insert into role_rules(name, role_id, rule_id) values('TestRole', 1, 1);
insert into items(name, user_id, state_id, category_id) values('TestItem', 1, 1, 1);
insert into comments(name, item_id) values('TestComment', 1);
insert into attaches(name, item_id) values('TestAttaches', 1);

