create table owners
(
id serial primary key,
name varchar,
user_id int not null references user(id)
);
