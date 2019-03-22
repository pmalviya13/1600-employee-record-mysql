create database department;
use department;
create table department (
code int primary key auto_increment,
name char(20) not null unique
)Engine=InnoDB;

create table designation (
code int primary key auto_increment,
name char(20) not null unique
)Engine=InnoDB;

create table employee (
code int primary key auto_increment,
name char(20),
department_code int references department,
designation_code int references designation
)Engine=InnoDB;

insert into department (name) values('Sales');
insert into department (name) values('Stores');
insert into department (name) values('Purchase');
insert into department (name) values('House Keeping');
insert into designation (name) values('Manager');
insert into designation (name) values('Clerk');
insert into designation (name) values('Inspector');
insert into designation (name) values('Cashier');
insert into designation (name) values('Officer');
