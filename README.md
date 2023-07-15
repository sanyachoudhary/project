# project
The Phone Book is a straightforward application that utilizes graphical components in the Java Swing toolkit, coupled with MySQL as a data source. 
This application allows users to add, update, delete, view, and search for telephone subscribers. 

create databases PhoneBookManagement;
use PhoneBookManagement;
create table login(username varchar(50), password varchar(16));
insert into login(username,password) values("admin","admin");
create table add_contact(Id int primary key not null auto_increment, name varchar(50),nickname varchar(50),phone varchar(10),mobile varchar(10), email varchar(50), address varchar(50), company varchar(50), position varchar(50), group_name varchar(50));
