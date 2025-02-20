alter table post
add column brand_id int not null unique references brand(id);