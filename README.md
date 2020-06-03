create database db_almacen character set utf8 collate utf8_general_ci;

create table productos(id int not null auto_increment primary key, descripcion varchar(250), stock int);
insert into productos(descripcion,stock)values("Celular Xiaomi note10",150);
insert into productos(descripcion,stock)values("laptop i7 lenovo 8GB RAM",30);
insert into productos(descripcion,stock)values("Ipop pro 10",80);
insert into productos(descripcion,stock)values("Monitor 4K UHD",10);
