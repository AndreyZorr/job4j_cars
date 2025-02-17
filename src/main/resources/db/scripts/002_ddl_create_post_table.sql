create table post
(
    id   serial primary key,
    description varchar not null,
    created timestamp,
    auto_user_id int references auto_user(id),
    car_id int references car(id)
);
