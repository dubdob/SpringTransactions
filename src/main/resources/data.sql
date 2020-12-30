DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Sound;

CREATE TABLE Author (Name varchar(50) not null, id int primary key);
CREATE TABLE Sound (Author varchar(50) not null, Name varchar(50) not null, id int primary key);
