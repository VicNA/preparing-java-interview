create table if not exists students (id bigserial primary key, name varchar(255), age int);

insert into students (name, age)
values
('Bob', 22),
('Jack', 23),
('John', 24),
('John2', 25);