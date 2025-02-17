create table participates
(
   id serial primary key,
   post_id int not null references post(id),
   auto_user_id int not null references auto_user(id),
   unique (post_id, auto_user_id)
);
