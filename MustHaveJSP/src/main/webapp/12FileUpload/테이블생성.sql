create table myfile (
	idx int primary key,
	name varchar(50) not null,
	title varchar(200) not null,
	cate varchar(30),
	ofile varchar(100) not null,
	sfile varchar(30) not null,
	postdate timestamp not null
);